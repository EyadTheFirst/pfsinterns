package GUI;

import Exceptions.EmployeeNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static EPS.PayrollSystem.*;

public class Deduction {
    @FXML
    TextField n,s,n1;
    @FXML
    Label l,ex;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void done(ActionEvent event) throws IOException {
        double salary = 0;
        try {
            salary=Double.parseDouble(s.getText());
        }catch (Exception e){
            l.setOpacity(0);
            ex.setText("Please enter numerical value");
            throw e;
        }
        try {
            deduction(n.getText(),salary,n1.getText());
            l.setText("Deduction done successfully");
            l.setLayoutX(6);
            l.setOpacity(1);
            ex.setOpacity(0);
        }catch (EmployeeNotFoundException e){
            l.setOpacity(0);
            ex.setOpacity(1);
            ex.setText("Employee not found");
            throw e;
        }catch (Exception e){
            l.setOpacity(0);
            ex.setOpacity(1);
            ex.setText("Something went wrong");
            throw e;
        }
    }
    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("interface-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
