package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnLongClickListener;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ThreadEmbedEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadEmbed$onConfigure$2 implements View$OnLongClickListener {
    public final /* synthetic */ ChatListEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemThreadEmbed this$0;

    public WidgetChatListAdapterItemThreadEmbed$onConfigure$2(WidgetChatListAdapterItemThreadEmbed widgetChatListAdapterItemThreadEmbed, ChatListEntry chatListEntry) {
        this.this$0 = widgetChatListAdapterItemThreadEmbed;
        this.$data = chatListEntry;
    }

    @Override // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view) {
        WidgetChatListAdapterItemThreadEmbed.access$getAdapter$p(this.this$0).onThreadLongClicked(((ThreadEmbedEntry) this.$data).getThread());
        return true;
    }
}
