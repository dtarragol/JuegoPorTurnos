package BBDD;
import personajes.*;

import java.sql.*;
import java.util.ArrayList;

public class ConexionMySQL {
    private Connection con = null;

    public ConexionMySQL() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proyectoJuego",
                    "root", "muslon2023");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void realizarConsulta(String tabla) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+tabla);
            while (rs.next()) {
                // hacer algo con los resultados de la consulta
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void listarGuerrerosArray (ArrayList<Guerrero> a, ArrayList<Mago> b){
        try {
            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Guerrero;");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int fuerza = rs.getInt("fuerza");
                int vida = rs.getInt("vida");
                Guerrero guerrero = new Guerrero(nombre, vida, fuerza);
                a.add(guerrero);
            }
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM Mago;");
            while (rs2.next()) {
                String nombre = rs2.getString("nombre");
                int mana = rs2.getInt("mana");
                int vida = rs2.getInt("vida");
                Mago mago = new Mago(nombre, vida, mana);
                b.add(mago);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insetarDatosEnTabla(String personajeTipo, String nombre, int atributo, int vida) {
        try {
            if (personajeTipo.equals("Mago")){
                PreparedStatement st= con.prepareStatement("INSERT INTO Mago (nombre, mana, vida) VALUES (?,?,?);");

                st.setString(1, nombre);
                st.setInt(2, 100);
                st.setInt(3, 100);
                st.executeUpdate();
            }else{
                PreparedStatement st= con.prepareStatement("INSERT INTO Guerrero (nombre, fuerza, vida) VALUES (?,?,?);");

                st.setString(1, nombre);
                st.setInt(2, 100);
                st.setInt(3, 100);
                st.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void sacarPersonajeBBDD(String tabla, String nombre){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+tabla+" WHERE nombre = '"+nombre+"';");
            while (rs.next()) {
                if (tabla.equals("Guerrero")) {
                    int fuerza = rs.getInt("fuerza");
                    int vida = rs.getInt("vida");
                    Guerrero guerrero = new Guerrero(nombre, vida, fuerza);

                    System.out.println("Se ha escogido un guerrero");
                }
                if (tabla.equals("Mago")) {
                    int fuerza = rs.getInt("mana");
                    int vida = rs.getInt("vida");
                    Guerrero guerrero = new Guerrero(nombre, vida, fuerza);

                    System.out.println("Se ha escogido un mago");
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
