/**
 * @author Victor Aznar Echevarria - victor.aznar.2017
 * @project ViewRuleta
 */

package controller;

import view.Config;
import view.ViewPanelDraw;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static view.Config.*;

public class ButtonsAnimationController implements MouseListener {

    ViewPanelDraw viewPanelDraw;

    public ButtonsAnimationController (ViewPanelDraw viewPanelDraw){
        this.viewPanelDraw = viewPanelDraw;
    }


    @Override
    public void mouseClicked(MouseEvent e) {


        //TODO: Enviar l'aposta al sistema

    }

    @Override
    public void mousePressed(MouseEvent e) {

        JButton tempButton = (JButton) e.getSource();
        ImageIcon tempImage;

        switch (tempButton.getActionCommand()){


            case Config.BET_ACTIONCOMMAND:

                tempImage = new ImageIcon(BLACK_JACK_BET_BUTTON_PRESSED_IMAGE);
                viewPanelDraw.getBetButton().setIcon(tempImage);

                break;


            case Config.BACK_ACTIONCOMMAND:

                tempImage = new ImageIcon(BLACK_JACK_BACK_BUTTON_PRESSED);
                viewPanelDraw.getBackButton().setIcon(tempImage);

                break;




        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        JButton tempButton = (JButton) e.getSource();
        ImageIcon tempImage;

        switch(tempButton.getActionCommand()){

            case Config.BET_ACTIONCOMMAND:

                 tempImage = new ImageIcon(BET_BUTTON_IMAGE);
                viewPanelDraw.getBetButton().setIcon(tempImage);

                break;


            case Config.BACK_ACTIONCOMMAND:

                tempImage = new ImageIcon(BACK_BUTTON_IMAGE);
                viewPanelDraw.getBackButton().setIcon(tempImage);

                break;




        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        JButton tempButton = (JButton) e.getSource();
        ImageIcon tempImage;

        switch (tempButton.getActionCommand()){

            case Config.BET_ACTIONCOMMAND:

                tempImage = new ImageIcon(BLACK_JACK_BET_BUTTON_ON_TOP);
                viewPanelDraw.getBetButton().setIcon(tempImage);
                break;


            case Config.BACK_ACTIONCOMMAND:

                tempImage = new ImageIcon(BLACK_JACK_BACK_BUTTON_ON_TOP);
                viewPanelDraw.getBackButton().setIcon(tempImage);
                break;



        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        JButton tempButton = (JButton) e.getSource();
        ImageIcon tempImage;

        switch (tempButton.getActionCommand()){

            case Config.BET_ACTIONCOMMAND:

                tempImage = new ImageIcon(BET_BUTTON_IMAGE);
                viewPanelDraw.getBetButton().setIcon(tempImage);

                break;

            case Config.BACK_ACTIONCOMMAND:

                tempImage = new ImageIcon(BACK_BUTTON_IMAGE);
                viewPanelDraw.getBackButton().setIcon(tempImage);

                break;

        }

    }

}
