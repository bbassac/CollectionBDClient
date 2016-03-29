package displaylist.collectionbdclient.utils;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.github.johnpersano.supertoasts.SuperToast;

import java.util.List;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.adapter.ManageBDAdapter;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.ManageListItem;

/**
 * Created by b.bassac on 03/12/2014.
 */
public class MyOnLongClickListener implements View.OnLongClickListener {

    private final List<ManageListItem> listItems;
    private final int index;
    private Activity activity;
    private View itemView;
    private ManageBDAdapter adapter;

    public MyOnLongClickListener(ManageBDAdapter adapter, Activity activity,View view, List<ManageListItem> listItems, int index) {
        this.activity = activity;
        this.itemView = view;
        this.adapter=adapter;
        this.listItems= listItems;
        this.index = index;
    }

    @Override
    public boolean onLongClick(View view) {
        Long serie_ID = Long.valueOf(((TextView) itemView.findViewById(R.id.manquant_serie_id)).getText().toString());
        Long bd_id = Long.valueOf(((TextView) itemView.findViewById(R.id.manquant_bd_id)).getText().toString());
        ToastUtils.display(activity,serie_ID+" "+bd_id+" "+((TextView) itemView.findViewById(R.id.manquant_nom)).getText(), SuperToast.Duration.VERY_SHORT);
        listItems.remove(index);
        CollectionProvider.setBDAsPossede(activity,bd_id);
        adapter.notifyDataSetChanged();
        return true;
    }


}

