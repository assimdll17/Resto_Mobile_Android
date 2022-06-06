package ma.enset.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListPlats implements Serializable {
    private List<Plat> plats;
    private String nomPlat;

    public ListPlats(List<Plat> plats, String nomPlat) {
        this.plats = plats;
        this.nomPlat = nomPlat;
    }

    public String getNomPlat() {
        return nomPlat;
    }

    public void setNomPlat(String nomPlat) {
        this.nomPlat = nomPlat;
    }

    public ListPlats(List<Plat> plats) {
        this.plats = plats;
    }

    public List<Plat> getPlats() {
        return plats;
    }

    public void setPlats(List<Plat> plats) {
        this.plats = plats;
    }
}
