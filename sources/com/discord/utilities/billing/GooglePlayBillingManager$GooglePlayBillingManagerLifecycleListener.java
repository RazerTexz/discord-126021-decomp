package com.discord.utilities.billing;

import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.j;
import com.discord.app.AppActivity;
import com.discord.utilities.rx.ActivityLifecycleCallbacks;
import d0.z.d.m;

/* JADX INFO: compiled from: GooglePlayBillingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayBillingManager$GooglePlayBillingManagerLifecycleListener extends ActivityLifecycleCallbacks {
    @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
    public void onActivityCreated(AppActivity activity, Bundle savedInstanceState) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        super.onActivityCreated(activity, savedInstanceState);
        j jVar = j.g;
        if (activity.g(j.f)) {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            if (GooglePlayBillingManager.access$isAuthenticated$p(googlePlayBillingManager)) {
                googlePlayBillingManager.onActivityCreated();
            }
        }
    }

    @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
    public void onActivityDestroyed(AppActivity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        super.onActivityDestroyed(activity);
        j jVar = j.g;
        if (activity.g(j.f)) {
            GooglePlayBillingManager.INSTANCE.onActivityDestroyed();
        }
    }

    @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
    public void onActivityResumed(AppActivity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        super.onActivityResumed(activity);
        j jVar = j.g;
        if (activity.g(j.f)) {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            if (GooglePlayBillingManager.access$isAuthenticated$p(googlePlayBillingManager)) {
                googlePlayBillingManager.queryPurchases();
            }
        }
    }
}
