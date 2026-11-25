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
    private int posXLinea;
    private ListaEnemigos[] poolEnemigos;
    private Random random = new Random();
    private List<Enemigo> enemigos = new CopyOnWriteArrayList<>();
    private VentanaPrincipal ventana;
    
    //constructor
    public Linea(int numeroIndividual, int numeroTotal, ListaEnemigos[] poolEnemigos,VentanaPrincipal ventana) {
        this.numeroIndividual = numeroIndividual;
        this.numeroTotal = numeroTotal;
        this.poolEnemigos = poolEnemigos;
        this.ventana = ventana;
    }
    
    //Metodos 
    public void refrescarPosLineas() {
        posXLinea = ventana.getXLineas();
    }
    public void spawnearEnemigos() {
        ListaEnemigos enemigoSeleccionado = poolEnemigos[random.nextInt(poolEnemigos.length)];
        ids++;
        switch(enemigoSeleccionado) {
            case ANTIDISTURBIOS:
                enemigos.add(new Antidisturbios(numeroIndividual,posXLinea,ids,ventana));
                System.out.println("Spawn Antidisturbios, linea "+numeroIndividual);
                ventana.crearEnemigo(numeroIndividual,ids);
                break;
            case ANTIDISTURBIOSESCUDO:
                enemigos.add(new AntidisturbiosEscudo(numeroIndividual,posXLinea,ids,ventana));
                System.out.println("Spawn Antidisturbios escudo, linea "+numeroIndividual);
                ventana.crearEnemigo(numeroIndividual,ids);
                break;
            case ANTIDISTURBIOSGAS:
                enemigos.add(new AntidisturbiosGas(numeroIndividual,posXLinea,ids,ventana));
                System.out.println("Spawn Antidisturbios gas, linea "+numeroIndividual);
                ventana.crearEnemigo(numeroIndividual,ids);
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
    public void eliminarEnemigo(int id) {
        for(Enemigo e:enemigos) {
            if(e.getId()==id) {
                enemigos.remove(e);
                System.out.println("Enemigo abajo id:"+e.getId()+", dist:"+e.getPosX());
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
