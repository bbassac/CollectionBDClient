package displaylist.collectionbdclient.components;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.activities.DisplayActivity;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.Serie;
import displaylist.collectionbdclient.utils.SerieUtils;

/**
 * Created by b.bassac on 03/12/2014.
 */
public class MyOnClickListener implements View.OnClickListener {

    private DisplayActivity displayActivity;
    private Collection codeLeanChapterList;
    private Context context;
    private Map<String, Boolean> colapsedMap;

    public MyOnClickListener(Context context, DisplayActivity displayActivity, Collection codeLeanChapterList) {
        this.displayActivity = displayActivity;
        this.codeLeanChapterList = codeLeanChapterList;
        this.context = context;
        this.colapsedMap = new HashMap<String, Boolean>();
    }

    @Override
    public void onClick(View view) {
        String s_id = String.valueOf(((TextView) view.findViewById(R.id.bd_id)).getText());
        Serie serie = SerieUtils.getBDById(codeLeanChapterList, Integer.valueOf(s_id));
        if (!colapsedMap.containsKey(s_id) || colapsedMap.get(s_id) == true) {
            ((TextView) view.findViewById(R.id.possede)).setText(SerieUtils.getStringPossede(serie));
            ((TextView) view.findViewById(R.id.manquant)).setText(SerieUtils.getStringManquant(serie));
            colapsedMap.put(s_id, false);
        } else {
            ((TextView) view.findViewById(R.id.possede)).setText("");
            ((TextView) view.findViewById(R.id.manquant)).setText("");
            colapsedMap.put(s_id, true);
        }
    }
}

