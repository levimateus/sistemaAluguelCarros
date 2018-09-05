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
import model.dao.DAOFuncionario;
import model.vo.Funcionario;

/**
 *
 * @author RSM
 */
public class ControllerMostruarioFuncionario {
    public void atribuiDadosAlterar(
            String id,
            String nome,
            String cpf,
            String rg,
            String cnh,
            String endereco,
            String cidade,
            String uf,
            String ddi,
            String ddd,
            String telefone,
            String dataNascDia,
            String dataNascMes,
            String dataNascAno,
            String matricula,
            String senha,
            String login
    ){
        int codigo = parseInt(id);
        
        int dia = parseInt(dataNascDia);
        int mes = parseInt(dataNascMes);
        int ano = parseInt(dataNascAno);
        
        Funcionario funcionario = new Funcionario();
        DAOFuncionario dao = new DAOFuncionario();
        String data = dataNascDia+"/"+(mes+1)+"/"+dataNascAno;
        
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
        Date dataNasc;
        try {
            dataNasc = sdf1.parse(data);
            funcionario.setFuncCod(codigo);
            funcionario.setFuncNm(nome);
            funcionario.setFuncCPF(cpf);
            funcionario.setFuncRG(rg);
            funcionario.setFuncCNH(cnh);
            funcionario.setFuncEndDs(endereco);
            funcionario.setFuncCidDs(cidade);
            funcionario.setFuncUf(uf);
            funcionario.setFuncTelefoneDDI(ddi);
            funcionario.setFuncTelefoneDDD(ddd);
            funcionario.setFuncTelefoneDs(telefone);
            funcionario.setFuncNascDt(dataNasc);
            funcionario.setFuncMatrCod(matricula);
            funcionario.setFuncSenha(senha);
            funcionario.setFuncLogin(login);

            dao.atualizaDadosFuncionario(funcionario);
        } catch (ParseException ex) {
            Logger.getLogger(ControllerMostruarioFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
