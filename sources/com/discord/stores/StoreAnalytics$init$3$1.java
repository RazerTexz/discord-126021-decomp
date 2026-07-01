package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$init$3$1<T, R> implements b<Long, StoreAnalytics$ScreenViewed> {
    public final /* synthetic */ StoreAnalytics$ScreenViewed $screenViewed;

    public StoreAnalytics$init$3$1(StoreAnalytics$ScreenViewed storeAnalytics$ScreenViewed) {
        this.$screenViewed = storeAnalytics$ScreenViewed;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ StoreAnalytics$ScreenViewed call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreAnalytics$ScreenViewed call2(Long l) {
        return this.$screenViewed;
    }
}
