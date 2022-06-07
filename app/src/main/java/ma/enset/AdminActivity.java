package ma.enset;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ma.enset.adapters.CommandeAdapter;
import ma.enset.model.Commande;
import ma.enset.model.Plat;
import ma.enset.service.PlatRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdminActivity extends AppCompatActivity {
    List<Commande>commandes=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainadmin);

        ListView listView=findViewById(R.id.list);
        Button button=findViewById(R.id.add);

        CommandeAdapter userAdapter=new CommandeAdapter(this,R.layout.commande_widget,commandes);
        listView.setAdapter(userAdapter);


        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:8088/")
                .addConverterFactory(GsonConverterFactory.create()).build();
     PlatRepository serviceApi=retrofit.create(PlatRepository.class);

        Call<List<Commande>> callUsers=serviceApi.getAllcommandes();

        callUsers.enqueue(new Callback<List<Commande>>() {
            @Override
            public void onResponse(Call<List<Commande>> call, Response<List<Commande>> response) {
                Log.i("info","sucess");
               List<Commande> ptls=response.body();
                if(!response.isSuccessful()){

                    Log.i("indo",String.valueOf(response.code()));
                    return;
                }
                for (Commande p: ptls
                     ) {
                    commandes.add(p);
                }
                userAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Commande>> call, Throwable t) {
                Log.e("error","Error");
                Log.e("error",t.getMessage());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next=new Intent(getApplicationContext(),AddPlat.class);
                startActivity(next);
            }
        });


    }
}
