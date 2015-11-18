package displaylist.collectionbdclient.utils;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.bean.Bd;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.Serie;

/**
 * Created by b.bassac on 21/05/2015.
 */
public class SerieUtils {

    public static String getStringPossede(Serie s){
        StringBuilder builder = new StringBuilder();
        for(Bd bd : s.getListPossede()){
            builder.append(bd.getNumero()).append(" ").append(bd.getTitre()).append("\n");
        }
        return builder.toString();
    }

    public static String getStringManquant(Serie s){
        StringBuilder builder = new StringBuilder();
        for(Bd bd : s.getListManquante()){
            builder.append(bd.getNumero()).append(" ").append(bd.getTitre()).append("\n");
        }
        return builder.toString();
    }

    public static int getResourceFini(Serie s){
        return (s.isFini() ? R.drawable.check : R.drawable.cross);
    }

    public static Serie getBDById(Collection CollectionBDClient,int id){
        for (Serie serie : CollectionBDClient.getListeSerie()) {
            if(serie.getId()==id){
                return serie;
            }
        }
        return null;
    }

}
