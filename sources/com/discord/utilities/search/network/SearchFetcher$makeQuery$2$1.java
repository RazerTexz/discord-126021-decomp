package com.discord.utilities.search.network;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: SearchFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchFetcher$makeQuery$2$1<T, R> implements b<Void, Observable<? extends Long>> {
    public final /* synthetic */ SearchFetcher$makeQuery$2 this$0;

    public SearchFetcher$makeQuery$2$1(SearchFetcher$makeQuery$2 searchFetcher$makeQuery$2) {
        this.this$0 = searchFetcher$makeQuery$2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(Void r1) {
        return call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(Void r3) {
        return Observable.d0(this.this$0.$resubscribeDelayMillis.get(), TimeUnit.MILLISECONDS);
    }
}
