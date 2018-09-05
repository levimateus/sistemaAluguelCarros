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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.vo.Cliente;

/**
 *
 * @author RSM
 */
public class DAOCliente {
    public void insereCliente(Cliente cliente){
        //Setamos a data atual no cadastro
        cliente.setClieCadDt(new Date());
       
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        //consulta
        String query = "INSERT INTO cliente"
                + "(clie_debito,"
                + "clie_debito_ant,"
                + "clie_cpf,"
                + "clie_rg,"
                + "clie_cnh,"
                + "clie_nasc_dt,"
                + "clie_cad_dt,"
                + "clie_nm,"
                + "clie_end_ds,"
                + "clie_cid_ds,"
                + "clie_uf,"
                + "clie_telefone_ds,"
                + "clie_telefone_ddd,"
                + "clie_telefone_ddi)"
                
                + "VALUES("
                + "?," //clie_debito
                + "?," //clie_debito_ant
                + "?," //clie_cpf
                + "?," //clie_rg
                + "?," //clie_cnh
                + "?," //clie_nasc_dt
                + "?," //clie_cad_dt
                + "?," //clie_nm
                + "?," //clie_end_ds
                + "?," //clie_cid_ds
                + "?," //clie_uf
                + "?," //clie_telefone_ds
                + "?," //clie_telefone_ddd
                + "?)";//clie_telefone_ddi
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //débito atual do cliente
            stmt.setFloat(1, cliente.getClieDebito());
            //débito anterior do cliente
            stmt.setFloat(2, cliente.getClieDebitoAnt());
            //CPF
            stmt.setString(3, cliente.getClieCPF());
            //RG
            stmt.setString(4, cliente.getClieRG());
            //CNH
            stmt.setString(5, cliente.getClieCNH());
            
            //Data de nascimento
            stmt.setString(6, this.converteDataSimples(cliente.getClieNascDt()));
            //Data de cadastro no sistema
            stmt.setString(7, this.converteDataSimples(cliente.getClieCadDt()));
            
            //Nome do cliente
            stmt.setString(8, cliente.getClieNm());
            
            //Endereço do cliente(logradouro e número)
            stmt.setString(9, cliente.getClieEndDs());
            //Cidade do cliente
            stmt.setString(10, cliente.getClieCidDs());
            //UF do cliente
            stmt.setString(11, cliente.getClieUf());
            //Telefone do cliente
            stmt.setString(12, cliente.getClieTelefoneDs());
            //DDD do telefone
            stmt.setString(13, cliente.getClieTelefoneDDD());
            //DDI
            stmt.setString(14, cliente.getClieTelefoneDDI());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public int removeCliente(int cod){
        int nlinhas;
        
        nlinhas = this.consulta(cod);
        if(nlinhas == 0) return 0;
                
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "DELETE FROM cliente WHERE clie_cod = "+cod;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return 1;
    }
    
    public int atualizaDadosCliente(Cliente cliente){
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        //consulta
        int linhas;
        linhas = this.consulta(cliente.getClieCod());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE cliente "
                + "SET "
                + "clie_debito     = ?, "
                + "clie_debito_ant = ?, "
                + "clie_cpf        = ?, "
                + "clie_rg         = ?, "
                + "clie_cnh        = ?, "
                + "clie_nasc_dt    = ?, "
                + "clie_nm         = ?, "
                + "clie_end_ds     = ?, "
                + "clie_cid_ds     = ?, "
                + "clie_uf         = ?, "
                + "clie_telefone_ds    = ?, "
                + "clie_telefone_ddd   = ?, "
                + "clie_telefone_ddi   = ? "
                + "WHERE clie_cod = "+cliente.getClieCod();

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //débito atual do cliente
            stmt.setFloat(1, cliente.getClieDebito());
            //débito anterior do cliente
            stmt.setFloat(2, cliente.getClieDebitoAnt());
            //CPF
            stmt.setString(3, cliente.getClieCPF());
            //RG
            stmt.setString(4, cliente.getClieRG());
            //CNH
            stmt.setString(5, cliente.getClieCNH());
            
            //Data de nascimento
            stmt.setString(6, this.converteDataSimples(cliente.getClieNascDt()));
            
            //Nome do cliente
            stmt.setString(7, cliente.getClieNm());
            
            //Endereço do cliente(logradouro e número)
            stmt.setString(8, cliente.getClieEndDs());
            //Cidade do cliente
            stmt.setString(9, cliente.getClieCidDs());
            //UF do cliente
            stmt.setString(10, cliente.getClieUf());
            //Telefone do cliente
            stmt.setString(11, cliente.getClieTelefoneDs());
            //DDD do telefone
            stmt.setString(12, cliente.getClieTelefoneDDD());
            //DDI
            stmt.setString(13, cliente.getClieTelefoneDDI());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public Cliente consultaCliente(int cod){
        int numLinhas;
        Cliente cliente;
        String query;
        ResultSet resultado;
        
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM cliente WHERE clie_cod = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            
            cliente = new Cliente();
        
            while(resultado.next()){
                cliente.setClieCod(resultado.getInt("clie_cod"));
                cliente.setClieDebito(resultado.getFloat("clie_debito"));
                cliente.setClieDebitoAnt(resultado.getFloat("clie_debito_ant"));
                cliente.setClieCPF(resultado.getString("clie_cpf"));
                cliente.setClieRG(resultado.getString("clie_rg"));
                cliente.setClieCNH(resultado.getString("clie_cnh"));
                cliente.setClieNascDt(resultado.getDate("clie_nasc_dt"));
                cliente.setClieCadDt(resultado.getDate("clie_cad_dt"));
                cliente.setClieNm(resultado.getString("clie_nm"));
                cliente.setClieEndDs(resultado.getString("clie_end_ds"));
                cliente.setClieCidDs(resultado.getString("clie_cid_ds"));
                cliente.setClieUf(resultado.getString("clie_uf"));
                cliente.setClieTelefoneDs(resultado.getString("clie_telefone_ds"));
                cliente.setClieTelefoneDDD(resultado.getString("clie_telefone_ddd"));
                cliente.setClieTelefoneDDI(resultado.getString("clie_telefone_ddi"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
            
        }
        
        return cliente;
    }
    
    public int consultaIDCliente(String cpf, Date dataNasc){
        int codigo;
        
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "SELECT clie_cod "
                        + "FROM cliente "
                        + "WHERE clie_nasc_dt = ?"
                        + "AND   clie_cpf = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, this.converteDataSimples(dataNasc));
            stmt.setString(2, cpf);
            
            ResultSet resultado = stmt.executeQuery();
            
            resultado.next();
            codigo  = resultado.getInt("clie_cod");
            
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return codigo;
    }
    
    public ArrayList listaClientes(){
        ArrayList<Integer>codigos = new ArrayList<Integer>();
        Connection connection = new ConnectionFactory().getConnection();
        String query = "SELECT clie_cod FROM cliente ORDER BY clie_nm";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);         
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                codigos.add(resultado.getInt("clie_cod"));
            }
            stmt.close();
            
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return codigos;
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
        
        String query = "SELECT COUNT(*) FROM cliente AS numRows WHERE clie_cod = ?";
        
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
