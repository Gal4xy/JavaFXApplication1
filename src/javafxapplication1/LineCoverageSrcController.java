/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Galaxy Yang
 */
public class LineCoverageSrcController implements Initializable {

    
      private Coverage application;
      private static String filepath="C:\\\\Users\\\\Galaxy Yang\\\\Desktop\\\\1.txt";
      private static String filepathSrc="C:\\\\Users\\\\Galaxy Yang\\\\Desktop\\\\WHETS.C";
      private  List<String> list;
      private Map<String,Integer> info;
  
   
    @FXML 
    private VBox VBox;
    
   
   
    public void setApp(Coverage application){
        this.application=application;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        list=new ArrayList<String>();
        info=new HashMap<String,Integer>();
        
        StaticData sd=new StaticData(); 
        
        
          try{
          sd.getContext(filepath);
                if(sd.getMapInfo()!=null){
                    info=sd.getMapInfo();
                    System.out.println("res"+info.values().size());
                        for(String s:info.keySet()){
                            System.out.println(" S IN KEYSET "+s);
                        }
                      this.getSrcContext();
                      this.insertContext(sd.getMapInfo());               
                }
                else{
                    System.out.println("Error_MapNull");
                }
          
          
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
    }    
    
    
     //insert context 
    public void insertContext(Map<String,Integer> info)throws IOException{
        
        if(list.isEmpty()==false){
           for(int i=0;i<list.size();i++){
              String str=list.get(i);
              String num=""+i;
               Text t=new Text(str);
                   if(info.get(num)!=null&&info.get(num)==1){
                       System.out.println(" Line "+i+" is "+info.get(num));
                              t.setFill(Color.GREEN);}
                         else{t.setFill(Color.GREY);}
               VBox.getChildren().add(t);}
           }            
       
        else{
            Text ErrorMsg=new Text("Sry Error_insert");
            VBox.getChildren().add(ErrorMsg);
        }
        
    }
    
    
    // read
    protected void getSrcContext() throws IOException{
     
        File f=new File(filepathSrc);
       BufferedReader br=new BufferedReader(new FileReader(f));
       String s;
       while((s=br.readLine())!=null){
           list.add(s);
       } 
        System.out.println(list.size());
    }
    
    
    
      @FXML 
    protected void handleReturnButtonAction(ActionEvent event) {
       if(application!=null){
           application.gotomain();
       }
    }
}
