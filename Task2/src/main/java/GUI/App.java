package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application{
    public static AnchorPane root;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/GUI/hello-view.fxml"));
        root=(AnchorPane)loader2.load();
        HelloController controller2=loader2.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
