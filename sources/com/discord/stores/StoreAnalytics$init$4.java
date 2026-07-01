package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreAnalytics$init$4 extends k implements Function1<StoreAnalytics$ScreenViewed, Unit> {
    public StoreAnalytics$init$4(StoreAnalytics storeAnalytics) {
        super(1, storeAnalytics, StoreAnalytics.class, "onScreenViewed", "onScreenViewed(Lcom/discord/stores/StoreAnalytics$ScreenViewed;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreAnalytics$ScreenViewed storeAnalytics$ScreenViewed) {
        invoke2(storeAnalytics$ScreenViewed);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreAnalytics$ScreenViewed storeAnalytics$ScreenViewed) {
        m.checkNotNullParameter(storeAnalytics$ScreenViewed, "p1");
        StoreAnalytics.access$onScreenViewed((StoreAnalytics) this.receiver, storeAnalytics$ScreenViewed);
    }
}
