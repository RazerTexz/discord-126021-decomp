package com.discord.stores;

import com.discord.models.gifpicker.dto.TrendingGifCategoriesResponseDto;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGifPicker$fetchGifCategories$2 extends k implements Function1<TrendingGifCategoriesResponseDto, Unit> {
    public StoreGifPicker$fetchGifCategories$2(StoreGifPicker storeGifPicker) {
        super(1, storeGifPicker, StoreGifPicker.class, "handleFetchGifCategoriesOnNext", "handleFetchGifCategoriesOnNext(Lcom/discord/models/gifpicker/dto/TrendingGifCategoriesResponseDto;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        invoke2(trendingGifCategoriesResponseDto);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        m.checkNotNullParameter(trendingGifCategoriesResponseDto, "p1");
        StoreGifPicker.access$handleFetchGifCategoriesOnNext((StoreGifPicker) this.receiver, trendingGifCategoriesResponseDto);
    }
}
