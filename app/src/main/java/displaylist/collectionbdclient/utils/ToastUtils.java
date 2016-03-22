package displaylist.collectionbdclient.utils;

import android.app.Activity;

import com.github.johnpersano.supertoasts.SuperActivityToast;
import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

public class ToastUtils {

    public static void display(Activity activity, String content) {
        SuperActivityToast.create(activity, content, SuperToast.Duration.LONG, Style.getStyle(Style.GREEN, SuperToast.Animations.FLYIN)).show();
    }

    public static void display(Activity activity, String content,int duration) {
        SuperActivityToast.create(activity, content, duration, Style.getStyle(Style.GREEN, SuperToast.Animations.FLYIN)).show();
    }

}
