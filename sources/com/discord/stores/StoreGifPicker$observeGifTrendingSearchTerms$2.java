package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$observeGifTrendingSearchTerms$2 extends o implements Function0<List<? extends String>> {
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$observeGifTrendingSearchTerms$2(StoreGifPicker storeGifPicker) {
        super(0);
        this.this$0 = storeGifPicker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends String> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends String> invoke2() {
        return StoreGifPicker.access$getGifTrendingSearchTerms(this.this$0);
    }
}
