package ventanas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
public class VentanaInicio implements Initializable{
    @FXML
    private Button btnEscoger, btnCrear, btnSalir;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }
    @FXML
    public void clickBtnSalir(javafx.event.ActionEvent actionEvent){
        Stage stage = (Stage) this.btnSalir.getScene().getWindow();
        stage.close();
    }
    public void clickBtnCrear(javafx.event.ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try{
            Parent root = FXMLLoader.load(VentanaCrearPersonaje.class.getClassLoader().getResource("ventanas/VentanaCrearPersonaje.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("CREANDO PERSONAJE");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }
    }
    public void clickBtnEscoger(javafx.event.ActionEvent actionEvent){
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try{
            Parent root = FXMLLoader.load(VentanaEscogerPersonaje.class.getClassLoader().getResource("ventanas/VentanaEscogerPersonaje.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("ESCOGIENDO GUERRERO");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }
    }

}
