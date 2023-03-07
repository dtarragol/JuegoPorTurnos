
package personajes;
import javafx.scene.control.Alert;

import java.util.Random;

public class Guerrero extends Personaje {
    int fuerza;

    public Guerrero(String nombre, int vida, int fuerza) {
        super(nombre, vida);
        this.fuerza = fuerza;
        /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("GUERRERO CREADO");
        alert.setContentText("Has creado un Guerrero que se llama "+nombre+".");
        alert.showAndWait();*/
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int ataqueFisico() {
        Random random = new Random();
        int hitpoints = random.nextInt(fuerza);
        System.out.println(nombre + " realiza su ataque e inflije " + hitpoints + " de daño.");
        return hitpoints;
    }

    public void recibeDaño(int hitpoints) {
        int vidaResultante = vida - hitpoints;
        if(vidaResultante<0) vidaResultante=0;
        setVida(vidaResultante);
        if (vida == 0) {
            System.out.println(nombre + " ha muerto");
        } else {
            System.out.println("La vida de " + nombre + " resulta en " + vida);
        }
    }
    public int contrataque(int vida){
        Random random = new Random();
        int hitpoints = random.nextInt((int)(fuerza*(1.2)));
        hitpoints = hitpoints + random.nextInt(hitpoints);
        System.out.println(nombre+" realiza un contrataque magico e inflije "+hitpoints+" de daño.");
        vida = vida - hitpoints;
        if (vida < 0) vida=0;
        return vida;
    }
}

