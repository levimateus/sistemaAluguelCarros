/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import model.dao.DAOCarro;
import model.dao.DAOTipoCarro;
import model.vo.Carro;

/**
 *
 * @author RSM
 */
public class ControllerCadastraCarro {
    public void associaDadosCarro(
            String uf,
            String cidade,
            String placa,
            String ano,
            String modelo,
            String marca,
            String cor,
            String tipo,
            String valor
    ){
        Carro carro = new Carro();
        DAOCarro dao = new DAOCarro();
        int tipoCarro;
        
        DAOTipoCarro daoTipoCarro = new DAOTipoCarro();
        tipoCarro = daoTipoCarro.consultaTipoCarroID(tipo);
        
        carro.setCarrUf(uf);
        carro.setCarrMunicipio(cidade);
        carro.setCarrPlacaDs(placa);
        carro.setCarrAno(parseInt(ano));
        carro.setCarrModeloDs(modelo);
        carro.setCarrMarca(marca);
        carro.setCarrCor(cor);
        carro.setTpcaCod(tipoCarro);
        carro.setCarrOcupado(false);
        carro.setCarrAluguelVl(parseFloat(valor));
        
        dao.insereCarro(carro);
    }
}
