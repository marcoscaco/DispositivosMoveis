package com.example.aula6;

public class Aluno {
    private  String nome;
    private String ra;
    private int foto;
    private String miniCV;
    private int time;
    private int idade;
    private double altura;

    public Aluno(String nome, String ra, int foto, String miniCV, double altura, int idade, int time) {
        this.nome = nome;
        this.ra = ra;
        this.foto = foto;
        this.miniCV = miniCV;
        this.time = time;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getMiniCV() {
        return miniCV;
    }

    public void setMiniCV(String miniCV) {
        this.miniCV = miniCV;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
