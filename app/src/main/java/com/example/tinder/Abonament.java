package com.example.tinder;

public class Abonament {

    private String nume;
    private float pret;
    private String descriere;

    public Abonament(String nume, float pret, String descriere) {
        this.nume = nume;
        this.pret = pret;
        this.descriere = descriere;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Abonament{" +
                "nume='" + nume + '\'' +
                ", pret=" + pret +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
