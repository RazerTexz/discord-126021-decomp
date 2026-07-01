package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$observeSuggestedSearchTerms$2 extends o implements Function0<Unit> {
    public final /* synthetic */ String $query;
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$observeSuggestedSearchTerms$2(StoreGifPicker storeGifPicker, String str) {
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
        if (StoreGifPicker.access$getGifSuggestedSearchTermsHistory$p(this.this$0).containsKey(this.$query)) {
            return;
        }
        StoreGifPicker.access$getGifSuggestedSearchTermsHistory$p(this.this$0).put(this.$query, StoreGifPicker.Companion.getSearchTermsLoadingList());
        StoreGifPicker.access$fetchSuggestedSearchTerms(this.this$0, this.$query);
    }
}
