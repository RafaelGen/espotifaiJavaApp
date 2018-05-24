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
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rafaelm
 */
public class CancionDaoImpl implements ICancionesDao{
 String cadenaConexion = "jdbc:mysql:"
                        + "//localhost:3306/espotifyDB?useSSL=false";
 String usuarioDB = "root";
 String passDB = "mysqlroot";
 Connection conexion;

 private void conexion(){
            try{
              conexion = DriverManager.getConnection(cadenaConexion,usuarioDB,passDB);
            }catch(SQLException ex){
                ex.printStackTrace();
            }
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
        return ejecutado;
    }

    @Override
    public List<Cancion> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
