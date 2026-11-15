/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;


/**
 *
 * @author juand
 */
public class Linea {
    //Atributos
    private int numeroIndividual;
    private int numeroTotal;
    private int posY;
    private ListaEnemigos[] poolEnemigos;
    //private static int pool; <---- no olvidar poner las pools cuado se hagan :0
    
    //constructor
    public Linea(int numeroIndividual, int numeroTotal, ListaEnemigos[] poolEnemigos) {
        this.numeroIndividual = numeroIndividual;
        this.numeroTotal = numeroTotal;
        this.poolEnemigos = poolEnemigos;
    }
    
    //Metodos 
    public void spawnearEnemigos() {
        
    }
    
    
}
