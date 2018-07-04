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
import javafx.scene.control.*;
import java.util.ArrayList;
import java.io.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author Galaxy Yang
 */
public class HelloFXController implements Initializable {

      private static String filepath="C:\\\\Users\\\\Galaxy Yang\\\\Desktop\\\\WHETS.objcov";
      private  ArrayList<String> a;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
          a=new ArrayList<String>();
       }
    
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
    
    @FXML 
    protected void handleSubmitButtonAction(ActionEvent event)throws IOException {
        System.out.println("handleAction Completed");
        this.getContext();
        
     if(a.isEmpty()==false){
        
         double s1=Double.parseDouble(a.get(1));
         double s2=Double.parseDouble(a.get(0));
         double s3=Double.parseDouble(a.get(3));
         double s4=Double.parseDouble(a.get(2));
         
         double p1=s1/s2;
         double p2=s3/s4;
         
         System.out.println("1ST"+p1+"2nd"+p2+""+s1+""+s2+""+s3+""+s4);
         
      ins_c.setText(a.get(0));
       ins_r.setText(a.get(1));
       cov_c.setText(a.get(2));
       cov_r.setText(a.get(3));
      p_i.setProgress(p1);
      p_c.setProgress(p2);
        C_i.setText(p1+"");
        C_c.setText(p2+"");
                      
        this.insertContext();
     
     }
     else{
         ins_c.setText("Sry Error");
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
