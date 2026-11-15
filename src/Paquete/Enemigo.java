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
    protected Velocidad velocidad;
    protected Faccion faccion;
    
    //constructor
    public Enemigo(int vidaMax, int vida, int ataque, int posLinea, int posX, Velocidad velocidad, Faccion faccion) {    
        this.vidaMax = vidaMax;
        this.vida = vida;
        this.ataque = ataque;
        this.posLinea = posLinea;
        this.posX = posX;
        this.velocidad = velocidad;
        this.faccion = faccion;
    }

    //Metodos
    public abstract void atacar();
    public abstract void moverse();
    public abstract void metodosExtra();
    
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
    
}
