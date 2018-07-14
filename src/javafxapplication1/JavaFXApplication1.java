/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;



/**
 *
 * @author Galaxy Yang
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        
        stage.setTitle("Line coverage");
        stage.setScene(new Scene(root, 800, 480));
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(JavaFXApplication1.class, args);
    }
}