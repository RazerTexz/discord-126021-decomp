package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;

/* JADX INFO: loaded from: classes.dex */
public enum RoomDatabase$JournalMode {
    AUTOMATIC,
    TRUNCATE,
    WRITE_AHEAD_LOGGING;

    private static boolean isLowRamDevice(@NonNull ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    @SuppressLint({"NewApi"})
    public RoomDatabase$JournalMode resolve(Context context) {
        if (this != AUTOMATIC) {
            return this;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        return (activityManager == null || isLowRamDevice(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
    }
}
