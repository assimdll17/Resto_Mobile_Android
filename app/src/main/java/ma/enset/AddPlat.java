package ma.enset;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

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
        TextInputEditText img=findViewById(R.id.img);
        Button button=findViewById(R.id.envoyer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("ok");
                Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:8088/")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                PlatRepository serviceApi=retrofit.create(PlatRepository.class);
                Plat plat=new Plat();
                plat.setName(name.getText().toString());
                plat.setPrice(Double.parseDouble(prix.getText().toString()));
                plat.setTime(time.getText().toString());
                plat.setDescription(desc.getText().toString());
                plat.setImage(img.getText().toString());

                Call<Plat> addPlat=serviceApi.createPlat(plat);
                addPlat.enqueue(new Callback<Plat>() {
                    @Override
                    public void onResponse(Call<Plat> call, Response<Plat> response) {
                        Toast toast =  Toast.makeText(view.getContext(), "Plat créer avec Succès!", Toast.LENGTH_SHORT);
                        // Gravity.CENTER = Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL;
                        toast.setGravity(Gravity.CENTER, 20, 30);
                        toast.show();

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
