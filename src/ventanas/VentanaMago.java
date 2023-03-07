package ventanas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import BBDD.*;
import personajes.Mago;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class VentanaMago implements Initializable{
    @FXML
    public Label label;
    @FXML
    private Button btnSalir;
    @FXML
    private TextField txtNombre, txtVida, txtAtributo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
    }
    @FXML
    public void clickBtnSalir(javafx.event.ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try{
            Parent root = FXMLLoader.load(VentanaInicio.class.getClassLoader().getResource("ventanas/VentanaInicio.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Inicio");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }
    }
    @FXML
    public void clickBtnAceptar(javafx.event.ActionEvent actionEvent){
        String nombre = txtNombre.getText();
        int vida = Integer.parseInt(txtVida.getText());
        int atributo = Integer.parseInt(txtAtributo.getText());

        ConexionMySQL c = new ConexionMySQL();
        c.insetarDatosEnTabla("Mago", nombre, atributo,vida);
        c.cerrarConexion();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("GUERRERO");
        alert.setContentText("Has creado un mago que se llama " + nombre);
        alert.showAndWait();
    }
}
