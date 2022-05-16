package ma.enset;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import ma.enset.adapters.PlatAdapter;
import ma.enset.model.Plat;
import ma.enset.service.PlatRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdminActivity extends AppCompatActivity {
    List<Plat>plats=new ArrayList<>();
    List<Plat>data=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainadmin);

        ListView listView=findViewById(R.id.list);


        PlatAdapter userAdapter=new PlatAdapter(this,R.layout.plat_widget,plats);
        listView.setAdapter(userAdapter);


        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://10.0.2.2:8084/")
                .addConverterFactory(GsonConverterFactory.create()).build();
     PlatRepository serviceApi=retrofit.create(PlatRepository.class);

        Call<List<Plat>> callUsers=serviceApi.getAllplats();

        callUsers.enqueue(new Callback<List<Plat>>() {
            @Override
            public void onResponse(Call<List<Plat>> call, Response<List<Plat>> response) {
                Log.i("info","sucess");
               List<Plat> ptls=response.body();
                if(!response.isSuccessful()){

                    Log.i("indo",String.valueOf(response.code()));
                    return;
                }
                for (Plat p: ptls
                     ) {
                    plats.add(p);
                }
                userAdapter.notifyDataSetChanged();
                // adapter.notifyDataSetChanged();
                System.out.println(plats.get(0).getName());
                //attention adapter
            }

            @Override
            public void onFailure(Call<List<Plat>> call, Throwable t) {
                Log.e("error","Error");
                Log.e("error",t.getMessage());
            }
        });




    }
}
