package ma.enset.model;

import java.util.List;

public class Plat {

    private Long id_plat;
    private String name;
    private String description;
    private String time;
    private double price;
    private  String image;
    private double rate;
    List<Commande> commandes;
    Categorie categorie;

    public Plat(String pizzas_b, String mangez_bien, String s, double v, String s1, double v1) {
    }

    public Long getId_plat() {
        return id_plat;
    }

    public void setId_plat(Long id_plat) {
        this.id_plat = id_plat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Plat() {
    }

    public Plat(String name, String description, String time, double price) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
