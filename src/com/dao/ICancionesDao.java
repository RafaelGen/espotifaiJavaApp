/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.utileria.Cancion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rafaelm
 */
public interface ICancionesDao {
    boolean create(Cancion entidad) throws SQLException ;
    List<Cancion> read();
    boolean update(Cancion entidad);
    boolean delete(int num_cancion);

}
