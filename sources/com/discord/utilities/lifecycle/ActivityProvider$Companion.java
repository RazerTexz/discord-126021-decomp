package com.discord.utilities.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.MainThread;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ActivityProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActivityProvider$Companion {
    private ActivityProvider$Companion() {
    }

    @MainThread
    public final Activity getActivity() {
        ActivityProvider activityProviderAccess$getINSTANCE$cp = ActivityProvider.access$getINSTANCE$cp();
        if (activityProviderAccess$getINSTANCE$cp == null) {
            m.throwUninitializedPropertyAccessException("INSTANCE");
        }
        return activityProviderAccess$getINSTANCE$cp.getCurrentActivity();
    }

    public final void init(Application application) {
        m.checkNotNullParameter(application, "application");
        ActivityProvider.access$setINSTANCE$cp(new ActivityProvider());
        ActivityProvider activityProviderAccess$getINSTANCE$cp = ActivityProvider.access$getINSTANCE$cp();
        if (activityProviderAccess$getINSTANCE$cp == null) {
            m.throwUninitializedPropertyAccessException("INSTANCE");
        }
        application.registerActivityLifecycleCallbacks(activityProviderAccess$getINSTANCE$cp);
    }

    public /* synthetic */ ActivityProvider$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
