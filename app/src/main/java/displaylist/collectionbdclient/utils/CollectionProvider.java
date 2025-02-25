package displaylist.collectionbdclient.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;

import com.github.kevinsawicki.http.HttpRequest;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import displaylist.collectionbdclient.bean.Bd;
import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.ManageListItem;
import displaylist.collectionbdclient.bean.Serie;

/**
 * Created by b.bassac on 29/12/2014.
 */
public class CollectionProvider {
    static SimpleChronometer chrono = new SimpleChronometer();

    static public Collection getEntireCollection(Activity activity) {

           // Getting JSON from URL
           String stringJson = null;
           Collection listBD = null;
           try {
               if(isOnline(activity)) {
                   chrono.start();
                   stringJson = WSProvider.getJSONFromUrl(getCollectionServerUrl(activity) + "/collection");
                   chrono.stop();
               }else {
                   throw new CustomException("Not connected");
               }
               ToastUtils.display(activity, "Data loaded in " + chrono.getDuration() + " ms");
               final ObjectMapper mapper = new ObjectMapper();
               final JsonFactory factory = mapper.getJsonFactory();
               JsonParser jp = factory.createJsonParser(new ByteArrayInputStream(stringJson.getBytes(StandardCharsets.UTF_8)));
               //Jacksonize to bean
               listBD = mapper.readValue(jp, Collection.class);
               populateFakeIds(listBD);
           } catch (Exception e) {
               ToastUtils.display(activity, e.getMessage());
           }
           return listBD;

    }

    private static void populateFakeIds(Collection listBD) {
        long i = 0;
        for (Serie s:listBD.getListeSerie() ) {
            s.setId(i++);
            for (Bd bd : s.getListPossede()){
                bd.setId(i++);
            }
            for (Bd bd : s.getListManquante()){
                bd.setId(i++);
            }
        }
    }

    static public boolean isOnline(Activity activity) {
        ConnectivityManager cm =
                (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    private static String getCollectionServerUrl(Activity activity) {
        return PreferenceManager.getDefaultSharedPreferences(activity).getString("collectionServerUrl", null);
    }


    private static class WSProvider {

        public static String getJSONFromUrl(String url) throws CustomException {
            // defaultHttpClient
            HttpRequest httpRequest = HttpRequest.get(url).basic("bruno","bruno");
            // return JSON String
            return httpRequest.body();

        }
    }
}
