/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.DAOFuncionario;
import model.vo.Funcionario;
import static java.lang.Integer.parseInt;

/**
 *
 * @author RSM
 */
public class ControllerCadastraFuncionario {
    public void atribuiDadosFuncionario(
            String matricula,
            String nome,
            String cpf,
            String rg,
            String cnh,
            String endereco,
            String cidade,
            String uf,
            String ddd,
            String ddi,
            String telefone,
            String dataNascDia,
            String dataNascMes,
            String dataNascAno,
            String login,
            String senha
    )
    {
        
        Funcionario funcionario = new Funcionario();
        DAOFuncionario dao      = new DAOFuncionario();
        String data = dataNascDia+"/"+dataNascMes+"/"+dataNascAno;
        
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
        try {
            Date dataNasc= sdf1.parse(data);
            funcionario.setFuncMatrCod(matricula);
            funcionario.setFuncNm(nome);
            funcionario.setFuncCPF(cpf);
            funcionario.setFuncRG(rg);
            funcionario.setFuncCNH(cnh);
            funcionario.setFuncEndDs(endereco);
            funcionario.setFuncCidDs(cidade);
            funcionario.setFuncUf(uf);
            funcionario.setFuncTelefoneDDD(ddd);
            funcionario.setFuncTelefoneDDI(ddi);
            funcionario.setFuncTelefoneDs(telefone);
            funcionario.setFuncNascDt(dataNasc);
            funcionario.setFuncLogin(login);
            funcionario.setFuncSenha(senha);

            dao.insereFuncionario(funcionario);
        } catch (ParseException ex) {
            Logger.getLogger(ControllerCadastraFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    
}
