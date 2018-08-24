/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coverage.sum;
import coverage.main.Coverage;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Galaxy Yang
 */
public class main extends Application {

    private Stage stage;
    
     @Override
    public void start(Stage primaryStage) throws Exception {
       stage=primaryStage;
       stage.setTitle("Line coverage");
       // gotomain();
       stage.show();
    }
    
    /*
      // go to main menu 
     public void gotomain(){  
      try {  
            TableViewController t = (TableViewController) replaceSceneContent("TableView.fxml");  
            t.setApp(this);
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
        Scene scene = new Scene(page,800,480);  
        stage.setScene(scene);  
        stage.sizeToScene();  
        return (Initializable) loader.getController();  
    }   
     

  public static void main(String[] args) {
        launch(args);
    }

}
