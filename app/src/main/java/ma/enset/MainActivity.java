package ma.enset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ma.enset.model.ListPlatAdapter;
import ma.enset.model.ListPlatsRes;
import ma.enset.model.Plat;
import ma.enset.service.RestServiceAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button buttonpizzas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Plat p1 = new Plat("Pizzas_B","Mangez bien","10-15min",35.00,"",4.2);
        Plat p2 = new Plat("Pizzas_X","Bon app","15-20min",40.00,"",4.0);

        List<Plat> plats = new ArrayList<>();
        plats.add(p1);
        plats.add(p2);

        ListView listViewPlats = findViewById(R.id.listViewPlats);
        ListPlatAdapter adapter = new ListPlatAdapter(this, R.layout.list_plats_element,plats);
        listViewPlats.setAdapter(adapter);

        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:8084/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RestServiceAPI serviceAPI=retrofit.create(RestServiceAPI.class);

        buttonpizzas = findViewById(R.id.buttonpizzas);
        buttonpizzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<ListPlatsRes> callPlats = serviceAPI.listPlats();
                callPlats.enqueue(new Callback<ListPlatsRes>() {
                    @Override
                    public void onResponse(Call<ListPlatsRes> call, Response<ListPlatsRes> response) {
                        ListPlatsRes listPlats = response.body();
                        for(Plat plat : listPlats.getPlats()){
                            System.out.println(plat);
                            System.out.println("-------------------------------");
                        }
                    }

                    @Override
                    public void onFailure(Call<ListPlatsRes> call, Throwable t) {
                        Log.e("error","Erreur de réseau");
                    }
                });

            }
        });
    }
}