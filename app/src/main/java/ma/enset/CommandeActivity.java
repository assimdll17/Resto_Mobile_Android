package ma.enset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ma.enset.model.DetailCommande;
import ma.enset.model.Plat;

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
                Intent intent = new Intent(getApplicationContext(), ValidationActivity.class);
                intent.putExtra("detailCommande",new DetailCommande(nomClient.getText().toString(),plat.getPrice(),Integer.valueOf(quantite.getText().toString()), plat));
                startActivity(intent);
            }
        });

    }
}