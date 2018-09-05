/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.dao.DAOFuncionario;

/**
 *
 * @author RSM
 */
public class ControllerTelaLogin {
    public int atribuiDados(String usuario, String senha){
        DAOFuncionario funcionario = new DAOFuncionario();
        
        int x = funcionario.login(usuario, senha);
        
        return x;
    }
}
