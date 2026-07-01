package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.home.WidgetHome;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$init$3<T, R> implements b<StoreAnalytics$ScreenViewed, Observable<? extends StoreAnalytics$ScreenViewed>> {
    public static final StoreAnalytics$init$3 INSTANCE = new StoreAnalytics$init$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends StoreAnalytics$ScreenViewed> call(StoreAnalytics$ScreenViewed storeAnalytics$ScreenViewed) {
        return call2(storeAnalytics$ScreenViewed);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StoreAnalytics$ScreenViewed> call2(StoreAnalytics$ScreenViewed storeAnalytics$ScreenViewed) {
        return m.areEqual(storeAnalytics$ScreenViewed.getScreen(), WidgetHome.class) ? Observable.d0(2L, TimeUnit.SECONDS).G(new StoreAnalytics$init$3$1(storeAnalytics$ScreenViewed)) : new k(storeAnalytics$ScreenViewed);
    }
}
