package com.discord.widgets.chat.input.sticker;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPackStoreSheet$onResume$1 extends k implements Function1<StickerPackStoreSheetViewModel$ViewState, Unit> {
    public WidgetStickerPackStoreSheet$onResume$1(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
        super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerPackStoreSheetViewModel$ViewState stickerPackStoreSheetViewModel$ViewState) {
        invoke2(stickerPackStoreSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerPackStoreSheetViewModel$ViewState stickerPackStoreSheetViewModel$ViewState) {
        WidgetStickerPackStoreSheet.access$configureUI((WidgetStickerPackStoreSheet) this.receiver, stickerPackStoreSheetViewModel$ViewState);
    }
}
