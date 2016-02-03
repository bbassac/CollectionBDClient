package displaylist.collectionbdclient.adapter;


import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.Locale;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.activities.DisplayActivity;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.Serie;
import displaylist.collectionbdclient.components.MyOnClickListener;
import displaylist.collectionbdclient.utils.SerieUtils;

public class ListBDAdapter extends BaseAdapter implements Filterable{
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
			LayoutInflater inflater =LayoutInflater.from(context);
			view = inflater.inflate(R.layout.list_item, null);
			view.setClickable(true);
			view.setOnClickListener(new MyOnClickListener(context,displayActivity, filteredCollection));
		}

		ImageView imageview = (ImageView) view.findViewById(R.id.imageView);

		((TextView) view.findViewById(R.id.nom)).setText(serie.getNom());
		((TextView) view.findViewById(R.id.numero)).setText(SerieUtils.getStringPossede(serie));
		((TextView) view.findViewById(R.id.bd_id)).setText(String.valueOf(serie.getId()));
		((ImageView) view.findViewById(R.id.fini)).setImageResource(SerieUtils.getResourceFini(serie));
		((TextView) view.findViewById(R.id.manquant)).setText(SerieUtils.getStringManquant(serie));
        ((TextView)view.findViewById(R.id.editeur)).setText(serie.getEditeur());
        ((TextView) displayActivity.findViewById(R.id.counter)).setText("(" + filteredCollection.getListeSerie().size() + ")");
        String nbPossede = String.valueOf(serie.getListPossede()==null ? "--" : serie.getListPossede().size());
        String nbManquante = String.valueOf(serie.getListPossede() ==null || serie.getListManquante()==null ? "--" : serie.getListManquante().size()+serie.getListPossede().size());
        ((TextView) view.findViewById(R.id.serie_counter)).setText(nbPossede+"/"+nbManquante);

        imageview.setImageBitmap(null);
		if(!TextUtils.isEmpty(serie.getImageUrl())) {
            Picasso.with(context).load("file:///android_asset/img/" + serie.getNom() + ".jpg").resize(100, 120).into(imageview);
		}

		return view;
	}




    @Override
    public Filter getFilter() {
        if (filter == null){
            filter  = new BDFilter();
        }
        return filter;
    }

    public class BDFilter extends Filter{

        @Override
        public FilterResults performFiltering(CharSequence constraint) {

            FilterResults result = new FilterResults();
            if(constraint == null || constraint.length() == 0){

                result = null;
            }else{
                Collection filteredList = new Collection();
                for(Serie serie: unfilteredCollection.getListeSerie()){

                    if(     serie.getNom().toLowerCase(Locale.FRANCE).contains(constraint) ||
                            SerieUtils.getStringManquant(serie).toLowerCase(Locale.FRANCE).contains(constraint) ||
                            SerieUtils.getStringPossede(serie).toLowerCase(Locale.FRANCE).contains(constraint) ||
                            serie.getEditeur().toLowerCase(Locale.FRANCE).contains(constraint) ) {
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
            if(results==null){
                filteredCollection = unfilteredCollection;
                notifyDataSetChanged();
            }

            else if (results.count == 0) {
                filteredCollection = new Collection();
                notifyDataSetChanged();
            } else {
                filteredCollection = (Collection) results.values;
                notifyDataSetChanged();
            }
        }
    }
}



