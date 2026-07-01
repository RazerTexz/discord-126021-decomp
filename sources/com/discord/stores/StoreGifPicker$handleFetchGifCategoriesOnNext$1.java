package com.discord.stores;

import com.discord.models.gifpicker.dto.TrendingGifCategoriesResponseDto;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$handleFetchGifCategoriesOnNext$1 extends o implements Function0<Unit> {
    public final /* synthetic */ TrendingGifCategoriesResponseDto $trendingGifsResponseRaw;
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$handleFetchGifCategoriesOnNext$1(StoreGifPicker storeGifPicker, TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        super(0);
        this.this$0 = storeGifPicker;
        this.$trendingGifsResponseRaw = trendingGifCategoriesResponseDto;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGifPicker.access$handleTrendingCategoriesResponse(this.this$0, this.$trendingGifsResponseRaw);
        StoreGifPicker.access$setFetchingGifCategories$p(this.this$0, false);
    }
}
