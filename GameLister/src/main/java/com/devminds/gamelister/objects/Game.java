package com.devminds.gamelister.objects;

public class Game {
    private String nome;
    private String genero;
    private String critica;
    private String ano;
    private String pirata;
    private String  tamanho;
    private Boolean isPirata;
    private int idgame;

    public int getIdgame() {
        return idgame;
    }

    public void setIdgame(int idgame) {
        this.idgame = idgame;
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

    public void setPirata(Integer pirata) {
        this.pirata = String.valueOf(pirata);
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
