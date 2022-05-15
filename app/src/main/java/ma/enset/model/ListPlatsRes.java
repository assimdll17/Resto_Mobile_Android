package ma.enset.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ListPlatsRes implements Serializable {
    @SerializedName("")
    private List<Plat> plats;

    public ListPlatsRes(List<Plat> plats) {
        this.plats = plats;
    }

    public List<Plat> getPlats() {
        return plats;
    }

    public void setPlats(List<Plat> plats) {
        this.plats = plats;
    }
}
