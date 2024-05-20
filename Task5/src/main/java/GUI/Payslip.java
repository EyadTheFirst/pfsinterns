package GUI;

import Exceptions.EmployeeNotFoundException;
import Exceptions.TaxesAlreadyDeducedException;
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

import static EPS.employee.*;

public class Payslip {
    @FXML
    TextField n,s;
    @FXML
    Label l,ex,k;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void done() throws IOException {
        try {
            l.setOpacity(1);
            k.setOpacity(1);
            k.setText(String.valueOf(PayrollDetailsn(s.getText())));
            ex.setOpacity(0);
        }catch (EmployeeNotFoundException e) {
            l.setOpacity(0);
            k.setOpacity(0);
            ex.setOpacity(1);
            ex.setText("Employee not found");
            throw e;
        }catch (Exception e){
            l.setOpacity(0);
            ex.setOpacity(1);
            k.setOpacity(0);
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
