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
import model.vo.Funcionario;

/**
 *
 * @author RSM
 */
public class DAOFuncionario {
    public int login(String login, String senha){
        int n;
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "SELECT COUNT(*) FROM funcionario AS numRows"
                + " WHERE func_login = ? AND func_senha = ?";
        
        try{
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, login);
        stmt.setString(2, senha);
        
        ResultSet resultado = stmt.executeQuery();
        resultado.next();
        
        n = resultado.getInt(1);
        
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return n;
    }
    
    public void insereFuncionario(Funcionario funcionario){
        //Setamos a data atual no cadastro
        funcionario.setFuncCadDt(new Date());
       
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        //consulta
        String query = "INSERT INTO funcionario"
                + "(func_matr_cod,"
                + "func_cpf,"
                + "func_rg,"
                + "func_cnh,"
                + "func_nasc_dt,"
                + "func_cad_dt,"
                + "func_nm,"
                + "func_end_ds,"
                + "func_cid_ds,"
                + "func_uf,"
                + "func_telefone_ds,"
                + "func_telefone_ddd,"
                + "func_telefone_ddi,"
                + "func_login,"
                + "func_senha)"
                
                + "VALUES("
                + "?," //func_matr_cod
                + "?," //func_cpf
                + "?," //func_rg
                + "?," //func_cnh
                + "?," //func_nasc_dt
                + "?," //func_cad_dt
                + "?," //func_nm
                + "?," //func_end_ds
                + "?," //func_cid_ds
                + "?," //func_uf
                + "?," //func_telefone_ds
                + "?," //func_telefone_ddd
                + "?," //func_telefone_ddi
                + "?," //func_login
                + "?)";//func_senha
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //mátricula do funcionário
            stmt.setString(1, funcionario.getFuncMatrCod());
            //CPF
            stmt.setString(2, funcionario.getFuncCPF());
            //RG
            stmt.setString(3, funcionario.getFuncRG());
            //CNH
            stmt.setString(4, funcionario.getFuncCNH());
            
            //Data de nascimento
            stmt.setString(5, this.converteDataSimples(funcionario.getFuncNascDt()));
            //Data de cadastro no sistema
            stmt.setString(6, this.converteDataSimples(funcionario.getFuncCadDt()));
            
            //Nome do funcionario
            stmt.setString(7, funcionario.getFuncNm());
            
            //Endereço do funcionario(logradouro e número)
            stmt.setString(8, funcionario.getFuncEndDs());
            //Cidade do funcionario
            stmt.setString(9, funcionario.getFuncCidDs());
            //UF do funcionario
            stmt.setString(10, funcionario.getFuncUf());
            //Telefone do funcionario
            stmt.setString(11, funcionario.getFuncTelefoneDs());
            //DDD do telefone
            stmt.setString(12, funcionario.getFuncTelefoneDDD());
            //DDI
            stmt.setString(13, funcionario.getFuncTelefoneDDI());
            //Login
            stmt.setString(14, funcionario.getFuncLogin());
            //Senha
            stmt.setString(15, funcionario.getFuncSenha());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public int removeFuncionario(int cod){
        int numLinhas;
        
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        numLinhas = this.consulta(cod);
        System.out.println(numLinhas);
        if(numLinhas == 0){
            return 0;
        } 
        
        String query = "DELETE FROM funcionario WHERE func_cod = "+cod;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public int atualizaDadosFuncionario(Funcionario funcionario){
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        //consulta
        int linhas;
        linhas = this.consulta(funcionario.getFuncCod());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE funcionario "
                + "SET "
                + "func_matr_cod   = ?, "
                + "func_cpf        = ?, "
                + "func_rg         = ?, "
                + "func_cnh        = ?, "
                + "func_nasc_dt    = ?, "
                + "func_nm         = ?, "
                + "func_end_ds     = ?, "
                + "func_cid_ds     = ?, "
                + "func_uf         = ?, "
                + "func_telefone_ds    = ?, "
                + "func_telefone_ddd   = ?, "
                + "func_telefone_ddi   = ?, "
                + "func_login   = ?, "
                + "func_senha   = ? "
                + "WHERE func_cod = "+funcionario.getFuncCod();

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //número de matrícula
            stmt.setString(1, funcionario.getFuncMatrCod());
            //CPF
            stmt.setString(2, funcionario.getFuncCPF());
            //RG
            stmt.setString(3, funcionario.getFuncRG());
            //CNH
            stmt.setString(4, funcionario.getFuncCNH());
            
            //Data de nascimento
            stmt.setString(5, this.converteDataSimples(funcionario.getFuncNascDt()));
            
            //Nome do funcionario
            stmt.setString(6, funcionario.getFuncNm());
            
            //Endereço do funcionario(logradouro e número)
            stmt.setString(7, funcionario.getFuncEndDs());
            //Cidade do funcionario
            stmt.setString(8, funcionario.getFuncCidDs());
            //UF do funcionario
            stmt.setString(9, funcionario.getFuncUf());
            //Telefone do funcionario
            stmt.setString(10, funcionario.getFuncTelefoneDs());
            //DDD do telefone
            stmt.setString(11, funcionario.getFuncTelefoneDDD());
            //DDI
            stmt.setString(12, funcionario.getFuncTelefoneDDI());
            //DDD do telefone
            stmt.setString(13, funcionario.getFuncLogin());
            //DDI
            stmt.setString(14, funcionario.getFuncSenha());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public Funcionario consultaFuncionario(int cod){
        int numLinhas;
        Funcionario funcionario;
        String query;
        ResultSet resultado;
        
        //nova conexão
        Connection connection = new ConnectionFactory().getConnection();
        
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM funcionario WHERE func_cod = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            
            funcionario = new Funcionario();
        
            while(resultado.next()){
                funcionario.setFuncCod(resultado.getInt("func_cod"));
                funcionario.setFuncMatrCod(resultado.getString("func_matr_cod"));
                funcionario.setFuncCPF(resultado.getString("func_cpf"));
                funcionario.setFuncRG(resultado.getString("func_rg"));
                funcionario.setFuncCNH(resultado.getString("func_cnh"));
                funcionario.setFuncNascDt(resultado.getDate("func_nasc_dt"));
                funcionario.setFuncCadDt(resultado.getDate("func_cad_dt"));
                funcionario.setFuncNm(resultado.getString("func_nm"));
                funcionario.setFuncEndDs(resultado.getString("func_end_ds"));
                funcionario.setFuncCidDs(resultado.getString("func_cid_ds"));
                funcionario.setFuncUf(resultado.getString("func_uf"));
                funcionario.setFuncTelefoneDs(resultado.getString("func_telefone_ds"));
                funcionario.setFuncTelefoneDDD(resultado.getString("func_telefone_ddd"));
                funcionario.setFuncTelefoneDDI(resultado.getString("func_telefone_ddi"));
                funcionario.setFuncLogin(resultado.getString("func_login"));
                funcionario.setFuncSenha(resultado.getString("func_senha"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return funcionario;
    }
    
    public int consultaIDFuncionario(Funcionario funcionario){
        int codigo;
        
        Connection connection = new ConnectionFactory().getConnection();
        
        String query = "SELECT func_cod "
                        + "FROM funcionario "
                        + "WHERE func_login = ?"
                        + "AND   func_senha = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, funcionario.getFuncLogin());
            stmt.setString(2, funcionario.getFuncSenha());
            
            ResultSet resultado = stmt.executeQuery();
            
            resultado.next();
            codigo  = resultado.getInt("func_cod");
            
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return codigo;
    }
    
    public ArrayList listaFuncionarios(){
        ArrayList<Integer>codigos = new ArrayList<Integer>();
        Connection connection = new ConnectionFactory().getConnection();
        String query = "SELECT func_cod FROM funcionario ORDER BY func_nm";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);         
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                codigos.add(resultado.getInt("func_cod"));
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
        
        String query = "SELECT COUNT(*) FROM funcionario AS numRows WHERE func_cod = ?";
        
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
