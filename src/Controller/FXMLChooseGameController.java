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
        //mire fxml vase single game ro baz mikone va badesh satge ro be fuck mide
        
        Parent root2 = FXMLLoader.load(getClass().getResource("/View/FXMLSinglePlayer.fxml"));       
        Scene scene2 = new Scene(root2);
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        stage2.setTitle("Game");
        stage2.show();
        handleExitButtonAction();
    }
    
    @FXML
    private void handleDoubleGameButtonAction(ActionEvent event) {
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
