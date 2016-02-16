package displaylist.collectionbdclient.utils;

import java.util.Collections;
import java.util.Comparator;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.bean.Bd;
import displaylist.collectionbdclient.bean.Collection;
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

}
