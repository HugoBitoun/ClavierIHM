/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavierihm;

import java.util.ArrayList;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author hugo
 */
public class ClavierView {
    
    Touche suppr,espace,entrer,maj,a,z,e,r,t,y,u,i,o,p,q,s,d,f,g,h,j,k,l,m,w,x,c,v,b,n,parentheses;  
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
        touches.add(espace = new Touche("Espace",0,0,false));
        touches.add(suppr = new Touche("Delete",2,0, false)); 
        touches.add(entrer = new Touche("Entrée",1,0, false));
        touches.add(maj = new Touche("Maj",3,0,true));

        
        // LIGNE 1 AZERTY
        touches.add(parentheses = new Touche("()",10,2,false));
        touches.add(a = new Touche("a", 0,2, true));
        touches.add(z = new Touche("z", 1,2, true));
        touches.add(e = new Touche("e",2,2, true));
        touches.add(r = new Touche("r",3,2, true));
        touches.add(t = new Touche("t",4,2, true));
        touches.add(y = new Touche("y",5,2, true));
        touches.add(u = new Touche("u",6,2, true));
        touches.add(i = new Touche("i",7,2, true));
        touches.add(o = new Touche("o",8,2, true));
        touches.add(p = new Touche("p",9,2, true));
        
        // LIGNE 2 AZERTY
        touches.add(q = new Touche("q", 0,3, true));
        touches.add(s = new Touche("s", 1,3, true));
        touches.add(d = new Touche("d",2,3, true));
        touches.add(f = new Touche("f",3,3, true));
        touches.add(g = new Touche("g",4,3, true));
        touches.add(h = new Touche("h",5,3, true));
        touches.add(j = new Touche("j",6,3, true));
        touches.add(k = new Touche("k",7,3, true));
        touches.add(l = new Touche("l",8,3, true));
        touches.add(m = new Touche("m",9,3, true));
        
        // LIGNE 3 AZERTY
        touches.add(q = new Touche("w", 0,4, true));
        touches.add(s = new Touche("x", 1,4, true));
        touches.add(d = new Touche("c",2,4, true));
        touches.add(f = new Touche("v",3,4, true));
        touches.add(g = new Touche("b",4,4, true));
        touches.add(h = new Touche("n",5,4, true));
        
        
        
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
        
        for (Touche touche : this.touches){
            touche.addEventHandler(KeyEvent.KEY_PRESSED, controler);
        }
    }
    
}
