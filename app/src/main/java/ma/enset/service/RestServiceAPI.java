package ma.enset.service;

import ma.enset.model.ListPlatsRes;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestServiceAPI {
    @GET("plats")
    Call<ListPlatsRes> listPlats();
}
