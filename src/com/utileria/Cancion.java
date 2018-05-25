/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utileria;
public class Cancion {
    private int num_cancion;
    private String nombre;
    private String artista;
    
   /* public Cancion(String nombre, String artista){
        this.nombre = nombre;
        this.artista = artista;
    }*/
    public Cancion(){}

    public int getNum_cancion() {
        return num_cancion;
    }

    public void setNum_cancion(int num_cancion) {
        this.num_cancion = num_cancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
    
    
}
