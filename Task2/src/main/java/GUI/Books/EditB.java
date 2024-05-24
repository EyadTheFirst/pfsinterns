package GUI.Books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditB {
    @FXML
    TextField Id, position;

    private Stage stage;
    private Scene scene;
    public static AnchorPane root;
    Connection con;
    PreparedStatement pst;

    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/GUI/hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void done() {
        connect();
        int id = 0;
        double Position = 0.0;
        try {
            id = Integer.parseInt(Id.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter numerical value");
        }
        try {
            Position = Double.parseDouble(position.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid position");
        }
        if (id!=0) {
            try {
                pst = con.prepareStatement("update books set Position = ? where id = ?");
                pst.setDouble(1, Position);
                pst.setInt(2, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Updated");
                //table_load();
                Id.setText("");
                position.setText("");
                Id.requestFocus();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "missing values");
            }
        }else {
            JOptionPane.showMessageDialog(null, "missing values");
        }
    }

    public void connect() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/library", "root", "6842");
            //System.out.println("Successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
