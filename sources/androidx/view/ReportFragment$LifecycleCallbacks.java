package androidx.view;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public class ReportFragment$LifecycleCallbacks implements Application$ActivityLifecycleCallbacks {
    public static void registerIn(Activity activity) {
        activity.registerActivityLifecycleCallbacks(new ReportFragment$LifecycleCallbacks());
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        ReportFragment.dispatch(activity, Lifecycle$Event.ON_CREATE);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NonNull Activity activity) {
        ReportFragment.dispatch(activity, Lifecycle$Event.ON_RESUME);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPostStarted(@NonNull Activity activity) {
        ReportFragment.dispatch(activity, Lifecycle$Event.ON_START);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(@NonNull Activity activity) {
        ReportFragment.dispatch(activity, Lifecycle$Event.ON_DESTROY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPrePaused(@NonNull Activity activity) {
        ReportFragment.dispatch(activity, Lifecycle$Event.ON_PAUSE);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPreStopped(@NonNull Activity activity) {
        ReportFragment.dispatch(activity, Lifecycle$Event.ON_STOP);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }
}
