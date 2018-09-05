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
public class Carro {
    int carrCod;
    float carrAluguelVl;
    String carrPlacaDs;
    String carrMunicipio;
    String carrUf;
    String carrCor;
    int    carrAno;
    String carrModeloDs;
    String carrMarca;
    Date   carrCadastroDt;
    int    tpcaCod;
    boolean carrOcupado;

    public boolean isCarrOcupado() {
        return carrOcupado;
    }

    public void setCarrOcupado(boolean carrOcupado) {
        this.carrOcupado = carrOcupado;
    }
    
    public int getCarrCod() {
        return carrCod;
    }

    public void setCarrCod(int carrCod) {
        this.carrCod = carrCod;
    }

    public float getCarrAluguelVl() {
        return carrAluguelVl;
    }

    public void setCarrAluguelVl(float carrAluguelVl) {
        this.carrAluguelVl = carrAluguelVl;
    }

    public String getCarrPlacaDs() {
        return carrPlacaDs;
    }

    public void setCarrPlacaDs(String carrPlacaDs) {
        this.carrPlacaDs = carrPlacaDs;
    }

    public String getCarrMunicipio() {
        return carrMunicipio;
    }

    public void setCarrMunicipio(String carrMunicipio) {
        this.carrMunicipio = carrMunicipio;
    }

    public String getCarrUf() {
        return carrUf;
    }

    public void setCarrUf(String carrUf) {
        this.carrUf = carrUf;
    }

    public String getCarrCor() {
        return carrCor;
    }

    public void setCarrCor(String carrCor) {
        this.carrCor = carrCor;
    }

    public int getCarrAno() {
        return carrAno;
    }

    public void setCarrAno(int carrAno) {
        this.carrAno = carrAno;
    }

    public String getCarrModeloDs() {
        return carrModeloDs;
    }

    public void setCarrModeloDs(String carrModeloDs) {
        this.carrModeloDs = carrModeloDs;
    }

    public String getCarrMarca() {
        return carrMarca;
    }

    public void setCarrMarca(String carrMarca) {
        this.carrMarca = carrMarca;
    }

    public Date getCarrCadastroDt() {
        return carrCadastroDt;
    }

    public void setCarrCadastroDt(Date carrCadastroDt) {
        this.carrCadastroDt = carrCadastroDt;
    }

    public int getTpcaCod() {
        return tpcaCod;
    }

    public void setTpcaCod(int tpcaCod) {
        this.tpcaCod = tpcaCod;
    }
}
