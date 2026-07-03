package com.discord.utilities.lifecycle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ActivityProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActivityProvider implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SuppressLint({"StaticFieldLeak"})
    private static ActivityProvider INSTANCE;
    private Activity currentActivity;

    /* JADX INFO: compiled from: ActivityProvider.kt */
    public static final class Companion {
        private Companion() {
        }

        @MainThread
        public final Activity getActivity() {
            ActivityProvider activityProvider = ActivityProvider.INSTANCE;
            if (activityProvider == null) {
                C12238m.throwUninitializedPropertyAccessException("INSTANCE");
            }
            return activityProvider.getCurrentActivity();
        }

        public final void init(Application application) {
            C12238m.checkNotNullParameter(application, "application");
            ActivityProvider.INSTANCE = new ActivityProvider();
            ActivityProvider activityProvider = ActivityProvider.INSTANCE;
            if (activityProvider == null) {
                C12238m.throwUninitializedPropertyAccessException("INSTANCE");
            }
            application.registerActivityLifecycleCallbacks(activityProvider);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.currentActivity = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        int iHashCode = activity.hashCode();
        Activity activity2 = this.currentActivity;
        if (activity2 == null || iHashCode != activity2.hashCode()) {
            return;
        }
        this.currentActivity = null;
    }
}
