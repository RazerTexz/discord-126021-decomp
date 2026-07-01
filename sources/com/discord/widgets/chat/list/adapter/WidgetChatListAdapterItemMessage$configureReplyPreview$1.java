package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage$configureReplyPreview$1 implements View$OnClickListener {
    public final /* synthetic */ Message $repliedMessage;

    public WidgetChatListAdapterItemMessage$configureReplyPreview$1(Message message) {
        this.$repliedMessage = message;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getMessagesLoader().jumpToMessage(this.$repliedMessage.getChannelId(), this.$repliedMessage.getId());
    }
}
