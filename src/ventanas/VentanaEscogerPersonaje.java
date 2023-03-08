package ventanas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import BBDD.*;
import javafx.stage.Stage;
import personajes.Guerrero;
import personajes.Mago;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VentanaEscogerPersonaje implements Initializable {
    @FXML
    private ComboBox comboBoxPersonajes;
    @FXML
    private Button btnAtras, btnAceptar;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Guerrero> guerreros = new ArrayList<Guerrero>();
        ArrayList<Mago> magos = new ArrayList<Mago>();
        ConexionMySQL con = new ConexionMySQL();
        con.listarGuerrerosArray(guerreros, magos);
        for (int i= 0; i<guerreros.size(); i++){
            comboBoxPersonajes.getItems().add("Guerrero: "+guerreros.get(i).getNombre());
        }
        for (int i= 0; i<magos.size(); i++){
            comboBoxPersonajes.getItems().add("Mago: "+magos.get(i).getNombre());
        }
        con.cerrarConexion();
    }
    public void clickBtnAtras(javafx.event.ActionEvent actionEvent){
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
    public void clickBtnAceptar(javafx.event.ActionEvent actionEvent){
        String personaje = comboBoxPersonajes.getSelectionModel().getSelectedItem().toString();
        System.out.println(personaje);
        String[] partes = personaje.split(": ");
        String clase = partes[0];
        String nombre = partes[1];
        ConexionMySQL con = new ConexionMySQL();
        con.sacarPersonajeBBDD(clase, nombre);
    }
}
