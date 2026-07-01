package com.discord.widgets.chat.input.emoji;

import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker$onEmojiSelected$1 extends o implements Function1<Emoji, Unit> {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiPicker$onEmojiSelected$1(WidgetEmojiPicker widgetEmojiPicker) {
        super(1);
        this.this$0 = widgetEmojiPicker;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Emoji emoji) {
        invoke2(emoji);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Emoji emoji) {
        m.checkNotNullParameter(emoji, "validEmoji");
        EmojiPickerListener emojiPickerListenerAccess$getEmojiPickerListener$p = WidgetEmojiPicker.access$getEmojiPickerListener$p(this.this$0);
        if (emojiPickerListenerAccess$getEmojiPickerListener$p != null) {
            emojiPickerListenerAccess$getEmojiPickerListener$p.onEmojiPicked(emoji);
        }
    }
}
