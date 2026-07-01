package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$handleFetchTrendingSearchTermsOnNext$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $trendingSearchTerms;
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$handleFetchTrendingSearchTermsOnNext$1(StoreGifPicker storeGifPicker, List list) {
        super(0);
        this.this$0 = storeGifPicker;
        this.$trendingSearchTerms = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGifPicker.access$updateTrendingSearchTerms(this.this$0, this.$trendingSearchTerms);
        StoreGifPicker.access$setFetchingTrendingSearchTerms$p(this.this$0, false);
    }
}
