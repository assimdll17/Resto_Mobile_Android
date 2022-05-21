package ma.enset.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import ma.enset.R;
import ma.enset.model.Plat;

public class PlatAdapter extends ArrayAdapter<Plat> {
    private int resource;
    private List<Plat>plats;
    public PlatAdapter(@NonNull Context context, int resource, List<Plat>plats) {
        super(context, resource,plats);
        this.plats=plats;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem=convertView;
        System.out.println("nullll 2");
        //recup du layout des objets
        if(listViewItem==null){
            //contruire la vue  en fonction des elements du fihier xml==onsetview de oncreate
            System.out.println("nullll");
            listViewItem= LayoutInflater.from(getContext()).inflate(resource,parent,false);
        }

        TextView nom=listViewItem.findViewById(R.id.nom);
        TextView des=listViewItem.findViewById(R.id.editTextTextMultiLine2);
        TextView prix=listViewItem.findViewById(R.id.prix);
        TextView temps=listViewItem.findViewById(R.id.time);

        nom.setText(plats.get(position).getName());
        des.setText(plats.get(position).getDescription());
        prix.setText( String.valueOf(plats.get(position).getPrice()));
        temps.setText(plats.get(position).getTime());
        System.out.println("ok view");

        return  listViewItem;
    }
}
