/**
 * @author Victor Aznar Echevarria - victor.aznar.2017
 * @project ViewRuleta
 */

package view;

import controller.ButtonController;
import controller.ButtonsAnimationController;
import controller.betAmountController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewRuleta extends JFrame {

    public ViewPanelDraw getMainPanel() {
        return mainPanel;
    }
    private ViewPanelDraw mainPanel;
    private Timer timer;


    public ViewRuleta(){

        ImageIcon windowIcon = new ImageIcon(Config.WINDOW_GENERAL_ICON);
        mainPanel = new ViewPanelDraw();

        this.getContentPane().add(mainPanel);
        this.setSize(new Dimension(1920, 1080));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("ROULETTE");
        this.setIconImage(windowIcon.getImage());
        //this.setFullScreen(true);
        this.setUndecorated(false);
        this.setVisible(true);

        timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshScreen();
            }
        });

        timer.start();
    }

    public void startAnimations(){
        mainPanel.startAnimations(mainPanel);
    }

    public void refreshScreen(){
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }

    public void registerControllers (ButtonController buttonController, ButtonsAnimationController buttonsAnimationController, betAmountController betAmountController){
        mainPanel.registerControllers(buttonController, buttonsAnimationController, betAmountController);
    }

}
