package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GifPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifPickerViewModel$2 extends o implements Function1<GifPickerViewModel$StoreState, Unit> {
    public final /* synthetic */ GifPickerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifPickerViewModel$2(GifPickerViewModel gifPickerViewModel) {
        super(1);
        this.this$0 = gifPickerViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GifPickerViewModel$StoreState gifPickerViewModel$StoreState) {
        invoke2(gifPickerViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GifPickerViewModel$StoreState gifPickerViewModel$StoreState) {
        m.checkNotNullParameter(gifPickerViewModel$StoreState, "storeState");
        GifPickerViewModel.access$handleStoreState(this.this$0, gifPickerViewModel$StoreState);
    }
}
