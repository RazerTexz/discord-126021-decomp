package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGooglePlayPurchases$doDowngrade$1 extends k implements Function1<Throwable, Boolean> {
    public StoreGooglePlayPurchases$doDowngrade$1(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        super(1, storeGooglePlayPurchases, StoreGooglePlayPurchases.class, "shouldRetryDowngrade", "shouldRetryDowngrade(Ljava/lang/Throwable;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
        return Boolean.valueOf(invoke2(th));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Throwable th) {
        m.checkNotNullParameter(th, "p1");
        return StoreGooglePlayPurchases.access$shouldRetryDowngrade((StoreGooglePlayPurchases) this.receiver, th);
    }
}
