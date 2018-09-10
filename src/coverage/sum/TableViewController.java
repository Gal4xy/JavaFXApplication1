/*
 * 2018.08.23 17:20 String/Integer 版本
 */
package coverage.sum;

import coverage.BeanFactory;
import coverage.CovConstants;
import coverage.StaticData;
import coverage.main.Coverage;
import java.io.BufferedReader;
import java.io.File;
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
import java.io.IOException;

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
    private String filePath="";
   
    public TableViewController(){
     
      // cov.getColumns().addAll(cov_synax,cov_fragment);
       /* 
       data=FXCollections.observableArrayList();
        
        */
       
     
      
      data=FXCollections.observableArrayList(
      );
      
        String PrjName=CovConstants.PrjName;
        filePath=this.getFilePath(PrjName);
        System.out.println("CHECK_89_FILEPATH "+filePath);
        
       try{
          this.getContext(filePath);
         }
         catch(IOException e){
         }
       
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
    
    @FXML 
    protected void handleStartButtonAction(ActionEvent event) throws IOException{
       String filePath="C:\\Program Files\\Notepad++\\notepad++.exe";
       Runtime rt=Runtime.getRuntime();
       rt.exec(filePath);
    }
    
    
    /**
     * 20180829 14:16  
     *  数据注入
     * @param filePath
     * @throws IOException 
     */
    
  
     public void getContext(String filePath) throws IOException{
         BufferedReader br=StaticData.readDocFile(filePath);
           String s;
         while((s=br.readLine())!=null){
             if(s.contains("#")){
              String[] args=s.split("#");
                if(args!=null){
                data.add(BeanFactory.getFileBeanInstance(s.split("#")));}
                else{
                    System.out.println("CHECK_208_REGEX_NULL");
                }
             }
           }
            br.close();
     }    
     
     /**
      * 20180829 14:34 合成sumlist的地址
      * 
      * @param PrjName
      * @return 
      */
     
      public String getFilePath(String PrjName){
        
          /**
           * 20180829
         
          String destDir=System.getProperty("user.home")+File.separator+"IDE_WORKSPACE"
                 +File.separator+PrjName+File.separator+"log.txt";  */
          String destDir="C:\\Path\\log.txt";
          
         return destDir;
     }
   }
