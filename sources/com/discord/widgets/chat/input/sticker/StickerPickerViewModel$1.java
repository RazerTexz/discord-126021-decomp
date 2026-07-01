package com.discord.widgets.chat.input.sticker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPickerViewModel$1 extends o implements Function1<StickerPickerViewModel$StoreState, Unit> {
    public final /* synthetic */ StickerPickerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPickerViewModel$1(StickerPickerViewModel stickerPickerViewModel) {
        super(1);
        this.this$0 = stickerPickerViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerPickerViewModel$StoreState stickerPickerViewModel$StoreState) {
        invoke2(stickerPickerViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerPickerViewModel$StoreState stickerPickerViewModel$StoreState) {
        StickerPickerViewModel stickerPickerViewModel = this.this$0;
        m.checkNotNullExpressionValue(stickerPickerViewModel$StoreState, "storeState");
        StickerPickerViewModel.access$handleStoreState(stickerPickerViewModel, stickerPickerViewModel$StoreState);
    }
}
