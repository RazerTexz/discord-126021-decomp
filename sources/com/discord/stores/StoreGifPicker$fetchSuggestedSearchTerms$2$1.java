package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$fetchSuggestedSearchTerms$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $suggestedSearchTerms;
    public final /* synthetic */ StoreGifPicker$fetchSuggestedSearchTerms$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$fetchSuggestedSearchTerms$2$1(StoreGifPicker$fetchSuggestedSearchTerms$2 storeGifPicker$fetchSuggestedSearchTerms$2, List list) {
        super(0);
        this.this$0 = storeGifPicker$fetchSuggestedSearchTerms$2;
        this.$suggestedSearchTerms = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGifPicker$fetchSuggestedSearchTerms$2 storeGifPicker$fetchSuggestedSearchTerms$2 = this.this$0;
        StoreGifPicker.access$handleSuggestedSearchTerms(storeGifPicker$fetchSuggestedSearchTerms$2.this$0, storeGifPicker$fetchSuggestedSearchTerms$2.$query, this.$suggestedSearchTerms);
    }
}
