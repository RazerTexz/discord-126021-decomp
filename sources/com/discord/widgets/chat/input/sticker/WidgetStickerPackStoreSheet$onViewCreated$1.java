package com.discord.widgets.chat.input.sticker;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPackStoreSheet$onViewCreated$1 extends k implements Function1<StickerItem, Unit> {
    public WidgetStickerPackStoreSheet$onViewCreated$1(WidgetStickerPackStoreSheet widgetStickerPackStoreSheet) {
        super(1, widgetStickerPackStoreSheet, WidgetStickerPackStoreSheet.class, "onStickerItemSelected", "onStickerItemSelected(Lcom/discord/widgets/chat/input/sticker/StickerItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerItem stickerItem) {
        invoke2(stickerItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerItem stickerItem) {
        m.checkNotNullParameter(stickerItem, "p1");
        WidgetStickerPackStoreSheet.access$onStickerItemSelected((WidgetStickerPackStoreSheet) this.receiver, stickerItem);
    }
}
