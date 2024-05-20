package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SystemInterfaceController {
    @FXML
    Button p1,p2,p3,p4,p5,p6;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void active1(){
        p1.setOpacity(0.5);
    }
    public void active2(){
        p2.setOpacity(0.5);
    }
    public void active3(){
        p3.setOpacity(0.5);
    }
    public void active4(){
        p4.setOpacity(0.5);
    }
    public void active5(){
        p5.setOpacity(0.5);
    }
    public void active6(){
        p6.setOpacity(0.5);
    }
    public void inactive1(){
        p1.setOpacity(1);
    }
    public void inactive2(){
        p2.setOpacity(1);
    }
    public void inactive3(){
        p3.setOpacity(1);
    }
    public void inactive4(){
        p4.setOpacity(1);
    }
    public void inactive5(){
        p5.setOpacity(1);
    }
    public void inactive6(){
        p6.setOpacity(1);
    }
    public void action1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void action2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChangeSalary.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void action3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("taxes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void action4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("deduction.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void action5(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("payroll.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void action6(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("payslip.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}