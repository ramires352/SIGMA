/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;


/**
 *
 * @author ramir
 */
public class Manutencao {
    private int idManutencao, idItem, horas_dur, idMaquina;
    private String marca;
    private double preco;
    private Date dia;
    private static int chaveID;

    public static int getChaveID() {
        return chaveID;
    }

    public static void setChaveID(int chaveID) {
        Manutencao.chaveID = chaveID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(int idManutencao) {
        this.idManutencao = idManutencao;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getHoras_dur() {
        return horas_dur;
    }

    public void setHoras_dur(int horas_dur) {
        this.horas_dur = horas_dur;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    
}


