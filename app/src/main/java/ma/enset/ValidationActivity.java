package ma.enset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import ma.enset.model.DetailCommande;
import ma.enset.model.Plat;

public class ValidationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);

        Intent intent = getIntent();
        DetailCommande detailCommande = (DetailCommande) intent.getSerializableExtra("detailCommande");
        TextView msg = findViewById(R.id.msg);
        TextView nompdetail = findViewById(R.id.nomp_detail);
        TextView prixpdetail = findViewById(R.id.prixp_detail);
        TextView qtedetail = findViewById(R.id.qte_detail);
        TextView totaldetail = findViewById(R.id.total_detail);

        msg.setText("M/Mme "+detailCommande.getNomClient()+" votre commande a été enregistrée avec succès");
        nompdetail.setText(detailCommande.getPlat().getName());
        prixpdetail.setText(detailCommande.getPlat().getPrice()+" DH");
        qtedetail.setText(detailCommande.getQuantite());
        totaldetail.setText(detailCommande.getQuantite()*detailCommande.getPlat().getPrice()+" DH");
    }
}