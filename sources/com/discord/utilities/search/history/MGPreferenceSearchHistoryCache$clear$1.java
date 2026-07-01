package com.discord.utilities.search.history;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSearch$SearchTarget;
import d0.z.d.m;
import j0.k.b;
import java.util.LinkedList;

/* JADX INFO: compiled from: MGPreferenceSearchHistoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGPreferenceSearchHistoryCache$clear$1<T, R> implements b<LinkedList<MGPreferenceSearchHistoryCache$TargetHistory>, LinkedList<MGPreferenceSearchHistoryCache$TargetHistory>> {
    public final /* synthetic */ StoreSearch$SearchTarget $searchTarget;
    public final /* synthetic */ MGPreferenceSearchHistoryCache this$0;

    public MGPreferenceSearchHistoryCache$clear$1(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, StoreSearch$SearchTarget storeSearch$SearchTarget) {
        this.this$0 = mGPreferenceSearchHistoryCache;
        this.$searchTarget = storeSearch$SearchTarget;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> call(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList) {
        return call2(linkedList);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> call2(LinkedList<MGPreferenceSearchHistoryCache$TargetHistory> linkedList) {
        MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = this.this$0;
        m.checkNotNullExpressionValue(linkedList, "it");
        return MGPreferenceSearchHistoryCache.access$removeAndCopy(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget);
    }
}
