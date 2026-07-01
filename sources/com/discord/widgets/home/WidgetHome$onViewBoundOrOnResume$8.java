package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreNux$NuxState;
import j0.k.b;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$onViewBoundOrOnResume$8<T, R> implements b<StoreNux$NuxState, Boolean> {
    public static final WidgetHome$onViewBoundOrOnResume$8 INSTANCE = new WidgetHome$onViewBoundOrOnResume$8();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(StoreNux$NuxState storeNux$NuxState) {
        return call2(storeNux$NuxState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreNux$NuxState storeNux$NuxState) {
        return Boolean.valueOf(storeNux$NuxState.getFirstOpen());
    }
}
