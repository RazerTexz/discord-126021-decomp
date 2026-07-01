package com.discord.utilities.search.network;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelSearchResponse;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: SearchFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchFetcher$makeQuery$3<T, R> implements b<ModelSearchResponse, Boolean> {
    public final /* synthetic */ SearchFetcher this$0;

    public SearchFetcher$makeQuery$3(SearchFetcher searchFetcher) {
        this.this$0 = searchFetcher;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(ModelSearchResponse modelSearchResponse) {
        return call2(modelSearchResponse);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(ModelSearchResponse modelSearchResponse) {
        SearchFetcher searchFetcher = this.this$0;
        m.checkNotNullExpressionValue(modelSearchResponse, "it");
        return Boolean.valueOf(!SearchFetcher.access$isIndexing(searchFetcher, modelSearchResponse));
    }
}
