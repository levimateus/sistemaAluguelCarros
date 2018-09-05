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
import model.dao.DAOCliente;
import model.vo.Cliente;

/**
 *
 * @author RSM
 */
public class ControllerMostruarioCliente {
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
            String dataNascAno
    ){
        int codigo = parseInt(id);
        
        int dia = parseInt(dataNascDia);
        int mes = parseInt(dataNascMes);
        int ano = parseInt(dataNascAno);
        
        Cliente cliente = new Cliente();
        DAOCliente dao = new DAOCliente();
        String data = dataNascDia+"/"+(mes+1)+"/"+dataNascAno;
        
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
        Date dataNasc;
        
        try {
            dataNasc = sdf1.parse(data);
            cliente.setClieCod(codigo);
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

            dao.atualizaDadosCliente(cliente);
        } catch (ParseException ex) {
            Logger.getLogger(ControllerMostruarioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
