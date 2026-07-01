package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.api.message.attachment.MessageAttachment;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment$configureUI$6 implements View$OnClickListener {
    public final /* synthetic */ MessageAttachment $attachment;

    public WidgetChatListAdapterItemAttachment$configureUI$6(MessageAttachment messageAttachment) {
        this.$attachment = messageAttachment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemAttachment$Companion.access$navigateToAttachment(WidgetChatListAdapterItemAttachment.Companion, a.x(view, "it", "it.context"), this.$attachment);
    }
}
