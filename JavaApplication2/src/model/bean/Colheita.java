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
public class Colheita {
    private int idColheita, idTerreno;
    private Date data;
    private double qtde;
    private String nomeTerreno, cultura;

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    public int getIdColheita() {
        return idColheita;
    }

    public void setIdColheita(int idColheita) {
        this.idColheita = idColheita;
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

    public double getQtde() {
        return qtde;
    }

    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    public String getNomeTerreno() {
        return nomeTerreno;
    }

    public void setNomeTerreno(String nomeTerreno) {
        this.nomeTerreno = nomeTerreno;
    }
    
    
    
    
}
