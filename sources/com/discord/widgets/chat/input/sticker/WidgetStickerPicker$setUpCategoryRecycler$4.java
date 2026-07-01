package com.discord.widgets.chat.input.sticker;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPicker$setUpCategoryRecycler$4 extends k implements Function1<Integer, Unit> {
    public WidgetStickerPicker$setUpCategoryRecycler$4(WidgetStickerPicker widgetStickerPicker) {
        super(1, widgetStickerPicker, WidgetStickerPicker.class, "onSelectedCategoryAdapterPositionUpdated", "onSelectedCategoryAdapterPositionUpdated(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetStickerPicker.access$onSelectedCategoryAdapterPositionUpdated((WidgetStickerPicker) this.receiver, i);
    }
}
