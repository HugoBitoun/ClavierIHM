/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavierihm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author hugo
 */
public class ClavierView {
    
    Touche suppr,espace,entrer,maj,a,z,e,r,t,y,u,i,o,p,q,s,d,f,g,h,j,k,l,m,w,x,c,v,b,n;  
    TextArea textArea; 
    ArrayList<Touche> touches = new ArrayList(); 

    ClavierView(Stage primaryStage) {
        
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane(); 
        textArea = new TextArea(); 
        
        initTouches();
        getEvent(); 
        insertTouches(gridPane); 
        
        
        
        borderPane.setCenter(textArea);
        borderPane.setBottom(gridPane);
        
        Scene scene = new Scene(borderPane, 400,200); 
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    
    public void initTouches(){
        touches.add(espace = new Touche("Espace",0,0));
        touches.add(suppr = new Touche("Delete",2,0)); 
        touches.add(entrer = new Touche("Entrée",1,0));
        touches.add(maj = new Touche("Maj",3,0));

        
        // LIGNE 1 AZERTY
        touches.add(a = new Touche("a", 0,2));
        touches.add(z = new Touche("z", 1,2));
        touches.add(e = new Touche("e",2,2));
        touches.add(r = new Touche("r",3,2));
        touches.add(t = new Touche("t",4,2));
        touches.add(y = new Touche("y",5,2));
        touches.add(u = new Touche("u",6,2));
        touches.add(i = new Touche("i",7,2));
        touches.add(o = new Touche("o",8,2));
        touches.add(p = new Touche("p",9,2));
        
        // LIGNE 2 AZERTY
        touches.add(q = new Touche("q", 0,3));
        touches.add(s = new Touche("s", 1,3));
        touches.add(d = new Touche("d",2,3));
        touches.add(f = new Touche("f",3,3));
        touches.add(g = new Touche("g",4,3));
        touches.add(h = new Touche("h",5,3));
        touches.add(j = new Touche("j",6,3));
        touches.add(k = new Touche("k",7,3));
        touches.add(l = new Touche("l",8,3));
        touches.add(m = new Touche("m",9,3));
        
        // LIGNE 3 AZERTY
        touches.add(q = new Touche("w", 0,4));
        touches.add(s = new Touche("x", 1,4));
        touches.add(d = new Touche("c",2,4));
        touches.add(f = new Touche("v",3,4));
        touches.add(g = new Touche("b",4,4));
        touches.add(h = new Touche("n",5,4));
        
        
        
    }
    
    public void insertTouches(GridPane gridPane){
        for (Touche touche : touches){
            gridPane.add(touche, touche.getCol(), touche.getRow(),touche.getColspan(),touche.getRowspan());
        }
    }
    
    public void getEvent(){
        ClavierControler controler = new ClavierControler(this, new ClavierModel()); 
        for (Touche touche : this.touches){
            touche.addEventHandler(MouseEvent.MOUSE_CLICKED, controler);
        }
    }
    
}
