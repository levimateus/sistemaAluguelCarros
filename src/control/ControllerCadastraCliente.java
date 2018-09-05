/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.DAOCliente;
import model.vo.Cliente;

/**
 *
 * @author RSM
 */
public class ControllerCadastraCliente {
    public void atribuiDadosCliente(
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
            String dataNascAno
    ){
        DAOCliente dao = new DAOCliente();
        Cliente cliente = new Cliente();
        
        String dataNascString = dataNascDia + "/" + dataNascMes + "/" + dataNascAno;
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataNasc = sdf1.parse(dataNascString);
            
            cliente.setClieNm(nome);
            cliente.setClieCPF(cpf);
            cliente.setClieRG(rg);
            cliente.setClieCNH(cnh);
            cliente.setClieEndDs(endereco);
            cliente.setClieCidDs(cidade);
            cliente.setClieUf(uf);
            cliente.setClieTelefoneDDI(ddi);
            cliente.setClieTelefoneDDD(ddd);
            cliente.setClieTelefoneDs(telefone);
            cliente.setClieNascDt(dataNasc);
            
            dao.insereCliente(cliente);
            
        } catch (ParseException ex) {
            Logger.getLogger(ControllerCadastraFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
