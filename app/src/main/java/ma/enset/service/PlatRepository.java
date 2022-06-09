package ma.enset.service;

import java.util.List;

import ma.enset.model.Commande;
import ma.enset.model.Plat;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PlatRepository {

    @GET("plats")
    Call<List<Plat>> getAllplats();
    @GET("commandes")
    Call<List<Commande>> getAllcommandes();

    @POST("plat/new")
    Call<Plat> createPlat(@Body Plat plat);


    @POST("commande/new")
    Call<Commande> createCommande(@Body Commande commande);


    @GET("/commande/{id}")
    Call<Boolean> deleteCommande(@Path("id") long id);
}
