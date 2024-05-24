package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Borrowers {
    private Stage stage;
    private Scene scene;
    public static AnchorPane root;
    public void switch1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void borrow(ActionEvent event) throws IOException {
        root =(AnchorPane) FXMLLoader.load(getClass().getResource("Borrowers/borrow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void returns(ActionEvent event) throws IOException {
        root =(AnchorPane) FXMLLoader.load(getClass().getResource("Borrowers/return.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void edit(ActionEvent event) throws IOException {
        root =(AnchorPane) FXMLLoader.load(getClass().getResource("Borrowers/editBorrow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void view(ActionEvent event) throws IOException {
        root =(AnchorPane) FXMLLoader.load(getClass().getResource("Borrowers/viewBorrow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
