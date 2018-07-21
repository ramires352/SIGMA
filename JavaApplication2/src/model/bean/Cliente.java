package model.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Cliente {
    private String login, senha;
    private static String nome;
    
    public void setLogin(String log){
        login = log;
    }

    public String getLogin() {
        return login;
    }

    public static String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
    
    public static void setNome(String n){
        nome = n;
    }
    
    public void setSenha(String s){
        senha = s;
    }
}
