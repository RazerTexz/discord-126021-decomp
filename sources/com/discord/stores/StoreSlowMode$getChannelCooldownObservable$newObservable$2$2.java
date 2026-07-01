package com.discord.stores;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import j0.l.a.i2;
import j0.l.a.r;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode$getChannelCooldownObservable$newObservable$2$2<T, R> implements b<Long, Observable<? extends Long>> {
    public final /* synthetic */ StoreSlowMode$getChannelCooldownObservable$newObservable$2 this$0;

    public StoreSlowMode$getChannelCooldownObservable$newObservable$2$2(StoreSlowMode$getChannelCooldownObservable$newObservable$2 storeSlowMode$getChannelCooldownObservable$newObservable$2) {
        this.this$0 = storeSlowMode$getChannelCooldownObservable$newObservable$2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(Long l) {
        long jCurrentTimeMillis = StoreSlowMode.access$getClock$p(this.this$0.this$0).currentTimeMillis();
        if (l == null || l.longValue() <= jCurrentTimeMillis) {
            return new k(0L);
        }
        Observable<R> observableG = Observable.E(0L, 1L, TimeUnit.SECONDS).G(new StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$1(l, jCurrentTimeMillis));
        return Observable.h0(new r(observableG.j, new i2(StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$2.INSTANCE)));
    }
}
