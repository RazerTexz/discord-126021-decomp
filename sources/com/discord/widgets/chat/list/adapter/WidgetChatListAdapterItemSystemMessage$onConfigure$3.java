package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.message.Message;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$onConfigure$3 implements View$OnClickListener {
    public final /* synthetic */ ChatListEntry $data;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage this$0;

    public WidgetChatListAdapterItemSystemMessage$onConfigure$3(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage, Message message, ChatListEntry chatListEntry) {
        this.this$0 = widgetChatListAdapterItemSystemMessage;
        this.$message = message;
        this.$data = chatListEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getEventHandler().onSystemMessageCtaClicked(this.$message, ((MessageEntry) this.$data).getCtaData().getChannel(), ((MessageEntry) this.$data).getCtaData().getSticker());
    }
}
