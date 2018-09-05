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
import model.dao.DAOAluguel;
import model.dao.DAOCliente;
import model.vo.Aluguel;
import model.vo.Cliente;

/**
 *
 * @author RSM
 */
public class ControllerCreservar {
    public void atribuiDadosAluguel(
            String dataInicioDia,
            String dataInicioMes,
            String dataInicioAno,
            String dataFinalDia,
            String dataFinalMes,
            String dataFinalAno,
            String clieCod,
            String carrCod
    ){
        DAOAluguel dao = new DAOAluguel();
        Aluguel aluguel = new Aluguel();
        
        String dataInicioStr = dataInicioDia+"/"+dataInicioMes+"/"+dataInicioAno;
        String dataFinalStr  = dataFinalDia+"/"+dataFinalMes+"/"+dataFinalAno;
        
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
        SimpleDateFormat sdf2= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
        Date dataInicio;
        Date dataFinal;
        try {
            dataInicio = sdf1.parse(dataInicioStr);
            dataFinal = sdf2.parse(dataFinalStr);
            
            aluguel.setAlugDt(dataInicio);
            aluguel.setAlugDevolPrevdt(dataFinal);
            aluguel.setCarrCod(parseInt(carrCod));
            aluguel.setClieCod(parseInt(clieCod));
            
            dao.insereAluguel(aluguel);
            
        } catch (ParseException ex) {
            Logger.getLogger(ControllerCreservar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
    public int consultaCliente(String cpf, String dia, String mes, String ano){
        int clieCod;
        
        DAOCliente dao = new DAOCliente();
        Cliente cliente = new Cliente();
        int intmes = parseInt(mes);
        
        String data  = dia+"/"+(intmes+1)+"/"+ano;
        
        Date dataNasc;
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
        try {
            dataNasc = sdf1.parse(data);
            clieCod = dao.consultaIDCliente(cpf, dataNasc);
            return clieCod;
            
        } catch (ParseException ex) {
            Logger.getLogger(ControllerCreservar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    
}
