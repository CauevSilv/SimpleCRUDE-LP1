package com.devminds.gamelister.objects;

public class Game {
    private String nome;
    private String genero;
    private String critica;
    private String ano;
    private String  pirata;
    private String  tamanho;
    private Boolean isPirata;

    public Game(String nome, String genero, String critica, String ano, String pirata, String tamanho, Boolean isPirata) {
        this.nome = nome;
        this.genero = genero;
        this.critica = critica;
        this.ano = ano;
        this.pirata = pirata;
        this.tamanho = tamanho;
        this.isPirata = isPirata;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCritica() {
        return critica;
    }

    public void setCritica(String critica) {
        this.critica = critica;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPirata() {
        return pirata;
    }

    public void setPirata(Boolean pirata) {
        isPirata = pirata;
    }

    public void setPirata(String pirata) {
        this.pirata = pirata;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
