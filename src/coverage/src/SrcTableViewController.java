/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage.src;

import coverage.main.Coverage;
import coverage.sum.FileBean;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.TextField;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Galaxy Yang
 */
public class SrcTableViewController implements Initializable {
    
    
     @FXML 
    private TableView<SrcBean> table;
    
    @FXML 
    private TableColumn Name;
    
    @FXML 
    private TableColumn PrjName;
     
    @FXML 
    private TableColumn LineProgress;
    
    @FXML 
    private TableColumn LinePer;
    
    @FXML 
    private TableColumn FProgress;
    
    @FXML 
    private TableColumn FPer;
    
    @FXML 
    private TextField Cover_L;
    
     @FXML 
    private TextField Total_L;
     
     @FXML 
    private TextField Cover_F;
     
     @FXML 
    private TextField Total_F;
    
     
    @FXML 
    private BarChart linebar;
    
    @FXML 
    private BarChart fbar;
     
    private final ObservableList<SrcBean> data;
    private Coverage application;
    private final String c="运行";
    private final String uc="未运行";
    
    
     public SrcTableViewController(){
     
      // cov.getColumns().addAll(cov_synax,cov_fragment);
        
      data=FXCollections.observableArrayList(
        new SrcBean("WHET.C","WHETS",00.47,"47%",00.57,"57%",149,315,56,98),
        new SrcBean("TIME.C","WHETS",00.40,"40%",00.00,"0%",14,35,0,0),
        new SrcBean("a.C","WHETS",00.25,"25%",00.61,"61%",14,35,0,0),
        new SrcBean("b.C","WHETS",00.34,"34%",00.10,"10%",14,35,0,0)
      );
      
       
    }
     
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         this.setColumns();
       // tf.setText("Hello World");
      table.setItems(data);
      table.getColumns().addAll(Name,PrjName,LineProgress,LinePer,FProgress,FPer);
      table.setOnMouseClicked(new EventHandler<Event>(){
            public void handle(Event e){
                TableViewSelectionModel<SrcBean> selectionModel=table.selectionModelProperty().get();
                SrcBean srcBean=selectionModel.getSelectedItem();
                    if(srcBean==null){
                        return;
                    }
                    else{
                        
                         linebar.getData().clear();
                         fbar.getData().clear();
                         
                         Cover_L.setText(srcBean.getCov_L()+" ");
                         Cover_F.setText(srcBean.getCov_F()+" ");
                         Total_L.setText(srcBean.getTotal_L()+" ");
                         Total_F.setText(srcBean.getTotal_F()+" ");
                         
                        XYChart.Series series1 = new XYChart.Series();
                        series1.getData().add(new XYChart.Data(c,srcBean.getLineProgress()));
                        series1.getData().add(new XYChart.Data(uc,(1-srcBean.getLineProgress())));

                        linebar.getData().add(series1);
                        

                        XYChart.Series series2 = new XYChart.Series();
                        series2.getData().add(new XYChart.Data(c,srcBean.getFProgress()));
                        series2.getData().add(new XYChart.Data(uc,(1-srcBean.getFProgress())));

                        fbar.getData().add(series2);
                        
                        
                    }
            }
            
        });
    }    
 
    
    public void setApp(Coverage application){
        this.application=application;
    }

     public void setColumns(){
         
        Name.setCellValueFactory(
        new PropertyValueFactory<>("Name"));
        
        PrjName.setCellValueFactory(
        new PropertyValueFactory<>("PrjName"));
        
        
        LineProgress.setCellValueFactory(
        new PropertyValueFactory<>("lineProgress"));
        
        LineProgress.setCellFactory(
        ProgressBarTableCell.forTableColumn());
        
         LinePer.setCellValueFactory(
        new PropertyValueFactory<>("linePer"));
         
         FProgress.setCellValueFactory(
        new PropertyValueFactory<>("fProgress"));
        
        FProgress.setCellFactory(
        ProgressBarTableCell.forTableColumn());
        
         FPer.setCellValueFactory(
        new PropertyValueFactory<>("fPer"));
     }
     
       @FXML 
    protected void handleReturnButtonAction(ActionEvent event) {
       if(application!=null){
           application.gotomain();
       }
    }
     
    public void setProgressColor(){
        
    }
    
}



