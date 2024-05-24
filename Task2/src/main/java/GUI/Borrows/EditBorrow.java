package GUI.Borrows;

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
import java.sql.*;

public class EditBorrow {
    @FXML
    TextField Id, Issue;

    private Stage stage;
    private Scene scene;
    public static AnchorPane root;
    Connection con;
    PreparedStatement pst;

    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/GUI/Borrowers.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void done() {
        connect();
        int id = 0;
        String issue=Issue.getText();
        try {
            id = Integer.parseInt(Id.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter numerical value");
        }

        try {
            pst = con.prepareStatement("select * from borrowers where Library_ID = ?");
            pst.setDouble(1, id);
            ResultSet rs = pst.executeQuery();
            StringBuilder sb = new StringBuilder();
            if(!rs.next()) {
                JOptionPane.showMessageDialog(null, "this borrower is not found");
                throw new RuntimeException("this borrower is not found");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "missing values");
        }

        if (id>0) {
            try {
                pst = con.prepareStatement("update borrowers set Issues = ? where Library_ID = ?");
                pst.setString(1, issue);
                pst.setInt(2, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Issue added");
                //table_load();
                Id.setText("");
                Issue.setText("");
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
