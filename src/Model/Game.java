
package Model;

/**
 *
 * @author Morteza
 */
public class Game {
    private String userName;
    private int gameID;

    
    public Game(String n , int ID){
        this.gameID = ID;
        this.userName = n;
    }
    
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the gameID
     */
    public int getGameID() {
        return gameID;
    }

    /**
     * @param gameID the gameID to set
     */
    public void setGameID(int gameID) {
        this.gameID = gameID;
    }
    
}
