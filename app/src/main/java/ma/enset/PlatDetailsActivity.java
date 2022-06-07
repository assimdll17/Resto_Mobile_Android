package ma.enset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

import ma.enset.model.Plat;

public class PlatDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plat_details);

        Intent intent = getIntent();
        Plat plat = (Plat) intent.getSerializableExtra("plat");
        TextView nompl = findViewById(R.id.nompl);
        TextView prixpl = findViewById(R.id.prixpl);
        TextView descrippl = findViewById(R.id.descrippl);
        ImageView img = findViewById(R.id.img);
        Button commander = findViewById(R.id.btncommander);

        nompl.setText(plat.getName());
        prixpl.setText(plat.getPrice()+" DH");
        descrippl.setText(plat.getDescription());

        if(plat.getImage()!=null){
            try {
                URL url = new URL(plat.getImage());
                Bitmap bitmap= BitmapFactory.decodeStream(url.openStream());
                img.setImageBitmap(bitmap);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        commander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CommandeActivity.class);
                intent.putExtra("plat",plat);
                startActivity(intent);
            }
        });

    }
}