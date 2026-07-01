package com.discord.widgets.chat.list.actions;

import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MoreEmojisViewHolder extends MGRecyclerViewHolder<WidgetChatListActionsEmojisAdapter, EmojiItem> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreEmojisViewHolder(WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter) {
        super(R$layout.view_chat_list_actions_emoji_item_more, widgetChatListActionsEmojisAdapter);
        m.checkNotNullParameter(widgetChatListActionsEmojisAdapter, "adapter");
    }

    public static final /* synthetic */ WidgetChatListActionsEmojisAdapter access$getAdapter$p(MoreEmojisViewHolder moreEmojisViewHolder) {
        return (WidgetChatListActionsEmojisAdapter) moreEmojisViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, EmojiItem emojiItem) {
        onConfigure2(i, emojiItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, EmojiItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.itemView.setOnClickListener(new MoreEmojisViewHolder$onConfigure$1(this));
    }
}
