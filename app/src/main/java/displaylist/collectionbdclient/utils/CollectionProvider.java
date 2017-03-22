package displaylist.collectionbdclient.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.util.Log;

import com.github.kevinsawicki.http.HttpRequest;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import displaylist.collectionbdclient.bean.Collection;
import displaylist.collectionbdclient.bean.ManageListItem;

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
                   chrono.start();
                   stringJson= new MockDemo().getMockDemo();
                   chrono.stop();
               }
               ToastUtils.display(activity, "Data loaded in " + chrono.getDuration() + " ms");
               final ObjectMapper mapper = new ObjectMapper();
               final JsonFactory factory = mapper.getJsonFactory();
               JsonParser jp = factory.createJsonParser(new ByteArrayInputStream(stringJson.getBytes("UTF-8")));
               //Jacksonize to bean
               listBD = mapper.readValue(jp, Collection.class);
           } catch (Exception e) {
               ToastUtils.display(activity, e.getMessage());
           }
           return listBD;

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

    static public void setBDAsPossede(Activity activity,Long bdId){
        WSProvider.postJSONFromUrl(getCollectionServerUrl(activity) +"/switch/"+bdId);
    }

    public static List<ManageListItem> getListManquante(Activity activity) {
        // Getting JSON from URL
        String stringJson = null;
        List<ManageListItem> listBD = null;
        try {
            chrono.start();
            stringJson = WSProvider.getJSONFromUrl(getCollectionServerUrl(activity) +"/bds/manquantes");
            chrono.stop();
            ToastUtils.display(activity,"Data loaded in "+chrono.getDuration()+" ms");
            JsonParser jp = new JsonFactory().createJsonParser(new ByteArrayInputStream(stringJson.getBytes("UTF-8")));
            //Jacksonize to bean

            ObjectMapper objectMapper = new ObjectMapper();
            listBD = objectMapper.readValue(jp, objectMapper.getTypeFactory().constructCollectionType(List.class, ManageListItem.class));
        } catch (Exception e) {
            ToastUtils.display(activity, e.getMessage());
            listBD = new ArrayList<>();
        }
       return listBD;
    }

    private static class WSProvider {

        public static String getJSONFromUrl(String url) throws CustomException {
            // defaultHttpClient
            HttpRequest httpRequest = HttpRequest.get(url).basic("bruno","bruno");
            // return JSON String
            return httpRequest.body();

        }


        public static void postJSONFromUrl(String s) {
                HttpRequest.post(s).basic("bruno","bruno").accept("text/plain; charset=utf-8").code();
        }
    }
}
