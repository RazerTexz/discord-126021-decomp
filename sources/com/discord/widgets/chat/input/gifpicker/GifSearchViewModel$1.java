package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel$1 extends o implements Function1<GifSearchViewModel$StoreState, Unit> {
    public final /* synthetic */ GifSearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel$1(GifSearchViewModel gifSearchViewModel) {
        super(1);
        this.this$0 = gifSearchViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GifSearchViewModel$StoreState gifSearchViewModel$StoreState) {
        invoke2(gifSearchViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GifSearchViewModel$StoreState gifSearchViewModel$StoreState) {
        m.checkNotNullParameter(gifSearchViewModel$StoreState, "storeState");
        GifSearchViewModel.access$handleStoreState(this.this$0, gifSearchViewModel$StoreState);
    }
}
