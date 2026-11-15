/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

import java.util.Random;
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
    private Random random = new Random();
    
    //constructor
    public Linea(int numeroIndividual, int numeroTotal, ListaEnemigos[] poolEnemigos) {
        this.numeroIndividual = numeroIndividual;
        this.numeroTotal = numeroTotal;
        this.poolEnemigos = poolEnemigos;
    }
    
    //Metodos 
    public void spawnearEnemigos() {
        ListaEnemigos enemigoSeleccionado = poolEnemigos[random.nextInt(poolEnemigos.length)];
        switch(enemigoSeleccionado) {
            case ANTIDISTURBIOS:
                System.out.println("Spawn Antidisturbios en la linea "+numeroIndividual);
                break;
            case ANTIDISTURBIOSESCUDO:
                System.out.println("Spawn Antidisturbios escudo en la linea "+numeroIndividual);
                break;
            case ANTIDISTURBIOSGAS:
                System.out.println("Spawn Antidisturbios gas en la linea "+numeroIndividual);
                break;
        }
    }
    
    
}
