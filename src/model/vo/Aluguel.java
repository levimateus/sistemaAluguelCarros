/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.util.Date;

/**
 *
 * @author RSM
 */
public class Aluguel {
    int alugCod;
    
    Date alugDt;
    Date alugDevolPrevdt;
    Date alugDevolDt;
    
    int clieCod;
    int funcCod;
    int carrCod;

    public int getAlugCod() {
        return alugCod;
    }

    public void setAlugCod(int alugCod) {
        this.alugCod = alugCod;
    }

    public Date getAlugDt() {
        return alugDt;
    }

    public void setAlugDt(Date alugDt) {
        this.alugDt = alugDt;
    }

    public Date getAlugDevolPrevdt() {
        return alugDevolPrevdt;
    }

    public void setAlugDevolPrevdt(Date alugDevolPrevdt) {
        this.alugDevolPrevdt = alugDevolPrevdt;
    }

    public Date getAlugDevolDt() {
        return alugDevolDt;
    }

    public void setAlugDevolDt(Date alugDevolDt) {
        this.alugDevolDt = alugDevolDt;
    }

    public int getClieCod() {
        return clieCod;
    }

    public void setClieCod(int clieCod) {
        this.clieCod = clieCod;
    }

    public int getFuncCod() {
        return funcCod;
    }

    public void setFuncCod(int funcCod) {
        this.funcCod = funcCod;
    }

    public int getCarrCod() {
        return carrCod;
    }

    public void setCarrCod(int carrCod) {
        this.carrCod = carrCod;
    }
    
    
}
