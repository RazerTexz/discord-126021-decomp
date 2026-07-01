package com.discord.widgets.chat.input.sticker;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStickerPicker$setUpCategoryRecycler$3 extends k implements Function0<Unit> {
    public WidgetStickerPicker$setUpCategoryRecycler$3(WidgetStickerPicker widgetStickerPicker) {
        super(0, widgetStickerPicker, WidgetStickerPicker.class, "onRecentClicked", "onRecentClicked()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetStickerPicker.access$onRecentClicked((WidgetStickerPicker) this.receiver);
    }
}
