package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGifPicker$fetchGifTrendingSearchTerms$2 extends k implements Function1<List<? extends String>, Unit> {
    public StoreGifPicker$fetchGifTrendingSearchTerms$2(StoreGifPicker storeGifPicker) {
        super(1, storeGifPicker, StoreGifPicker.class, "handleFetchTrendingSearchTermsOnNext", "handleFetchTrendingSearchTermsOnNext(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
        invoke2((List<String>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<String> list) {
        m.checkNotNullParameter(list, "p1");
        StoreGifPicker.access$handleFetchTrendingSearchTermsOnNext((StoreGifPicker) this.receiver, list);
    }
}
