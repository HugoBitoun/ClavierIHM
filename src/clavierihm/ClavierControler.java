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
        
        
        String colorMajPressed = "-fx-background-color: #676767;";
        String colorMajDefault = ""; 
        int caret = this.view.textArea.getCaretPosition();

        if (this.view.maj.getStyle().equals(colorMajPressed) && ((Touche) event.getSource()).isMajOk()) {
            if (event.getSource().equals(this.view.guillemet)) {
                this.view.textArea.insertText(caret, "\'\'");
            } else if (event.getSource().equals(this.view.chevrons)){
                this.view.textArea.insertText(caret, ">");
            } else {
                this.view.textArea.insertText(caret, ((Touche) event.getSource()).getText().toUpperCase());
            }
        } else {
            if (event.getSource().equals(this.view.espace)) {
                this.view.textArea.insertText(caret, " ");
            } else if (event.getSource().equals(this.view.entrer)) {
                this.view.textArea.insertText(caret, "\n");
            } else if (event.getSource().equals(this.view.suppr)) {
                this.view.textArea.deletePreviousChar();
            } else if (event.getSource().equals(this.view.maj)) {
                if (this.view.maj.getStyle().equals(colorMajPressed)) {
                    this.view.maj.setStyle(colorMajDefault);
                } else {
                    this.view.maj.setStyle(colorMajPressed);
                }
            } else if (event.getSource().equals(this.view.guillemet)) {
                this.view.textArea.insertText(caret, "\"\"");
            } else if (event.getSource().equals(this.view.esc)){
                // useless
            } else if (event.getSource().equals(this.view.chevrons)){
                this.view.textArea.insertText(caret, "<");
            } else if (event.getSource().equals(this.view.tab)) {
                this.view.textArea.insertText(caret, "    ");
            } else if (event.getSource().equals(this.view.flecheG)) {//l'event arrivé esr : de se déplacer à gauche
                this.view.textArea.positionCaret(caret - 1);
            } else if (event.getSource().equals(this.view.flecheD)) {//l'event arrivé esr : de se déplacer à droite
                this.view.textArea.positionCaret(caret + 1);
            } 
            else {
                this.view.textArea.insertText(caret, ((Touche) event.getSource()).getText());
            }
        }
    }

}
