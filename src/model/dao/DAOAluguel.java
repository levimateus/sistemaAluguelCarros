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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.vo.Aluguel;

/**
 *
 * @author RSM
 */

/////////////  FALTA TESTAR ////////////////////////////////////

public class DAOAluguel {
    
    public void mostraDadosAluguel(){
        Connection connection = new ConnectionFactory().getConnection();
        int cont = 0;
        int n;
        
        
        String sql = "Select COUNT(*) AS numRows FROM aluguel";
        
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
        sql = "SELECT clie_nm FROM cliente WHERE clie_cod = ANY(SELECT clie_cod FROM aluguel)";
        String nome[] = new String[n];
        int id[] = new int[n];
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                nome[cont] = resultado.getString("clie_nm");
                //System.out.println(nome[cont]);
                cont++;
            }
            
        connection.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        connection = new ConnectionFactory().getConnection();
        sql = "Select alug_cod FROM aluguel";
        
        try{
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            cont = 0;
            while(resultado.next()){
                id[cont] = resultado.getInt("alug_cod");
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
        
        JOptionPane.showMessageDialog(null, "Cliente -> ID do Aluguel\n"+tipos);
    } 
    
    public void insereAluguel(Aluguel aluguel){
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "INSERT INTO aluguel("
                + "alug_dt,"
                + "alug_devol_prev_dt,"
                + "alug_devol_dt,"
                + "clie_cod,"
                + "func_cod,"
                + "carr_cod) "
                + "VALUES("
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?,"
                + "?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, this.converteDataSimples(aluguel.getAlugDt()));
            stmt.setString(2, this.converteDataSimples(aluguel.getAlugDevolPrevdt()));
            stmt.setString(3, this.converteDataSimples(aluguel.getAlugDevolDt()));
            stmt.setInt(4, aluguel.getClieCod());
            stmt.setInt(5, aluguel.getFuncCod());
            stmt.setInt(6, aluguel.getCarrCod());
            stmt.execute();
            stmt.close();
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
    }
    
    public int removeAluguel(int cod){
        int nLinhas;
        nLinhas = this.consulta(cod);
        if(nLinhas == 0) return 0;
        
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "DELETE FROM aluguel WHERE alug_cod = "+cod;
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();

        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
        
    }
    
    public int atualizaDadosAluguel(Aluguel aluguel){
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        //consulta
        int linhas;
        linhas = this.consulta(aluguel.getAlugCod());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE aluguel "
                + "SET "
                + "alug_dt = ?,"
                + "alug_devol_prev_dt = ?,"
                + "alug_devol_dt = ?,"
                + "clie_cod = ?,"
                + "func_cod = ?, "
                + "carr_cod = ? "
                + "WHERE alug_cod = "+aluguel.getAlugCod();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, this.converteDataSimples(aluguel.getAlugDt()));
            stmt.setString(2, this.converteDataSimples(aluguel.getAlugDevolPrevdt()));
            stmt.setString(3, this.converteDataSimples(aluguel.getAlugDevolDt()));
            stmt.setInt(4, aluguel.getClieCod());
            stmt.setInt(5, aluguel.getFuncCod());
            stmt.setInt(6, aluguel.getCarrCod());
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public Aluguel consultaAluguel(int cod){
        int numLinhas;
        Aluguel aluguel;
        String query;
        ResultSet resultado;
        
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM aluguel WHERE alug_cod = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            aluguel = new Aluguel();
            
            while(resultado.next()){
                aluguel.setAlugCod(resultado.getInt("alug_cod"));
                aluguel.setAlugDt(resultado.getDate("alug_dt"));
                aluguel.setAlugDevolPrevdt(resultado.getDate("alug_devol_prev_dt"));
                aluguel.setAlugDevolDt(resultado.getDate("alug_devol_dt"));
                aluguel.setClieCod(resultado.getInt("clie_cod"));   
                aluguel.setFuncCod(resultado.getInt("func_cod"));
                aluguel.setCarrCod(resultado.getInt("carr_cod"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return aluguel;
    }
    
    private int consulta(int cod){
        int linhas;
        ResultSet resultado;
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "SELECT COUNT(*) FROM aluguel AS numRows WHERE alug_cod = ?";
        
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

    private String converteDataHora(Date data){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = format.format(data);
        System.out.println();
        return dataFormatada;
    }
    
    private String converteDataSimples(Date data){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = format.format(data);
        return dataFormatada;
    }
}

