/*
 * 2018.08.23 17:20 String/Integer 版本
 */
package coverage.sum;

import coverage.main.Coverage;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.TextField;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * FXML Controller class
 *
 * @author Galaxy Yang
 */
public class TableViewController implements Initializable {

    
    @FXML 
    private TableView<FileBean> table;
    
    @FXML 
    private TableColumn check;
    
    @FXML 
    private TableColumn index;
     
    @FXML 
    private TableColumn date;
    
    @FXML 
    private TableColumn name;
    
    @FXML 
    private TableColumn per;
    
    @FXML 
    private TableColumn cov;
    
    
 /*   
   private TableColumn cov_synax;
   private TableColumn cov_fragment;
    */
    private final ObservableList<FileBean> data;
    private Coverage application;
   
    public TableViewController(){
     
      // cov.getColumns().addAll(cov_synax,cov_fragment);
        
      data=FXCollections.observableArrayList(
         new FileBean(true,1,"2018-08-23 18:06","WHETS",00.23,"23%"),
         new FileBean(false,2,"2018-08-23 18:08","WHETS",00.56,"56%"),
         new FileBean(false,3,"2018-08-23 19:27","WHETS",00.77,"77%"),
         new FileBean(false,4,"2018-08-23 19:45","WHETS",00.49,"49%"),
         new FileBean(false,5,"2018-08-23 19:57","WHETS",00.80,"80%"),
         new FileBean(false,6,"2018-08-23 20:02","WHETS",00.12,"12%")
      );
      
       
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.setColumns();
        table.setItems(data);
        table.getColumns().addAll(check,index,date,name,cov);
       /*
        table.setOnMouseClicked(new EventHandler<Event>(){
            public void handle(Event e){
                TableViewSelectionModel<FileBean> selectionModel=table.selectionModelProperty().get();
                FileBean fileBean=selectionModel.getSelectedItem();
                    if(fileBean==null){
                        return;
                    }
                    else{
                        
                    }
            }
            
        });
    
  */
     }    
    
     public void setApp(Coverage application){
        this.application=application;
    }
    
     
     
     public void setColumns(){
          check.setCellFactory(CheckBoxTableCell.forTableColumn(check)
        );
        
        index.setCellValueFactory(
        new PropertyValueFactory<>("index"));
        
        date.setCellValueFactory(
        new PropertyValueFactory<>("date"));
        
        name.setCellValueFactory(
        new PropertyValueFactory<>("name"));
        
        cov.setCellValueFactory(
        new PropertyValueFactory<>("cov"));
        
        cov.setCellFactory(
        ProgressBarTableCell.forTableColumn());
        
         per.setCellValueFactory(
        new PropertyValueFactory<>("per"));
     }
     
       @FXML 
    protected void handleReturnButtonAction(ActionEvent event) {
       if(application!=null){
           application.gotomain();
       }
    }
}
