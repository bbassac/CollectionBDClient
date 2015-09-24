package displaylist.collectionbdclient.utils;

import android.app.Activity;

import com.github.johnpersano.supertoasts.SuperActivityToast;
import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

/**
 * Created by b.bassac on 21/05/2015.
 */
public class ToastUtils {

    public static void display(Activity activity,String content) {
        SuperActivityToast.create(activity,content,SuperToast.Duration.LONG,Style.getStyle(Style.GREEN,SuperToast.Animations.FLYIN)).show();
    }

}
