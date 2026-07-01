package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.EmbedEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ ChatListEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemEmbed this$0;

    public WidgetChatListAdapterItemEmbed$onConfigure$2(WidgetChatListAdapterItemEmbed widgetChatListAdapterItemEmbed, ChatListEntry chatListEntry) {
        this.this$0 = widgetChatListAdapterItemEmbed;
        this.$data = chatListEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemEmbed.access$getAdapter$p(this.this$0).getEventHandler().onMessageClicked(((EmbedEntry) this.$data).getMessage(), ((EmbedEntry) this.$data).isThreadStarterMessage());
    }
}
