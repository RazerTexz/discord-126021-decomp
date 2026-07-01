package com.discord.widgets.chat.list.adapter;

import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterEventsHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1$1 implements EmojiPickerListener {
    public final /* synthetic */ WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1 this$0;

    public WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1$1(WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1 widgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1) {
        this.this$0 = widgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1;
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
    public void onEmojiPicked(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        WidgetChatListAdapterEventsHandler$UserReactionHandler widgetChatListAdapterEventsHandler$UserReactionHandlerAccess$getUserReactionHandler$p = WidgetChatListAdapterEventsHandler.access$getUserReactionHandler$p(this.this$0.this$0);
        WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1 widgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1 = this.this$0;
        widgetChatListAdapterEventsHandler$UserReactionHandlerAccess$getUserReactionHandler$p.addNewReaction(emoji, widgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1.$channelId, widgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1.$messageId);
    }
}
