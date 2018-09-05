/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author RSM
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/alugacarros","root","");
        }catch(SQLException excecao){
            JOptionPane.showMessageDialog(null, "Erro no banco de dados:\n"+excecao);
            throw new RuntimeException(excecao);
        }
    }
    
   /*public static void main(String[] args){
        ResultSet resultado;
        String mensagem;
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "CREATE TABLE IF NOT EXISTS teste(mensagem varchar(10))";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        query = "INSERT INTO teste(mensagem) VALUES('Funcionou')";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        query = "SELECT * FROM teste";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            resultado = stmt.executeQuery();
            while(resultado.next()){
                mensagem = resultado.getString("mensagem");
                
                JOptionPane.showMessageDialog(null, mensagem);
            }
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        query = "DROP TABLE teste";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
    }
    /*public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection(
          "jdbc:mysql://localhost/alugacarros", "root", "");
        System.out.println("Conectado!");
        conexao.close();
    }*/
}

