package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.query.node.QueryNode;
import d0.t.n;
import j0.k.b;
import j0.l.e.k;
import java.util.Collection;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: StoreSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearch$getHistory$1<T, R> implements b<StoreSearch$SearchTarget, Observable<? extends Collection<? extends List<? extends QueryNode>>>> {
    public final /* synthetic */ StoreSearch this$0;

    public StoreSearch$getHistory$1(StoreSearch storeSearch) {
        this.this$0 = storeSearch;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Collection<? extends List<? extends QueryNode>>> call(StoreSearch$SearchTarget storeSearch$SearchTarget) {
        return call2(storeSearch$SearchTarget);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Collection<List<QueryNode>>> call2(StoreSearch$SearchTarget storeSearch$SearchTarget) {
        return storeSearch$SearchTarget != null ? StoreSearch.access$getHistoryCache$p(this.this$0).getHistory(storeSearch$SearchTarget) : new k(n.emptyList());
    }
}
