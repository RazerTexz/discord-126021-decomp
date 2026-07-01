package androidx.core.app;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityRecreator$LifecycleCheckCallbacks implements Application$ActivityLifecycleCallbacks {
    public Object currentlyRecreatingToken;
    private Activity mActivity;
    private final int mRecreatingHashCode;
    private boolean mStarted = false;
    private boolean mDestroyed = false;
    private boolean mStopQueued = false;

    public ActivityRecreator$LifecycleCheckCallbacks(@NonNull Activity activity) {
        this.mActivity = activity;
        this.mRecreatingHashCode = activity.hashCode();
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.mActivity == activity) {
            this.mActivity = null;
            this.mDestroyed = true;
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (!this.mDestroyed || this.mStopQueued || this.mStarted || !ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, activity)) {
            return;
        }
        this.mStopQueued = true;
        this.currentlyRecreatingToken = null;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.mActivity == activity) {
            this.mStarted = true;
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
