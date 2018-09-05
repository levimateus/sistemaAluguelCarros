/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.vo.TipoCarro;

/**
 *
 * @author RSM
 */
public class DAOTipoCarro {
    public void mostraDadosTipoCarro(){
        Connection connection = new ConnectionFactory().getConnection();
        int cont = 0;
        int n;
        
        
        String sql = "Select COUNT(*) AS numRows FROM tipocarro";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            resultado.next();
            n = resultado.getInt(1);
            
            connection.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        connection = new ConnectionFactory().getConnection();
        sql = "Select tpca_ds FROM tipocarro";
        String nome[] = new String[n];
        int id[] = new int[n];
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                nome[cont] = resultado.getString("tpca_ds");
                //System.out.println(nome[cont]);
                cont++;
            }
            
        connection.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        connection = new ConnectionFactory().getConnection();
        sql = "Select tpca_cod FROM tipocarro";
        
        try{
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            cont = 0;
            while(resultado.next()){
                id[cont] = resultado.getInt("tpca_cod");
                //System.out.println(id[cont]);
                cont++;
            }
            
        connection.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        String tipos = "";
        cont = 0;
        while(cont < n){
            tipos += nome[cont];
            tipos += "  ->  ";
            tipos += id[cont];
            tipos += "\n";
            cont++;
        }
        
        JOptionPane.showMessageDialog(null, "ID -> tipo\n"+tipos);
    } 
    
    public void insereTipoCarro(TipoCarro tipoCarro){
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "INSERT INTO tipoCarro("
                + "tpca_ds) "
                + "VALUES("
                + "?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, tipoCarro.getTpcaDs());
            stmt.execute();
            stmt.close();
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
    }
    
    public int removeTipoCarro(int cod){
        int nLinhas;
        nLinhas = this.consulta(cod);
        if(nLinhas == 0) return 0;
        
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "DELETE FROM tipoCarro WHERE tpca_cod = "+cod;
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();

        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
        
    }
    
    public int atualizaDadosTipoCarro(TipoCarro tipoCarro){
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        //consulta
        int linhas;
        linhas = this.consulta(tipoCarro.getTpcaCod());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE tipoCarro "
                + "SET "
                + "tpca_ds  = ? "
                + "WHERE tpca_cod = "+tipoCarro.getTpcaCod();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, tipoCarro.getTpcaDs());
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public TipoCarro consultaTipoCarro(int cod){
        int numLinhas;
        TipoCarro tipoCarro;
        String query;
        ResultSet resultado;
        
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM tipoCarro WHERE tpca_cod = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            tipoCarro = new TipoCarro();
            
            while(resultado.next()){
                tipoCarro.setTpcaCod(resultado.getInt("tpca_cod"));
                tipoCarro.setTpcaDs(resultado.getString("tpca_ds"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return tipoCarro;
    }

    private int consulta(int cod){
        int linhas;
        ResultSet resultado;
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "SELECT COUNT(*) FROM tipoCarro AS numRows WHERE tpca_cod = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            resultado.next(); //utilizado pois o cursor inicia antes da posição válida
            
            linhas = resultado.getInt(1);
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return linhas;
    }
    
    public ArrayList listarTipos(){
        ResultSet resultado;
        Connection connection = new ConnectionFactory().getConnection();
        String query = "SELECT tpca_ds FROM tipoCarro ORDER BY tpca_ds";
        ArrayList<String> tiposCarro = new ArrayList<String>();
        
        try{
            
            PreparedStatement stmt = connection.prepareStatement(query);
            resultado = stmt.executeQuery();
            
            while(resultado.next()){
                tiposCarro.add(resultado.getString("tpca_ds"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return tiposCarro;
    }
    
    public int consultaTipoCarroID(String tpcaDs){
        int tpcaCod;
        ResultSet resultado;
        Connection connection = new ConnectionFactory().getConnection();
        String query = "SELECT tpca_cod FROM tipoCarro WHERE tpca_ds = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, tpcaDs);
            resultado = stmt.executeQuery();

            resultado.next();
            tpcaCod = resultado.getInt("tpca_cod");
            
            stmt.close();
            
        }catch(SQLException u){
            
            throw new RuntimeException(u);
        }
        return tpcaCod;
    }
}
