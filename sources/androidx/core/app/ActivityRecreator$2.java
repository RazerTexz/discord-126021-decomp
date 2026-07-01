package androidx.core.app;

import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class ActivityRecreator$2 implements Runnable {
    public final /* synthetic */ Application val$application;
    public final /* synthetic */ ActivityRecreator$LifecycleCheckCallbacks val$callbacks;

    public ActivityRecreator$2(Application application, ActivityRecreator$LifecycleCheckCallbacks activityRecreator$LifecycleCheckCallbacks) {
        this.val$application = application;
        this.val$callbacks = activityRecreator$LifecycleCheckCallbacks;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$application.unregisterActivityLifecycleCallbacks(this.val$callbacks);
    }
}
