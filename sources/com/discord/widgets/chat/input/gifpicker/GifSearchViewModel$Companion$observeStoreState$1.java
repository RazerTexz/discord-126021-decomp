package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel$Companion$observeStoreState$1<T, R> implements b<List<? extends String>, Observable<? extends GifSearchViewModel$StoreState>> {
    public final /* synthetic */ BehaviorSubject $searchSubject;
    public final /* synthetic */ StoreAnalytics $storeAnalytics;
    public final /* synthetic */ StoreGifPicker $storeGifPicker;

    public GifSearchViewModel$Companion$observeStoreState$1(BehaviorSubject behaviorSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker) {
        this.$searchSubject = behaviorSubject;
        this.$storeAnalytics = storeAnalytics;
        this.$storeGifPicker = storeGifPicker;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends GifSearchViewModel$StoreState> call(List<? extends String> list) {
        return call2((List<String>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GifSearchViewModel$StoreState> call2(List<String> list) {
        GifSearchViewModel$Companion gifSearchViewModel$Companion = GifSearchViewModel.Companion;
        BehaviorSubject behaviorSubject = this.$searchSubject;
        StoreAnalytics storeAnalytics = this.$storeAnalytics;
        StoreGifPicker storeGifPicker = this.$storeGifPicker;
        m.checkNotNullExpressionValue(list, "terms");
        return GifSearchViewModel$Companion.access$observeQueryState(gifSearchViewModel$Companion, behaviorSubject, storeAnalytics, storeGifPicker, list);
    }
}
