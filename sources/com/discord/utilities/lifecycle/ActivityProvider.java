package com.discord.utilities.lifecycle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import d0.z.d.m;

/* JADX INFO: compiled from: ActivityProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActivityProvider implements Application$ActivityLifecycleCallbacks {
    public static final ActivityProvider$Companion Companion = new ActivityProvider$Companion(null);

    @SuppressLint({"StaticFieldLeak"})
    private static ActivityProvider INSTANCE;
    private Activity currentActivity;

    public static final /* synthetic */ Activity access$getCurrentActivity$p(ActivityProvider activityProvider) {
        return activityProvider.currentActivity;
    }

    public static final /* synthetic */ ActivityProvider access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ void access$setCurrentActivity$p(ActivityProvider activityProvider, Activity activity) {
        activityProvider.currentActivity = activity;
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(ActivityProvider activityProvider) {
        INSTANCE = activityProvider;
    }

    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.currentActivity = activity;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        int iHashCode = activity.hashCode();
        Activity activity2 = this.currentActivity;
        if (activity2 == null || iHashCode != activity2.hashCode()) {
            return;
        }
        this.currentActivity = null;
    }
}
