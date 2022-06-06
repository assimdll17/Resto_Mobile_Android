package ma.enset.model;

import java.io.Serializable;
import java.util.List;

public class Plat implements Serializable {

    private String name;
    private String description;
    private String time;
    private double price;
    private  String image;
    private double rate;
    Categorie categorie;

    public Plat(String name, String description, String time, double price, String image, double rate) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.price = price;
        this.image = image;
        this.rate = rate;
        this.categorie = categorie;
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
