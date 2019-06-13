
package Controller;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Morteza Sarvestani
 */
public class BattleShip extends Application {
    
    @Override
    public void start(Stage stage1) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("/View/FXMLChooseGame.fxml"));       
        Scene scene1 = new Scene(root1);
        stage1.setScene(scene1);
        stage1.setTitle("Game");
        stage1.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}