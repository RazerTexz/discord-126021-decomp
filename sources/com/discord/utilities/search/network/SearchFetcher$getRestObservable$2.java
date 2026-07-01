package com.discord.utilities.search.network;

import androidx.core.app.NotificationCompat;
import j0.l.e.k;
import rx.Observable;
import rx.functions.Func0;

/* JADX INFO: compiled from: SearchFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchFetcher$getRestObservable$2<R> implements Func0<Observable<Integer>> {
    public final /* synthetic */ SearchFetcher this$0;

    public SearchFetcher$getRestObservable$2(SearchFetcher searchFetcher) {
        this.this$0 = searchFetcher;
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // rx.functions.Func0, java.util.concurrent.Callable
    public final Observable<Integer> call() {
        return new k(SearchFetcher$getRestObservable$1.INSTANCE.invoke2(SearchFetcher.access$getIndexingRetryCount$p(this.this$0)));
    }
}
