/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavierihm;

import java.awt.event.KeyEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;

/**
 *
 * @author hugo
 */
public class ClavierControler implements EventHandler {

    private ClavierView view;
  
    //private int lastLine = 0;
    //private int nextLine = 0;

    ClavierControler(ClavierView view) {
        this.view = view;
    }

    @Override
    public void handle(Event event) {

        //System.out.println("caret debut = "+this.view.textArea.getCaretPosition());
        String colorMajPressed = "-fx-background-color: #676767;";
        String colorMajDefault = "";
        int caret = this.view.textArea.getCaretPosition();

        if (((Touche) event.getSource()).isUsefull()) {

            if (this.view.maj.getStyle().equals(colorMajPressed) && ((Touche) event.getSource()).isMajOk()) {
                if (event.getSource().equals(this.view.guillemet)) {
                    this.view.textArea.insertText(caret, "\'\'");
                    this.view.textArea.positionCaret(this.view.textArea.getCaretPosition() - 1);
                } else if (event.getSource().equals(this.view.chevrons)) {
                    this.view.textArea.insertText(caret, ">");
                } else if (event.getSource().equals(this.view.dollar)) {
                    this.view.textArea.insertText(caret, "€");
                } else if (event.getSource().equals(this.view.pointExclam)) {
                    this.view.textArea.insertText(caret, "?");
                } else if (event.getSource().equals(this.view.pipe)) {
                    this.view.textArea.insertText(caret, "&");
                } else {
                    this.view.textArea.insertText(caret, ((Touche) event.getSource()).getText().toUpperCase());
                }
            } else {
                if (event.getSource().equals(this.view.espace)) {
                    this.view.textArea.insertText(caret, " ");
                } else if (event.getSource().equals(this.view.entrer)) {
                    this.view.textArea.insertText(caret, "\n");
                    //lastLine = this.view.textArea.getCaretPosition()-1;
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
                    this.view.textArea.positionCaret(caret + 1);
                } else if (event.getSource().equals(this.view.parentheses)) {
                    this.view.textArea.insertText(caret, "()");
                    this.view.textArea.positionCaret(this.view.textArea.getCaretPosition() - 1);
                } else if (event.getSource().equals(this.view.crochets)) {
                    this.view.textArea.insertText(caret, "[]");
                    this.view.textArea.positionCaret(this.view.textArea.getCaretPosition() - 1);
                } else if (event.getSource().equals(this.view.accolades)) {
                    this.view.textArea.insertText(caret, "{}");
                    this.view.textArea.positionCaret(this.view.textArea.getCaretPosition() - 1);
                } else if (event.getSource().equals(this.view.esc)) {
                    // useless
                } else if (event.getSource().equals(this.view.chevrons)) {
                    this.view.textArea.insertText(caret, "<");
                } else if (event.getSource().equals(this.view.parentheses)) {
                    this.view.textArea.insertText(caret, "()");
                    this.view.textArea.positionCaret(caret + 1);
                } else if (event.getSource().equals(this.view.crochets)) {
                    this.view.textArea.insertText(caret, "[]");
                    this.view.textArea.positionCaret(caret + 1);
                } else if (event.getSource().equals(this.view.accolades)) {
                    this.view.textArea.insertText(caret, "{}");
                    this.view.textArea.positionCaret(caret + 1);
                } else if (event.getSource().equals(this.view.tab)) {
                    this.view.textArea.insertText(caret, "    ");
                } else if (event.getSource().equals(this.view.flecheG)) {//l'event arrivé esr : de se déplacer à gauche
                    this.view.textArea.positionCaret(caret - 1);
                } else if (event.getSource().equals(this.view.flecheD)) {//l'event arrivé esr : de se déplacer à droite
                    this.view.textArea.positionCaret(caret + 1);
                } else if (event.getSource().equals(this.view.flecheH)) {//l'event arrivé esr : de se déplacer en haut
                    //nextLine = this.view.textArea.getCaretPosition()+1;
                    //this.view.textArea.positionCaret(lastLine);
                } else if (event.getSource().equals(this.view.flecheB)) {//l'event arrivé esr : de se déplacer en bas
//                if(nextLine != 0){
//                    lastLine = this.view.textArea.getCaretPosition();
//                    this.view.textArea.positionCaret(nextLine);
//                }
                } else if (event.getSource().equals(this.view.suppr2)) {
                    this.view.textArea.deleteNextChar();
                } else if (event.getSource().equals(this.view.debut)) {
                    this.view.textArea.positionCaret(0);
                } else if (event.getSource().equals(this.view.fin)) {
                    this.view.textArea.positionCaret(Integer.MAX_VALUE);
                } else if (event.getSource().equals(this.view.dollar)) {
                    this.view.textArea.insertText(caret, "$");
                } else if (event.getSource().equals(this.view.pointExclam)) {
                    this.view.textArea.insertText(caret, "!");
                } else if (event.getSource().equals(this.view.pipe)) {
                    this.view.textArea.insertText(caret, "|");
                } else {
                    this.view.textArea.insertText(caret, ((Touche) event.getSource()).getText());
                }
            }
            //System.out.println("caret Fin = "+this.view.textArea.getCaretPosition()+"\n");
        }
    }

}
