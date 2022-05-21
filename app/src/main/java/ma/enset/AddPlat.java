package ma.enset;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import ma.enset.model.Commande;
import ma.enset.model.Plat;
import ma.enset.service.PlatRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddPlat extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_plat);

        TextInputEditText name=findViewById(R.id.nom);
        TextInputEditText  cat=findViewById(R.id.categorie);
        TextInputEditText prix=findViewById(R.id.prix);
        TextInputEditText time=findViewById(R.id.time);
        TextInputEditText desc=findViewById(R.id.desc);
        Button button=findViewById(R.id.envoyer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("ok");
                Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:8084/")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                PlatRepository serviceApi=retrofit.create(PlatRepository.class);

                Plat plat=new Plat();
                plat.setName(name.toString());
                //plat.setPrice(prix.toString()));
                plat.setTime(time.toString());
                plat.setDescription(desc.toString());

                Call<Plat> addPlat=serviceApi.createPlat(plat);
                addPlat.enqueue(new Callback<Plat>() {
                    @Override
                    public void onResponse(Call<Plat> call, Response<Plat> response) {

                    }

                    @Override
                    public void onFailure(Call<Plat> call, Throwable t) {
                        Log.e("error","Error");
                        Log.e("error",t.getMessage());
                    }
                });


            }
        });
    }
}
