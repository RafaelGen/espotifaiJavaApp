/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.impl;

import com.dao.ICancionesDao;
import com.utileria.Cancion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelm
 */
public class CancionDaoImpl implements ICancionesDao{
 String cadenaConexion = "jdbc:mysql:"
                        + "//localhost:3306/espotifaiDB?useSSL=false";
 String usuarioDB = "root";
 String passDB = "mysqlroot";
 Connection conexion;
 
 public CancionDaoImpl(){}

 private void conexion(){
            try{
              conexion = DriverManager.getConnection(cadenaConexion,usuarioDB,passDB);
            }catch(SQLException ex){
                ex.printStackTrace();
            }
    }
 
 private void cerrar() throws SQLException{
     conexion.close();
 }
    
    @Override
    public boolean create(Cancion entidad) throws SQLException {
        conexion();
        String insertCancion = "INSERT INTO canciones  "
                + "(nombre,artista) VALUES (? , ?)";
        PreparedStatement stm = conexion.prepareStatement(insertCancion);
        stm.setString(1, entidad.getNombre());
        stm.setString(2, entidad.getArtista());
        boolean ejecutado = stm.executeUpdate() > 0;
        stm.close();
        cerrar();
        return ejecutado;
    }

    @Override
    public List<Cancion> read() throws SQLException {
        List<Cancion> cancionesLista = new ArrayList<>(); 
        String leerQuery = "SELECT * FROM canciones";
        
        
        conexion();
        Statement sentencia = conexion.createStatement();
        ResultSet resultado = sentencia.executeQuery(leerQuery);
        while(resultado.next()){
            Cancion cancion = new Cancion();
           cancion.setNum_cancion(resultado.getInt(1));
           cancion.setNombre(resultado.getString(2));
           cancion.setArtista(resultado.getString(3));
           cancionesLista.add(cancion);
        }
        resultado.close();
        sentencia.close();
        cerrar();
        return cancionesLista;
    }

    @Override
    public boolean update(Cancion entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int num_cancion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
