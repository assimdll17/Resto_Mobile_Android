package ma.enset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import ma.enset.adapters.ListPlatAdapter;
import ma.enset.model.ListPlats;
import ma.enset.model.Plat;

public class PlatsByCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plats_by_category);

        Intent intent = getIntent();
        ListPlats listPlats = (ListPlats) intent.getSerializableExtra("listPlats");

        Button button = findViewById(R.id.button5);
        button.setText(listPlats.getNomPlat());

        ListView listPlatsCategory = findViewById(R.id.listviewplatscategory);
        ListPlatAdapter adapter = new ListPlatAdapter(this, R.layout.list_plats_element,listPlats.getPlats());
        listPlatsCategory.setAdapter(adapter);

        listPlatsCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), PlatDetailsActivity.class);
                intent.putExtra("plat",listPlats.getPlats().get(i));
                startActivity(intent);
            }
        });
    }
}