package view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * RouletteAnimation: JPanel que s'encarrega de l'animació de la bola
 *
 * @author Jaume Campeny - jaume.campeny.2016
 * @version 1.0
 */

public class RouletteAnimation extends JPanel {
    private static final int RADIUS = 166;
    private final Position CENTER;
    private Image bgImage;
    private Image ballImage;
    private RefreshPaint refreshPaint;
    private BallMovement ballMovement;
    private Position[] positions;
    private int random;

    /**
     * Constructor. Inicialitza atributs i carrega imatges
     */
    public RouletteAnimation(){
        CENTER = new Position(176,176);
        setSize(382,382);
        bgImage = Toolkit.getDefaultToolkit().createImage("./resources/FonsRuleta.png");
        ballImage = Toolkit.getDefaultToolkit().createImage("./resources/PIXEL_BALL.png");
        refreshPaint = new RefreshPaint();
        positions = getPositions();
    }

    /**
     * Declara totes les possibles posicions a caure
     * @return Array de posicions (x i y) dels possibles punts a caure
     */
    private Position[] getPositions(){
        Position[] positions = new Position[37];
        positions[0] = new Position(180,70);
        positions[32] = new Position(200,72);
        positions[15] = new Position(218,74);
        positions[19] = new Position(236,80);
        positions[4] = new Position(252,92);
        positions[21] = new Position(266,107);
        positions[2] = new Position(277,121);
        positions[25] = new Position(284,138);
        positions[17] = new Position(290,156);
        positions[34] = new Position(293,176);
        positions[6] = new Position(292,195);
        positions[27] = new Position(288,213);
        positions[13] = new Position(283,232);
        positions[36] = new Position(273,247);
        positions[11] = new Position(260,262);
        positions[30] = new Position(245,273);
        positions[8] = new Position(228,283);
        positions[23] = new Position(210,289);
        positions[10] = new Position(190,292);
        positions[5] = new Position(171,293);
        positions[24] = new Position(152,290);
        positions[16] = new Position(134,285);
        positions[33] = new Position(118,274);
        positions[1] = new Position(102,263);
        positions[20] = new Position(90,248);
        positions[14] = new Position(80,232);
        positions[31] = new Position(74,214);
        positions[9] = new Position(70,195);
        positions[22] = new Position(70,176);
        positions[18] = new Position(70,156);
        positions[29] = new Position(75,138);
        positions[7] = new Position(83,121);
        positions[28] = new Position(96,106);
        positions[12] = new Position(110,94);
        positions[35] = new Position(125,81);
        positions[3] = new Position(143,74);
        positions[26] = new Position(162,70);

        return positions;
    }

    /**
     * Comença el joc
     * @param i: Numero on ha de caure la bola
     */
    public void game(int i){
        random = i;
        ballMovement = new BallMovement();
        refreshPaint.start();
        ballMovement.start();
        joinThread(ballMovement);
    }

    /**
     * Finalitza el joc. Tancament de Threads
     */
    public void terminate(){
        interruptThread(ballMovement);
        refreshPaint.exitLoop();
        repaint();
        joinThread(refreshPaint);
        interruptThread(refreshPaint);
        System.out.println(random);
    }

    /**
     * Metode join per a Threads
     * @param thread : Thread a fer-li join
     */
    private void joinThread(Thread thread){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metode interrupt per a Threads
     * @param thread : Thread a fer-li interrupt
     */
    private void interruptThread(Thread thread){ thread.interrupt(); }

    /**
     * Metode que s'encarrega de pintar la pantalla (background + bola)
     * @param g : Graphics del JPanel
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, this);
        if(!ballMovement.getCondition()){
            g.drawImage(ballImage, positions[random].getX(),positions[random].getY(),this);
        }else{
            g.drawImage(ballImage,176 + (int)(ballMovement.getRadius()*Math.cos(Math.toRadians(ballMovement.getAngle()))),176 + (int)(ballMovement.getRadius()*Math.sin(Math.toRadians(ballMovement.getAngle()))),this);
        }
    }

    /**
     * BallMovement : Thread encarregat de la lògica del moviment de la bola
     *
     * @author Jaume Campeny - jaume.campeny.2016
     * @version 1.0
     */
    private class BallMovement extends Thread{
        private int angle;
        private float radius;
        private boolean condition;

        /**
         * Constructor. Inicialitza atributs
         */
        private BallMovement(){
            this.angle = (int)(Math.round(Math.toDegrees(Math.acos((positions[random].getX()-CENTER.getX())/Math.hypot(positions[random].getY()-CENTER.getY(),positions[random].getX()-CENTER.getX())))));
            if(positions[random].getY()-CENTER.getY() <0) angle *= -1;
            angle += 115;
            if(positions[random].getY()-CENTER.getY() >0) angle += 65*((float)(positions[random].getY()-CENTER.getY())/160);
            if(positions[random].getX()-CENTER.getX() >0) angle += 65*((float)(positions[random].getX()-CENTER.getX())/160);
            this.condition = true;
            this.radius = RADIUS;
            }

        /**
         * Main del Thread. Es calcula la posicio de la bola mitjançant coordenades polars
         */
        @Override
        public void run() {
            float counter = 1;
            super.run();
            while(condition){
                angle++;
                if(angle == 360){ angle = 0; }
                if(Math.pow(2,counter) > 15){ radius = radius - 0.2f;}
                counter = counter * 1.002f;
                try {
                    Thread.sleep((int)(Math.pow(1.8,counter)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(Math.abs(Math.cos(Math.toRadians(angle))*radius - (positions[random].getX()-176)) < 4 && Math.abs(positions[random].getY()-176-Math.sin(Math.toRadians(angle))*radius) < 5){
                    condition = false;
                }
            }
        }

        /**
         * Getter del radi
         * @return int del radi
         */
        private int getRadius(){ return (int)radius;}

        /**
         * Getter del Angle
         * @return int del angle
         */
        private int getAngle() { return angle; }

        /**
         * Getter de la condicio de bucle
         * @return boolean de la condicio de bucle
         */
        private boolean getCondition(){ return condition;}

    }

    /**
     * RefreshPaint: Thread que s'encarrega d'actualitzar el JPanel continuament
     *
     * @author Jaume Campeny - jaume.campeny.2016
     * @version 1.0
     */
    private class RefreshPaint extends Thread{
        private boolean condition;
        private RefreshPaint(){
            this.condition = true;
        }

        /**
         * Main del Thread. S'encarrega d'actualitzar cada ms el JPanel
         */
        @Override
        public void run() {
            super.run();
            while (condition){
                repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * Cancela la condicio de bucle
         */
        private void exitLoop() {
            this.condition = false;
        }
    }

    /**
     * Position: Posicio x i y d'un punt en el JPanel
     */
    private class Position{
        private int x;
        private int y;

        /**
         * Constructor. Incialitza atributs
         * @param x : int de la component x del punt
         * @param y : int de la component y del punt
         */
        private Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        /**
         * Getter de la component x del punt
         * @return int de la component x del punt
         */
        private int getX() { return x; }

        /**
         * Getter de la component y del punt
         * @return int de la component y del punt
         */
        private int getY() { return y; }
    }

    /**
     * Main d'exemple
     * @param args : parametres interns
     */
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        RouletteAnimation roulette = new RouletteAnimation();
        jFrame.setSize(398,421);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle("RouletteAnimation");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.getContentPane().add(roulette);
        jFrame.setVisible(true);
        roulette.game(new Random().nextInt(37));
        roulette.terminate();
    }
}
