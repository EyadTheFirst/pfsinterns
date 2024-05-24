package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    private Stage stage;
    private Scene scene;
    public static AnchorPane root;
    public void switch1(ActionEvent event) throws IOException {
        root =(AnchorPane) FXMLLoader.load(getClass().getResource("Borrowers.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Add(ActionEvent event) throws IOException {
        root =(AnchorPane) FXMLLoader.load(getClass().getResource("Books/Add.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void edit(ActionEvent event) throws IOException {
        root =(AnchorPane) FXMLLoader.load(getClass().getResource("Books/editB.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void view(ActionEvent event) throws IOException {
        root =(AnchorPane) FXMLLoader.load(getClass().getResource("Books/viewB.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void delete(ActionEvent event) throws IOException {
        root =(AnchorPane) FXMLLoader.load(getClass().getResource("Books/deleteB.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}