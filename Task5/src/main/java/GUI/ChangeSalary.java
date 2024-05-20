package GUI;

import Exceptions.EmployeeNotFoundException;
import Exceptions.NotNumericalValue;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import java.io.IOException;

import static EPS.PayrollSystem.*;

public class ChangeSalary {
    @FXML
    TextField n,s;
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
            ex.setOpacity(1);
            ex.setText("Please enter numerical value");
            throw e;
        }
        try {
            ChangeSalary(n.getText(),salary);
            l.setOpacity(1);
            l.setText("Salary updated successfully");
            l.setLayoutX(4);
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
