/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author juand
 */
public class AntidisturbiosEscudo extends Enemigo{

    public AntidisturbiosEscudo(int posLinea, int posX,int id,VentanaPrincipal ventana) {
        super(150, 150, 10, posLinea, posX, Velocidad.LENTO, Faccion.ESMAD,id,ventana);
    }

    @Override
    public void atacar() {
     
    }
    @Override
    public void metodosExtra() {
     
    }
    
}
