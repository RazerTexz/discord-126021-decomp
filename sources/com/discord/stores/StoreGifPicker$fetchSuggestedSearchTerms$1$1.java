package com.discord.stores;

import d0.t.n;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$fetchSuggestedSearchTerms$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGifPicker$fetchSuggestedSearchTerms$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$fetchSuggestedSearchTerms$1$1(StoreGifPicker$fetchSuggestedSearchTerms$1 storeGifPicker$fetchSuggestedSearchTerms$1) {
        super(0);
        this.this$0 = storeGifPicker$fetchSuggestedSearchTerms$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGifPicker$fetchSuggestedSearchTerms$1 storeGifPicker$fetchSuggestedSearchTerms$1 = this.this$0;
        StoreGifPicker.access$handleSuggestedSearchTerms(storeGifPicker$fetchSuggestedSearchTerms$1.this$0, storeGifPicker$fetchSuggestedSearchTerms$1.$query, n.emptyList());
    }
}
