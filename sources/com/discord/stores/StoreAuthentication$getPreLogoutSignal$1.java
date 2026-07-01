package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$getPreLogoutSignal$1<T, R> implements b<Boolean, Boolean> {
    public static final StoreAuthentication$getPreLogoutSignal$1 INSTANCE = new StoreAuthentication$getPreLogoutSignal$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool) {
        return Boolean.valueOf(!bool.booleanValue());
    }
}
