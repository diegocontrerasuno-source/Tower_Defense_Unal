/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author juand
 */
public class AntidisturbiosGas extends Enemigo{

    public AntidisturbiosGas(int posLinea, int posX, int id, VentanaPrincipal ventana) {
        super(50, 50, 5, posLinea, posX, Velocidad.RAPIDO, Faccion.ESMAD,id,ventana);
    }

    @Override
    public void atacar() {
        
    }
    @Override
    public void metodosExtra() {
        
    }
    
}
