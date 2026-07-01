package com.discord.widgets.chat.list.actions;

import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$onViewCreated$2$1 implements EmojiPickerListener {
    public final /* synthetic */ WidgetChatListActions$onViewCreated$2 this$0;

    public WidgetChatListActions$onViewCreated$2$1(WidgetChatListActions$onViewCreated$2 widgetChatListActions$onViewCreated$2) {
        this.this$0 = widgetChatListActions$onViewCreated$2;
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
    public void onEmojiPicked(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        WidgetChatListActions.access$addReaction(this.this$0.this$0, emoji);
    }
}
