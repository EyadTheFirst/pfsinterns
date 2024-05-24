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
import java.sql.*;

public class Add {
    @FXML
    TextField id,name,author,position;

    private Stage stage;
    private Scene scene;
    public static AnchorPane root;
    Connection con;
    PreparedStatement pst;

    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/GUI/hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void done(ActionEvent event){
        connect();
        String Name = name.getText();
        String Author = author.getText();
        int ID=0;
        double Position=0.0;
        try {
            ID=Integer.parseInt(id.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please enter numerical value");
        }
        try {
            Position=Double.parseDouble(position.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Invalid position");
        }

        try {
//            pst=con.prepareStatement("use library");
//            pst.executeUpdate();
            pst = con.prepareStatement("insert into books(Id,Book_Name,Author_Name,Position)values(?,?,?,?)");
            pst.setInt(1, ID);
            pst.setString(2, Name);
            pst.setString(3, Author);
            pst.setDouble(4, Position);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Added");
            //table_load();
            name.setText("");
            author.setText("");
            id.setText("");
            position.setText("");
            name.requestFocus();
        }

        catch (SQLException e1) {
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
