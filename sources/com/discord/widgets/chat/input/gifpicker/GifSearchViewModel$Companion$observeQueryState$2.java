package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGifPicker;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel$Companion$observeQueryState$2<T, R> implements b<String, Observable<? extends GifSearchViewModel$StoreState>> {
    public final /* synthetic */ StoreGifPicker $storeGifPicker;
    public final /* synthetic */ List $trendingSearchTerms;

    public GifSearchViewModel$Companion$observeQueryState$2(List list, StoreGifPicker storeGifPicker) {
        this.$trendingSearchTerms = list;
        this.$storeGifPicker = storeGifPicker;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends GifSearchViewModel$StoreState> call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GifSearchViewModel$StoreState> call2(String str) {
        m.checkNotNullExpressionValue(str, "query");
        return str.length() == 0 ? new k(new GifSearchViewModel$StoreState$TrendingSearchTermsResults(this.$trendingSearchTerms)) : Observable.j(this.$storeGifPicker.observeGifsForSearchQuery(str).y(GifSearchViewModel$Companion$observeQueryState$2$1.INSTANCE), this.$storeGifPicker.observeSuggestedSearchTerms(str), new GifSearchViewModel$Companion$observeQueryState$2$2(this, str));
    }
}
