/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        //V0.5
       
        //TEST
        ListaEnemigos[] testPool = {ListaEnemigos.ANTIDISTURBIOS,ListaEnemigos.ANTIDISTURBIOS,ListaEnemigos.ANTIDISTURBIOSESCUDO,
        ListaEnemigos.ANTIDISTURBIOS, ListaEnemigos.ANTIDISTURBIOSESCUDO, ListaEnemigos.ANTIDISTURBIOSGAS};
        Nivel test = new Nivel("Test",3,1000,testPool,5);
    }
}
