package ventanas;
import BBDD.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import personajes.*;
import javafx.application.Platform;
import javafx.fxml.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class VentanaGuerrero implements Initializable{
    @FXML
    public Label label;
    @FXML
    private TextField txtNombre,txtVida, txtAtributo;
    @FXML
    private Button btnSalir;


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
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }
    }
    @FXML
    public void clickBtnAceptar(javafx.event.ActionEvent actionEvent) {
        String nombre = txtNombre.getText();
        int vida = Integer.parseInt(txtVida.getText());
        int atributo = Integer.parseInt(txtAtributo.getText());

        ConexionMySQL c = new ConexionMySQL();
        c.insetarDatosEnTabla("Guerrero", nombre, atributo,vida);
        c.cerrarConexion();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("GUERRERO");
        alert.setContentText("Has creado un guerrero que se llama " + nombre);
        alert.showAndWait();

    }
}
