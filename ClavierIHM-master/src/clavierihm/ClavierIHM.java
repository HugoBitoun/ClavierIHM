/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clavierihm;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author hugo
 */
public class ClavierIHM extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       ClavierView view = new ClavierView(primaryStage); 
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
