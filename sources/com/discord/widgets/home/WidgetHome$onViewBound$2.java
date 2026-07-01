package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNux$NuxState;
import com.discord.widgets.tabs.WidgetTabsHost;
import d0.z.d.a0;
import j0.k.b;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$onViewBound$2<T, R> implements b<StoreNux$NuxState, Boolean> {
    public final /* synthetic */ WidgetHome this$0;

    public WidgetHome$onViewBound$2(WidgetHome widgetHome) {
        this.this$0 = widgetHome;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(StoreNux$NuxState storeNux$NuxState) {
        return call2(storeNux$NuxState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreNux$NuxState storeNux$NuxState) {
        FragmentActivity activity = this.this$0.getActivity();
        if (!(activity instanceof AppActivity)) {
            activity = null;
        }
        AppActivity appActivity = (AppActivity) activity;
        return Boolean.valueOf(appActivity != null && appActivity.h(a0.getOrCreateKotlinClass(WidgetTabsHost.class)));
    }
}
