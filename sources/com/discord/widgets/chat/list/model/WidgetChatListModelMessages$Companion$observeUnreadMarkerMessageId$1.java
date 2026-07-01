package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.models.application.Unread;
import j0.k.b;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelMessages$Companion$observeUnreadMarkerMessageId$1<T, R> implements b<Unread, Long> {
    public static final WidgetChatListModelMessages$Companion$observeUnreadMarkerMessageId$1 INSTANCE = new WidgetChatListModelMessages$Companion$observeUnreadMarkerMessageId$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(Unread unread) {
        return call2(unread);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Unread unread) {
        Long messageId = unread.getMarker().getMessageId();
        return Long.valueOf(messageId != null ? messageId.longValue() : 0L);
    }
}
