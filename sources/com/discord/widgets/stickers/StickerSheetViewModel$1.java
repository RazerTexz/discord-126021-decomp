package com.discord.widgets.stickers;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerSheetViewModel$1 extends o implements Function1<StickerSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ StickerSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerSheetViewModel$1(StickerSheetViewModel stickerSheetViewModel) {
        super(1);
        this.this$0 = stickerSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerSheetViewModel$StoreState stickerSheetViewModel$StoreState) {
        invoke2(stickerSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerSheetViewModel$StoreState stickerSheetViewModel$StoreState) {
        m.checkNotNullParameter(stickerSheetViewModel$StoreState, "storeState");
        StickerSheetViewModel.access$handleStoreState(this.this$0, stickerSheetViewModel$StoreState);
    }
}
