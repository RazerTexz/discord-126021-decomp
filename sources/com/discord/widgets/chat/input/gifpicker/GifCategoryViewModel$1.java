package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GifCategoryViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifCategoryViewModel$1 extends o implements Function1<GifCategoryViewModel$StoreState, Unit> {
    public final /* synthetic */ GifCategoryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryViewModel$1(GifCategoryViewModel gifCategoryViewModel) {
        super(1);
        this.this$0 = gifCategoryViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GifCategoryViewModel$StoreState gifCategoryViewModel$StoreState) {
        invoke2(gifCategoryViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GifCategoryViewModel$StoreState gifCategoryViewModel$StoreState) {
        m.checkNotNullParameter(gifCategoryViewModel$StoreState, "storeState");
        GifCategoryViewModel.access$handleStoreState(this.this$0, gifCategoryViewModel$StoreState);
    }
}
