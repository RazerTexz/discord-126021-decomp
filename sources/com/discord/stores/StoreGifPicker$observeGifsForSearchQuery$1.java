package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$observeGifsForSearchQuery$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $query;
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$observeGifsForSearchQuery$1(StoreGifPicker storeGifPicker, String str) {
        super(0);
        this.this$0 = storeGifPicker;
        this.$query = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreGifPicker.access$getGifSearchHistory$p(this.this$0).containsKey(this.$query)) {
            return;
        }
        StoreGifPicker.access$getGifSearchHistory$p(this.this$0).put(this.$query, StoreGifPicker.Companion.getSearchResultsLoadingList());
        StoreGifPicker.access$fetchGifsForSearchQuery(this.this$0, this.$query);
    }
}
