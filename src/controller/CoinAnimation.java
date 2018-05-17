/**
 * @author Victor Aznar Echevarria - victor.aznar.2017
 * @project ViewRuleta
 */

package controller;

import view.ViewPanelDraw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinAnimation implements ActionListener {
    private ViewPanelDraw viewPanelDraw;

    public CoinAnimation(ViewPanelDraw viewPanelDraw){
        this.viewPanelDraw = viewPanelDraw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Animació cartell

        if (viewPanelDraw.getFrameCartel() == 1){
            viewPanelDraw.setFrameCartel(0);
        }else{
            viewPanelDraw.setFrameCartel(viewPanelDraw.getFrameCartel() + 1);
        }


        //Animació moneda
        if (viewPanelDraw.getFrameCoin() == 7){
            viewPanelDraw.setFrameCoin(0);

        }else{
            viewPanelDraw.setFrameCoin(viewPanelDraw.getFrameCoin() + 1);
        }

        //Animació billets
        if (viewPanelDraw.getFrameMoney() == 1){
            viewPanelDraw.setFrameMoney(0);
        }else{
            viewPanelDraw.setFrameMoney(viewPanelDraw.getFrameMoney() + 1);
        }

        //Animació coinstack
        if (viewPanelDraw.getFrameStack() == 1){
            viewPanelDraw.setFrameStack(0);
        }else{
            viewPanelDraw.setFrameStack(viewPanelDraw.getFrameStack() + 1);
        }


    }
}
