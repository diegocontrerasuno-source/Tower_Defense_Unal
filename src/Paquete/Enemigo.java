/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

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
    protected int posX;
    protected int id;
    protected Velocidad velocidad;
    protected Faccion faccion;
    
    
    //constructor
    public Enemigo(int vidaMax, int vida, int ataque, int posLinea, int posX, Velocidad velocidad, Faccion faccion, int id) {    
        this.vidaMax = vidaMax;
        this.vida = vida;
        this.ataque = ataque;
        this.posLinea = posLinea;
        this.posX = posX;
        this.velocidad = velocidad;
        this.faccion = faccion;
        this.id = id;
    }

    //Metodos
    public abstract void atacar();
    public void moverse() {
        //Temporal pero la idea es q si sea definido desde aqui y luego sea sobreescrito por los q se muevan de otra manera
        if(posX!=1000) {
        switch(velocidad) {
            case MUYLENTO:
                posX+=20;
                break;
            case LENTO:
                posX+=25;
                break;
            case REGULAR:
                posX+=40;
                break;
            case RAPIDO:
                posX+=50;
                break;
            case MUYRAPIDO:
                posX+=100;
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

    public int getPosX() {
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
