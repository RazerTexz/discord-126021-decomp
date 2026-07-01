package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.message.Message;

/* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemCallMessage$handleState$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemCallMessage$CallStatus $callStatus;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemCallMessage this$0;

    public WidgetChatListAdapterItemCallMessage$handleState$1(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, WidgetChatListAdapterItemCallMessage$CallStatus widgetChatListAdapterItemCallMessage$CallStatus, Message message) {
        this.this$0 = widgetChatListAdapterItemCallMessage;
        this.$callStatus = widgetChatListAdapterItemCallMessage$CallStatus;
        this.$message = message;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemCallMessage.access$onItemClick(this.this$0, this.$callStatus, this.$message.getChannelId());
    }
}
