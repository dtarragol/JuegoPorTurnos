import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
    /*public static void main(String[] args) {

        Connection con = null;
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proyectoJuego",
                    "root", "muslon2023");
            PreparedStatement st= con.prepareStatement("insert Mago (nombre, mana, vida) values (?,?,?);");
            st.setString(1, "nombre01");
            st.setInt(2, 100);
            st.setInt(3, 150);
            st.executeUpdate();
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("ventanas/VentanaInicio.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("PROYECTO JUEGO");
            primaryStage.setResizable(false);
            primaryStage.show();
        }
    }