package ma.enset.model;

import java.io.Serializable;

public class Plat implements Serializable {
    private String name;
    private String description;
    private String time;
    private double price;
    private  String image;
    private double rate;

    public Plat(String name, String description, String time, double price, String image, double rate) {
        this.name = name;
        this.description = description;
        this.time = time;
        this.price = price;
        this.image = image;
        this.rate = rate;
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

    public double getPrice() {
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

    @Override
    public String toString() {
        return "Plat{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", rate=" + rate +
                '}';
    }
}
