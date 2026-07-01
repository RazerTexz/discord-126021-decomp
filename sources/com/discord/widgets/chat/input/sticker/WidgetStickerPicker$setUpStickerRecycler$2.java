package com.discord.widgets.chat.input.sticker;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPicker$setUpStickerRecycler$2 extends k implements Function1<StoreHeaderItem, Unit> {
    public WidgetStickerPicker$setUpStickerRecycler$2(WidgetStickerPicker widgetStickerPicker) {
        super(1, widgetStickerPicker, WidgetStickerPicker.class, "onStickerHeaderItemsClicked", "onStickerHeaderItemsClicked(Lcom/discord/widgets/chat/input/sticker/StoreHeaderItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreHeaderItem storeHeaderItem) {
        invoke2(storeHeaderItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreHeaderItem storeHeaderItem) {
        m.checkNotNullParameter(storeHeaderItem, "p1");
        WidgetStickerPicker.access$onStickerHeaderItemsClicked((WidgetStickerPicker) this.receiver, storeHeaderItem);
    }
}
