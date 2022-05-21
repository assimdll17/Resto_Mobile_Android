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
import ma.enset.model.Commande;
import ma.enset.model.Plat;

public class CommandeAdapter extends ArrayAdapter<Commande> {
    private int resource;
    private List<Commande>commandes;
    public CommandeAdapter(@NonNull Context context, int resource, List<Commande>commandes) {
        super(context, resource,commandes);
        this.commandes=commandes;
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

        TextView numero=listViewItem.findViewById(R.id.numero);
        TextView qte=listViewItem.findViewById(R.id.quantity);
        TextView client=listViewItem.findViewById(R.id.client);

        numero.setText("N° "+commandes.get(position).getId_cmd().toString());
        qte.setText("qty: "+String.valueOf(commandes.get(position).getQuantity()));
        client.setText( String.valueOf(commandes.get(position).getCustomerName()));
        System.out.println("ok view");

        return  listViewItem;
    }
}
