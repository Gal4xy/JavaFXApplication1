/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import javafx.scene.control.ProgressBar;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Galaxy Yang
 */
public class IndexController implements Initializable {

    
     @FXML 
    private TextField testName;
    @FXML 
    private TextField dateT;
    @FXML 
    private TextField hitLine;
    @FXML 
    private TextField totalLine;
    @FXML 
    private TextField coverageL;
    @FXML 
    private TextField fileName;
   
    @FXML 
    private ProgressBar pbar1;
    @FXML 
    private ProgressIndicator pi;
    
    private Stage stage;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
             StaticData sd=new StaticData();
             sd.getContext();
             sd.calculate();
              pbar1.setProgress(sd.getProgress());
              pi.setProgress(sd.getProgress());
              dateT.setText(sd.getDate());
              hitLine.setText(sd.getHitLineNumer());
              totalLine.setText(sd.getTotalLineNumber());
              coverageL.setText(""+sd.getProgress());
        
        }
          catch(Exception e){
            e.printStackTrace();
        }
    }    
    
    
    
    @FXML 
    protected void handleSubmitButtonAction(ActionEvent event)throws IOException {
       System.out.println("button is clicked");
       gotoDetail();
    }

   public void gotoDetail(){
       try {
           HelloFXController detail=(HelloFXController)replaceSceneContent("HelloFX.fxml");
          // detail.setApp(this);
       }
       catch(Exception e){
           
       }
       
   }
       
     private Initializable replaceSceneContent(String fxml) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        InputStream in =JavaFXApplication1 .class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(JavaFXApplication1.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page, 800, 600);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
 }



