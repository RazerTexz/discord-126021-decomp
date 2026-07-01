package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.chat.list.entries.AttachmentEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ AttachmentEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemAttachment this$0;

    public WidgetChatListAdapterItemAttachment$configureUI$4(WidgetChatListAdapterItemAttachment widgetChatListAdapterItemAttachment, AttachmentEntry attachmentEntry) {
        this.this$0 = widgetChatListAdapterItemAttachment;
        this.$data = attachmentEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemAttachment.access$getAdapter$p(this.this$0).getEventHandler().onMessageClicked(this.$data.getMessage(), this.$data.isThreadStarterMessage());
    }
}
