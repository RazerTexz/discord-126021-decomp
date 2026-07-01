package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$call$2$1<T, R> implements b<Integer, Observable<? extends Boolean>> {
    public final /* synthetic */ StoreCalls$call$2 this$0;

    public StoreCalls$call$2$1(StoreCalls$call$2 storeCalls$call$2) {
        this.this$0 = storeCalls$call$2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Integer num) {
        return call2(num);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Boolean> call2(Integer num) {
        return (num != null && num.intValue() == 1) ? new k(Boolean.TRUE) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().call(this.this$0.$channelId), false, 1, null).G(StoreCalls$call$2$1$1.INSTANCE);
    }
}
