/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage.main;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
     private List<String> list;
     private static final String filepath="C:\\\\Path\\\\Path.txt";
     
  
    
    
     public WelcomeController() throws IOException{
       this.list=new ArrayList<String>();   
        try{
           this.getContext(filepath);
       }
        catch(Exception e){
            e.printStackTrace();
        }
     }
     
     public void setApp(Coverage application){
        this.application=application;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         *   set default values for fields
        
       try{
           this.getContext(filepath);
       }
        catch(Exception e){
            e.printStackTrace();
        }
       */
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
    
    
    /**
     *  added bu Galaxy 15:18
     */
     @FXML 
    protected void handleSrcPathButtonAction(ActionEvent event) {
       System.out.println("button is clicked");
       if(application==null){
           System.out.println("Errror_applicationNull");
       }
       else{
       application.gotoIndex();}
    }
    
     @FXML 
    protected void handleSrcCovPathButtonAction(ActionEvent event) {
       System.out.println("button is clicked");
       if(application==null){
           System.out.println("Errror_applicationNull");
       }
       else{
       application.gotoIndex();}
    }
    
     @FXML 
    protected void handleObjCovButtonAction(ActionEvent event) {
       System.out.println("button is clicked");
       if(application==null){
           System.out.println("Errror_applicationNull");
       }
       else{
       application.gotoIndex();}
    }
    
    /**
     * read files
     */

    public void getContext(String filepath) throws IOException{
     if(list!=null){
        File f=new File(filepath);
       BufferedReader br=new BufferedReader(new FileReader(f));
       String s;
       while((s=br.readLine())!=null){
           list.add(s);
           } 
        System.out.println(" SIZE "+list.size());
     }
     else{
           System.out.println("Error_listEmpty");
     }
    }
    
    
    public List<String> getList(){
        return list;
    }
}
