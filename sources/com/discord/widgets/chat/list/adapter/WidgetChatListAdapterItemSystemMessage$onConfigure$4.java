package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.message.Message;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage$onConfigure$4 implements View$OnClickListener {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListAdapterItemSystemMessage this$0;

    public WidgetChatListAdapterItemSystemMessage$onConfigure$4(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage, Long l, Message message) {
        this.this$0 = widgetChatListAdapterItemSystemMessage;
        this.$guildId = l;
        this.$message = message;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Long l = this.$guildId;
        if (l != null) {
            l.longValue();
            WidgetChatListAdapterItemSystemMessage.access$getAdapter$p(this.this$0).getEventHandler().onMessageAuthorAvatarClicked(this.$message, this.$guildId.longValue());
        }
    }
}
