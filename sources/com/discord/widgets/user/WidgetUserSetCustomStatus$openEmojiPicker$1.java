package com.discord.widgets.user;

import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatus$openEmojiPicker$1 implements EmojiPickerListener {
    public final /* synthetic */ WidgetUserSetCustomStatus this$0;

    public WidgetUserSetCustomStatus$openEmojiPicker$1(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
        this.this$0 = widgetUserSetCustomStatus;
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
    public void onEmojiPicked(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        WidgetUserSetCustomStatus.access$getViewModel$p(this.this$0).setStatusEmoji(emoji);
    }
}
