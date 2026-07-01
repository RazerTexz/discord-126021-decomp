package androidx.core.app;

/* JADX INFO: loaded from: classes.dex */
public class ActivityRecreator$1 implements Runnable {
    public final /* synthetic */ ActivityRecreator$LifecycleCheckCallbacks val$callbacks;
    public final /* synthetic */ Object val$token;

    public ActivityRecreator$1(ActivityRecreator$LifecycleCheckCallbacks activityRecreator$LifecycleCheckCallbacks, Object obj) {
        this.val$callbacks = activityRecreator$LifecycleCheckCallbacks;
        this.val$token = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$callbacks.currentlyRecreatingToken = this.val$token;
    }
}
