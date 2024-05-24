package GUI.Borrows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class ViewBorrow {
    @FXML
    Label view;

    private Stage stage;
    private Scene scene;
    public static AnchorPane root;
    Connection con;
    PreparedStatement pst;

    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/GUI/Borrowers.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void done(ActionEvent event){
        connect();
        try {
            pst = con.prepareStatement("select * from borrowers");
            ResultSet rs = pst.executeQuery();
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                String id = rs.getString("Library_ID");
                String name= rs.getString("First_Name");
                String author= rs.getString("Phone_Number");
                String position= rs.getString("Book_ID");
                String case1= rs.getString("Issues");
                sb.append(id).append("   ||   ");
                sb.append(name).append("   ||   ");
                sb.append(author).append("   ||   ");
                sb.append(position).append("   ||   ");
                sb.append(case1).append("\n");
            }
            view.setText(sb.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "missing values");
        }
    }
    public void connect() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/library","root","6842");
            //System.out.println("Successful");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
