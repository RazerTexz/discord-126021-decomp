package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$observeGifCategories$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifPicker$observeGifCategories$1(StoreGifPicker storeGifPicker) {
        super(0);
        this.this$0 = storeGifPicker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (!StoreGifPicker.access$getGifCategories$p(this.this$0).isEmpty() || StoreGifPicker.access$isFetchingGifCategories$p(this.this$0)) {
            return;
        }
        this.this$0.fetchGifCategories();
    }
}
