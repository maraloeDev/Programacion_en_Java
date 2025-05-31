package com.examen.martin_sonseca_eduardo.problema3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que gestiona las operaciones con la base de datos
 *
 * @author macarena
 */
public class GestorBD {

    public static Connection conn = null;
    public static String urlBD = "jdbc:mysql://localhost:3306/encuestas";

    /**
     * Obtiene la conexion a la base de datos
     *
     * @return Connection
     */
    public static Connection getConnection() {

        if (conn != null) {
            finalizarConexion();
        }
        try {            
            conn = (Connection) DriverManager.getConnection(urlBD, "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return conn;
    }

    /**
     * Cierra la conexion con la base de datos si esta abierta y hace un commit
     * si procede.
     */
    public static void finalizarConexion() {
        if (conn != null) {
            try {            
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }       
    }

    /**
     * Devuelve un Resultset con el resultado de la consulta:
     * nº de filas que cumplen la codición del WHERE
     * 
     * @return ResultSet
     */
    public static ResultSet consulta() {
        Connection con = null;
        ResultSet rs = null;
        try {
            con = GestorBD.getConnection();            
            String sql="SELECT * FROM respuestas";
            PreparedStatement pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            whi
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return rs;
    }    
   

    /**
     * Devuelve el numero de filas insertadas
     *
     * @return Int
     */
    public static Integer insertarY() {
        Connection con = null;
        int resultado = -1;
        try {
            con = GestorBD.getConnection();
            String sql="INSERT INTO respuestas (y) VALUES (1)";
            PreparedStatement ps = con.prepareStatement(sql);
            //...                 
            resultado = ps.executeUpdate();            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            finalizarConexion();
        }
        return resultado;
    }
    
     /**
     * Devuelve el numero de filas insertadas
     *
     * @return Int
     */
    public static Integer insertarN() {
        Connection con = null;
        int resultado = -1;
        try {
            con = GestorBD.getConnection();
            String sql="INSERT INTO respuestas (n) VALUES (1)";
            PreparedStatement ps = con.prepareStatement(sql);
            //...                 
            resultado = ps.executeUpdate();            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            finalizarConexion();
        }
        return resultado;
    }

     /**
     * Devuelve el numero de filas insertadas
     *
     * @return Int
     */
    public static Integer insertarNS() {
        Connection con = null;
        int resultado = -1;
        try {
            con = GestorBD.getConnection();
            String sql="INSERT INTO respuestas (ns) VALUES (1)";
            PreparedStatement ps = con.prepareStatement(sql);
            //...                 
            resultado = ps.executeUpdate();            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            finalizarConexion();
        }
        return resultado;
    }

}
