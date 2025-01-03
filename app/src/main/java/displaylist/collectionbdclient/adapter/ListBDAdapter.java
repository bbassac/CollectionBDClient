package displaylist.collectionbdclient.adapter;


import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Console;
import java.util.Locale;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.activities.DisplayActivity;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.Serie;
import displaylist.collectionbdclient.components.MyOnClickListener;
import displaylist.collectionbdclient.utils.SerieUtils;

public class ListBDAdapter extends BaseAdapter implements Filterable {
    Collection unfilteredCollection = null; //GET FROM JSON
    Collection filteredCollection;
    DisplayActivity displayActivity;
    BDFilter filter;
    private Context context;

    public ListBDAdapter(Context exContext, Collection listeBD, DisplayActivity displayActivity) {
        super();
        context = exContext;
        unfilteredCollection = listeBD;
        filteredCollection = listeBD;
        this.displayActivity = displayActivity;
        getFilter();
    }

    @Override
    public int getCount() {
        return filteredCollection.getListeSerie().size();
    }

    @Override
    public Serie getItem(int arg0) {
        return filteredCollection.getListeSerie().get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return filteredCollection.getListeSerie().get(arg0).getId();
    }


    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {

        Serie serie = filteredCollection.getListeSerie().get(index);
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.display_list_item, null);
            view.setClickable(true);
            view.setOnClickListener(new MyOnClickListener(context, displayActivity, filteredCollection));
        }

        ImageView imageview = (ImageView) view.findViewById(R.id.imageView);

        ((TextView) view.findViewById(R.id.nom)).setText(serie.getNom());
        ((TextView) view.findViewById(R.id.manquant)).setText(null);
        ((TextView) view.findViewById(R.id.possede)).setText(null);
        ((TextView) view.findViewById(R.id.bd_id)).setText(String.valueOf(serie.getId()));
        ((ImageView) view.findViewById(R.id.fini)).setImageResource(SerieUtils.getResourceFini(serie));
        ((TextView) view.findViewById(R.id.editeur)).setText(serie.getEditeur());

        ((TextView) displayActivity.findViewById(R.id.counter)).setText("(" + filteredCollection.getListeSerie().size() + ")");
        ((TextView) view.findViewById(R.id.serie_counter)).setText(SerieUtils.getNbBdPossede(serie) + "/" + SerieUtils.getNbTotalBd(serie));

        imageview.setImageBitmap(null);

        String assetUrl = serie.getImageUrl();
        Picasso picasso = Picasso.get();
        picasso.setIndicatorsEnabled(true);
        if(!TextUtils.isEmpty(assetUrl)) {
            //Debug
            Log.i("Picasso",serie.getNom() + " " + assetUrl);
            picasso.load(assetUrl).resize(100, 120).into(imageview);
        }else{
            picasso.load(R.drawable.ic_launcher).resize(100, 120).into(imageview);
        }

        return view;
    }


    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new BDFilter();
        }
        return filter;
    }

    public class BDFilter extends Filter {

        @Override
        public FilterResults performFiltering(CharSequence constraint) {
            FilterResults result = new FilterResults();
            if (constraint == null || constraint.length() == 0) {

                result = null;
            } else {
                Collection filteredList = new Collection();
                String filtre = constraint.toString().toLowerCase(Locale.FRANCE);
                for (Serie serie : unfilteredCollection.getListeSerie()) {

                    if (serie.getNom().toLowerCase(Locale.FRANCE).contains(filtre) ||
                            SerieUtils.getStringManquant(serie).toLowerCase(Locale.FRANCE).contains(filtre) ||
                            SerieUtils.getStringPossede(serie).toLowerCase(Locale.FRANCE).contains(filtre) ||
                            SerieUtils.getStringEditeur(serie).toLowerCase(Locale.FRANCE).contains(filtre)) {
                            filteredList.addBD(serie);
                    }
                }
                result.values = filteredList;
                result.count = filteredList.getListeSerie().size();
            }

            return result;
        }

        @Override
        public void publishResults(CharSequence constraint, FilterResults results) {
            if (results == null) {
                filteredCollection = unfilteredCollection;
                notifyDataSetChanged();
            } else if (results.count == 0) {
                filteredCollection = new Collection();
                notifyDataSetChanged();
            } else {
                filteredCollection = (Collection) results.values;
                notifyDataSetChanged();
            }
        }
    }
}



