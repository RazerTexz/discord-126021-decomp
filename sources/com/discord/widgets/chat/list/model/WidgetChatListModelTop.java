package com.discord.widgets.chat.list.model;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListModelTop.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListModelTop {
    public static final WidgetChatListModelTop$Companion Companion = new WidgetChatListModelTop$Companion(null);
    private final ChatListEntry item;

    public WidgetChatListModelTop(ChatListEntry chatListEntry) {
        m.checkNotNullParameter(chatListEntry, "item");
        this.item = chatListEntry;
    }

    public static /* synthetic */ WidgetChatListModelTop copy$default(WidgetChatListModelTop widgetChatListModelTop, ChatListEntry chatListEntry, int i, Object obj) {
        if ((i & 1) != 0) {
            chatListEntry = widgetChatListModelTop.item;
        }
        return widgetChatListModelTop.copy(chatListEntry);
    }

    public static final Observable<WidgetChatListModelTop> get(Channel channel) {
        return Companion.get(channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ChatListEntry getItem() {
        return this.item;
    }

    public final WidgetChatListModelTop copy(ChatListEntry item) {
        m.checkNotNullParameter(item, "item");
        return new WidgetChatListModelTop(item);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChatListModelTop) && m.areEqual(this.item, ((WidgetChatListModelTop) other).item);
        }
        return true;
    }

    public final ChatListEntry getItem() {
        return this.item;
    }

    public int hashCode() {
        ChatListEntry chatListEntry = this.item;
        if (chatListEntry != null) {
            return chatListEntry.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetChatListModelTop(item=");
        sbU.append(this.item);
        sbU.append(")");
        return sbU.toString();
    }
}
