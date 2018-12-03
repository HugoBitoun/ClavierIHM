/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavierihm;

import javafx.scene.control.Button;

/**
 *
 * @author hugo
 */
public class Touche extends Button {
    
    private int col, row, colspan, rowspan;  
    private boolean majOk, usefull;

    Touche(String text, int col, int row, int colspan, int rowspan, boolean majOk, boolean usefull) {
        super(text);
        this.col = col;
        this.row = row;
        this.colspan = colspan; 
        this.rowspan = rowspan; 
        this.majOk = majOk;
        this.usefull = usefull; 
    }

    public boolean isUsefull() {
        return usefull;
    }
    
    Touche(String text, int col, int row, boolean majOk, boolean usefull) {
        super(text);
        colspan = 1; 
        rowspan = 1; 
        this.col = col;
        this.row = row; 
        this.majOk = majOk; 
        this.usefull = usefull;
        
    }

    public int getCol() {
        return col;
    }

    public boolean isMajOk() {
        return majOk;
    }

    public int getRow() {
        return row;
    }

    public int getColspan() {
        return colspan;
    }

    public int getRowspan() {
        return rowspan;
    } 
}
