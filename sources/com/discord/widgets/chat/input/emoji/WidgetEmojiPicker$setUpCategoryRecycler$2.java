package com.discord.widgets.chat.input.emoji;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEmojiPicker$setUpCategoryRecycler$2 extends k implements Function1<Integer, Unit> {
    public WidgetEmojiPicker$setUpCategoryRecycler$2(WidgetEmojiPicker widgetEmojiPicker) {
        super(1, widgetEmojiPicker, WidgetEmojiPicker.class, "onSelectedCategoryAdapterPositionUpdated", "onSelectedCategoryAdapterPositionUpdated(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetEmojiPicker.access$onSelectedCategoryAdapterPositionUpdated((WidgetEmojiPicker) this.receiver, i);
    }
}
