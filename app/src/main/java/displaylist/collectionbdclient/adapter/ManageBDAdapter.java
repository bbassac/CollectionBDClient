package displaylist.collectionbdclient.adapter;


import android.app.Activity;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.bean.ManageListItem;
import displaylist.collectionbdclient.utils.MyOnLongClickListener;


public class ManageBDAdapter extends BaseAdapter implements Filterable {
    List<ManageListItem> unfilteredlistItems = null;
    List<ManageListItem> filteredlistItems = null;
    Activity activity;

    BDFilter filter;
    private Context context;

    public ManageBDAdapter(Context exContext, List<ManageListItem> listeBD, Activity displayActivity) {
        super();
        context = exContext;
        unfilteredlistItems = listeBD;
        filteredlistItems = listeBD;
        this.activity = displayActivity;
        getFilter();
    }

    @Override
    public int getCount() {
        return filteredlistItems.size();
    }

    @Override
    public ManageListItem getItem(int arg0) {
        return filteredlistItems.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return filteredlistItems.get(arg0).getBdid();
    }


    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {

        ManageListItem item = filteredlistItems.get(index);
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.manage_list_item, null);
            view.setClickable(true);
        }

        ImageView imageview = (ImageView) view.findViewById(R.id.manquant_imageView);
        ((TextView) view.findViewById(R.id.manquant_serie)).setText(item.getSerieName());
        ((TextView) view.findViewById(R.id.manquant_nom)).setText(item.getTitre());
        ((TextView) view.findViewById(R.id.manquant_bd_id)).setText(String.valueOf(item.getBdid()));
        ((TextView) view.findViewById(R.id.manquant_serie_id)).setText(String.valueOf(item.getSerieId()));
        ((TextView) view.findViewById(R.id.manquant_editeur)).setText(item.getEditeur());
        ((TextView) activity.findViewById(R.id.counter)).setText("(" + filteredlistItems.size() + ")");
        view.findViewById(R.id.manquant_button).setOnLongClickListener(new MyOnLongClickListener(ManageBDAdapter.this, activity,view, filteredlistItems,index));

        imageview.setImageBitmap(null);

        String assetUrl = item.getUrlImage();
        Picasso picasso = Picasso.with(context);
        if(!TextUtils.isEmpty(assetUrl)) {
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
                List<ManageListItem> filteredList = new ArrayList<>();
                String filtre = constraint.toString().toLowerCase(Locale.FRANCE);
                for (ManageListItem item : unfilteredlistItems) {

                    if (item.getTitre().toLowerCase(Locale.FRANCE).contains(filtre) ||
                            item.getSerieName().toLowerCase(Locale.FRANCE).contains(filtre)||
                            item.getEditeur().toLowerCase(Locale.FRANCE).contains(filtre)) {
                        filteredList.add(item);
                    }
                }
                result.values = filteredList;
                result.count = filteredList.size();
            }

            return result;
        }

        @Override
        public void publishResults(CharSequence constraint, FilterResults results) {
            if (results == null) {
                filteredlistItems = unfilteredlistItems;
                notifyDataSetChanged();
            } else if (results.count == 0) {
                filteredlistItems = new ArrayList<>();
                notifyDataSetChanged();
            } else {
                filteredlistItems = (List<ManageListItem>) results.values;
                notifyDataSetChanged();
            }
        }


    }
}

