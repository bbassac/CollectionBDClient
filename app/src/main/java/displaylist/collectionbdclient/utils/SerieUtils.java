package displaylist.collectionbdclient.utils;

import android.app.Activity;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.bean.Bd;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.ManageListItem;
import displaylist.collectionbdclient.bean.Serie;

public class SerieUtils {


    private static BDComparator bdComparator = new BDComparator();

    public static String getStringPossede(Serie s) {
        StringBuilder builder = new StringBuilder();
        Collections.sort(s.getListPossede(), bdComparator);
        for (Bd bd : s.getListPossede()) {
            builder.append(bd.getNumero()).append(" ").append(bd.getTitre()).append("\n");
        }
        return builder.toString();
    }

    public static String getStringManquant(Serie s) {
        StringBuilder builder = new StringBuilder();
        Collections.sort(s.getListManquante(), bdComparator);
        for (Bd bd : s.getListManquante()) {
            builder.append(bd.getNumero()).append(" ").append(bd.getTitre()).append("\n");
        }
        return builder.toString();
    }

    public static int getResourceFini(Serie serie) {
        return (serie.getListManquante().size() == 0 ? R.drawable.check : R.drawable.cross);
    }

    public static Serie getBDById(Collection CollectionBDClient, int id) {
        for (Serie serie : CollectionBDClient.getListeSerie()) {
            if (serie.getId() == id) {
                return serie;
            }
        }
        return null;
    }

    public static String getNbBdPossede(Serie serie) {
        return String.valueOf(serie.getListPossede() == null ? "--" : serie.getListPossede().size());
    }

    public static String getNbTotalBd(Serie serie) {
        return String.valueOf(serie.getListPossede() == null || serie.getListManquante() == null ? "--" : serie.getListManquante().size() + serie.getListPossede().size());
    }

    public static String getSerieImageUrl(Activity activity, Serie serie){
        String assetUrl = "file:///android_asset/img/" + serie.getNom() + ".jpg";
        if (!AssetUtils.instance(activity).checkAssetExists(assetUrl)) {
            assetUrl = serie.getImageUrl();
        }
        return assetUrl;
    }

    public static List<ManageListItem> convertCollection(Collection listeBD) {
        List<ManageListItem> toReturn = new ArrayList<>();
        for(Serie serie : listeBD.getListeSerie()){
            if (serie.getListManquante()!= null && serie.getListManquante().size()>0){
                for (Bd bd : serie.getListManquante()) {
                    ManageListItem item = new ManageListItem();
                    item.setSerieId(serie.getId());
                    item.setSerieName(serie.getNom());
                    item.setEditeur(serie.getEditeur());
                    item.setBdid(bd.getId());
                    if (!TextUtils.isEmpty(bd.getCouvertureUrl()))
                    {
                        item.setUrlImage(bd.getCouvertureUrl());
                    }else {
                        item.setUrlImage(serie.getImageUrl());
                    }

                    item.setTitre(bd.getTitre());
                    item.setNumero(bd.getNumero());
                    toReturn.add(item);
                }

            }
        }
        return toReturn;
    }

}
