package ma.enset.service;

import java.util.List;

import ma.enset.model.Plat;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestServiceAPI {
    @GET("plats/pizza")
    Call<List<Plat>> listPlatsPizzas();
    @GET("plats/boisson")
    Call<List<Plat>> listPlatsBoissons();
    @GET("plats/burger")
    Call<List<Plat>> listPlatsBurgers();
    @GET("plats/tacos")
    Call<List<Plat>> listPlatsTacos();
}
