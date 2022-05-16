package ma.enset.service;

import java.util.List;

import ma.enset.model.Plat;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PlatRepository {

    @GET("plats")
    Call<List<Plat>> getAllplats();
}
