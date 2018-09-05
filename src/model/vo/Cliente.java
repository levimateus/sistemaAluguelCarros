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
public class Cliente {
    int clieCod;
    
    float clieDebito;
    float clieDebitoAnt;
    
    String clieCPF;
    String clieRG;
    String clieCNH;
    
    Date clieNascDt;
    Date clieCadDt;
    
    String clieNm;
    
    String clieEndDs;
    String clieCidDs;
    String clieUf;
    String clieTelefoneDs;
    String clieTelefoneDDD;
    String clieTelefoneDDI;

    public int getClieCod() {
        return clieCod;
    }

    public void setClieCod(int clieCod) {
        this.clieCod = clieCod;
    }

    public String getClieNm() {
        return clieNm;
    }

    public void setClieNm(String clieNm) {
        this.clieNm = clieNm;
    }

    public String getClieCPF() {
        return clieCPF;
    }

    public void setClieCPF(String clieCPF) {
        this.clieCPF = clieCPF;
    }

    public String getClieRG() {
        return clieRG;
    }

    public void setClieRG(String clieRG) {
        this.clieRG = clieRG;
    }

    public String getClieCNH() {
        return clieCNH;
    }

    public void setClieCNH(String clieCNH) {
        this.clieCNH = clieCNH;
    }

    public float getClieDebito() {
        return clieDebito;
    }

    public void setClieDebito(float clieDebito) {
        this.clieDebito = clieDebito;
    }

    public float getClieDebitoAnt() {
        return clieDebitoAnt;
    }

    public void setClieDebitoAnt(float clieDebitoAnt) {
        this.clieDebitoAnt = clieDebitoAnt;
    }

    public Date getClieNascDt() {
        return clieNascDt;
    }

    public void setClieNascDt(Date clieNascDt) {
        this.clieNascDt = clieNascDt;
    }

    public Date getClieCadDt() {
        return clieCadDt;
    }

    public void setClieCadDt(Date clieCadDt) {
        this.clieCadDt = clieCadDt;
    }

    public String getClieEndDs() {
        return clieEndDs;
    }

    public void setClieEndDs(String clieEndDs) {
        this.clieEndDs = clieEndDs;
    }

    public String getClieCidDs() {
        return clieCidDs;
    }

    public void setClieCidDs(String clieCidDs) {
        this.clieCidDs = clieCidDs;
    }

    public String getClieUf() {
        return clieUf;
    }

    public void setClieUf(String clieUf) {
        this.clieUf = clieUf;
    }

    public String getClieTelefoneDs() {
        return clieTelefoneDs;
    }

    public void setClieTelefoneDs(String clieTelefoneDs) {
        this.clieTelefoneDs = clieTelefoneDs;
    }

    public String getClieTelefoneDDD() {
        return clieTelefoneDDD;
    }

    public void setClieTelefoneDDD(String clieTelefoneDDD) {
        this.clieTelefoneDDD = clieTelefoneDDD;
    }

    public String getClieTelefoneDDI() {
        return clieTelefoneDDI;
    }

    public void setClieTelefoneDDI(String clieTelefoneDDI) {
        this.clieTelefoneDDI = clieTelefoneDDI;
    }
    
}
