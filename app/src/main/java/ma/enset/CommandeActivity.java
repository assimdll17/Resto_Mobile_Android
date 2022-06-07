package ma.enset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ma.enset.model.Commande;
import ma.enset.model.DetailCommande;
import ma.enset.model.Plat;
import ma.enset.service.PlatRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommandeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);

        Intent intent = getIntent();
        Plat plat = (Plat) intent.getSerializableExtra("plat");
        TextView nomp = findViewById(R.id.nomp);
        TextView prixp = findViewById(R.id.prixp);
        EditText nomClient = findViewById(R.id.nomcommande);
        EditText adresseClient = findViewById(R.id.adressecommande);
        EditText quantite = findViewById(R.id.quantitecommande);
        Button valider = findViewById(R.id.btnvalider);

        nomp.setText(plat.getName());
        prixp.setText(plat.getPrice()+" DH");


        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:8088/")
                        .addConverterFactory(GsonConverterFactory.create()).build();
                PlatRepository serviceApi=retrofit.create(PlatRepository.class);

                Commande commande=new Commande();
                commande.setQuantity(Integer.parseInt(quantite.getText().toString()));
                commande.setCustomerAddress(adresseClient.getText().toString());
                commande.setCustomerName(nomClient.getText().toString());
                commande.setNomplat(nomp.getText().toString());
                commande.setPrixplat(plat.getPrice());
                commande.setTotalPrice(plat.getPrice()*Integer.parseInt(quantite.getText().toString()));
                System.out.println("-"+plat.getPrice()*Integer.parseInt(quantite.getText().toString()));


                Call<Commande>addCommande=serviceApi.createCommande(commande);
                addCommande.enqueue(new Callback<Commande>() {
                    @Override
                    public void onResponse(Call<Commande> call, Response<Commande> response) {
                        System.out.println("-"+commande.getTotalPrice());
                        Toast toast =  Toast.makeText(view.getContext(), "Plat créer avec Succès!", Toast.LENGTH_SHORT);
                        // Gravity.CENTER = Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL;
                        toast.setGravity(Gravity.CENTER, 20, 30);
                        toast.show();
                    }

                    @Override
                    public void onFailure(Call<Commande> call, Throwable t) {
                        Log.e("error","Error");
                        Log.e("error",t.getMessage());
                    }
                });

                Intent intent = new Intent(getApplicationContext(), ValidationActivity.class);
                intent.putExtra("detailCommande",new DetailCommande(nomClient.getText().toString(),plat.getPrice(),Integer.parseInt(quantite.getText().toString()), plat));
                startActivity(intent);
            }
        });

    }
}