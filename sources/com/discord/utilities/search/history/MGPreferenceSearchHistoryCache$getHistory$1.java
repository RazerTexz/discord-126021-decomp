package com.discord.utilities.search.history;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSearch$SearchTarget;
import com.discord.utilities.search.query.node.QueryNode;
import d0.z.d.m;
import j0.k.b;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGPreferenceSearchHistoryCache$getHistory$1<T, R> implements b<LinkedList<MGPreferenceSearchHistoryCache$TargetHistory>, Collection<? extends List<? extends QueryNode>>> {
    public final /* synthetic */ StoreSearch$SearchTarget $searchTarget;
    public final /* synthetic */ MGPreferenceSearchHistoryCache this$0;

    public MGPreferenceSearchHistoryCache$getHistory$1(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, StoreSearch$SearchTarget storeSearch$SearchTarget) {
        this.this$0 = mGPreferenceSearchHistoryCache;
        this.$searchTarget = storeSearch$SearchTarget;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Collection<? extends List<? extends QueryNode>> call(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList) {
        return call2(linkedList);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Collection<List<QueryNode>> call2(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList) {
        MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = this.this$0;
        m.checkNotNullExpressionValue(linkedList, "it");
        return MGPreferenceSearchHistoryCache.access$find(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget);
    }
}
