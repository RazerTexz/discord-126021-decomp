package com.discord.utilities.search.network;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;

/* JADX INFO: compiled from: SearchFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchFetcher$makeQuery$2<T, R> implements b<Observable<? extends Void>, Observable<?>> {
    public final /* synthetic */ AtomicLong $resubscribeDelayMillis;

    public SearchFetcher$makeQuery$2(AtomicLong atomicLong) {
        this.$resubscribeDelayMillis = atomicLong;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<?> call(Observable<? extends Void> observable) {
        return call2(observable);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<?> call2(Observable<? extends Void> observable) {
        return observable.A(new SearchFetcher$makeQuery$2$1(this));
    }
}
