/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author juand
 */
public class Antidisturbios extends Enemigo{

    public Antidisturbios(int posLinea, int posX, int id) {
        super(50, 50, 20, posLinea, posX, Velocidad.REGULAR, Faccion.ESMAD,id);
    }

    @Override
    public void atacar() {
    }
    @Override
    public void metodosExtra() {
        //No tiene
    }
    
}
