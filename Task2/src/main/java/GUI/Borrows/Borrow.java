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

public class Borrow {
    @FXML
    TextField BID,LID,ISS,PN,FN;

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
        String Name = FN.getText();
        String issues = ISS.getText();
        int lID=0;
        int bID=0;
        String phone=PN.getText();
        int c=0;
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
            c=Integer.parseInt(PN.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "invalid phone number");
        }

        try {
            pst = con.prepareStatement("select * from books where id = ?");
            pst.setDouble(1, bID);
            ResultSet rs = pst.executeQuery();
            //view.setOpacity(1);
            //System.out.println(5);
            //System.out.println(rs.getString(2).toString());
//                for (int i = 1; i <= 5; i++) {
//                    view.setText(view.getText()+" , "+rs.getString(i));
//                    System.out.println(rs.getString(i));
//                }
            //table1.setModel(DbUtils.resultSetToTableModel(rs));
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                // Assuming the table has a 'name' column
//                String id = rs.getString("ID");
//                String name= rs.getString("Book_Name");
//                String author= rs.getString("Author_Name");
//                String position= rs.getString("Position");
                String case1= (rs.getString("is_Borrowed")).equals("0")? "No" : "Yes";
//                sb.append(id).append("  ||  ");
//                sb.append(name).append("  ||  ");
//                sb.append(author).append("  ||  ");
//                sb.append(position).append("  ||  ");
//                sb.append(case1).append("  ||  ");
                if (case1.equals("Yes")){
                    JOptionPane.showMessageDialog(null, "the Book is already borrowed");
                    throw new RuntimeException("the Book is already borrowed");
                }
            }

            // Update Label text with ResultSet data
            //view.setText(sb.toString());


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "missing values");
        }

        try {
//            pst=con.prepareStatement("use library");
//            pst.executeUpdate();
            pst = con.prepareStatement("insert into borrowers(Library_ID,First_Name,Phone_Number,Book_ID,Issues)values(?,?,?,?,?)");
            pst.setInt(1, lID);
            pst.setString(2, Name);
            pst.setString(3, phone);
            pst.setInt(4, bID);
            pst.setString(5, issues);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "You borrowed the book successfully");
            //table_load();
            BID.setText("");
            LID.setText("");
            PN.setText("");
            ISS.setText("");
            FN.setText("");
            LID.requestFocus();
        }

        catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "missing values");
        }
        if (bID!=0) {
            try {
                pst = con.prepareStatement("update books set is_Borrowed = ? where id = ?");
                pst.setBoolean(1, true);
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
