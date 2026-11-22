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
    private boolean finSpawn = false;
    private boolean finNivel = false;
    
    //Constructor
    public Nivel(String nombre, int numeroLineas, int vidaPuerta, ListaEnemigos[] poolEnemigos) {
        VentanaPrincipal v = new VentanaPrincipal(numeroLineas);
        v.setVisible(true);
        v.crearEnemigo(1);
        v.crearEnemigo(2);
        
        
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
        Timer movimiento = new Timer();
        TimerTask spawnear = new TimerTask() {
            @Override
            public void run() {
                lineas[random.nextInt(numeroLineas)].spawnearEnemigos();
            }
            
        };
        TimerTask detenerSpawn = new TimerTask() {
            @Override
            public void run() {
                delaySpawn.cancel();
                finSpawn = true;
            }
        };
        TimerTask moverEnemigos = new TimerTask() {
            @Override
            public void run() {
               for(Linea l:lineas) {
                   l.moverEnemigos();
               }
               if(finSpawn) {
                   detenerNivel(movimiento);
               }
               //MUY temporal luego un metodo separado para los ataques de los defensores
               for(Linea l:lineas) {
                   l.ataqueDefensor();
               }
            } 
        };
        
        delaySpawn.schedule(spawnear, 2000, 5000);
        delaySpawn.schedule(detenerSpawn, 27000);
        delaySpawn.cancel(); //<-----apagado
        movimiento.schedule(moverEnemigos, 2000, 2000);
        movimiento.cancel();
        
    }
    public void detenerNivel(Timer movimiento) {
        int cuentaVacias = 0; 
        for(Linea l:lineas) {
            if (l.getEnemigos().isEmpty()) {
                cuentaVacias++;
                if(cuentaVacias==numeroLineas) {
                    movimiento.cancel();
                    finNivel = true;
                }
            }
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
