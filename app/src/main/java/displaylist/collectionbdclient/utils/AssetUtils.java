package displaylist.collectionbdclient.utils;

import android.app.Activity;
import android.content.res.AssetManager;
import android.net.Uri;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by b.bassac on 21/03/2016.
 */
public class AssetUtils {

    private static AssetUtils instance;
    private AssetManager am;

    private AssetUtils(Activity activity) {
        this.am = activity.getAssets();
    }

    public static synchronized AssetUtils instance(Activity activity) {
        if (instance == null) {
            instance = new AssetUtils(activity);
        }
        return instance;
    }


    public boolean checkAssetExists(String path) {
        boolean bAssetOk = false;
        InputStream f = null;
        try {
            f = am.open(path.replace("file:///android_asset/",""));
            bAssetOk=true;
            f.close();
        } catch (IOException e) {
            // Do nothing
        }
        return bAssetOk;
    }
}
