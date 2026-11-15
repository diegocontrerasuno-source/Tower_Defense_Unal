/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

import javax.swing.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author juand
 */
public class Nivel {
    //Atributos
    private String nombre;
    private int numeroLineas;
    private int vidaPuerta;
    private Linea[] lineas;
    private ListaEnemigos[] poolEnemigos;
    private Random random = new Random();
    
    //Constructor
    public Nivel(String nombre, int numeroLineas, int vidaPuerta, ListaEnemigos[] poolEnemigos) {
        this.nombre = nombre;
        this.numeroLineas = numeroLineas;
        this.vidaPuerta = vidaPuerta;
        this.poolEnemigos = poolEnemigos;
        lineas = new Linea[numeroLineas];
        crearLineas();
    }
   
    //Metodos
    public void crearLineas() {
        for (int i=0;i<numeroLineas;i++) {
            lineas[i] = new Linea(i+1,numeroLineas,poolEnemigos);
        }
    }
    
    public void jugar() {
        Timer delaySpawn = new Timer();
        TimerTask spawnear = new TimerTask() {
            @Override
            public void run() {
                lineas[random.nextInt(numeroLineas)].spawnearEnemigos();
            }
            
        };
        TimerTask detener = new TimerTask() {
            @Override
            public void run() {
                delaySpawn.cancel();
            }
        };
        delaySpawn.schedule(spawnear, 2000, 1000);
        delaySpawn.schedule(detener, 23000);
    }
}
