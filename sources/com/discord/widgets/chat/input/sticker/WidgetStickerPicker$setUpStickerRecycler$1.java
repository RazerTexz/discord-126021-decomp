package com.discord.widgets.chat.input.sticker;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPicker$setUpStickerRecycler$1 extends k implements Function1<StickerItem, Unit> {
    public WidgetStickerPicker$setUpStickerRecycler$1(WidgetStickerPicker widgetStickerPicker) {
        super(1, widgetStickerPicker, WidgetStickerPicker.class, "onStickerItemSelected", "onStickerItemSelected(Lcom/discord/widgets/chat/input/sticker/StickerItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerItem stickerItem) {
        invoke2(stickerItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerItem stickerItem) {
        m.checkNotNullParameter(stickerItem, "p1");
        WidgetStickerPicker.access$onStickerItemSelected((WidgetStickerPicker) this.receiver, stickerItem);
    }
}
