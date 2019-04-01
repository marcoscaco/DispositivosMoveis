package br.unicamp.ft.m183387_v148167.aula4;

public class Aluno {

    private  String nome;
    private String ra;
    private int foto;
    private String miniCV;

    public Aluno(String nome, String ra, int foto, String miniCV){
        this.nome = nome;
        this.ra = ra;
        this.foto = foto;
        this.miniCV = miniCV;
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

}
