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

public class Return {
    @FXML
    TextField BID,LID;

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
        int lID=0;
        int bID=0;
        int returned=0;
        try {
            lID=Integer.parseInt(LID.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please enter numerical value");
        }
        try {
            bID=Integer.parseInt(BID.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please enter numerical value");
        }

        try {
            pst = con.prepareStatement("select * from books where id = ?");
            pst.setDouble(1, bID);
            ResultSet rs = pst.executeQuery();
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                String case1= (rs.getString("is_Borrowed")).equals("0")? "No" : "Yes";
                if (case1.equals("No")){
                    JOptionPane.showMessageDialog(null, "the Book is not borrowed");
                    throw new RuntimeException("the Book is not borrowed");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "missing values");
        }

        try {
            pst = con.prepareStatement("select * from borrowers where Library_ID = ?");
            pst.setDouble(1, lID);
            ResultSet rs = pst.executeQuery();
            StringBuilder sb = new StringBuilder();
            if(!rs.next()) {
                JOptionPane.showMessageDialog(null, "this borrower is not found");
                throw new RuntimeException("this borrower is not found");
            }
            else if(Integer.parseInt(rs.getString("Book_ID"))!=bID){
                JOptionPane.showMessageDialog(null, "this is not your book");
                throw new RuntimeException("this is not your book");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "missing values");
        }

        if (lID != 0) {
            try {
                pst = con.prepareStatement("delete from borrowers  where Library_ID = ?");
                pst.setInt(1, lID);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Book returned");
                //table_load();
                LID.setText("");
                BID.setText("");
                LID.requestFocus();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, "missing values");
            }
        }else JOptionPane.showMessageDialog(null, "missing values");

        if (bID!=0) {
            try {
                pst = con.prepareStatement("update books set is_Borrowed = ? where id = ?");
                pst.setBoolean(1, false);
                pst.setInt(2, bID);
                pst.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Record Updated");
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
            con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/library","root","6842");
            //System.out.println("Successful");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
