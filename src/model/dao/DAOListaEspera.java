/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RSM
 */
public class DAOListaEspera {
    public int pegaCarroDisponivel(){
        int n;
        Connection connection = new ConnectionFactory().getConnection();
        String query = "SELECT carr_cod FROM carro WHERE carr_ocupado = false";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet resultado = stmt.executeQuery();
            
            resultado.next();
            n = resultado.getInt("carr_cod");
            
            stmt.close();
            
            return n;
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
    }
    
    public int alugaCarro(){
        int n;
        Connection connection = new ConnectionFactory().getConnection();
        String query = "SELECT carr_cod FROM aluguel ORDER BY alug_devol_prev_dt";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet resultado = stmt.executeQuery();
            
            resultado.next();
            n = resultado.getInt("carr_cod");
            
            stmt.close();
            
            return n;
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
}
