package personajes;
import javafx.scene.control.Alert;

import java.util.Random;

public class Mago extends Personaje{
    int mana;

    public Mago(String nombre, int vida, int mana) {
        super(nombre, vida);
        this.mana = mana;
        /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("MAGO CREADO");
        alert.setContentText("Has creado un Mago que se llama "+nombre+".");
        alert.showAndWait();*/
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
    public int ataqueMagico(){
        Random random = new Random();
        int hitpoints = mana/random.nextInt(70);
        System.out.println(nombre+" realiza su ataque magico e inflije "+hitpoints+" de daño.");
        return hitpoints;
    }
    public void recibeDaño(int hitpoints){
        int vidaResultante = vida - hitpoints;
        if(vidaResultante<0) vidaResultante=0;
        setVida(vidaResultante);
        if (vida==0){
            System.out.println(nombre + " ha muerto");
        }else{
            System.out.println("La vida de "+nombre+" resulta en "+vida);
        }
    }
    public int contrataque(int vida){
        Random random = new Random();
        int hitpoints = random.nextInt((int)(mana*(1.5)));
        hitpoints = hitpoints + random.nextInt(hitpoints);
        System.out.println(nombre+" realiza un contrataque magico e inflije "+hitpoints+" de daño.");
        vida = vida - hitpoints;
        if (vida < 0) vida=0;
        return vida;
    }
}
