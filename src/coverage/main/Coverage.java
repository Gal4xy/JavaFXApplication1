/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage.main;



/**
 *
 * @author Galaxy Yang
 */
//import coverage.obj.IndexController;
//import coverage.src.IndexsrcController;
import coverage.src.SrcTableViewController;
import coverage.obj.LineCoverageController;
import coverage.src.LineCoverageSrcController;
import coverage.sum.TableViewController;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Coverage extends Application {
    
      private Stage stage;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       stage=primaryStage;
       stage.setTitle("Line coverage");
        gotomain();
       stage.show();
    }
    
  


    // go to main menu 
     public void gotomain(){  
      try {  
            WelcomeController main = (WelcomeController) replaceSceneContent("Welcome.fxml");  
            main.setApp(this);  
        } catch (Exception ex) {  
            Logger.getLogger(Coverage.class.getName()).log(Level.SEVERE, null, ex);  
        }  
    }  
    
    
      //go to LC 
      public void gotoLC(){
      try {  
            LineCoverageController lc = (LineCoverageController) replaceSceneContent("LineCoverage.fxml");  
            lc.setApp(this);  
        } catch (Exception ex) {  
            Logger.getLogger(Coverage.class.getName()).log(Level.SEVERE, null, ex);  
        }    
      }
    
        //go to LC 
      public void gotoLCSrc(){
      try {  
            LineCoverageSrcController lc = (LineCoverageSrcController) replaceSceneContent("LineCoverageSrc.fxml");  
            lc.setApp(this);  
        } catch (Exception ex) {  
            Logger.getLogger(Coverage.class.getName()).log(Level.SEVERE, null, ex);  
        }    
      }
      //go to Index
      public void gotoIndex(){
      try {  
            SrcTableViewController s= (SrcTableViewController) replaceSceneContent("SrcTableView.fxml");  
            if(s==null){
              System.out.println("Error_indexC NULL");
            }
            else{
                s.setApp(this);
            }  
        } catch (Exception ex) {  
            Logger.getLogger(Coverage.class.getName()).log(Level.SEVERE, null, ex);  
        }    
      }
     
      /**
      //go to Index
      public void gotoIndex(){
      try {  
            IndexController in= (IndexController) replaceSceneContent("index.fxml");  
            if(in==null){
              System.out.println("Error_indexC NULL");
            }
            else{
                in.setApp(this);
            }  
        } catch (Exception ex) {  
            Logger.getLogger(Coverage.class.getName()).log(Level.SEVERE, null, ex);  
        }    
      }*/
      
       //go to IndexSrc
      public void gotoIndexSrc(){
     try {  
            TableViewController t = (TableViewController) replaceSceneContent("TableView.fxml");  
            t.setApp(this);
        } catch (Exception ex) {  
            Logger.getLogger(Coverage.class.getName()).log(Level.SEVERE, null, ex);  
        }  
      }
      
      
      /*
      //go to IndexSrc
      public void gotoIndexSrc(){
      try {  
            IndexsrcController in= (IndexsrcController) replaceSceneContent("indexsrc.fxml");  
            if(in==null){
              System.out.println("Error_indexC NULL");
            }
            else{
                in.setApp(this);
            }  
        } catch (Exception ex) {  
            Logger.getLogger(Coverage.class.getName()).log(Level.SEVERE, null, ex);  
        }    
      }
      */
      
private Initializable replaceSceneContent(String fxml) throws Exception {  
        FXMLLoader loader = new FXMLLoader();  
        InputStream inFxml = Coverage.class.getResourceAsStream(fxml); 
        loader.setBuilderFactory(new JavaFXBuilderFactory());  
        loader.setLocation(Coverage.class.getResource(fxml));  
        Parent page;  
        try {  
            page = (Parent) loader.load(inFxml);  
        } finally {  
            inFxml.close();  
        }   
        Scene scene = new Scene(page,800,600);  
        stage.setScene(scene);  
        stage.sizeToScene();  
        return (Initializable) loader.getController();  
    }   
     

  public static void main(String[] args) {
        launch(args);
    }


}