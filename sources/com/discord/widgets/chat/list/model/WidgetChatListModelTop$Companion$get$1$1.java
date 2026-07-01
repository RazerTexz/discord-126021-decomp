package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetChatListModelTop.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelTop$Companion$get$1$1<T, R> implements b<ChatListEntry, WidgetChatListModelTop> {
    public static final WidgetChatListModelTop$Companion$get$1$1 INSTANCE = new WidgetChatListModelTop$Companion$get$1$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetChatListModelTop call(ChatListEntry chatListEntry) {
        return call2(chatListEntry);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModelTop call2(ChatListEntry chatListEntry) {
        m.checkNotNullExpressionValue(chatListEntry, "it");
        return new WidgetChatListModelTop(chatListEntry);
    }
}
