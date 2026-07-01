package com.discord.widgets.chat.list.model;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListModelMessages {
    public static final WidgetChatListModelMessages$Companion Companion = new WidgetChatListModelMessages$Companion(null);
    private static final int MAX_CONCAT_COUNT = 5;
    private static final long MESSAGE_CONCAT_TIMESTAMP_DELTA_THRESHOLD = 420000;
    private final Map<Long, GuildMember> guildMembers;
    private final List<ChatListEntry> items;
    private final long newMessagesMarkerMessageId;
    private final long newestKnownMessageId;
    private final Long newestSentByUserMessageId;
    private final long oldestMessageId;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatListModelMessages(List<? extends ChatListEntry> list, long j, long j2, Map<Long, GuildMember> map, long j3, Long l) {
        m.checkNotNullParameter(list, "items");
        this.items = list;
        this.oldestMessageId = j;
        this.newestKnownMessageId = j2;
        this.guildMembers = map;
        this.newMessagesMarkerMessageId = j3;
        this.newestSentByUserMessageId = l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListModelMessages copy$default(WidgetChatListModelMessages widgetChatListModelMessages, List list, long j, long j2, Map map, long j3, Long l, int i, Object obj) {
        return widgetChatListModelMessages.copy((i & 1) != 0 ? widgetChatListModelMessages.items : list, (i & 2) != 0 ? widgetChatListModelMessages.oldestMessageId : j, (i & 4) != 0 ? widgetChatListModelMessages.newestKnownMessageId : j2, (i & 8) != 0 ? widgetChatListModelMessages.guildMembers : map, (i & 16) != 0 ? widgetChatListModelMessages.newMessagesMarkerMessageId : j3, (i & 32) != 0 ? widgetChatListModelMessages.newestSentByUserMessageId : l);
    }

    public final List<ChatListEntry> component1() {
        return this.items;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getOldestMessageId() {
        return this.oldestMessageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    public final Map<Long, GuildMember> component4() {
        return this.guildMembers;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getNewestSentByUserMessageId() {
        return this.newestSentByUserMessageId;
    }

    public final WidgetChatListModelMessages copy(List<? extends ChatListEntry> items, long oldestMessageId, long newestKnownMessageId, Map<Long, GuildMember> guildMembers, long newMessagesMarkerMessageId, Long newestSentByUserMessageId) {
        m.checkNotNullParameter(items, "items");
        return new WidgetChatListModelMessages(items, oldestMessageId, newestKnownMessageId, guildMembers, newMessagesMarkerMessageId, newestSentByUserMessageId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListModelMessages)) {
            return false;
        }
        WidgetChatListModelMessages widgetChatListModelMessages = (WidgetChatListModelMessages) other;
        return m.areEqual(this.items, widgetChatListModelMessages.items) && this.oldestMessageId == widgetChatListModelMessages.oldestMessageId && this.newestKnownMessageId == widgetChatListModelMessages.newestKnownMessageId && m.areEqual(this.guildMembers, widgetChatListModelMessages.guildMembers) && this.newMessagesMarkerMessageId == widgetChatListModelMessages.newMessagesMarkerMessageId && m.areEqual(this.newestSentByUserMessageId, widgetChatListModelMessages.newestSentByUserMessageId);
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final List<ChatListEntry> getItems() {
        return this.items;
    }

    public final long getNewMessagesMarkerMessageId() {
        return this.newMessagesMarkerMessageId;
    }

    public final long getNewestKnownMessageId() {
        return this.newestKnownMessageId;
    }

    public final Long getNewestSentByUserMessageId() {
        return this.newestSentByUserMessageId;
    }

    public final long getOldestMessageId() {
        return this.oldestMessageId;
    }

    public int hashCode() {
        List<ChatListEntry> list = this.items;
        int iA = (b.a(this.newestKnownMessageId) + ((b.a(this.oldestMessageId) + ((list != null ? list.hashCode() : 0) * 31)) * 31)) * 31;
        Map<Long, GuildMember> map = this.guildMembers;
        int iA2 = (b.a(this.newMessagesMarkerMessageId) + ((iA + (map != null ? map.hashCode() : 0)) * 31)) * 31;
        Long l = this.newestSentByUserMessageId;
        return iA2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetChatListModelMessages(items=");
        sbU.append(this.items);
        sbU.append(", oldestMessageId=");
        sbU.append(this.oldestMessageId);
        sbU.append(", newestKnownMessageId=");
        sbU.append(this.newestKnownMessageId);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", newMessagesMarkerMessageId=");
        sbU.append(this.newMessagesMarkerMessageId);
        sbU.append(", newestSentByUserMessageId=");
        return a.G(sbU, this.newestSentByUserMessageId, ")");
    }
}
