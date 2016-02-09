package displaylist.collectionbdclient.utils;

import java.util.Collections;
import java.util.Comparator;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.bean.Bd;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.Serie;

/**
 * Created by b.bassac on 21/05/2015.
 */
public class SerieUtils {

    private static Comparator<Bd> bdComparator = new Comparator<Bd>() {
        @Override
        public int compare(Bd b1, Bd b2) {
            return compareString(b1.getNumero(), b2.getNumero());
        }

        private final boolean isDigit(char ch) {
            return ch >= 48 && ch <= 57;
        }

        /** Length of string is passed in for improved efficiency (only need to calculate it once) **/
        private final String getChunk(String s, int slength, int marker) {
            StringBuilder chunk = new StringBuilder();
            char c = s.charAt(marker);
            chunk.append(c);
            marker++;
            if (isDigit(c)) {
                while (marker < slength) {
                    c = s.charAt(marker);
                    if (!isDigit(c))
                        break;
                    chunk.append(c);
                    marker++;
                }
            } else {
                while (marker < slength) {
                    c = s.charAt(marker);
                    if (isDigit(c))
                        break;
                    chunk.append(c);
                    marker++;
                }
            }
            return chunk.toString();
        }

        public int compareString(Object o1, Object o2) {
            if (!(o1 instanceof String) || !(o2 instanceof String)) {
                return 0;
            }
            String s1 = (String) o1;
            String s2 = (String) o2;

            int thisMarker = 0;
            int thatMarker = 0;
            int s1Length = s1.length();
            int s2Length = s2.length();

            while (thisMarker < s1Length && thatMarker < s2Length) {
                String thisChunk = getChunk(s1, s1Length, thisMarker);
                thisMarker += thisChunk.length();

                String thatChunk = getChunk(s2, s2Length, thatMarker);
                thatMarker += thatChunk.length();

                // If both chunks contain numeric characters, sort them numerically
                int result = 0;
                if (isDigit(thisChunk.charAt(0)) && isDigit(thatChunk.charAt(0))) {
                    // Simple chunk comparison by length.
                    int thisChunkLength = thisChunk.length();
                    result = thisChunkLength - thatChunk.length();
                    // If equal, the first different number counts
                    if (result == 0) {
                        for (int i = 0; i < thisChunkLength; i++) {
                            result = thisChunk.charAt(i) - thatChunk.charAt(i);
                            if (result != 0) {
                                return result;
                            }
                        }
                    }
                } else {
                    result = thisChunk.compareTo(thatChunk);
                }

                if (result != 0)
                    return result;
            }

            return s1Length - s2Length;
        }
    };

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
