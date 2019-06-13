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
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Morteza
 */
public class FXMLSinglePlayerController implements Initializable {
    @FXML
    private GridPane MyGridPane;
    @FXML
    private Button LeaveGameButton;
    @FXML
    private Button NewGameButton;
    @FXML
    private GridPane SystemGridPane;

    //ba button map ro por mikonam va rahattar karam ro jolo mibaram
    private Button[][] myCells = new Button[10][10];    //in vase player
    private Button[][] systemCells = new Button[10][10];    //in vase system
    
    
        
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    

    //in tabe miad dokmeharo mirize tu gridpanha
    public void SetButton(){
        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j<10 ; j++){
                myCells[i][j].setBackground(Background.EMPTY);
                systemCells[i][j].setBackground(Background.EMPTY);
                MyGridPane.add(myCells[i][j], j, i);
                SystemGridPane.add(systemCells[i][j], j, i);
            }
        }
    }

    @FXML
    private void HandleLeaveGameButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleNewGameButtonAction(ActionEvent event) {
    }
    
}
