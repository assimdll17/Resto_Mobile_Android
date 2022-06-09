package ma.enset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ma.enset.adapters.ListPlatAdapter;
import ma.enset.model.ListPlats;
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

        StrictMode.ThreadPolicy strictMode=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(strictMode);

        Plat p1 = new Plat("Pizza Regina","Mangez bien","10-15min",35.00,"https://img.cuisineaz.com/660x660/2013/12/20/i42259-photo-de-pizza-regina.jpeg",4.2);
        Plat p2 = new Plat("Tacos de Lyon","Bon app","15-20min",40.00,"https://www.toute-la-franchise.com/images/zoom/le-tacos-de-lyon-salon-franchise-halal.jpg",4.0);


        List<Plat> plats2 = new ArrayList<>();
        plats2.add(p1);
        plats2.add(p2);

        ListView listViewPlats = findViewById(R.id.listViewPlats);
        ListPlatAdapter adapter = new ListPlatAdapter(this, R.layout.list_plats_element,plats2);
        listViewPlats.setAdapter(adapter);

        listViewPlats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), PlatDetailsActivity.class);
                intent.putExtra("plat",plats2.get(i));
                startActivity(intent);
            }
        });

        Button button=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(next);
            }
        });

        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:8088/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RestServiceAPI serviceAPI=retrofit.create(RestServiceAPI.class);

        buttonpizzas = findViewById(R.id.buttonpizzas);
        buttonpizzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<Plat>> callPlats = serviceAPI.listPlatsPizzas();
                callPlats.enqueue(new Callback<List<Plat>>() {
                    @Override
                    public void onResponse(Call<List<Plat>> call, Response<List<Plat>> response) {
                        List<Plat> plats = new ArrayList<>();
                        List<Plat> listPlats = response.body();
                        for(Plat plat : listPlats){
                            plats.add(plat);
                            System.out.println(plat);
                            System.out.println("-------------------------------");
                        }
                        adapter.notifyDataSetChanged();

                        ListPlats listPlats1 = new ListPlats(plats,"Nos pizzas, bon app");

                        Intent intent = new Intent(getApplicationContext(), PlatsByCategory.class);
                        intent.putExtra("listPlats",listPlats1);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<Plat>> call, Throwable t) {
                        Log.e("error","Erreur de réseau");
                    }
                });

            }
        });

        Button buttonburgers = findViewById(R.id.buttonburgers);
        buttonburgers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<Plat>> callPlats = serviceAPI.listPlatsBurgers();
                callPlats.enqueue(new Callback<List<Plat>>() {
                    @Override
                    public void onResponse(Call<List<Plat>> call, Response<List<Plat>> response) {
                        List<Plat> plats = new ArrayList<>();
                        List<Plat> listPlats = response.body();
                        for(Plat plat : listPlats){
                            plats.add(plat);
                            System.out.println(plat);
                            System.out.println("-------------------------------");
                        }
                        adapter.notifyDataSetChanged();

                        ListPlats listPlats1 = new ListPlats(plats,"Nos burgers");

                        Intent intent = new Intent(getApplicationContext(), PlatsByCategory.class);
                        intent.putExtra("listPlats",listPlats1);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<Plat>> call, Throwable t) {
                        Log.e("error","Erreur de réseau");
                    }
                });

            }
        });

        Button buttontacos = findViewById(R.id.buttontacos);
        buttontacos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<Plat>> callPlats = serviceAPI.listPlatsTacos();
                callPlats.enqueue(new Callback<List<Plat>>() {
                    @Override
                    public void onResponse(Call<List<Plat>> call, Response<List<Plat>> response) {
                        List<Plat> plats = new ArrayList<>();
                        List<Plat> listPlats = response.body();
                        for(Plat plat : listPlats){
                            plats.add(plat);
                            System.out.println(plat);
                            System.out.println("-------------------------------");
                        }
                        adapter.notifyDataSetChanged();

                        ListPlats listPlats1 = new ListPlats(plats,"Nos tacos, les meilleurs");

                        Intent intent = new Intent(getApplicationContext(), PlatsByCategory.class);
                        intent.putExtra("listPlats",listPlats1);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<Plat>> call, Throwable t) {
                        Log.e("error","Erreur de réseau");
                    }
                });

            }
        });


        Button buttonboissons = findViewById(R.id.buttonboissons);
        buttonboissons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<Plat>> callPlats = serviceAPI.listPlatsBoissons();
                callPlats.enqueue(new Callback<List<Plat>>() {
                    @Override
                    public void onResponse(Call<List<Plat>> call, Response<List<Plat>> response) {
                        List<Plat> plats = new ArrayList<>();
                        List<Plat> listPlats = response.body();
                        for(Plat plat : listPlats){
                            plats.add(plat);
                            System.out.println(plat);
                            System.out.println("-------------------------------");
                        }
                        adapter.notifyDataSetChanged();

                        ListPlats listPlats1 = new ListPlats(plats,"Nos rafraichissantes boissons");

                        Intent intent = new Intent(getApplicationContext(), PlatsByCategory.class);
                        intent.putExtra("listPlats",listPlats1);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<Plat>> call, Throwable t) {
                        Log.e("error","Erreur de réseau");
                    }
                });

            }
        });
    }
}