/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ship;
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
    @FXML
    private Button ThreeShipButton;
    @FXML
    private Button TwoShipButton;
    @FXML
    private Button FourShipBurron;
    @FXML
    private Button OneShipButton;
    @FXML
    private Button PlayButton;
    @FXML
    private Button NewShipsButton;
    
    //ba button map ro por mikonam va rahattar karam ro jolo mibaram
    private Button[][] myCells = new Button[10][10];    //in vase player
    private Button[][] systemCells = new Button[10][10];    //in vase system
    private Ship[] MyShips ;
    private Ship[] SystemShips;
    private static int sizeShipChoice = 0;
    private int[][] MyMap = new int[10][10];
    private static int NumberShip = 0 ;
    
    private static int numberTwoShip =0;
    private static int C_C;
    private static int H_V;

        //in vase keshtihaye 1 size
    public void EnterButtonForOneSize(int a ,int b){
        this.MyMap[a][b] = 1;
        this.myCells[a][b].setDisable(true);
        this.MyShips[NumberShip].setShipSize(sizeShipChoice);
        this.MyShips[NumberShip].setCulomnBegin(b);
        this.MyShips[NumberShip].setCulomnFinish(b);
        this.MyShips[NumberShip].setIsHORIZONTAL(false);
        this.MyShips[NumberShip].setIsVertical(true);
        this.MyShips[NumberShip].setRowBegin(a);
        this.MyShips[NumberShip++].setRowFinish(a);
        if(NumberShip  == 4){
            this.MyGridPane.setDisable(true);
            this.OneShipButton.setDisable(true);
            this.TwoShipButton.setDisable(false);
        }
        
        this.myCells[a][b].setStyle("-fx-background-color: Green;");
        for(int i=a-1 ; i<=a+1 ; i++){
            if(i>9){
                break;
            }
            if(i<0){
                continue;
            }
            for(int j=b-1 ; j<=b+1 ; j++){
                if(j>9){
                    break;
                }
                if(j<0){
                    continue;
                }
                this.myCells[i][j].setDisable(true);
                this.MyMap[i][j] =0;//naqshe ro michine
                
            }
        }
        
    }
    
        //in tabe keshtiaye 2 size ro migad
    public void EnterButtonForTwoSize(int a ,int b){
        numberTwoShip++;    //ba in motaqyer daram tedad keshtyaye ba size 2 ro mishmaram vali 2 barabar
        if(numberTwoShip %2 ==1){
            this.H_V = a;   //ba in miam taiin mikonam ke keshtim ofoqie ya amudi
            this.C_C = b;   //index sotun va radif ro ham barmidaram
        }
        myCells[a][b].setStyle("-fx-background-color: Green;");     //khuneii ke entekhab mishe ro rang mikonam 
        this.MyMap[a][b] = 1;       //khune entekhabim : mokhtasatesh ro negah midaram
        this.MyShips[NumberShip].setShipSize(sizeShipChoice);   //size keshti ro mifrestam be shey
        this.myCells[a][b].setDisable(true);    //khune entekhabi ham disable mishe
        if(numberTwoShip %2 == 1){  //in halqe zamani ejra mishe ke ye khune az keshti ro entekhab kardam
            for(int i=0 ; i<10 ; i++){
                //umadam khunehaye atrafesh ro ke niaz nabud disable kardam 
                for(int j=0 ; j<10 ; j++){
                    if(i==a && j==b-1){
                        continue;
                    }
                    if(i==a-1 && j==b){
                        continue;
                    }
                    if(i==a && j==b+1){
                        continue;
                    }
                    if(i==a+1 && j==b){
                        continue;
                    }
                    this.myCells[i][j].setDisable(true);
                }
            }
        }
        if(numberTwoShip % 2 == 0){
            //in zamani kar mikone ke tye keshti kamel shod
            if(H_V==a){ 
                //miam sheyesh ro kamel mikonam
                this.MyShips[NumberShip].setIsHORIZONTAL(true);
                this.MyShips[NumberShip].setIsVertical(false);
                this.MyShips[NumberShip].setRowBegin(a);
                this.MyShips[NumberShip].setRowFinish(a);
                if(C_C>b){  //in male sotonas miad kochike ro aval migire
                    int t = b;
                    b = C_C;
                    C_C = t;
                }
                //va bad shey ro migad
                this.MyShips[NumberShip].setCulomnBegin(C_C);
                this.MyShips[NumberShip].setCulomnFinish(b);    
                for(int i=H_V-1 ; i<=H_V+1 ; i++){
                    //az khunehaye atrafesh unayi ke bayad disable shan ro mokhtasateshum ro 0 mikonam
                    if(i<0){continue;}
                    if(i>9){break;}
                    for(int j=C_C-1 ; j<=C_C+2 ; j++){
                        if(j>9){break;}
                        if(j<0){continue;}
                        this.myCells[i][j].setDisable(true);
                        if(this.MyMap[i][j] != 1){
                            this.MyMap[i][j]=0;
                        }
                    }
                }
                
            }else{  //inam hamunkar ro mikone vali vase keshti Amudi
                this.MyShips[NumberShip].setIsHORIZONTAL(false);
                this.MyShips[NumberShip].setIsVertical(true);
                this.MyShips[NumberShip].setCulomnBegin(b);
                this.MyShips[NumberShip].setCulomnFinish(b);
                if(H_V>a){
                    int t = H_V;
                    H_V = a;
                    a = t;
                }
                this.MyShips[NumberShip].setRowBegin(H_V);
                this.MyShips[NumberShip].setRowFinish(a);
                for(int i = H_V-1  ; i<=H_V+2 ; i++){
                    if(i<0){continue;}
                    if(i>9){break;}
                    for(int j=C_C-1 ; j<=C_C+1 ; j++){
                        if(j>9){break;}
                        if(j<0){continue;}
                        this.myCells[i][j].setDisable(true);
                        if(this.MyMap[i][j] != 1){
                            this.MyMap[i][j]=0;
                        }
                        
                    }
                }
                
            }
            NumberShip++;   //khob ye keshti jadid gayidam yeki beshun ezaf mishe
        }
        if(numberTwoShip % 2 == 0){
            //Akhar ham miam map ro update mikonam ba keshti jadid
            for(int i=0 ; i<10 ; i++){
                for(int j=0 ; j<10 ; j++){
                    if(MyMap[i][j]== 0 || MyMap[i][j] == 1){
                        this.myCells[i][j].setDisable(true);
                        continue;
                    }
                    myCells[i][j].setDisable(false);
                }
            }
        }
        this.MyGridPane.setDisable(false);
        if(numberTwoShip == 6){
            //khob 3 ta keshti 2 size ezaf shod pas kar 2 tamum
            System.out.println("" + NumberShip);
            this.MyGridPane.setDisable(true);
            this.TwoShipButton.setDisable(true);
            this.ThreeShipButton.setDisable(false);
        }
    }
    
    
    Thread Action = new Thread(){

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLSinglePlayerController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int a = i, b = j;
                myCells[i][j].setOnAction(new EventHandler(){
                    
                    @Override
                    public void handle(Event event) {
                        switch(sizeShipChoice){
                            case 1:
                                EnterButtonForOneSize(a,b);
                                break;
                            case 2:
                                EnterButtonForTwoSize( a ,b);
                                break;
                               
                        }    
                    }  
               });
            }
        }
        }
        
    };

        //in tabe faqat miad map ro amade mikone
    public void SetButtonAndShips(){
        //tu in tabe umadam shipha va cellha ro ok kardam
        MyShips = new Ship[10];
        SystemShips = new Ship[10];
        
        this.SystemGridPane.setDisable(true);
        this.MyGridPane.setDisable(true);
        this.PlayButton.setDisable(true);
        this.ThreeShipButton.setDisable(true);
        this.TwoShipButton.setDisable(true);
        this.FourShipBurron.setDisable(true);
        for(int i=0 ; i<10 ; i++){
            MyShips[i] = new Ship();
            SystemShips[i] = new Ship();
            if(i<=3){
                MyShips[i].setShipSize(1);
                SystemShips[i].setShipSize(1);              
            }
            else if(i<=6){
                MyShips[i].setShipSize(2);
                SystemShips[i].setShipSize(2);             
            }
            else if(i<=8){
                MyShips[i].setShipSize(3);
                SystemShips[i].setShipSize(3);               
            }
            else if(i==9){
                MyShips[i].setShipSize(4);
                SystemShips[i].setShipSize(4);
            }
            
            for(int j=0 ; j<10 ; j++){
                MyMap[i][j] = -1;
                myCells[i][j] = new Button();
                systemCells[i][j] = new Button();
                myCells[i][j].setMaxSize(60, 45);
                systemCells[i][j].setMaxSize(60, 45);
                MyGridPane.add(myCells[i][j], j, i);
                SystemGridPane.add(systemCells[i][j], j, i);
            }
        }    
    }  
    
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SetButtonAndShips();
        Action.start();
    }    

    
    @FXML
    private void handleOneShipButtonAction(ActionEvent e){
        sizeShipChoice = 1;
        this.MyGridPane.setDisable(false);    
    }
    
    @FXML
    private void handleTwoShipButtonAction(ActionEvent e){
        sizeShipChoice = 2;
        this.MyGridPane.setDisable(false);
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