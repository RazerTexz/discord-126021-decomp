package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.message.Message;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemMessage this$0;

    public WidgetChatListAdapterItemMessage$onConfigure$1(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Message message) {
        this.this$0 = widgetChatListAdapterItemMessage;
        this.$message = message;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemMessage.access$getAdapter$p(this.this$0).getEventHandler().onMessageAuthorNameClicked(this.$message, WidgetChatListAdapterItemMessage.access$getAdapter$p(this.this$0).getData().getGuildId());
    }
}
