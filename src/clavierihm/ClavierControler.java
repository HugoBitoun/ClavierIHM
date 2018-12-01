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

        int caret = this.view.textArea.getCaretPosition();

        if (this.view.maj.isDisable() && ((Touche) event.getSource()).isMajOk()) {
            if (event.getSource().equals(this.view.guillemet)) {
                this.view.textArea.insertText(caret, "\'\'");
            } else {
                this.view.textArea.insertText(caret, ((Touche) event.getSource()).getText().toUpperCase());
            }
            this.view.maj.setDisable(false);
        } else {

            if (this.view.maj.isDisable()) {
                this.view.maj.setDisable(false);
            }

            if (event.getSource().equals(this.view.espace)) {
                this.view.textArea.insertText(caret, " ");
            } else if (event.getSource().equals(this.view.entrer)) {
                this.view.textArea.insertText(caret, "\n");
            } else if (event.getSource().equals(this.view.suppr)) {
                this.view.textArea.deletePreviousChar();
            } else if (event.getSource().equals(this.view.maj)) {
                this.view.maj.setDisable(true);
            } else if (event.getSource().equals(this.view.guillemet)) {
                this.view.textArea.insertText(caret, "\"\"");
            } else if(event.getSource().equals(this.view.tab)){
                this.view.textArea.insertText(caret, "  ");
            } else {
                this.view.textArea.insertText(caret, ((Touche) event.getSource()).getText());
            }
        }
    }

}
