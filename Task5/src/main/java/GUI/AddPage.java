package GUI;

import Exceptions.EmployeeIsAlreadyRecorded;
import Exceptions.EmployeeNotFoundException;
import Exceptions.InvaliedGenderException;
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

public class AddPage {
    @FXML
    Label l,t,ex;
    @FXML
    TextField fname,fage,fsalary;
    @FXML
    RadioButton M,F;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void add(ActionEvent event) throws Exception{
        int age = 0;
        char g;
        double s = 0;
        try {
            age=Integer.parseInt(fage.getText());
        }catch (Exception e){
            l.setOpacity(0);
            ex.setText("Please enter numerical value");
            throw e;
        }
        try {
            s=Double.parseDouble(fsalary.getText());
        }catch (Exception e){
            l.setOpacity(0);
            ex.setText("Please enter numerical value");
            throw e;
        }
        if (M.isSelected())
            g='m';
        else if (F.isSelected())
            g='f';
        else{
            l.setOpacity(0);
            ex.setOpacity(1);
            t.setOpacity(0);
            ex.setText("Invalid gender");
            throw new InvaliedGenderException();
        }
        try {
            Add(fname.getText(),age,g,s);
            l.setOpacity(0);
            t.setOpacity(1);
            ex.setOpacity(0);
        }catch (EmployeeIsAlreadyRecorded e) {
            l.setOpacity(0);
            ex.setOpacity(1);
            t.setOpacity(0);
            ex.setText("Employee already added");
            throw e;
        }catch (Exception e){
            l.setOpacity(0);
            ex.setOpacity(1);
            t.setOpacity(0);
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
