package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$handleFetchTrendingGifsOnNext$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $gifs;
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$handleFetchTrendingGifsOnNext$1(StoreGifPicker storeGifPicker, List list) {
        super(0);
        this.this$0 = storeGifPicker;
        this.$gifs = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGifPicker.access$updateTrendingCategoryGifs(this.this$0, this.$gifs);
        StoreGifPicker.access$setFetchingTrendingCategoryGifs$p(this.this$0, false);
    }
}
