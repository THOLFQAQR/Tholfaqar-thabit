package com.example.cc203_tholfaqar;

public class Climat {

    public Climat() {
    }

    public Climat(int id, String nomVille, String pays, int temprature, int pourcentage) {
        this.id = id;
        this.nomVille = nomVille;
        Pays = pays;
        this.temprature = temprature;
        Pourcentage = pourcentage;
    }

    int id  ;
     String nomVille ;
     String Pays ;
     int temprature ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }

    public int getTemprature() {
        return temprature;
    }

    public void setTemprature(int temprature) {
        this.temprature = temprature;
    }

    public int getPourcentage() {
        return Pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        Pourcentage = pourcentage;
    }

    int 	Pourcentage ;

}
