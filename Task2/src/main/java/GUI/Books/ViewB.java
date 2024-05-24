package GUI.Books;

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
import javax.swing.text.TableView;
import java.io.IOException;
import java.sql.*;

public class ViewB {
    @FXML
    TextField id;
    @FXML
    Label view;

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
        int ID=0;
        try {
            ID=Integer.parseInt(id.getText());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Please enter numerical value");
        }
//        void table_load()
//        {
            try {
                pst = con.prepareStatement("select * from books where id = ?");
                pst.setDouble(1, ID);
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
                    String id = rs.getString("ID");
                    String name= rs.getString("Book_Name");
                    String author= rs.getString("Author_Name");
                    String position= rs.getString("Position");
                    String case1= (rs.getString("is_Borrowed")).equals("0")? "No" : "Yes";
                    sb.append(id).append("  ||  ");
                    sb.append(name).append("  ||  ");
                    sb.append(author).append("  ||  ");
                    sb.append(position).append("  ||  ");
                    sb.append(case1).append("  ||  ");
                }

                // Update Label text with ResultSet data
                view.setText(sb.toString());


            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "missing values");
            }
//        }

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
