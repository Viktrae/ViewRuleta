/**
 * @author Victor Aznar Echevarria - victor.aznar.2017
 * @project ViewRuleta
 */

import controller.ButtonController;
import controller.ButtonsAnimationController;
import controller.betAmountController;
import view.Config;
import view.ViewRuleta;


public class Main {
    public static void main(String[] args) {

        Config.loadFont();
        ViewRuleta viewRuleta = new ViewRuleta();
        viewRuleta.setVisible(true);
        viewRuleta.startAnimations();
        //Creem i registrem controladors
        ButtonController buttonController = new ButtonController(viewRuleta.getMainPanel());
        ButtonsAnimationController buttonsAnimationController = new ButtonsAnimationController(viewRuleta.getMainPanel());
        betAmountController betAmountController = new betAmountController(viewRuleta.getMainPanel());
        viewRuleta.registerControllers(buttonController, buttonsAnimationController, betAmountController);
    }
}
