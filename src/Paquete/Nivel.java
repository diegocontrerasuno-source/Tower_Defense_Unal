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
    private int totalSpawns;
    private int numeroSpawns;
    private Linea[] lineas;
    private ListaEnemigos[] poolEnemigos;
    private Random random = new Random();
    private boolean finSpawn = false;
    private boolean finNivel = false;
    private VentanaPrincipal ventana;
    
    //Constructor
    public Nivel(String nombre, int numeroLineas, int vidaPuerta, ListaEnemigos[] poolEnemigos, int totalSpawns) {
        ventana = new VentanaPrincipal(numeroLineas);
        ventana.setVisible(true);
        
        this.totalSpawns = totalSpawns;
        this.nombre = nombre;
        this.numeroLineas = numeroLineas;
        this.vidaPuerta = vidaPuerta;
        this.poolEnemigos = poolEnemigos;
        lineas = new Linea[numeroLineas];
        switch(numeroLineas) {
            case 1:
                lineas[0] = new Linea(3,numeroLineas,poolEnemigos,ventana);
                break;
            case 2:
                lineas[0] = new Linea(2,numeroLineas,poolEnemigos,ventana);
                lineas[1] = new Linea(4,numeroLineas,poolEnemigos,ventana);
                break;
            case 3:
                lineas[0] = new Linea(2,numeroLineas,poolEnemigos,ventana);
                lineas[1] = new Linea(3,numeroLineas,poolEnemigos,ventana);
                lineas[2] = new Linea(4,numeroLineas,poolEnemigos,ventana);
                break;
            case 4:
                lineas[0] = new Linea(1,numeroLineas,poolEnemigos,ventana);
                lineas[1] = new Linea(2,numeroLineas,poolEnemigos,ventana);
                lineas[2] = new Linea(4,numeroLineas,poolEnemigos,ventana);
                lineas[3] = new Linea(5,numeroLineas,poolEnemigos,ventana);
                break;
            case 5:
                lineas[0] = new Linea(1,numeroLineas,poolEnemigos,ventana);
                lineas[1] = new Linea(2,numeroLineas,poolEnemigos,ventana);
                lineas[2] = new Linea(3,numeroLineas,poolEnemigos,ventana);
                lineas[3] = new Linea(4,numeroLineas,poolEnemigos,ventana);
                lineas[4] = new Linea(5,numeroLineas,poolEnemigos,ventana);
                break;
        }
        
        this.jugar();
    }
   
    //Metodos
    
    private void jugar() {
    
        Timer contadorTicksMovimiento = new Timer();
        TimerTask accionTicks = new TimerTask() {
            @Override
            public void run() {
               for (Linea l:lineas) {
                   l.moverEnemigos();
               }
            }
            
        };
        contadorTicksMovimiento.schedule(accionTicks, 0, 30);
        
        Timer refrescar = new Timer();
        TimerTask refrescarPos = new TimerTask() {
            @Override
            public void run() {
               for (Linea l:lineas) {
                   l.refrescarPosLineas();
               }
            }
            
        };
        refrescar.schedule(refrescarPos, 100);
        Timer contadorSpawn = new Timer();
        TimerTask spawns = new TimerTask() {
            @Override
            public void run() {
               spawn();
            }
        };
        contadorSpawn.schedule(spawns, 5000, 3000);
    }
    
    private void spawn() {
        if(numeroSpawns < totalSpawns) {
            lineas[random.nextInt(numeroLineas)].spawnearEnemigos();
            numeroSpawns +=1;
        }

    }
   
    //Getters y setters
    public int getVidaPuerta() {
        return vidaPuerta;
    }

    public void setVidaPuerta(int vidaPuerta) {
        this.vidaPuerta = vidaPuerta;
    }

    public Linea[] getLineas() {
        return lineas;
    }

    public void setLineas(Linea[] lineas) {
        this.lineas = lineas;
    }

    public int getNumeroLineas() {
        return numeroLineas;
    }

    public void setNumeroLineas(int numeroLineas) {
        this.numeroLineas = numeroLineas;
    }
    
}
