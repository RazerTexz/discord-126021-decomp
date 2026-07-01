package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.list.entries.AttachmentEntry;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment$configureUI$5 implements View$OnClickListener {
    public final /* synthetic */ AttachmentEntry $data;
    public final /* synthetic */ WidgetChatListAdapterItemAttachment$Model $model;
    public final /* synthetic */ WidgetChatListAdapterItemAttachment this$0;

    public WidgetChatListAdapterItemAttachment$configureUI$5(WidgetChatListAdapterItemAttachment widgetChatListAdapterItemAttachment, WidgetChatListAdapterItemAttachment$Model widgetChatListAdapterItemAttachment$Model, AttachmentEntry attachmentEntry) {
        this.this$0 = widgetChatListAdapterItemAttachment;
        this.$model = widgetChatListAdapterItemAttachment$Model;
        this.$data = attachmentEntry;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (WidgetChatListAdapterItemAttachment.access$getAdapter$p(this.this$0).getData().getIsSpoilerClickAllowed()) {
            StoreStream.Companion.getMessageState().revealSpoilerEmbed(this.$model.getAttachmentEntry().getMessage().getId(), this.$data.getEmbedIndex());
        } else {
            WidgetChatListAdapterItemAttachment.access$getAdapter$p(this.this$0).getEventHandler().onMessageClicked(this.$model.getAttachmentEntry().getMessage(), this.$data.isThreadStarterMessage());
        }
    }
}
