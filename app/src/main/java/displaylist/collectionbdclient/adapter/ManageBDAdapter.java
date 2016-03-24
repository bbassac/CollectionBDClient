package displaylist.collectionbdclient.adapter;



import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.ManageListItem;
import displaylist.collectionbdclient.utils.MyOnLongClickListener;
import displaylist.collectionbdclient.utils.SerieUtils;


public class ManageBDAdapter extends BaseAdapter {
    Collection collection = null; //GET FROM JSON
    List<ManageListItem> listItems = null;
    Activity activity;
    ManageListItem item;
    private Context context;

    public ManageBDAdapter(Context exContext, Collection listeBD, Activity displayActivity) {
        super();
        context = exContext;
        collection = listeBD;
        listItems = SerieUtils.convertCollection(listeBD);
        this.activity = displayActivity;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public ManageListItem getItem(int arg0) {
        return listItems.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return listItems.get(arg0).getBdid();
    }


    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {

        item = listItems.get(index);
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
        view.findViewById(R.id.manquant_button).setOnLongClickListener(new MyOnLongClickListener(ManageBDAdapter.this, activity,collection,view,listItems,index));

        imageview.setImageBitmap(null);

        String assetUrl = item.getUrlImage();
        Picasso picasso = Picasso.with(context);
        picasso.setIndicatorsEnabled(true);
        picasso.load(assetUrl).resize(100, 120).into(imageview);

        return view;
    }

}