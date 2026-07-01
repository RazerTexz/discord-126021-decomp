package com.discord.widgets.stickers;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetStickerSheet$bindSubscriptions$1 extends k implements Function1<StickerSheetViewModel$ViewState, Unit> {
    public WidgetStickerSheet$bindSubscriptions$1(WidgetStickerSheet widgetStickerSheet) {
        super(1, widgetStickerSheet, WidgetStickerSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/stickers/StickerSheetViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerSheetViewModel$ViewState stickerSheetViewModel$ViewState) {
        invoke2(stickerSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerSheetViewModel$ViewState stickerSheetViewModel$ViewState) {
        m.checkNotNullParameter(stickerSheetViewModel$ViewState, "p1");
        WidgetStickerSheet.access$configureUI((WidgetStickerSheet) this.receiver, stickerSheetViewModel$ViewState);
    }
}
