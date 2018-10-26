/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author ramires
 */
public class Plantio {
    
    private int idPlantio, idTerreno;
    private Date data;
    private String sementes, cultura, nomeTerreno;

    public String getNomeTerreno() {
        return nomeTerreno;
    }

    public void setNomeTerreno(String nomeTerreno) {
        this.nomeTerreno = nomeTerreno;
    }
    private double qtde_sementes;

    public int getIdPlantio() {
        return idPlantio;
    }

    public void setIdPlantio(int idPlantio) {
        this.idPlantio = idPlantio;
    }

    public int getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(int idTerreno) {
        this.idTerreno = idTerreno;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSementes() {
        return sementes;
    }

    public void setSementes(String sementes) {
        this.sementes = sementes;
    }

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    public double getQtde_sementes() {
        return qtde_sementes;
    }

    public void setQtde_sementes(double qtde_sementes) {
        this.qtde_sementes = qtde_sementes;
    }
    
    
    
    
}
