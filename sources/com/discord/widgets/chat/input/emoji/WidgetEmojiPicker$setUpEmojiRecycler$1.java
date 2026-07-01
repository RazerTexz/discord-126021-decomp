package com.discord.widgets.chat.input.emoji;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEmojiPicker$setUpEmojiRecycler$1 extends k implements Function0<Unit> {
    public WidgetEmojiPicker$setUpEmojiRecycler$1(WidgetEmojiPicker widgetEmojiPicker) {
        super(0, widgetEmojiPicker, WidgetEmojiPicker.class, "onPremiumCtaClicked", "onPremiumCtaClicked()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetEmojiPicker.access$onPremiumCtaClicked((WidgetEmojiPicker) this.receiver);
    }
}
