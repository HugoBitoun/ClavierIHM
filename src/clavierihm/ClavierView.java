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

    Touche trois, quatre, cinq, six, sept, huit, neuf, deux, un,
            zero, slash, aSlash, chevrons, pointExclam, pointVirgule, add, mult, soustr, egal, etLogique, pipe, tab, esc, accolades, crochets, pourcentage, guillemet, ctrl, suppr, espace, entrer, maj, a, z, e, r, t, y, u, i, o, flecheG, flecheD, flecheH, flecheB,
            p, q, s, d, f, g, h, j, k, l, m, w, x, c, v, b, n, parentheses;

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

        Scene scene = new Scene(borderPane, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Fonction qui initialise toute les touches 
     */
    public void initTouches() {

        //LIGNE 0
        touches.add(ctrl = new Touche("Ctrl", 0, 0, false));
        touches.add(chevrons = new Touche("<>", 1, 0, false));
        touches.add(slash = new Touche("/", 2, 0, false));
        touches.add(aSlash = new Touche("\\", 3, 0, false));   
                
        //LIGNE 1
        touches.add(esc = new Touche("Esc", 0, 1, false));
        touches.add(guillemet = new Touche("\"\"\'\'", 1, 1, true));
        touches.add(pourcentage = new Touche("%", 2, 1, false));
        touches.add(pointExclam = new Touche("!", 3, 1, false));
        touches.add(un = new Touche("1", 4, 1, false));
        touches.add(deux = new Touche("2", 5, 1, false));
        touches.add(trois = new Touche("3", 6, 1, false));
        touches.add(quatre = new Touche("4", 7, 1, false));
        touches.add(cinq = new Touche("5", 8, 1, false));
        touches.add(six = new Touche("6", 9, 1, false));
        touches.add(sept = new Touche("7", 10, 1, false));
        touches.add(huit = new Touche("8", 11, 1, false));
        touches.add(neuf = new Touche("9", 12, 1, false));
        touches.add(zero = new Touche("0", 13, 1, false));
            
        //LIGNE 2
        touches.add(suppr = new Touche("Delete", 0, 2, 2, 1, false));
        touches.add(crochets = new Touche("[]", 2, 2, false));
        touches.add(accolades = new Touche("{}", 3, 2, false));
        touches.add(a = new Touche("a", 4, 2, true));
        touches.add(z = new Touche("z", 5, 2, true));
        touches.add(e = new Touche("e", 6, 2, true));
        touches.add(r = new Touche("r", 7, 2, true));
        touches.add(t = new Touche("t", 8, 2, true));
        touches.add(y = new Touche("y", 9, 2, true));
        touches.add(u = new Touche("u", 10, 2, true));
        touches.add(i = new Touche("i", 11, 2, true));
        touches.add(o = new Touche("o", 12, 2, true));
        touches.add(p = new Touche("p", 13, 2, true));

        //LIGNE 3
        touches.add(entrer = new Touche("Entrée", 0, 3, 2, 1, false));
        touches.add(pointVirgule = new Touche(";", 2, 3, false));
        touches.add(parentheses = new Touche("()", 3, 3, false));
        touches.add(q = new Touche("q", 4, 3, true));
        touches.add(s = new Touche("s", 5, 3, true));
        touches.add(d = new Touche("d", 6, 3, true));
        touches.add(f = new Touche("f", 7, 3, true));
        touches.add(g = new Touche("g", 8, 3, true));
        touches.add(h = new Touche("h", 9, 3, true));
        touches.add(j = new Touche("j", 10, 3, true));
        touches.add(k = new Touche("k", 11, 3, true));
        touches.add(l = new Touche("l", 12, 3, true));
        touches.add(m = new Touche("m", 13, 3, true));
        
        //LIGNE 4
        touches.add(tab = new Touche("Tab", 0, 4, 2, 1, false));
        touches.add(etLogique = new Touche("&", 2, 4, false));
        touches.add(pipe = new Touche("|", 3, 4, false));
        touches.add(q = new Touche("w", 4, 4, true));
        touches.add(s = new Touche("x", 5, 4, true));
        touches.add(d = new Touche("c", 6, 4, true));
        touches.add(f = new Touche("v", 7, 4, true));
        touches.add(g = new Touche("b", 8, 4, true));
        touches.add(h = new Touche("n", 9, 4, true));
        touches.add(maj = new Touche("Maj", 10, 4, 4, 1, false));
        touches.add(flecheH = new Touche("^", 14, 4, false));
                     
        //LIGNE 5
        touches.add(mult = new Touche("*", 0, 5, false));
        touches.add(add = new Touche("+", 1, 5, false));
        touches.add(soustr = new Touche("-", 2, 5, false));
        touches.add(egal = new Touche("=", 3, 5, false));
        touches.add(espace = new Touche("Espace", 4, 5, 9, 1, false));
        touches.add(flecheG = new Touche("<", 13, 5, false));
        touches.add(flecheB = new Touche("", 14, 5, false));
        touches.add(flecheD = new Touche(">", 15, 5, false));

        for (Touche touche : touches) {
            touche.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        }
    }

    /**
     * Cette fonction ajoute les touches qui sont dans la liste touches dans le gridPane
     * @param gridPane
     */
    public void insertTouches(GridPane gridPane) {
        for (Touche touche : touches) {
            gridPane.add(touche, touche.getCol(), touche.getRow(), touche.getColspan(), touche.getRowspan());
        }
    }

    /**
     * Fonction qui récupère les évenements 
     */
    public void getEvent() {
        ClavierControler controler = new ClavierControler(this, new ClavierModel());
        for (Touche touche : this.touches) {
            touche.addEventHandler(MouseEvent.MOUSE_CLICKED, controler);
        }

        for (Touche touche : this.touches) {
            touche.addEventHandler(KeyEvent.KEY_PRESSED, controler);
        }
    }

}
