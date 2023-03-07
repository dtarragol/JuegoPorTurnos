package ventanas;
import javafx.application.Platform;
import javafx.fxml.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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

public class VentanaCrearPersonaje implements Initializable{
    @FXML
    public Label label;
    @FXML
    private  Button btnGuerrero, btnMago, btnSalir;
    @FXML
    private Pane paneFoto1, paneFoto2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image img2 = new Image(getClass().getResourceAsStream("/imagenes/wizard.png"));
        Image img = new Image(getClass().getResourceAsStream("/imagenes/gato.png"));
        ImageView imgView = new ImageView(img);
        ImageView imgView2 = new ImageView(img2);
        imgView.setFitWidth(410);
        imgView.setFitHeight(460);
        imgView2.setFitWidth(410);
        imgView2.setFitHeight(460);
        paneFoto1.getChildren().add(imgView);
        paneFoto2.getChildren().add(imgView2);
    }
    @FXML
    public void clickBtnGuerrero(javafx.event.ActionEvent actionEvent) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("GUERRERO");
        alert.setContentText("¿Deseas realmente confirmar?\n" +
                "El guerrero es un personaje altamente habilidoso en el combate cuerpo a cuerpo y equipado con armadura y armas poderosas.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            try{
                Parent root = FXMLLoader.load(VentanaGuerrero.class.getClassLoader().getResource("ventanas/ventanaGuerrero.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("GUERRERO");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
            }
        } else {
            // Acción a realizar si el usuario hace clic en Cancelar
        }
    }
    @FXML
    public void clickBtnMago(javafx.event.ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("MAGO");
        alert.setContentText("¿Deseas realmente confirmar?\n" +
                "Es mago es un personaje especializado en el uso de la magia. Tiene habilidades para lanzar hechizos y conjuros");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            try{
                Parent root = FXMLLoader.load(VentanaMago.class.getClassLoader().getResource("ventanas/ventanaMago.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("MAGO");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
            }
        } else {
            // Acción a realizar si el usuario hace clic en Cancelar
        }
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


}
