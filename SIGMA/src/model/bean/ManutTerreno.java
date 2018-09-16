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
public class ManutTerreno {
    private int idManut_terreno, idTerreno;
    private String defensivo, nome;
    private double qtde_defensivo;
    private Date data;

    public int getIdManut_terreno() {
        return idManut_terreno;
    }

    public void setIdManut_terreno(int idManut_terreno) {
        this.idManut_terreno = idManut_terreno;
    }

    public int getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(int idTerreno) {
        this.idTerreno = idTerreno;
    }

    public String getDefensivo() {
        return defensivo;
    }

    public void setDefensivo(String defensivo) {
        this.defensivo = defensivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQtde_defensivo() {
        return qtde_defensivo;
    }

    public void setQtde_defensivo(double qtde_defensivo) {
        this.qtde_defensivo = qtde_defensivo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
