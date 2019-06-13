/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Morteza
 */
public class FXMLSinglePlayerController implements Initializable {
    @FXML
    private GridPane MyFirstGridPane;
    @FXML
    private Button LeaveGameButton;
    @FXML
    private Button NewGameButton;
    @FXML
    private GridPane SystemGridPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleLeaveGameButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleNewGameButtonAction(ActionEvent event) {
    }
    
}
