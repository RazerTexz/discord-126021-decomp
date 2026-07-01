package com.discord.widgets.chat.input.emoji;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker$subscribeToCategoryRecyclerScrolls$1 extends o implements Function1<Unit, Unit> {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiPicker$subscribeToCategoryRecyclerScrolls$1(WidgetEmojiPicker widgetEmojiPicker) {
        super(1);
        this.this$0 = widgetEmojiPicker;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
        invoke2(unit);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Unit unit) {
        WidgetEmojiPicker widgetEmojiPicker = this.this$0;
        WidgetEmojiPicker.access$configureUnicodeCategoriesShortcutButton(widgetEmojiPicker, WidgetEmojiPicker.access$getPreviousViewState$p(widgetEmojiPicker));
    }
}
