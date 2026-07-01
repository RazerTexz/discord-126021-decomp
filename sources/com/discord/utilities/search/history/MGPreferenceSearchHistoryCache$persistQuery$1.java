package com.discord.utilities.search.history;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSearch$SearchTarget;
import d0.z.d.m;
import j0.k.b;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGPreferenceSearchHistoryCache$persistQuery$1<T, R> implements b<LinkedList<MGPreferenceSearchHistoryCache$TargetHistory>, LinkedList<MGPreferenceSearchHistoryCache$TargetHistory>> {
    public final /* synthetic */ List $query;
    public final /* synthetic */ StoreSearch$SearchTarget $searchTarget;
    public final /* synthetic */ MGPreferenceSearchHistoryCache this$0;

    public MGPreferenceSearchHistoryCache$persistQuery$1(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, StoreSearch$SearchTarget storeSearch$SearchTarget, List list) {
        this.this$0 = mGPreferenceSearchHistoryCache;
        this.$searchTarget = storeSearch$SearchTarget;
        this.$query = list;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> call(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList) {
        return call2(linkedList);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> call2(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList) {
        MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = this.this$0;
        m.checkNotNullExpressionValue(linkedList, "it");
        return MGPreferenceSearchHistoryCache.access$putAndCopy(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget, this.$query);
    }
}
