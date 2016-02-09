package displaylist.collectionbdclient.utils;

import android.app.Activity;

import com.github.kevinsawicki.http.HttpRequest;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayInputStream;

import displaylist.collectionbdclient.R;
import displaylist.collectionbdclient.bean.Collection;

/**
 * Created by b.bassac on 29/12/2014.
 */
public class CollectionProvider {

    static public Collection getEntireCollection(Activity activity) {
        // Getting JSON from URL
        String stringJson = null;
        Collection listBD = null;
        try {
            stringJson = WSProvider.getJSONFromUrl(activity, activity.getString(R.string.url));
            JsonParser jp = new JsonFactory().createJsonParser(new ByteArrayInputStream(stringJson.getBytes("UTF-8")));
            //Jacksonize to bean
            listBD = new ObjectMapper().readValue(jp, Collection.class);
        } catch (Exception e) {
            ToastUtils.display(activity, e.getMessage());
        }
        if (stringJson != null && listBD != null) {
            FileUtils.saveContent(activity, stringJson);
            //FOR TEST
            FileUtils.saveContentToFile(activity, listBD.toString(), FileUtils.UPDATED_JSON);
            return listBD;
        } else {
            return new Collection();
        }
    }

    private static class WSProvider {


        public static String getJSONFromUrl(Activity activity, String url) throws CustomException {
            String json;
            // defaultHttpClient
            try {
                json = HttpRequest.get(url).body();

                if (json != null && json.contains("listeSerie")) {
                    FileUtils.saveContent(activity, json);
                }
            } catch (HttpRequest.HttpRequestException e) {
            }
            json = FileUtils.loadFile(activity);
            // return JSON String
            return json;

        }


    }
}
