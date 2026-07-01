package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.RestAPI;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: StoreClientVersion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreClientVersion$init$1<T, R> implements b<Long, Observable<? extends Integer>> {
    public static final StoreClientVersion$init$1 INSTANCE = new StoreClientVersion$init$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Integer> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Integer> call2(Long l) {
        return RestAPI.Companion.getApi().getClientVersion();
    }
}
