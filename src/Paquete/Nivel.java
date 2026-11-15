/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;


/**
 *
 * @author juand
 */
public class Nivel {
    //Atributos
    private String nombre;
    private int numeroLineas;
    private Dificultad dificultad;
    private int vidaPuerta;
    private Linea[] lineas;
    private ListaEnemigos[] poolEnemigos;
    
    //Constructor
    public Nivel(String nombre, int numeroLineas, Dificultad dificultad, int vidaPuerta, ListaEnemigos[] poolEnemigos) {
        this.nombre = nombre;
        this.numeroLineas = numeroLineas;
        this.dificultad = dificultad;
        this.vidaPuerta = vidaPuerta;
        this.poolEnemigos = poolEnemigos;
        lineas = new Linea[numeroLineas];
    }
   
    //Metodos
    public void crearLineas() {
        for (int i=0;i<numeroLineas;i++) {
            lineas[i] = new Linea(i+1,numeroLineas,poolEnemigos);
        }
    }
}
