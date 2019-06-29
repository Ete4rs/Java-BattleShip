/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Morteza Sarvestani
 */
public class FXMLChooseGameController implements Initializable {
    @FXML
    private Button SingleGameButton;
    @FXML
    private Button DoubleGameButton;
    @FXML
    private Button GameGuideButton;
    @FXML
    private Button AboutButton;
    @FXML
    private Button ExitButton;

    /**
     * Initializes the controller class.
     */
    

    @FXML
    private void handleSingleGameButtonAction(ActionEvent event) throws IOException {
        try
        {
            handleExitButtonAction();
            Parent root2 = FXMLLoader.load(getClass().getResource("/View/FXMLSinglePlayer.fxml"));       
            Stage stage2 = new Stage();
            Scene scene2 = new Scene(root2);
            stage2.setScene(scene2);
            stage2.setTitle("BattleShip Game");
    
            stage2.show();
        }catch(RuntimeException e){
          System.out.println("** RuntimeException from main");
        }
        
        
        
    }
    
    @FXML
    private void handleDoubleGameButtonAction(ActionEvent event) throws IOException {
        try
        {
            handleExitButtonAction();
            Parent root3 = FXMLLoader.load(getClass().getResource("/View/FXMLDoubleGame.fxml"));       
            Stage stage3 = new Stage();
            Scene scene3 = new Scene(root3);
            stage3.setScene(scene3);
            stage3.setTitle("BattleShip Game");
    
            stage3.show();
        }catch(RuntimeException e){
          System.out.println("** RuntimeException from main");
        }
    }

    @FXML
    private void handleGameGuideButtonAction(ActionEvent event) {
        //tu in tabe mire va ye page baz mikone ke rahnamaye bazi unjast
        Desktop d = Desktop.getDesktop();
        try {
            d.browse(new URI("https://www.thesprucecrafts.com/the-basic-rules-of-battleship-411069"));
        } catch (IOException | URISyntaxException e2) {
            e2.printStackTrace();
        } 
    }

    @FXML
    private void handleAboutButtonAction(ActionEvent event) {
        //inja ye file baz mikone ke darbare proje tush neveshtam
        try{
            
            File About = new File("E:/Java/codes/BattleShip/README.md");
            Desktop.getDesktop().edit(About);
        }catch(IOException e){
            //age file nabudesh exception mide
            e = new FileNotFoundException();
        }
    }

    @FXML
    private void handleExitButtonAction() {
        //inam ke vase bastane stage hast
        // get a handle to the stage
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
