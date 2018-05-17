/**
 * @author Victor Aznar Echevarria - victor.aznar.2017
 * @project ViewRuleta
 */

package controller;


import view.ViewPanelDraw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class betAmountController implements ActionListener {

    ViewPanelDraw viewPanelDraw;

    public betAmountController(ViewPanelDraw viewPanelDraw){
        this.viewPanelDraw = viewPanelDraw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        viewPanelDraw.updateBetLabelValue();
        //TODO: Comprovar que el valor introduït es correcte i fer l'aposta
    }
}
