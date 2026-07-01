package com.discord.utilities.rx;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ActivityLifecycleCallbacks.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private WeakReference<AppActivity> onActivityCreatedInvoked;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityCreated((AppActivity) activity, savedInstanceState);
        }
    }

    public void onActivityCreatedOrResumed(AppActivity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityDestroyed((AppActivity) activity);
        }
    }

    public void onActivityDestroyed(AppActivity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityPaused((AppActivity) activity);
        }
    }

    public void onActivityPaused(AppActivity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityResumed((AppActivity) activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(outState, "outState");
        if (activity instanceof AppActivity) {
            onActivitySaveInstanceState((AppActivity) activity, outState);
        }
    }

    public void onActivitySaveInstanceState(AppActivity activity, Bundle outState) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityStarted((AppActivity) activity);
        }
    }

    public void onActivityStarted(AppActivity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityStopped((AppActivity) activity);
        }
    }

    public void onActivityStopped(AppActivity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    public void onActivityCreated(AppActivity activity, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.onActivityCreatedInvoked = new WeakReference<>(activity);
        onActivityCreatedOrResumed(activity);
    }

    public void onActivityResumed(AppActivity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        WeakReference<AppActivity> weakReference = this.onActivityCreatedInvoked;
        if (Intrinsics3.areEqual(weakReference != null ? weakReference.get() : null, activity)) {
            this.onActivityCreatedInvoked = null;
        } else {
            onActivityCreatedOrResumed(activity);
        }
    }
}
