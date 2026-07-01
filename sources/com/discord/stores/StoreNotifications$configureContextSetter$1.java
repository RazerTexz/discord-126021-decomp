package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.utilities.rx.ActivityLifecycleCallbacks;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNotifications$configureContextSetter$1 extends ActivityLifecycleCallbacks {
    public final /* synthetic */ StoreNotifications this$0;

    public StoreNotifications$configureContextSetter$1(StoreNotifications storeNotifications) {
        this.this$0 = storeNotifications;
    }

    @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
    public void onActivityCreatedOrResumed(AppActivity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        super.onActivityCreatedOrResumed(activity);
        StoreNotifications.access$setContext$p(this.this$0, activity);
    }

    @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
    public void onActivityDestroyed(AppActivity activity) {
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        super.onActivityDestroyed(activity);
        StoreNotifications.access$setContext$p(this.this$0, null);
    }
}
