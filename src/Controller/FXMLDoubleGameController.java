/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.API;
import static Model.API.CheckStatus;
//import static Model.API.getmap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.abs;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Gh0st98
 */
public class FXMLDoubleGameController implements Initializable {
    @FXML
    private GridPane MyGridPane;
    @FXML
    private Button LeaveGameButton;
    @FXML
    private Button NewGameButton;
    @FXML
    private GridPane SystemGridPane;
    public static GridPane gridPublic;
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
    private Label ShipsLable;
    @FXML
    private Button NewShipsButton;
    @FXML
    private Button RandomButton;
    @FXML
    private Label RatinLable;
    @FXML
    private Label MyRatingLable;
    public static Label myRatingLabel;
    @FXML
    private Label SystemRatingLable;
    public static Label sysLabelRat;
    @FXML
    private Label WinLable;
    public static Label winlab;

    private int[][] MyMap;
    private int[][] SystemMap;
    private Button[][] myCells = new Button[10][10];    //in vase player
    private Button[][] systemCells = new Button[10][10];  
    
    private static int sizeShipChoice = 0;
    private static int NumberShip = 0 ;
    private static int myPoint =0;
    private static int systemPoint=0;
    
    private static int numberTwoShip =0;
    private static int C_C_2;
    private static int H_V_2;

    private static int numberThreeShip =0;
    private static int H_V_3;
    private static int C_C_3;
    
    private static int numberFourShip=0;
    private static int H_V_4;
    private static int C_C_4;
    
    private File file ;
    private FileWriter fileWriter;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    private LocalDateTime now;
    @FXML
    private Label StatusLabel;
    public static Label labelStatus;
    
    
    
    
    public void EnterButtonForOneSize(int a ,int b){
        this.MyMap[a][b] = 4;
        this.myCells[a][b].setDisable(true);
        if(++NumberShip  == 10){
            this.MyGridPane.setDisable(true);
            this.OneShipButton.setDisable(true);
            this.PlayButton.setDisable(false);
        }
        
        this.myCells[a][b].setStyle("-fx-background-color: Green;");
        for(int i=a-1 ; i<=a+1 ; i++){
            if(i>9){break;}
            if(i<0){continue;}
            for(int j=b-1 ; j<=b+1 ; j++){
                if(j>9){
                    break;
                }
                if(j<0){
                    continue;
                }
                if(i==a && j==b){continue;}
                this.myCells[i][j].setDisable(true);
                this.MyMap[i][j] =0;
            }
        }
        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j<10 ; j++){
                if(MyMap[i][j]==-1){
                    MyMap[i][j]=0;
                }
            }
        }
        
    }
    /*#############################*/
        //in tabe keshtiaye 2 size ro migad
    public void EnterButtonForTwoSize(int a ,int b){
            numberTwoShip++;
            
            myCells[a][b].setStyle("-fx-background-color: Green;"); 
            this.MyMap[a][b] = 3;   
            this.myCells[a][b].setDisable(true);    //khune entekhabi ham disable mishe

            if(numberTwoShip % 2  == 1 ){ 
                this.H_V_2 = a;  
                this.C_C_2 = b;   
                for(int i=0 ; i<=9 ; i++){
                    for(int j=0 ; j<=9 ; j++){
                        if(i==H_V_2 && j==C_C_2-1){continue;}
                        if(i==H_V_2 && j==C_C_2+1){continue;}
                        if(i==H_V_2-1 && j==C_C_2){continue;}
                        if(i==H_V_2+1 && j==C_C_2){continue;}
                        this.myCells[i][j].setDisable(true);
                    }
                }
                int num=0;
                if( a+1>=0 && a+1<=9  && !myCells[a+1][b].isDisabled()){num+=1;}
                if( a-1>=0 && a-1<=9  && !myCells[a-1][b].isDisabled()){num+=1;}
                if( b+1>=0 && b+1<=9  && !myCells[a][b+1].isDisabled()){num+=1;}
                if( b-1>=0 && b-1<=9  && !myCells[a][b-1].isDisabled()){num+=1;}
                if(num<1){
                    myCells[a][b].setStyle("-fx-background-color: White;");
                    MyMap[a][b] = -1;
                    for(int i=0 ; i<10 ; i++){
                        for(int j=0 ; j<10 ; j++){
                            if(MyMap[i][j]== 0 || MyMap[i][j]==1 || MyMap[i][j]==2 || MyMap[i][j]==3){
                                this.myCells[i][j].setDisable(true);
                                continue;
                            }
                            myCells[i][j].setDisable(false);
                        }
                    }
                    if(numberTwoShip==1){numberTwoShip=0;}
                    else if(numberTwoShip==3){numberTwoShip=2;}
                    else{numberTwoShip=4;}
                }
                
            }
            if(numberTwoShip % 2 == 0){
                if(H_V_2==a){
                    if(C_C_2 >b){  //in male sotonas miad kochike ro aval migire
                        int t = b;
                        b = C_C_2;
                        C_C_2 = t;
                    }   
                    for(int i=H_V_2 -1 ; i<=H_V_2 +1 ; i++){
                        //az khunehaye atrafesh unayi ke bayad disable shan ro mokhtasateshum ro 0 mikonam
                        if(i<0){continue;}
                        if(i>9){break;}
                        for(int j=C_C_2 -1 ; j<=C_C_2 +2 ; j++){
                            if(j>9){break;}
                            if(j<0){continue;}
                            this.myCells[i][j].setDisable(true);
                            if(this.MyMap[i][j] != 3){
                                this.MyMap[i][j]=0;
                            }
                        }
                    }

                }else{
                    if(H_V_2>a){
                        int t = H_V_2;
                        H_V_2 = a;
                        a = t;
                    }
                    for(int i = H_V_2 -1  ; i<=H_V_2 +2 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        for(int j=C_C_2 -1 ; j<=C_C_2 +1 ; j++){
                            if(j>9){break;}
                            if(j<0){continue;}
                            this.myCells[i][j].setDisable(true);
                            if(this.MyMap[i][j] != 3){
                                this.MyMap[i][j]=0;
                            }

                        }
                    }

                }
                for(int i=0 ; i<10 ; i++){
                    for(int j=0 ; j<10 ; j++){
                        if(MyMap[i][j]==0 || MyMap[i][j]==1 || MyMap[i][j]==2 || MyMap[i][j]==3){
                            this.myCells[i][j].setDisable(true);
                            continue;
                        }
                        myCells[i][j].setDisable(false);
                    }
                }
                NumberShip++;   //khob ye keshti jadid gayidam yeki beshun ezaf mishe
        }
        if(numberTwoShip == 6){
            //khob 3 ta keshti 2 size ezaf shod pas kar 2 tamum
            this.MyGridPane.setDisable(true);
            this.TwoShipButton.setDisable(true);
            this.OneShipButton.setDisable(false);
        }
    }
    /*############################*/
    
        //in tabe ham vase chidane naqshe keshtiaye 3taiie
    public void EnterButtonForThreeSize(int a ,int b){
        
        
        this.numberThreeShip++;
        this.MyMap[a][b] = 2;
        this.myCells[a][b].setDisable(true);
        this.myCells[a][b].setStyle("-fx-background-color: Green;");
        
        if(numberThreeShip == 1 || numberThreeShip == 4){
            this.H_V_3 = a;
            this.C_C_3 = b;
            
            
            for(int i=0 ; i<10 ; i++){
                for(int j=0 ; j<10 ; j++){
                    if(i==a && (j==b-1 || j==b-2 || j==b+1 || j==b+2)){continue;}
                    if(j==b && (i==a-1 ||  i==a-2 || i==a+1 || i==a+2 )){continue;}
                    if(MyMap[i][j]==0){continue;}
                    
                    this.myCells[i][j].setDisable(true);
                }
            }
            int numR=0 , numC=0;
            for(int i=a-2 ; i<=a+2 ; i++){
                if(i==a || i<0){continue;}
                if(i>9){break;}
                if(!myCells[i][b].isDisable()){
                    numR++;
                }
            }
            for(int i=b-3 ; i<=b+3 ; i++){
                if(i<0 || i==b){continue;}
                if(i>9){break;}
                if(!myCells[a][i].isDisabled()){
                    numC++;
                }
            }
            if(numR<2){
                for(int i=a-3 ; i<=a+3 ; i++){
                    if(i<0){continue;}
                    if(i>9){break;}
                    this.myCells[i][b].setDisable(true);
                }
            }
            if(numC<2){
                for(int i=b-2 ; i<=b+2 ; i++){
                    if(i<0){continue;}
                    if(i>9){break;}
                    this.myCells[a][i].setDisable(true);
                }
            }
            if(numC<2 && numR<2){
                this.MyMap[a][b] = -1;
                this.myCells[a][b].setStyle(null);
                for(int i=0 ; i<10 ; i++){
                    for(int j=0 ; j<10 ; j++){
                        if( MyMap[i][j]!=-1 ){
                            myCells[i][j].setDisable(false);
                        }
                    }
                }
                if(numberThreeShip==1){numberThreeShip=0;}
                else{numberThreeShip=3;}
            }
        }
        
        if(numberThreeShip == 2 || numberThreeShip == 5){
                if(H_V_3==a){
                    int x = C_C_3;
                    if(b<C_C_3){x=b;}
                    
                    
                    
                    for(int i=0 ; i<10 ; i++){
                        for(int j=0 ; j<10 ; j++){
                            if(i==a && (j==x -1 || j==x +2 )){continue;}
                            this.myCells[i][j].setDisable(true);
                        }
                    }
                }else{
                    int y = H_V_3;
                    if(y>a){y=a;}
                    
                    for(int i=0 ; i<10 ; i++){
                        for (int j=0 ; j<10 ; j++){
                            if(j==C_C_3 && (i==y-1 || i==y+2)){continue;}
                            this.myCells[i][j].setDisable(true);
                        }
                    }
                }
        }
        
        if(numberThreeShip==3 || numberThreeShip==6){
            if(H_V_3==a){
                int x = C_C_3;
                if(C_C_3>b){x=b;}
                for(int i=H_V_3 -1 ; i<=H_V_3 +1 ; i++){
                    if(i>9){break;}
                    if(i<0){continue;}
                    for(int j=x-1 ; j<=x+3 ; j++){
                        if(j>9){break;}
                        if(j<0){continue;}
                        if(MyMap[i][j]==1 || MyMap[i][j]==2){continue;}
                        MyMap[i][j]=0;
                    }
                }
            }
            else{
                int y=H_V_3 ;
                if(a<H_V_3){y=a;}
                for(int i=y-1 ; i<=y+3 ; i++){
                    if(i>9){break;}
                    if(i<0){continue;}
                    for(int j=C_C_3 -1 ; j<=C_C_3 +1 ; j++){
                        if(j>9){break;}
                        if(j<0){continue;}
                        
                        if(MyMap[i][j]==1 || MyMap[i][j]==2){continue;}
                        this.MyMap[i][j]=0;
                    }
                }
            }
            for(int i=0 ; i<10 ; i++){
                for(int j=0 ; j<10 ; j++){
                    if(MyMap[i][j]==0 || MyMap[i][j]==1 || MyMap[i][j]==2){
                        this.myCells[i][j].setDisable(true);
                        continue;
                    }
                    this.myCells[i][j].setDisable(false);
                }
            }
            this.NumberShip++;
        }
        
        
        if(numberThreeShip == 6){
            this.MyGridPane.setDisable(true);
            this.ThreeShipButton.setDisable(true);
            this.TwoShipButton.setDisable(false);
        }
    }
    /*############################*/
    
    //#####################
    public void EnterButtonForFourSize(int a,int b){
        numberFourShip++;
        this.myCells[a][b].setStyle("-fx-background-color: Green;");
        this.myCells[a][b].setDisable(true);
        this.MyMap[a][b] =1;
        if(numberFourShip==1){
            H_V_4 =a;
            C_C_4 =b;
            
            for(int i=0 ; i<10 ; i++){
                for(int j=0 ; j<10 ; j++){
                    if(i==H_V_4 && (j==C_C_4-3 || j==C_C_4-2 
                            || j==C_C_4-1 || j==C_C_4 || j==C_C_4+1 || j==C_C_4+2 || j==C_C_4+3 )){continue;
                    }
                    if(j==C_C_4 && (i==H_V_4-2 || i==H_V_4-1 || i==H_V_4 || i==H_V_4+3 
                            || i==H_V_4+2 || i==H_V_4+1 )){continue;}
                    this.myCells[i][j].setDisable(true);
                }
            }
        }
        
        if(numberFourShip==2){
                if(H_V_4==a){
                        int y = C_C_4;
                        if(y>b){y=b;}

                        for(int i=0 ; i<10 ; i++){
                            for(int j=0 ; j<10 ; j++){
                                if(i==H_V_4 && (j==y-3 || j==y-2 
                                        || j==y-1 || j==y || j==y+1 || j==y+2 || j==y+3 )){continue;
                                }
                                this.myCells[i][j].setDisable(true);
                            }
                        }
                }
                
                else{
                        int x = H_V_4;
                        if(x>a){x=a;}

                        for(int i=0 ; i<10 ; i++){
                            for(int j=0 ; j<10 ; j++){
                                if(j==C_C_4 && (i==x-2 || i==x-1 || i==x || i==x+3 
                                    || i==x+2 || i==x+1 )){continue;}

                                this.myCells[i][j].setDisable(true);
                            }
                        }  
                }
        }
        
        if(numberFourShip==3){
                if(H_V_4==a){
                    int y = C_C_4;
                    if(y>b){y=b;}
                    
                    for(int i=0 ; i<10 ; i++){
                        for(int j=0 ; j<10 ; j++){
                            if(i==H_V_4 && (j==y-1 || j==y || j==y+1 || j==y+2 || j==y+3 )){continue;
                            }
                            this.myCells[i][j].setDisable(true);
                        }
                    }
                }
                
                else{
                    int x = H_V_4;
                    if(x>a){x=a;}
                    
                    for(int i=0 ; i<10 ; i++){
                        for(int j=0 ; j<10 ; j++){
                            if(j==C_C_4 && (i==x-1 || i==x || i==x+3 || i==x+2 || i==x+1 )){continue;}
                            this.myCells[i][j].setDisable(true);
                        }
                    }
                }
        }
        
        if(numberFourShip==4){
                if(H_V_4==a){
                    int y = C_C_4;
                    if(y>b){y=b;}
                    
                    for(int i=H_V_4-1 ; i<=H_V_4+1 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        for(int j=y-1 ; j<=y+4 ; j++){
                            if(j<0){continue;}
                            if(j>9){break;}
                            if(this.MyMap[i][j]==1){continue;}
                            this.MyMap[i][j] =0;
                        }
                    }
                    
                }
                
                else{
                    int x = H_V_4;
                    if(x>a){x=a;}
                    
                    for(int i=x-1 ; i<=x+4 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        for(int j=C_C_4-1 ; j<=C_C_4+1 ; j++){
                            if(j<0){continue;}
                            if(j>9){break;}
                            if(this.MyMap[i][j]==1){continue;}
                            this.MyMap[i][j] =0;
                        }
                    }
                }
                
                for(int i=0 ; i<10 ; i++){
                    for(int j=0 ; j<10 ; j++){
                        if(MyMap[i][j]==0 || MyMap[i][j]==1){
                            this.myCells[i][j].setDisable(true);
                            continue;
                        }
                        this.myCells[i][j].setDisable(false);
                    }
                }
                
                
                
                this.NumberShip++;
                this.ThreeShipButton.setDisable(false);
                this.FourShipBurron.setDisable(true);
                this.MyGridPane.setDisable(true);
        }
        
        
    }
    //#####################
    
    public void FourShipRandom(int[][] Map , boolean w){
        System.out.println("for");
        this.FourShipBurron.setDisable(true);
        Random rand = new Random();
        boolean vertical = rand.nextBoolean();
        if(vertical){
                int a = abs(rand.nextInt()) %10;
                int b = abs(rand.nextInt()) %10;
                int First=0;
                for(int i=a-3 ; i<=a+3 ; i++){
                    if(i<0){continue;}
                    if(i>9){break;}
                    First = i;
                    break;
                }
                for(int i=First-1 ; i<=First+4 ; i++){
                    if(i<0){continue;}
                    if(i>9){break;}
                    for(int j=b-1 ; j<=b+1 ; j++){
                        if(j>9){break;}
                        if(j<0){continue;}
                        if(j==b && (i==First || i==First+1 || i==First+2 || i==First+3 )){
                            Map[i][j] = 1;
                            continue;
                        }
                        Map[i][j] = 0;
                    }
                }
        }
        else{
            int a = abs(rand.nextInt()) %10;
            int b = abs(rand.nextInt()) %10;
            int First=0;
            for(int i=b-3 ; i<=b+3 ; i++){
                if(i<0){continue;}
                if(i>9){break;}
                First = i;
                break;
            }
            for(int i=a-1 ; i<=a+1 ; i++){
                if(i<0){continue;}
                if(i>9){break;}
                for(int j=First-1 ; j<=First+4 ; j++){
                    if(j>9){break;}
                    if(j<0){continue;}
                    if(i==a && (j==First || j==First+1 || j==First+2 || j==First+3)){
                        Map[i][j] = 1;
                        continue;
                    }
                    Map[i][j] = 0;
                }
            }
        }
        if(w){
            for(int i=0 ; i<10 ; i++){
                for(int j=0 ; j<10 ; j++){
                    this.MyMap[i][j] = Map[i][j];
                }
            }
        }
    }
    //##################
    public void ThreeShipRandom(int[][] Map , boolean w){
        Random rand = new Random();
        int number=0;
        for(int z=0 ; z<2 ; z++){
            while(true){
                boolean vertical = rand.nextBoolean();
                if(vertical){
                    int a = abs(rand.nextInt())%10;
                    int b = abs(rand.nextInt())%10;
                    int First = 0 , f=0;
                    for(int i=a-2 ; i<=a+2 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        if(Map[i][b]==-1){f++;}
                    }
                    if(f<3){continue;}
                    for(int i=a-2 ; i<=a+2 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        if(Map[i][b] ==-1 && Map[i+1][b]==-1 && Map[i+2][b]==-1 ){
                            First = i;
                            break;
                        }
                    }
                    for(int i=First-1 ; i<=First+3 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        for(int j=b-1 ; j<=b+1 ; j++){
                            if(j>9){break;}
                            if(j<0){continue;}
                            if(j==b && (i==First || i==First+1 || i==First+2)){
                                Map[i][j]=2;
                                continue;
                            }
                            Map[i][j] = 0;
                        }
                    }
                    break;
                }
                else{
                    int a = abs(rand.nextInt())%10;
                    int b = abs(rand.nextInt())%10;
                    int First = 0 , f=0;
                    for(int i=b-2 ; i<=b+2 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        if(Map[a][i]==0 || Map[a][i]==2 || Map[a][i]==1){continue;}
                        f++;
                    }
                    if(f<3){continue;}

                    for(int i=b-2 ; i<=b+2 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        if(Map[a][i]==-1 && Map[a][i+1]==-1 && Map[a][i+2]==-1){
                            First = i;
                            break;
                        }
                    }
                    for(int i=a-1 ; i<=a+1 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        for(int j=First-1 ; j<=First+3 ; j++){
                            if(j<0){continue;}
                            if(j>9){break;}
                            if(i==a && (j==First || j==First+1 || j==First+2)){
                                Map[i][j]=2;
                                continue;
                            }
                            Map[i][j]=0;
                        }
                    }
                    break;
                }
            }
        }
        if(w){
            for(int i=0 ; i<10 ; i++){
                for(int j=0 ; j<10 ; j++){
                    this.MyMap[i][j] = Map[i][j];
                }
            }
        }
    }
    //##################
    public void TwoShipRandom(int[][] Map , boolean w){
        Random rand = new Random();
        for(int z=0 ; z<3 ; z++){
            while(true){
                boolean vertical = rand.nextBoolean();
                if(vertical){

                    int a = abs(rand.nextInt())%10;
                    int b = abs(rand.nextInt())%10;
                    int First=0  , f=0;

                    for(int i=a-1 ; i<=a+1 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        if(Map[i][b]==-1){
                            f++;
                        }
                    }
                    if(f<2){continue;}
                    for(int i=a-1 ; i<=a+1 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        if(Map[i][b]==-1 && Map[i+1][b]==-1){
                            First = i;
                            break;
                        }
                    }
                    for(int i=First-1 ; i<=First+2 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        for(int j=b-1 ; j<=b+1 ; j++){
                            if(j<0){continue;}
                            if(j>9){break;}
                            if(j==b && (i==First || i==First+1)){
                                Map[i][j] = 3;
                                continue;
                            }
                            Map[i][j] = 0;
                        }
                    }
                    break;
                }
                else{
                    int a = rand.nextInt();
                    int b = rand.nextInt();
                    int First=0  , f=0;
                    for(int i=b-1 ; i<=b+1 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        if(Map[a][i]==-1){f++;}
                    }
                    if(f<2){continue;}
                    for(int i=b-1 ; i<=b+1 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        if(Map[a][i]==-1 && Map[a][i+1]==-1){
                            First = i;
                            break;
                        }
                    }
                    for(int i=a-1 ; i<=a+1 ; i++){
                        if(i<0){continue;}
                        if(i>9){break;}
                        for(int j=First-1 ; j<=First+2 ; j++){
                            if(j<0){continue;}
                            if(j>9){break;}
                            if(i==a && (j==First || j==First+1)){
                                Map[i][j] = 3;
                                continue;
                            }
                            Map[i][j] = 0;
                        }
                    }
                    break;
                }

            }
        }
        if(w){
            for(int i=0 ; i<10 ; i++){
                for(int j=0 ; j<10 ; j++){
                    this.MyMap[i][j] = Map[i][j];
                }
            }
        }
    }
    //##################
    public void OneShipRandom(int[][] Map , boolean w){
        Random rand = new Random();
        for(int z=0 ; z<4 ; z++){
            while(true){
                int a = abs(rand.nextInt(10));
                int b = abs(rand.nextInt(10));
                
                if(Map[a][b]!=-1){continue;}
                Map[a][b] = 4;
                
                for(int i=a-1 ; i<=a+1 ; i++){
                    if(i<0){continue;}
                    if(i>9){break;}
                    for(int j=b-1 ; j<=b+1 ; j++){
                        if(j<0 || (i==a && j==b)){continue;}
                        if(j>9){break;}
                        Map[i][j] = 0;
                    }
                }
                break;
            }
        }
        if(w){
            for(int i=0 ; i<10 ; i++){
                for(int j=0 ; j<10 ; j++){
                    this.MyMap[i][j] = Map[i][j];
                }
            }
            for(int i=0 ; i<10 ; i++){
                for(int j=0 ; j<10 ; j++){
                    if(MyMap[i][j]==1 || MyMap[i][j]==2 || MyMap[i][j]==3 || MyMap[i][j]==4){
                        this.myCells[i][j].setStyle("-fx-background-color: Green;");
                    }
                    if(MyMap[i][j]==-1){
                        this.MyMap[i][j]=0;
                    }
                }
            }
        }
        
    }
    //###########################
    public void NewMap(){
        this.PlayButton.setDisable(true);
        this.OneShipButton.setDisable(true);
        this.TwoShipButton.setDisable(true);
        this.ThreeShipButton.setDisable(true);
        this.FourShipBurron.setDisable(false);
        this.MyGridPane.setDisable(true);
        NumberShip=0;
        numberFourShip=0;
        numberThreeShip=0;
        numberTwoShip=0;
        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j<10 ; j++){
                this.myCells[i][j].setStyle(null);
                this.MyMap[i][j] = -1;
                this.myCells[i][j].setDisable(false);
            }
        }
    }
    //########################
    
    Thread Action2 = new Thread(){

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
                    systemCells[i][j].setOnAction(new EventHandler(){
                        
                        @Override
                        public void handle(Event event) {
                            API.shota =a;
                            API.shotb=b;
                        }  
                   });
                }
            }
        }
        
    };
    
    
    
    
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
                                case 3:
                                    EnterButtonForThreeSize(a,b);
                                    break;
                                case 4:
                                    EnterButtonForFourSize(a,b);
                                    break;

                            }    
                        }  
                   });
                }
            }
        }
        
    };
    
    
    Thread CheckStatusAction = new Thread(){

        @Override
        public void run() {
            try {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                }
                for(int z=0 ; z<API.getmap.size() ;z++){
                for(int i=0 ; i<10 ; i++){
                    if(API.getmap.get(z++)==i){
                        for(int j=0 ; j<10 ; j++){
                            if(API.getmap.get(z)==j){
                                if(MyMap[i][j]==0){
                                    Shootdouble(i,j,false);
                                }
                                else{
                                    Shootdouble(i,j,true);
                                }
                            }
                        }
                    }
                }}
                CheckStatus(MyMap);
                
            } catch (IOException ex) {
                Logger.getLogger(FXMLDoubleGameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    };
    
    public void Shootdouble(int a , int b , boolean bool){
        if(!bool){this.myCells[a][b].setStyle("-fx-background-color: blue;");}
        else {this.myCells[a][b].setStyle("-fx-background-color: #FF7D00");}
    }
    
    public void SetButtonAndShips(){
        StatusLabel.setVisible(false);
        labelStatus = StatusLabel;
        myRatingLabel = MyRatingLable;
        sysLabelRat = SystemRatingLable;
        winlab = WinLable;
        this.NewGameButton.setDisable(true);
        this.WinLable.setVisible(false);
        this.MyRatingLable.setVisible(false);
        this.SystemRatingLable.setVisible(false);
        
        this.MyMap = new int[10][10];
        this.SystemMap = new int[10][10];
        this.SystemGridPane.setDisable(true);
        this.MyGridPane.setDisable(true);
        this.PlayButton.setDisable(true);
        this.ThreeShipButton.setDisable(true);
        this.TwoShipButton.setDisable(true);
        this.OneShipButton.setDisable(true);
        
        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j<10 ; j++){
                this.myCells[i][j] = new Button();
                this.systemCells[i][j] = new Button();
                MyMap[i][j] = -1;
                SystemMap[i][j] = -1;
                myCells[i][j].setMaxSize(60, 45);
                systemCells[i][j].setMaxSize(60, 45);
                MyGridPane.add(myCells[i][j], j, i);
                SystemGridPane.add(systemCells[i][j], j, i);
            }
        }    
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SetButtonAndShips();
        Action.start();
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
    private void handleNewGameButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) NewGameButton.getScene().getWindow();
        stage.close();
        try
        {
            Parent root3 = FXMLLoader.load(getClass().getResource("/View/FXMLChooseGame.fxml"));       
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
    private void handleThreeShipButtonAction(ActionEvent event) {
        sizeShipChoice = 3;
        this.MyGridPane.setDisable(false);
    }

    @FXML
    private void handleTwoShipButtonAction(ActionEvent event) {
        sizeShipChoice = 2;
        this.MyGridPane.setDisable(false);
    }

    @FXML
    private void handleFourShipButtonAction(ActionEvent event) {
        this.NewGameButton.setDisable(false);
        sizeShipChoice = 4;
        this.MyGridPane.setDisable(false);
    }

    @FXML
    private void handleOneShipButtonAction(ActionEvent event) {
        sizeShipChoice = 1;
        this.MyGridPane.setDisable(false);
    }

    @FXML
    private void handlePlayButtonAction(ActionEvent event) throws IOException {
        API.APII();
        this.NewShipsButton.setVisible(false);
        this.RandomButton.setVisible(false);
        this.PlayButton.setVisible(false);
        this.MyGridPane.setDisable(true);
        this.RatinLable.setVisible(true);
        this.OneShipButton.setVisible(false);
        this.TwoShipButton.setVisible(false);
        this.ThreeShipButton.setVisible(false);
        this.FourShipBurron.setVisible(false);
        this.ShipsLable.setVisible(false);
        this.MyRatingLable.setVisible(true);
        this.SystemRatingLable.setVisible(true);
        this.MyRatingLable.setText("0");
        this.SystemRatingLable.setText("0");
        this.file = new File("E:/Java/codes/BattleShip/SingleLog.txt");
        fileWriter = new FileWriter(file);
        fileWriter.write("Game is begun !!!\n"+LocalDateTime.now()+"\n");
        for(int i=0 ; i<10 ; i++){
            for(int j=0 ; j<10 ; j++){
                if(MyMap[i][j]!=0){MyMap[i][j]=1;}
            }
        }
        Action2.start();
        CheckStatusAction.start();
        gridPublic = SystemGridPane;
    }

    @FXML
    private void handleNewShipsButtonAction(ActionEvent event) {
        NewMap();
    }

    @FXML
    private void handleRandomButtonAction(ActionEvent event) {
        this.NewGameButton.setDisable(false);
        NewMap();
        FourShipRandom(this.MyMap , true);
        ThreeShipRandom(this.MyMap , true);
        TwoShipRandom(this.MyMap , true);
        OneShipRandom(this.MyMap , true);
        this.PlayButton.setDisable(false);
        Action.stop();
    }
    
}
