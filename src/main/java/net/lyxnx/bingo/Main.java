package net.lyxnx.bingo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("/bingo.fxml"));

        Parent root = loader.load();

        Controller controller = loader.getController();
        controller.load(root);

        primaryStage.setResizable(false); // unless we want it to be resizable but that will involve messing with components
        primaryStage.setTitle("Scammer Bingo");
        //primaryStage.getIcons().add(new Image("/icon.png")); TODO add icon
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
