/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author juand
 */
public abstract class Defensor {
    //Atributos
    protected int vidaMax;
    protected int vida;
    protected int ataque;
    protected int nivel = 1;
    protected int[] slot; //[2]-->[atras o deltante de la puerta(0,1) , linea]
    protected Facultad facultad;
    
    //Constructor

    public Defensor(int vidaMax, int vida, int ataque, int[] slot, Facultad facultad) {
        this.vidaMax = vidaMax;
        this.vida = vida;
        this.ataque = ataque;
        this.slot = slot;
        this.facultad = facultad;
    }
    
    //Metodos
    public void defender() {
    }
    public abstract void mejorar();
    public abstract void metodosExtra();
    
    //Getters y Setters

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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int[] getSlot() {
        return slot;
    }

    public void setSlot(int[] slot) {
        this.slot = slot;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
    
    
    
}
