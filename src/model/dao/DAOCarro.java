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
import model.vo.Carro;
import model.vo.TipoCarro;

/**
 *
 * @author RSM
 */
public class DAOCarro {
    
    public void listarCarros(){
        Connection connection = new ConnectionFactory().getConnection();
        int cont = 0;
        int n;
        
        
        String sql = "Select COUNT(*) AS numRows FROM carro";
        
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
        sql = "Select carr_modelo_ds FROM carro";
        String nome[] = new String[n];
        int id[] = new int[n];
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                nome[cont] = resultado.getString("carr_modelo_ds");
                //System.out.println(nome[cont]);
                cont++;
            }
            
        connection.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        connection = new ConnectionFactory().getConnection();
        sql = "Select carr_cod FROM carro";
        
        try{
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            cont = 0;
            while(resultado.next()){
                id[cont] = resultado.getInt("carr_cod");
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
        
        JOptionPane.showMessageDialog(null, "Modelo -> ID\n"+tipos);
    } 
    
    public void insereCarro(Carro carro){
        //Setamos a data atual no cadastro
        carro.setCarrCadastroDt(new Date());
       
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        //consulta
        String query = "INSERT INTO carro"
                + "(carr_aluguel_vl,"
                + "carr_placa_ds,"
                + "carr_municipio_ds,"
                + "carr_uf,"
                + "carr_cor,"
                + "carr_ano,"
                + "carr_modelo_ds,"
                + "carr_marca,"
                + "carr_cadastro_dt,"
                + "tpca_cod,"
                + "carr_ocupado)"
                
                + "VALUES("
                + "?," //carr_aluguel_vl
                + "?," //carr_placa_ds
                + "?," //carr_municipio_ds
                + "?," //carr_uf
                + "?," //carr_cor
                + "?," //carr_ano
                + "?," //carr_modelo_ds
                + "?," //carr_marca
                + "?," //carr_cadastro_dt
                + "?," //tpca_cod
                + "?)";//ocupado
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //carr_aluguel_vl
            stmt.setFloat(1, carro.getCarrAluguelVl());
            //carr_placa_ds
            stmt.setString(2, carro.getCarrPlacaDs());
            //carr_municipio_ds
            stmt.setString(3, carro.getCarrMunicipio());
            //carr_uf
            stmt.setString(4, carro.getCarrUf());
            //carr_cor
            stmt.setString(5, carro.getCarrCor());
            //carr_ano
            stmt.setInt(6, carro.getCarrAno());
            //carr_modelo_ds
            stmt.setString(7, carro.getCarrModeloDs());
            //carr_marca
            stmt.setString(8, carro.getCarrMarca());
            //carr_cadastro_dt
            stmt.setString(9, this.converteDataSimples(carro.getCarrCadastroDt()));
            //tpca_cod
            stmt.setInt(10, carro.getTpcaCod());
            
            //tpca_cod
            stmt.setBoolean(11, carro.isCarrOcupado());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public int removeCarro(int cod){
        int nlinhas;
        
        nlinhas = this.consulta(cod);
        if(nlinhas == 0) return 0;
                
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "DELETE FROM carro WHERE carr_cod = "+cod;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return 1;
    }
    
    public int atualizaDadosCarro(Carro carro){
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        //consulta
        int linhas;
        linhas = this.consulta(carro.getCarrCod());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE carro "
                + "SET "
                + "carr_aluguel_vl   = ?,"
                + "carr_placa_ds     = ?,"
                + "carr_municipio_ds = ?,"
                + "carr_uf           = ?,"
                + "carr_cor          = ?,"
                + "carr_ano          = ?,"
                + "carr_modelo_ds    = ?,"
                + "carr_marca        = ?,"
                + "tpca_cod          = ?,"
                + "carr_ocupado      = ? "
                + "WHERE carr_cod = "+carro.getCarrCod();

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //carr_aluguel_vl
            stmt.setFloat(1, carro.getCarrAluguelVl());
            //carr_placa_ds
            stmt.setString(2, carro.getCarrPlacaDs());
            //carr_municipio_ds
            stmt.setString(3, carro.getCarrMunicipio());
            //carr_uf
            stmt.setString(4, carro.getCarrUf());
            //carr_cor
            stmt.setString(5, carro.getCarrCor());
            //carr_ano
            stmt.setInt(6, carro.getCarrAno());
            //carr_modelo_ds
            stmt.setString(7, carro.getCarrModeloDs());
            //carr_marca
            stmt.setString(8, carro.getCarrMarca());
            //tpca_cod  
            stmt.setInt(9, carro.getTpcaCod());
            //carr_ocupado  
            stmt.setBoolean(10, carro.isCarrOcupado());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public Carro consultaCarro(int cod){
        int numLinhas;
        Carro carro;
        String query;
        ResultSet resultado;
        
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM carro WHERE carr_cod = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            
            carro = new Carro();
        
            while(resultado.next()){
                carro.setCarrCod(resultado.getInt("carr_cod"));
                carro.setCarrAluguelVl(resultado.getFloat("carr_aluguel_vl"));
                carro.setCarrPlacaDs(resultado.getString("carr_placa_ds"));
                carro.setCarrMunicipio(resultado.getString("carr_municipio_ds"));
                carro.setCarrUf(resultado.getString("carr_uf"));
                carro.setCarrCor(resultado.getString("carr_cor"));
                carro.setCarrAno(resultado.getInt("carr_ano"));
                carro.setCarrModeloDs(resultado.getString("carr_modelo_ds"));
                carro.setCarrMarca(resultado.getString("carr_marca"));
                carro.setCarrCadastroDt(resultado.getDate("carr_cadastro_dt"));
                carro.setTpcaCod(resultado.getInt("tpca_cod"));
                carro.setCarrOcupado(resultado.getBoolean("carr_ocupado"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
            
        }
        
        return carro;
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
    
    private int consulta(int cod){
        int linhas;
        ResultSet resultado;
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "SELECT COUNT(*) FROM carro AS numRows WHERE carr_cod = ?";
        
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
}
