package com.discord.widgets.chat.list.adapter;

import android.net.Uri;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.ImageView;
import com.discord.api.message.attachment.MessageAttachment;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment$configureFileData$2 implements View$OnClickListener {
    public final /* synthetic */ MessageAttachment $data;
    public final /* synthetic */ WidgetChatListAdapterItemAttachment this$0;

    public WidgetChatListAdapterItemAttachment$configureFileData$2(WidgetChatListAdapterItemAttachment widgetChatListAdapterItemAttachment, MessageAttachment messageAttachment) {
        this.this$0 = widgetChatListAdapterItemAttachment;
        this.$data = messageAttachment;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapter$EventHandler eventHandler = WidgetChatListAdapterItemAttachment.access$getAdapter$p(this.this$0).getEventHandler();
        Uri uri = Uri.parse(this.$data.getUrl());
        m.checkNotNullExpressionValue(uri, "Uri.parse(data.url)");
        boolean zOnQuickDownloadClicked = eventHandler.onQuickDownloadClicked(uri, this.$data.getFilename());
        ImageView imageView = WidgetChatListAdapterItemAttachment.access$getBinding$p(this.this$0).f;
        m.checkNotNullExpressionValue(imageView, "binding.chatListItemAttachmentDownload");
        imageView.setEnabled(!zOnQuickDownloadClicked);
        ImageView imageView2 = WidgetChatListAdapterItemAttachment.access$getBinding$p(this.this$0).f;
        m.checkNotNullExpressionValue(imageView2, "binding.chatListItemAttachmentDownload");
        imageView2.setAlpha(0.3f);
    }
}
