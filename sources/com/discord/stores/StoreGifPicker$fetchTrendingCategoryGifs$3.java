package com.discord.stores;

import com.discord.models.gifpicker.dto.ModelGif;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreGifPicker$fetchTrendingCategoryGifs$3 extends k implements Function1<List<? extends ModelGif>, Unit> {
    public StoreGifPicker$fetchTrendingCategoryGifs$3(StoreGifPicker storeGifPicker) {
        super(1, storeGifPicker, StoreGifPicker.class, "handleFetchTrendingGifsOnNext", "handleFetchTrendingGifsOnNext(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGif> list) {
        invoke2((List<ModelGif>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelGif> list) {
        m.checkNotNullParameter(list, "p1");
        StoreGifPicker.access$handleFetchTrendingGifsOnNext((StoreGifPicker) this.receiver, list);
    }
}
