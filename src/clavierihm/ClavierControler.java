/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavierihm;

import java.awt.event.KeyEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author hugo
 */
public class ClavierControler implements EventHandler {

    private ClavierView view;
    private ClavierModel model;

    ClavierControler(ClavierView view, ClavierModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void handle(Event event) {

        if (this.view.maj.isDisable() && ((Touche) event.getSource()).isMajOk()) {
            this.view.textArea.appendText(((Touche) event.getSource()).getText().toUpperCase());
            this.view.maj.setDisable(false);
        } else {

            if (this.view.maj.isDisable()){
                this.view.maj.setDisable(false);
            }
            
            if (event.getSource().equals(this.view.espace)) {
                this.view.textArea.appendText(" ");
            } else if (event.getSource().equals(this.view.entrer)) {
                this.view.textArea.appendText("\n");
            } else if (event.getSource().equals(this.view.suppr)) {
                this.view.textArea.deletePreviousChar();
            } else if (event.getSource().equals(this.view.maj)) {
                this.view.maj.setDisable(true);
            } else {
                this.view.textArea.appendText(((Touche) event.getSource()).getText());
            }

        }

    }

}
