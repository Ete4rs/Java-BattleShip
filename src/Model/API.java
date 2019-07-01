
package Model;

import Controller.FXMLDoubleGameController;
import static Controller.FXMLDoubleGameController.gridPublic;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author Morteza
 */
public class API {
    private static File f;
    private static FileWriter file ;
    private static String str = "";
    private static String MyToken = "6dec6041bab42deff11e6c6208494cea55ba5ae5";
    private static String Address = "https://java.ce.scu.ac.ir/api/";
    private static HttpClient httpClient = HttpClientBuilder.create().build();
    private static Game game;
    public static String Message;
    public static int[][] sysMap = new int[10][10];
    //"faf5e687ceae65f589748ee422f0f6ea51fd1c9d" new
    
    private static  JSONObject JSonObject ;
    public static void APII() throws IOException{
        f = new File("E:\\Java\\codes\\BattleShip\\BattleShip\\DoubleLog.txt");
        file = new FileWriter(f);
        JSonObject = new JSONObject();
        HttpResponse response;
        try {
            HttpPost request = new HttpPost(Address + "start/" );
            request.addHeader("Authorization","Token "+ MyToken);
            response = httpClient.execute(request);
            StartGame(response);
        }catch(Exception ex) {} finally {}
    }
    
    
    public static void StartGame(HttpResponse response) throws IOException{
        int code  =  response.getStatusLine().getStatusCode();
        String s = EntityUtils.toString(response.getEntity());
        System.out.println(s);
        JSONObject temp = new JSONObject(s);        
        game.setGameID( temp.getInt("game_id"));
    }
    
    public static void CheckStatus(int[][] Mymap) throws IOException{
        FXMLDoubleGameController.labelStatus.setText(Message);
        HttpGet get = new HttpGet(Address + "status/" + game.getGameID());
        get.addHeader("content-type" , "application/json ");
        get.addHeader("Authorization" , "Token " + MyToken);
        HttpResponse response;
        int code = 0;
        String temp="";
        
        try{
            response = httpClient.execute(get);
            temp += EntityUtils.toString(response.getEntity());
            code += response.getStatusLine().getStatusCode();
        }catch(Exception ex) {} 
        JSONObject json = new JSONObject(temp);
        if(code==200){
            if(json.getInt("code")==0){
                Message = json.getString("message");
                str += Message;
                
            }
            else if(json.getInt("code")==1){
                Message = json.getString("message");
                str += Message;
                game.setUserName(json.getString("rival"));
            }
            else if(json.getInt("code")==2){
                SendBoard(Mymap);
            }
            else if(json.getInt("code")==3){
                Message = json.getString("message");
                str += Message;
                gridPublic.setDisable(false);
                
            }
            else if(json.getInt("code")==4){
                Message = json.getString("message");
                gridPublic.setDisable(true);
            }
            else if(json.getInt("code")==5){
                gridPublic.setDisable(true);
            }
            else if(json.getInt("code")==6){
                Message = json.getString("message");
                
                str += Message;
                gridPublic.setDisable(true);
            }
        }
        else if (code==400){
            Message = json.getString("detail");
            str += Message;
            
        }
        else if(code==202){
            if(json.getString("message").equals("board loaded successfully")){
                Message = json.getString("message");
                str += Message;
            }
            else if(json.getBoolean("win")==false && json.get("status").equals("ok")&&json.getBoolean("ship")==false){
                str += "Shoot to water . "+false+"\n";
            }
            else if(json.getBoolean("win")==true && json.get("status").equals("ok")&&json.getBoolean("ship")==true){
                if(json.get("winner").equals(game.getUserName())){
                    
                }
            }
            
        }
        
        
    }
    public static void Shoot(int a , int b) throws IOException{
        JSONObject json = new JSONObject();
        HttpResponse response;
        
        try {
            HttpPost request = new HttpPost(Address + "move/" );
            request.addHeader("Authorization","Token "+ MyToken);
            json.put("game_id",game.getGameID());
            json.put("x", b);
            json.put("y", a);
            StringEntity param = new StringEntity(json.toString());
            request.setEntity(param);
            response = httpClient.execute(request);
            StartGame(response);
            
        }catch(Exception ex) {} finally {}
    }
    
    public static void SendBoard(int[][] MyMap) throws IOException{
        JSONObject t = new JSONObject();
        t.put("game_id" , game.getGameID());
        t.put("Board_array", MyMap);
        HttpPost request ;
        HttpResponse response ;
        try{
            request = new HttpPost(Address + "init_game/" );
            request.addHeader("Authorization","Token "+ MyToken);
            StringEntity temp = new StringEntity(t.toString());
            request.setEntity(temp);
            response = httpClient.execute(request);
        }catch(Exception ex) {} 
    }
    
     
   
}
