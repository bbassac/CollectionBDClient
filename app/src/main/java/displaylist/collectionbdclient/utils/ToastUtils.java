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
    public static SuperActivityToast create(Activity activity,String message){
        SuperActivityToast superActivityToast = new SuperActivityToast(activity, SuperToast.Type.PROGRESS);
        superActivityToast.setText(message);
        superActivityToast.setBackground(SuperToast.Background.GREEN);
        superActivityToast.setTextColor(SuperToast.Background.BLACK);
        superActivityToast.setIndeterminate(true);
        superActivityToast.setProgressIndeterminate(true);
        superActivityToast.setDuration(SuperToast.Duration.SHORT);
        superActivityToast.show();
        return superActivityToast;
    }


}
