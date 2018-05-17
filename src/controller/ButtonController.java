/**
 * @author Victor Aznar Echevarria - victor.aznar.2017
 * @project ViewRuleta
 */

package controller;

import view.Config;
import view.ViewPanelDraw;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener {

   private ViewPanelDraw viewPanelDraw;


   public ButtonController (ViewPanelDraw viewPanelDraw){

       this.viewPanelDraw = viewPanelDraw;

   }

    @Override
    public void actionPerformed(ActionEvent e) {

       switch(e.getActionCommand()){

           case Config.BET_ACTIONCOMMAND:

               System.out.println("BET");

               break;

           case Config.BACK_ACTIONCOMMAND:

                System.out.println("BACK");

                break;

       }



    }

}
