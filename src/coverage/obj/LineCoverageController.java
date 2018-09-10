/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage.obj;

import coverage.main.Coverage;
import coverage.main.WelcomeController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.io.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.ProgressBar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Galaxy Yang
 */
public class LineCoverageController implements Initializable {
      private Coverage application;
      //private static String filepath="C:\\\\Users\\\\Galaxy Yang\\\\Desktop\\\\WHETS.objcov";
      private String filepath="";
      private  ArrayList<String> a;
     
  
    @FXML 
    private TextField ins_c;
    @FXML 
    private TextField ins_r;
    @FXML 
    private TextField cov_c;
    @FXML 
    private TextField cov_r;
    @FXML 
    private TextField C_c;
    @FXML 
    private TextField C_i;
    @FXML 
    private VBox VBox;
    @FXML 
    private ProgressBar p_i;
    @FXML 
    private ProgressBar p_c;
    
   
    public void setApp(Coverage application){
        this.application=application;
    }
      /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
          a=new ArrayList<String>();
         
          try{
            WelcomeController wc=new WelcomeController();
           //this.filepath=wc.getList().get(3);
          getContext();
          this.insertContext();
         
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
       }
    
    
    
    
    
    @FXML 
    protected void handleReturnButtonAction(ActionEvent event) {
       if(application!=null){
           application.gotomain();
       }
    }
    
    // read
    protected void getContext() throws IOException{
     
        File f=new File(filepath);
       BufferedReader br=new BufferedReader(new FileReader(f));
       String s;
       while((s=br.readLine())!=null){
           a.add(s);
       } 
        System.out.println(a.size());
    }

   //insert context 
    public void insertContext()throws IOException{
        
        if(a.isEmpty()==false){
           for(String s:a){
               Text t=new Text(s);
                   if(s.length()>16){
                         if(s.charAt(16)!='0'){
                              t.setFill(Color.GREEN);}
                         else{t.setFill(Color.RED);}
               VBox.getChildren().add(t);}
           }
        }
        
        else{
            Text ErrorMsg=new Text("Sry Error_insert");
            VBox.getChildren().add(ErrorMsg);
        }
        
    }
   
  
}
