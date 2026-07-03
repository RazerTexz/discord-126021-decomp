package com.discord.widgets.chat.list.entries;

import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import java.util.Map;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ThreadEmbedEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ThreadEmbedEntry extends ChatListEntry {
    private final boolean animateEmojis;
    private final String key;
    private final long messageId;
    private final Message mostRecentMessage;
    private final GuildMember mostRecentMessageGuildMember;
    private final Map<Long, String> nickOrUsernames;
    private final Message parentMessage;
    private final Map<Long, GuildRole> roleMentions;
    private final Channel thread;
    private final int threadMessageCount;
    private final int type;

    public ThreadEmbedEntry(long j, Channel channel, int i, Message message, Map<Long, GuildRole> map, Map<Long, String> map2, boolean z2, GuildMember guildMember, Message message2) {
        C12238m.checkNotNullParameter(channel, "thread");
        C12238m.checkNotNullParameter(map2, "nickOrUsernames");
        C12238m.checkNotNullParameter(message2, "parentMessage");
        this.messageId = j;
        this.thread = channel;
        this.threadMessageCount = i;
        this.mostRecentMessage = message;
        this.roleMentions = map;
        this.nickOrUsernames = map2;
        this.animateEmojis = z2;
        this.mostRecentMessageGuildMember = guildMember;
        this.parentMessage = message2;
        this.type = 35;
        this.key = C1643a.m877t("35 -- ", j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getThread() {
        return this.thread;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getThreadMessageCount() {
        return this.threadMessageCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Message getMostRecentMessage() {
        return this.mostRecentMessage;
    }

    public final Map<Long, GuildRole> component5() {
        return this.roleMentions;
    }

    public final Map<Long, String> component6() {
        return this.nickOrUsernames;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final GuildMember getMostRecentMessageGuildMember() {
        return this.mostRecentMessageGuildMember;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Message getParentMessage() {
        return this.parentMessage;
    }

    public final ThreadEmbedEntry copy(long messageId, Channel thread, int threadMessageCount, Message mostRecentMessage, Map<Long, GuildRole> roleMentions, Map<Long, String> nickOrUsernames, boolean animateEmojis, GuildMember mostRecentMessageGuildMember, Message parentMessage) {
        C12238m.checkNotNullParameter(thread, "thread");
        C12238m.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
        C12238m.checkNotNullParameter(parentMessage, "parentMessage");
        return new ThreadEmbedEntry(messageId, thread, threadMessageCount, mostRecentMessage, roleMentions, nickOrUsernames, animateEmojis, mostRecentMessageGuildMember, parentMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadEmbedEntry)) {
            return false;
        }
        ThreadEmbedEntry threadEmbedEntry = (ThreadEmbedEntry) other;
        return this.messageId == threadEmbedEntry.messageId && C12238m.areEqual(this.thread, threadEmbedEntry.thread) && this.threadMessageCount == threadEmbedEntry.threadMessageCount && C12238m.areEqual(this.mostRecentMessage, threadEmbedEntry.mostRecentMessage) && C12238m.areEqual(this.roleMentions, threadEmbedEntry.roleMentions) && C12238m.areEqual(this.nickOrUsernames, threadEmbedEntry.nickOrUsernames) && this.animateEmojis == threadEmbedEntry.animateEmojis && C12238m.areEqual(this.mostRecentMessageGuildMember, threadEmbedEntry.mostRecentMessageGuildMember) && C12238m.areEqual(this.parentMessage, threadEmbedEntry.parentMessage);
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final Message getMostRecentMessage() {
        return this.mostRecentMessage;
    }

    public final GuildMember getMostRecentMessageGuildMember() {
        return this.mostRecentMessageGuildMember;
    }

    public final Map<Long, String> getNickOrUsernames() {
        return this.nickOrUsernames;
    }

    public final Message getParentMessage() {
        return this.parentMessage;
    }

    public final Map<Long, GuildRole> getRoleMentions() {
        return this.roleMentions;
    }

    public final Channel getThread() {
        return this.thread;
    }

    public final int getThreadMessageCount() {
        return this.threadMessageCount;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v25 */
    public int hashCode() {
        int iM3a = C0002b.m3a(this.messageId) * 31;
        Channel channel = this.thread;
        int iHashCode = (((iM3a + (channel != null ? channel.hashCode() : 0)) * 31) + this.threadMessageCount) * 31;
        Message message = this.mostRecentMessage;
        int iHashCode2 = (iHashCode + (message != null ? message.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.roleMentions;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.nickOrUsernames;
        int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        boolean z2 = this.animateEmojis;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode4 + r1) * 31;
        GuildMember guildMember = this.mostRecentMessageGuildMember;
        int iHashCode5 = (i + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        Message message2 = this.parentMessage;
        return iHashCode5 + (message2 != null ? message2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ThreadEmbedEntry(messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", thread=");
        sbM833U.append(this.thread);
        sbM833U.append(", threadMessageCount=");
        sbM833U.append(this.threadMessageCount);
        sbM833U.append(", mostRecentMessage=");
        sbM833U.append(this.mostRecentMessage);
        sbM833U.append(", roleMentions=");
        sbM833U.append(this.roleMentions);
        sbM833U.append(", nickOrUsernames=");
        sbM833U.append(this.nickOrUsernames);
        sbM833U.append(", animateEmojis=");
        sbM833U.append(this.animateEmojis);
        sbM833U.append(", mostRecentMessageGuildMember=");
        sbM833U.append(this.mostRecentMessageGuildMember);
        sbM833U.append(", parentMessage=");
        sbM833U.append(this.parentMessage);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
