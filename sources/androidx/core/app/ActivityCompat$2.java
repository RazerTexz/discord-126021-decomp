package androidx.core.app;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public class ActivityCompat$2 implements Runnable {
    public final /* synthetic */ Activity val$activity;

    public ActivityCompat$2(Activity activity) {
        this.val$activity = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.val$activity.isFinishing() || ActivityRecreator.recreate(this.val$activity)) {
            return;
        }
        this.val$activity.recreate();
    }
}
