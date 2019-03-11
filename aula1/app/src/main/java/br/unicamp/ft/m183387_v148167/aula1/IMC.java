package br.unicamp.ft.m183387_v148167.aula1;

public class IMC {
    private float peso;
    private float altura;
    public IMC(){

    }
    public float getPeso(){
        return this.peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    public float getIMC(){
        return getPeso()/(getAltura()*getAltura());
    }
}
