package com.discord.utilities.p501rx;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import java.lang.ref.WeakReference;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityLifecycleCallbacks.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private WeakReference<AppActivity> onActivityCreatedInvoked;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityCreated((AppActivity) activity, savedInstanceState);
        }
    }

    public void onActivityCreatedOrResumed(AppActivity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityDestroyed((AppActivity) activity);
        }
    }

    public void onActivityDestroyed(AppActivity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityPaused((AppActivity) activity);
        }
    }

    public void onActivityPaused(AppActivity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityResumed((AppActivity) activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(outState, "outState");
        if (activity instanceof AppActivity) {
            onActivitySaveInstanceState((AppActivity) activity, outState);
        }
    }

    public void onActivitySaveInstanceState(AppActivity activity, Bundle outState) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityStarted((AppActivity) activity);
        }
    }

    public void onActivityStarted(AppActivity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (activity instanceof AppActivity) {
            onActivityStopped((AppActivity) activity);
        }
    }

    public void onActivityStopped(AppActivity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    public void onActivityCreated(AppActivity activity, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.onActivityCreatedInvoked = new WeakReference<>(activity);
        onActivityCreatedOrResumed(activity);
    }

    public void onActivityResumed(AppActivity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        WeakReference<AppActivity> weakReference = this.onActivityCreatedInvoked;
        if (C12238m.areEqual(weakReference != null ? weakReference.get() : null, activity)) {
            this.onActivityCreatedInvoked = null;
        } else {
            onActivityCreatedOrResumed(activity);
        }
    }
}
