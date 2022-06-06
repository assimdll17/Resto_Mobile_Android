package ma.enset.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import ma.enset.R;
import ma.enset.model.Plat;

public class ListPlatAdapter extends ArrayAdapter<Plat> {
    private int resource;
    public ListPlatAdapter(@NonNull Context context, int resource, @NonNull List<Plat> plats) {
        super(context, resource, plats);
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }
        TextView nomplat = listItemView.findViewById(R.id.nomplat);
        nomplat.setText(getItem(position).getName());

        ImageView imageplat = listItemView.findViewById(R.id.imageplat);
        //imageplat.setImageDrawable();

        TextView prixplat = listItemView.findViewById(R.id.prixplat);
        prixplat.setText(getItem(position).getPrice()+" DH");

        TextView noteplat = listItemView.findViewById(R.id.noteplat);
        noteplat.setText(String.valueOf(getItem(position).getRate()));

        TextView tempsplat = listItemView.findViewById(R.id.tempsplat);
        tempsplat.setText(getItem(position).getTime());

        return listItemView;
    }
}
