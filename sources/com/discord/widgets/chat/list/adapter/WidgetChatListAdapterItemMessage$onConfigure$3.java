package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.message.Message;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$onConfigure$3 implements View$OnClickListener {
    public final /* synthetic */ boolean $isThreadStarterMessage;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemMessage this$0;

    public WidgetChatListAdapterItemMessage$onConfigure$3(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Message message, boolean z2) {
        this.this$0 = widgetChatListAdapterItemMessage;
        this.$message = message;
        this.$isThreadStarterMessage = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemMessage.access$getAdapter$p(this.this$0).getEventHandler().onMessageClicked(this.$message, this.$isThreadStarterMessage);
    }
}
