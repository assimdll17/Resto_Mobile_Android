package ma.enset.model;

import java.io.Serializable;

public class DetailCommande implements Serializable {
    private String nomClient;
    private double prix;
    private int quantite;
    private Plat plat;

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public DetailCommande(String nomClient, double prix, int quantite, Plat plat) {
        this.nomClient = nomClient;
        this.prix = prix;
        this.quantite = quantite;
        this.plat = plat;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
