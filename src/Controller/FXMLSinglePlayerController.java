/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.event.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Morteza Sarvestani
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

    Thread Action = new Thread(){

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLSinglePlayerController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int a = i, b = j;
                myCells[i][j].setOnAction(new EventHandler(){
                    
                    @Override
                    public void handle(Event event) {
                        myCells[a][b].setStyle("-fx-background-color: Green;");
                    }  
               });
            }
        }
        }
        
    };
        
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SetButton();
        Action.start();
        
    }    

    //in tabe miad dokmeharo mirize tu gridpanha

    
    public void SetButton(){
        SystemGridPane.setDisable(true);

        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j<10 ; j++){
                myCells[i][j] = new Button();
                systemCells[i][j] = new Button();
                myCells[i][j].setMaxSize(60, 45);
                systemCells[i][j].setMaxSize(60, 45);
                MyGridPane.add(myCells[i][j], j, i);
                SystemGridPane.add(systemCells[i][j], j, i);
            }
        }

    }    

    @FXML
    private void HandleLeaveGameButtonAction(ActionEvent event) {
        try{
            Parent root3 = FXMLLoader.load(getClass().getResource("/View/FXMLClosingGame.fxml"));       
            Stage stage3 = new Stage();
            Scene scene3 = new Scene(root3);
            stage3.setScene(scene3);
            stage3.setTitle("Warning");
            stage3.show();
        }catch(Exception e){
            System.out.println("** RuntimeException from main");
        }
    }

    @FXML
    private void handleNewGameButtonAction(ActionEvent event) {
    }    
}