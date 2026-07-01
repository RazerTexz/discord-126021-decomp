package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ThreadEmbedEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadEmbed$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ ChatListEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemThreadEmbed this$0;

    public WidgetChatListAdapterItemThreadEmbed$onConfigure$1(WidgetChatListAdapterItemThreadEmbed widgetChatListAdapterItemThreadEmbed, ChatListEntry chatListEntry) {
        this.this$0 = widgetChatListAdapterItemThreadEmbed;
        this.$data = chatListEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemThreadEmbed.access$getAdapter$p(this.this$0).onThreadClicked(((ThreadEmbedEntry) this.$data).getThread());
    }
}
