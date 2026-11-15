/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 *
 * @author juand
 */
public class Linea {
    //Atributos
    private static int ids = 0;
    private int numeroIndividual;
    private int numeroTotal;
    private int posY;
    private ListaEnemigos[] poolEnemigos;
    private Random random = new Random();
    private List<Enemigo> enemigos = new CopyOnWriteArrayList<>();
    
    //constructor
    public Linea(int numeroIndividual, int numeroTotal, ListaEnemigos[] poolEnemigos) {
        this.numeroIndividual = numeroIndividual;
        this.numeroTotal = numeroTotal;
        this.poolEnemigos = poolEnemigos;
    }
    
    //Metodos 
    public void spawnearEnemigos() {
        ListaEnemigos enemigoSeleccionado = poolEnemigos[random.nextInt(poolEnemigos.length)];
        ids++;
        switch(enemigoSeleccionado) {
            case ANTIDISTURBIOS:
                enemigos.add(new Antidisturbios(numeroIndividual,0,ids));
                System.out.println("Spawn Antidisturbios, linea "+numeroIndividual);
                break;
            case ANTIDISTURBIOSESCUDO:
                enemigos.add(new AntidisturbiosEscudo(numeroIndividual,0,ids));
                System.out.println("Spawn Antidisturbios escudo, linea "+numeroIndividual);
                break;
            case ANTIDISTURBIOSGAS:
                enemigos.add(new AntidisturbiosGas(numeroIndividual,0,ids));
                System.out.println("Spawn Antidisturbios gas, linea "+numeroIndividual);
                break;
        }
    }
    public void moverEnemigos() {
        for(Enemigo e:enemigos) {
            e.moverse();
        }
    }
    public void ataqueDefensor() {
        //COMPLETAMENTE PARA TESTEAR SE CAMBIA SI O SI
        synchronized (enemigos) {
        int pos = 0;
        for(Enemigo e:enemigos) {
            int posPrimero = e.posX;
            if (e.getPosX()>posPrimero) {
                posPrimero = e.posX;
            }
            pos = posPrimero;
        }
        for(Enemigo e:enemigos) {
            if (e.getPosX()==pos) {
                if(e.perderVida(20)) {
                    eliminarEnemigo(e.getId());
                }
            }
        }
        }
    }
    public void eliminarEnemigo(int id) {
        synchronized (enemigos) {
        for(Enemigo e:enemigos) {
            if(e.getId()==id) {
                enemigos.remove(e);
                System.out.println("Enemigo abajo id:"+e.getId()+", dist:"+e.getPosX());
            }
        }
        }
    }
    
    //Getters y Setters

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(List<Enemigo> enemigos) {
        this.enemigos = enemigos;
    }

    
    
    
}
