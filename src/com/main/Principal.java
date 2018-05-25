/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.dao.impl.CancionDaoImpl;
import com.utileria.Cancion;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rafaelm
 */
public class Principal {
    public static void main(String[] args) throws SQLException{
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("Ingresa la opcion que desees");
            System.out.println("1 -> Crear nueva cancion");
            System.out.println("2 -> Mostrar canciones");
            System.out.println("3 -> Actualiar cancion");
            System.out.println("4 -> Eliminar cancion");
            System.out.println("5 -> Salir");
            int opcion = scan.nextInt();
            flag = eleccion(opcion);
        }
        System.out.println("Gracias por participar, lo esperamos pronto");
    }

    private static boolean eleccion(int opcion) throws SQLException {
        //objetos
        Scanner scan = new Scanner(System.in);
        Cancion cancion = new Cancion();
        CancionDaoImpl cancionDao = new CancionDaoImpl();
        
        //Variables
        boolean flag = true;

        switch(opcion){
            case 1:
                System.out.println("Ingresa el nombre de la canción");
                String nombre_cancion = scan.nextLine();
                System.out.println("Ingresa el nombre del artista");
                String nombre_artista = scan.nextLine();
                //Settear nombre y artista a mi objeto tipo Cancion
                cancion.setNombre(nombre_cancion);
                cancion.setArtista(nombre_artista);
                //Retorno del método
               
                boolean resultado = cancionDao.create(cancion);
                
               if(resultado)
                   System.out.println("Se ingresó correctamente");
               
               else
                   System.out.println("No se arma :C");
                break;
            case 2: 
                List<Cancion> cancionesLista = cancionDao.read();
                for(Cancion i : cancionesLista){
                    System.out.println("Id: " + i.getNum_cancion());
                    System.out.println(" Nombre de cancion: " + i.getNombre());
                    System.out.println(" Artista: " + i.getArtista());
                }
                break; 
            case 3: 
                
                break;
            case 4: break;
            case 5: 
                flag = false;
                break;
        }
        
        return flag;
    }
}
