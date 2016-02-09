package displaylist.collectionbdclient.utils;

import android.os.SystemClock;

/**
 * Created by b.bassac on 21/05/2015.
 */
public class SimpleChronometer {
    private Long startTime;
    private Long duration;

    public void start() {
        startTime = SystemClock.currentThreadTimeMillis();
    }

    public void stop() {
        duration = SystemClock.currentThreadTimeMillis() - startTime;
    }

    public Long getDuration() {
        return duration;
    }
}
