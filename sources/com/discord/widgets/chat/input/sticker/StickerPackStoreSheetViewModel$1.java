package com.discord.widgets.chat.input.sticker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPackStoreSheetViewModel$1 extends o implements Function1<StickerPackStoreSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ StickerPackStoreSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPackStoreSheetViewModel$1(StickerPackStoreSheetViewModel stickerPackStoreSheetViewModel) {
        super(1);
        this.this$0 = stickerPackStoreSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerPackStoreSheetViewModel$StoreState stickerPackStoreSheetViewModel$StoreState) {
        invoke2(stickerPackStoreSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerPackStoreSheetViewModel$StoreState stickerPackStoreSheetViewModel$StoreState) {
        m.checkNotNullParameter(stickerPackStoreSheetViewModel$StoreState, "storeState");
        StickerPackStoreSheetViewModel.access$handleStoreState(this.this$0, stickerPackStoreSheetViewModel$StoreState);
    }
}
