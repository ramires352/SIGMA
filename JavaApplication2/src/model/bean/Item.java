package model.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Item {
    private String nome, marca;
    private int horas_dur, horas_trab, idMaquina, idItem;
    private double preco;
    private static int chave, chaveHD;
    private static double chavePreco;
    private static String chaveMarca;

    public static int getChaveHD() {
        return chaveHD;
    }

    public static void setChaveHD(int chaveHD) {
        Item.chaveHD = chaveHD;
    }

    public static double getChavePreco() {
        return chavePreco;
    }

    public static void setChavePreco(double chavePreco) {
        Item.chavePreco = chavePreco;
    }

    public static String getChaveMarca() {
        return chaveMarca;
    }

    public static void setChaveMarca(String chaveMarca) {
        Item.chaveMarca = chaveMarca;
    }

    public static int getChave() {
        return chave;
    }

    public static void setChave(int chave) {
        Item.chave = chave;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getHoras_dur() {
        return horas_dur;
    }

    public void setHoras_dur(int horas_dur) {
        this.horas_dur = horas_dur;
    }

    public int getHoras_trab() {
        return horas_trab;
    }

    public void setHoras_trab(int horas_trab) {
        this.horas_trab = horas_trab;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
    
}