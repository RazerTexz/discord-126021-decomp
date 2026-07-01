package com.discord.utilities.search.network;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelSearchResponse;
import d0.z.d.m;
import java.util.concurrent.atomic.AtomicLong;
import rx.functions.Action1;

/* JADX INFO: compiled from: SearchFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SearchFetcher$makeQuery$1<T> implements Action1<ModelSearchResponse> {
    public final /* synthetic */ AtomicLong $resubscribeDelayMillis;
    public final /* synthetic */ SearchFetcher this$0;

    public SearchFetcher$makeQuery$1(SearchFetcher searchFetcher, AtomicLong atomicLong) {
        this.this$0 = searchFetcher;
        this.$resubscribeDelayMillis = atomicLong;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(ModelSearchResponse modelSearchResponse) {
        call2(modelSearchResponse);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(ModelSearchResponse modelSearchResponse) {
        SearchFetcher searchFetcher = this.this$0;
        m.checkNotNullExpressionValue(modelSearchResponse, "searchResponse");
        if (SearchFetcher.access$isIndexing(searchFetcher, modelSearchResponse)) {
            this.$resubscribeDelayMillis.set(modelSearchResponse.getRetryMillis());
            SearchFetcher.access$getIndexingRetryCount$p(this.this$0).incrementAndGet();
        }
    }
}
