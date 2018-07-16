/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Galaxy Yang
 */
public class WelcomeController implements Initializable {

    private Coverage application;
    
     public void setApp(Coverage application){
        this.application=application;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
       @FXML 
    protected void handleStartButtonAction(ActionEvent event) {
       System.out.println("button is clicked");
       if(application==null){
           System.out.println("Errror_applicationNull");
       }
       else{
       application.gotoIndex();}
    }
    
   
        @FXML 
    protected void handleStartsrcButtonAction(ActionEvent event) {
       System.out.println("button is clicked");
       if(application==null){
           System.out.println("Errror_applicationNull");
       }
       else{
       application.gotoIndexSrc();}
    }
}
