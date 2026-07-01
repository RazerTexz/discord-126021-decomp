package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.media.WidgetMedia;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAttachment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAttachment$Companion {
    private WidgetChatListAdapterItemAttachment$Companion() {
    }

    public static final /* synthetic */ boolean access$isInlinedAttachment$p(WidgetChatListAdapterItemAttachment$Companion widgetChatListAdapterItemAttachment$Companion, MessageAttachment messageAttachment) {
        return widgetChatListAdapterItemAttachment$Companion.isInlinedAttachment(messageAttachment);
    }

    public static final /* synthetic */ void access$navigateToAttachment(WidgetChatListAdapterItemAttachment$Companion widgetChatListAdapterItemAttachment$Companion, Context context, MessageAttachment messageAttachment) {
        widgetChatListAdapterItemAttachment$Companion.navigateToAttachment(context, messageAttachment);
    }

    private final boolean isInlinedAttachment(MessageAttachment messageAttachment) {
        return messageAttachment.e() != MessageAttachmentType.FILE;
    }

    private final void navigateToAttachment(Context context, MessageAttachment attachment) {
        int iOrdinal = attachment.e().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            WidgetMedia.Companion.launch(context, attachment);
        } else {
            UriHandler.handleOrUntrusted$default(context, attachment.getUrl(), null, 4, null);
        }
    }

    public /* synthetic */ WidgetChatListAdapterItemAttachment$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
