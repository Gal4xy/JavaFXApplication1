/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage.src;

import coverage.StaticData;
import coverage.main.Coverage;
import coverage.main.WelcomeController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Galaxy Yang
 */
public class IndexsrcController implements Initializable {

  // private static String filepath="C:\\\\Users\\\\Galaxy Yang\\\\Desktop\\\\WHETS.srccov";
   private String filepath="";
   private String ProjName="";
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
    private TextField hitf;
    @FXML 
    private TextField totalf;
    @FXML 
    private TextField coveragef;
   
    @FXML 
    private ProgressBar pbar1;
    @FXML 
    private TextField pi;
    
     @FXML 
    private ProgressBar pbar2;
    @FXML 
    private TextField pf;
    
      @FXML 
    private BarChart linebar;
    @FXML 
    private BarChart fragmentbar;
    
    private Stage stage;
    private Coverage application;
    private final String c="运行";
    private final String uc="未运行";
    
    public void setApp(Coverage application){
        this.application=application;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        StaticData sd=new StaticData();
      try{  
      //read
      WelcomeController wc=new WelcomeController();
             this.filepath=wc.getList().get(2);
             this.ProjName=wc.getList().get(4);
        sd.getContext(filepath);
        
         sd.calculate();
             
              linebar.setStyle("-fx-fill:red");
             
             //colour 
             if(sd.getProgressLine()!=1){
             pbar1.setStyle("-fx-accent:red");}
             else{
                 pbar1.setStyle("-fx-accent:green");
             }
            
           if(sd.getProgressLine()!=1){
             pbar2.setStyle("-fx-accent:red");}
             else{
                 pbar2.setStyle("-fx-accent:green");
             }
            
             
             
             
             pbar1.setProgress(sd.getProgressLine());
              pi.setText(sd.getProgressLineStr());
              pbar2.setProgress(sd.getProgressF());
              pf.setText(sd.getProgressfStr());
              dateT.setText(sd.getDate());
              hitLine.setText(sd.getHitLineNumer());
              totalLine.setText(sd.getTotalLineNumber());
              totalf.setText(sd.getHitFNumber());
              hitf.setText(sd.getTotalFNumber());
              coverageL.setText(sd.getProgressLineStr());
              coveragef.setText(sd.getProgressfStr());
              testName.setText("002");
              fileName.setText(this.ProjName);
              
         
        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(c,sd.getProgressLine()));
        series1.getData().add(new XYChart.Data(uc,(1-sd.getProgressLine())));
     
       linebar.getData().add(series1);
       
        XYChart.Series series2 = new XYChart.Series();
        series2.getData().add(new XYChart.Data(c,sd.getProgressF()));
        series2.getData().add(new XYChart.Data(uc,(1-sd.getProgressF())));
        
       fragmentbar.getData().add(series2);
      
      }
      
      catch(Exception e){
          e.printStackTrace();
      }
    }    
    
    
     @FXML 
    protected void handleSubmitButtonAction(ActionEvent event)throws IOException {
        if(application!=null){
           application.gotoLCSrc();
       }
    }
    
    
      @FXML 
    protected void handleReturnButtonAction(ActionEvent event) {
       if(application!=null){
           application.gotomain();
       }
    }
}
