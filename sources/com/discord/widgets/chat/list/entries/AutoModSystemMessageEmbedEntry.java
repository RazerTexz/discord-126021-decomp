package com.discord.widgets.chat.list.entries;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState$State;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: AutoModSystemMessageEmbedEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutoModSystemMessageEmbedEntry extends ChatListEntry {
    private final boolean animateEmojis;
    private final GuildMember author;
    private final Channel channel;
    private final MessageEmbed embed;
    private final String key;
    private final Message message;
    private final StoreMessageState$State messageState;
    private final Map<Long, String> nickOrUsernames;
    private final Map<Long, GuildRole> roles;
    private final int type;

    public AutoModSystemMessageEmbedEntry(Channel channel, Message message, StoreMessageState$State storeMessageState$State, MessageEmbed messageEmbed, GuildMember guildMember, boolean z2, Map<Long, GuildRole> map, Map<Long, String> map2) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(messageEmbed, "embed");
        m.checkNotNullParameter(map2, "nickOrUsernames");
        this.channel = channel;
        this.message = message;
        this.messageState = storeMessageState$State;
        this.embed = messageEmbed;
        this.author = guildMember;
        this.animateEmojis = z2;
        this.roles = map;
        this.nickOrUsernames = map2;
        this.type = 45;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(message.getId());
        this.key = sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutoModSystemMessageEmbedEntry copy$default(AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry, Channel channel, Message message, StoreMessageState$State storeMessageState$State, MessageEmbed messageEmbed, GuildMember guildMember, boolean z2, Map map, Map map2, int i, Object obj) {
        return autoModSystemMessageEmbedEntry.copy((i & 1) != 0 ? autoModSystemMessageEmbedEntry.channel : channel, (i & 2) != 0 ? autoModSystemMessageEmbedEntry.message : message, (i & 4) != 0 ? autoModSystemMessageEmbedEntry.messageState : storeMessageState$State, (i & 8) != 0 ? autoModSystemMessageEmbedEntry.embed : messageEmbed, (i & 16) != 0 ? autoModSystemMessageEmbedEntry.author : guildMember, (i & 32) != 0 ? autoModSystemMessageEmbedEntry.animateEmojis : z2, (i & 64) != 0 ? autoModSystemMessageEmbedEntry.roles : map, (i & 128) != 0 ? autoModSystemMessageEmbedEntry.nickOrUsernames : map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreMessageState$State getMessageState() {
        return this.messageState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MessageEmbed getEmbed() {
        return this.embed;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuildMember getAuthor() {
        return this.author;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final Map<Long, GuildRole> component7() {
        return this.roles;
    }

    public final Map<Long, String> component8() {
        return this.nickOrUsernames;
    }

    public final AutoModSystemMessageEmbedEntry copy(Channel channel, Message message, StoreMessageState$State messageState, MessageEmbed embed, GuildMember author, boolean animateEmojis, Map<Long, GuildRole> roles, Map<Long, String> nickOrUsernames) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(embed, "embed");
        m.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
        return new AutoModSystemMessageEmbedEntry(channel, message, messageState, embed, author, animateEmojis, roles, nickOrUsernames);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoModSystemMessageEmbedEntry)) {
            return false;
        }
        AutoModSystemMessageEmbedEntry autoModSystemMessageEmbedEntry = (AutoModSystemMessageEmbedEntry) other;
        return m.areEqual(this.channel, autoModSystemMessageEmbedEntry.channel) && m.areEqual(this.message, autoModSystemMessageEmbedEntry.message) && m.areEqual(this.messageState, autoModSystemMessageEmbedEntry.messageState) && m.areEqual(this.embed, autoModSystemMessageEmbedEntry.embed) && m.areEqual(this.author, autoModSystemMessageEmbedEntry.author) && this.animateEmojis == autoModSystemMessageEmbedEntry.animateEmojis && m.areEqual(this.roles, autoModSystemMessageEmbedEntry.roles) && m.areEqual(this.nickOrUsernames, autoModSystemMessageEmbedEntry.nickOrUsernames);
    }

    public final boolean getAnimateEmojis() {
        return this.animateEmojis;
    }

    public final GuildMember getAuthor() {
        return this.author;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final MessageEmbed getEmbed() {
        return this.embed;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final StoreMessageState$State getMessageState() {
        return this.messageState;
    }

    public final Map<Long, String> getNickOrUsernames() {
        return this.nickOrUsernames;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v24 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Message message = this.message;
        int iHashCode2 = (iHashCode + (message != null ? message.hashCode() : 0)) * 31;
        StoreMessageState$State storeMessageState$State = this.messageState;
        int iHashCode3 = (iHashCode2 + (storeMessageState$State != null ? storeMessageState$State.hashCode() : 0)) * 31;
        MessageEmbed messageEmbed = this.embed;
        int iHashCode4 = (iHashCode3 + (messageEmbed != null ? messageEmbed.hashCode() : 0)) * 31;
        GuildMember guildMember = this.author;
        int iHashCode5 = (iHashCode4 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        boolean z2 = this.animateEmojis;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode5 + r2) * 31;
        Map<Long, GuildRole> map = this.roles;
        int iHashCode6 = (i + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, String> map2 = this.nickOrUsernames;
        return iHashCode6 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AutoModSystemMessageEmbedEntry(channel=");
        sbU.append(this.channel);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", messageState=");
        sbU.append(this.messageState);
        sbU.append(", embed=");
        sbU.append(this.embed);
        sbU.append(", author=");
        sbU.append(this.author);
        sbU.append(", animateEmojis=");
        sbU.append(this.animateEmojis);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", nickOrUsernames=");
        return a.M(sbU, this.nickOrUsernames, ")");
    }
}
