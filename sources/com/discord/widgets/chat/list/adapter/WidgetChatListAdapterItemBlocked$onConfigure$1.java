package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.message.Message;

/* JADX INFO: compiled from: WidgetChatListAdapterItemBlocked.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemBlocked$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemBlocked this$0;

    public WidgetChatListAdapterItemBlocked$onConfigure$1(WidgetChatListAdapterItemBlocked widgetChatListAdapterItemBlocked, Message message) {
        this.this$0 = widgetChatListAdapterItemBlocked;
        this.$message = message;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemBlocked.access$getAdapter$p(this.this$0).getEventHandler().onMessageBlockedGroupClicked(this.$message);
    }
}
