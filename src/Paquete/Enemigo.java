/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 *
 * @author juand
 */
public abstract class Enemigo {
    //Atributos
    protected int vidaMax;
    protected int vida;
    protected int ataque;
    protected int posLinea;
    protected double posX;
    protected int id;
    protected int spriteActual = 0;
    protected boolean refrescados = false;
    protected Velocidad velocidad;
    protected Faccion faccion;
    protected VentanaPrincipal ventana;
    
    ImageIcon sprites[] = {
    new ImageIcon("SpriteDefault1.png"), //moverse1
    new ImageIcon("SpriteDefault2.png"), //moverse2   
    
    };
    //constructor
    public Enemigo(int vidaMax, int vida, int ataque, int posLinea, int posX, Velocidad velocidad, Faccion faccion, int id,VentanaPrincipal ventana) {    
        this.vidaMax = vidaMax;
        this.vida = vida;
        this.ataque = ataque;
        this.posLinea = posLinea;
        this.posX = posX;
        this.velocidad = velocidad;
        this.faccion = faccion;
        this.id = id;
        this.ventana = ventana;
    }

    //Metodos
    public abstract void atacar();
    public void moverse() {
        if(posX>0) {
        switch(velocidad) {
            case MUYLENTO:
                posX-=0.3; //0.3 61s
                break;
            case LENTO:
                posX-=0.4; //0.4 46s
                break;
            case REGULAR:
                posX-=0.5; //0.5 37s
                break;
            case RAPIDO:
                posX-=0.7;  //0.7  27s
                break;
            case MUYRAPIDO:
                posX-=1.1;  //1.1  18s
                break;
        }
        ventana.moverEnemigo(id, posX);
        }   
    }
    public void refrescarSprite() {
        if(!refrescados) {
        for(int i=0;i<sprites.length;i++) {
            Image imagen = sprites[i].getImage().getScaledInstance(ventana.getYLineas()/2, ventana.getYLineas(),Image.SCALE_DEFAULT);
            sprites[i] = new ImageIcon(imagen); 
        }
        refrescados = true;
        }
    }
    public void ciclarSprite() {
        if(posX>0) {
        switch (spriteActual) {
            case 0:
                spriteActual = 1;
                ventana.spriteEnemigo(id, sprites, spriteActual);
                break;
            case 1:
                spriteActual = 0;
                ventana.spriteEnemigo(id, sprites, spriteActual);
                break;
            default:
                break;
        }
        }
    }
    
    public abstract void metodosExtra();
    public boolean perderVida(int dano) {
        //TEMPORAL PARA TEST PERO PUEDE SER UNA IDEA HACERLO PARECIDO
        vida -=dano;
        return (vida<1);
    }
    
    //getters y setters

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getPosLinea() {
        return posLinea;
    }

    public void setPosLinea(int posLinea) {
        this.posLinea = posLinea;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public Velocidad getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Velocidad velocidad) {
        this.velocidad = velocidad;
    }

    public Faccion getFaccion() {
        return faccion;
    }

    public void setFaccion(Faccion faccion) {
        this.faccion = faccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
