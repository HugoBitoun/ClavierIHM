/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavierihm;

/**
 * Cette classe n'est pas utile pour le moment mais peut-etre plus tard 
 * @author hugo
 */
public class ClavierModel {
    
    private int pos = 0; 

    ClavierModel() {
    }

    public int getPos() {
        return pos;
    }
    
    public void increment(){
        this.pos+=1; 
    }
    
    public void decrement(){
        this.pos+=1; 
    }
}
