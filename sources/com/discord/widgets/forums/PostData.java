package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import java.util.List;
import java.util.Map;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PostData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PostData {
    private final Channel channel;
    private final Map<Long, String> channelNames;
    private final Message firstMessage;
    private final Map<Long, GuildMember> guildMembers;
    private final Map<Long, GuildRole> guildRoles;
    private final boolean isActivePost;
    private final boolean isDefaultReaction;
    private final boolean isFirstMessageBlocked;
    private final boolean isMe;
    private final boolean isPinned;
    private final Integer messageCount;
    private final MessageReaction mostCommonReaction;
    private final Long mostRecentMessageTimestamp;
    private final long myUserId;
    private final User owner;
    private final ForumPostReadState readState;
    private final PostTagData tag;
    private final List<UserGuildMember> typingUsers;
    private final Integer unreadCount;

    public PostData(Channel channel, User user, long j, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, String> map3, Message message, boolean z2, Long l, Integer num, PostTagData postTagData, MessageReaction messageReaction, boolean z3, ForumPostReadState forumPostReadState, Integer num2, List<UserGuildMember> list) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(map, "guildMembers");
        C12238m.checkNotNullParameter(map2, "guildRoles");
        C12238m.checkNotNullParameter(map3, "channelNames");
        C12238m.checkNotNullParameter(forumPostReadState, "readState");
        C12238m.checkNotNullParameter(list, "typingUsers");
        this.channel = channel;
        this.owner = user;
        this.myUserId = j;
        this.guildMembers = map;
        this.guildRoles = map2;
        this.channelNames = map3;
        this.firstMessage = message;
        this.isFirstMessageBlocked = z2;
        this.mostRecentMessageTimestamp = l;
        this.messageCount = num;
        this.tag = postTagData;
        this.mostCommonReaction = messageReaction;
        this.isDefaultReaction = z3;
        this.readState = forumPostReadState;
        this.unreadCount = num2;
        this.typingUsers = list;
        this.isActivePost = !ChannelUtils.m7686j(channel);
        this.isPinned = ChannelUtils.m7666A(channel);
        this.isMe = user != null && user.getId() == j;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getMessageCount() {
        return this.messageCount;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final PostTagData getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final MessageReaction getMostCommonReaction() {
        return this.mostCommonReaction;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsDefaultReaction() {
        return this.isDefaultReaction;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final ForumPostReadState getReadState() {
        return this.readState;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getUnreadCount() {
        return this.unreadCount;
    }

    public final List<UserGuildMember> component16() {
        return this.typingUsers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getMyUserId() {
        return this.myUserId;
    }

    public final Map<Long, GuildMember> component4() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> component5() {
        return this.guildRoles;
    }

    public final Map<Long, String> component6() {
        return this.channelNames;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Message getFirstMessage() {
        return this.firstMessage;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsFirstMessageBlocked() {
        return this.isFirstMessageBlocked;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Long getMostRecentMessageTimestamp() {
        return this.mostRecentMessageTimestamp;
    }

    public final PostData copy(Channel channel, User owner, long myUserId, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, Message firstMessage, boolean isFirstMessageBlocked, Long mostRecentMessageTimestamp, Integer messageCount, PostTagData tag, MessageReaction mostCommonReaction, boolean isDefaultReaction, ForumPostReadState readState, Integer unreadCount, List<UserGuildMember> typingUsers) {
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(guildMembers, "guildMembers");
        C12238m.checkNotNullParameter(guildRoles, "guildRoles");
        C12238m.checkNotNullParameter(channelNames, "channelNames");
        C12238m.checkNotNullParameter(readState, "readState");
        C12238m.checkNotNullParameter(typingUsers, "typingUsers");
        return new PostData(channel, owner, myUserId, guildMembers, guildRoles, channelNames, firstMessage, isFirstMessageBlocked, mostRecentMessageTimestamp, messageCount, tag, mostCommonReaction, isDefaultReaction, readState, unreadCount, typingUsers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostData)) {
            return false;
        }
        PostData postData = (PostData) other;
        return C12238m.areEqual(this.channel, postData.channel) && C12238m.areEqual(this.owner, postData.owner) && this.myUserId == postData.myUserId && C12238m.areEqual(this.guildMembers, postData.guildMembers) && C12238m.areEqual(this.guildRoles, postData.guildRoles) && C12238m.areEqual(this.channelNames, postData.channelNames) && C12238m.areEqual(this.firstMessage, postData.firstMessage) && this.isFirstMessageBlocked == postData.isFirstMessageBlocked && C12238m.areEqual(this.mostRecentMessageTimestamp, postData.mostRecentMessageTimestamp) && C12238m.areEqual(this.messageCount, postData.messageCount) && C12238m.areEqual(this.tag, postData.tag) && C12238m.areEqual(this.mostCommonReaction, postData.mostCommonReaction) && this.isDefaultReaction == postData.isDefaultReaction && C12238m.areEqual(this.readState, postData.readState) && C12238m.areEqual(this.unreadCount, postData.unreadCount) && C12238m.areEqual(this.typingUsers, postData.typingUsers);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    public final Message getFirstMessage() {
        return this.firstMessage;
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final Integer getMessageCount() {
        return this.messageCount;
    }

    public final MessageReaction getMostCommonReaction() {
        return this.mostCommonReaction;
    }

    public final Long getMostRecentMessageTimestamp() {
        return this.mostRecentMessageTimestamp;
    }

    public final long getMyUserId() {
        return this.myUserId;
    }

    public final User getOwner() {
        return this.owner;
    }

    public final ForumPostReadState getReadState() {
        return this.readState;
    }

    public final PostTagData getTag() {
        return this.tag;
    }

    public final List<UserGuildMember> getTypingUsers() {
        return this.typingUsers;
    }

    public final Integer getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        User user = this.owner;
        int iM3a = (C0002b.m3a(this.myUserId) + ((iHashCode + (user != null ? user.hashCode() : 0)) * 31)) * 31;
        Map<Long, GuildMember> map = this.guildMembers;
        int iHashCode2 = (iM3a + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map2 = this.guildRoles;
        int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, String> map3 = this.channelNames;
        int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Message message = this.firstMessage;
        int iHashCode5 = (iHashCode4 + (message != null ? message.hashCode() : 0)) * 31;
        boolean z2 = this.isFirstMessageBlocked;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode5 + r0) * 31;
        Long l = this.mostRecentMessageTimestamp;
        int iHashCode6 = (i + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.messageCount;
        int iHashCode7 = (iHashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        PostTagData postTagData = this.tag;
        int iHashCode8 = (iHashCode7 + (postTagData != null ? postTagData.hashCode() : 0)) * 31;
        MessageReaction messageReaction = this.mostCommonReaction;
        int iHashCode9 = (iHashCode8 + (messageReaction != null ? messageReaction.hashCode() : 0)) * 31;
        boolean z3 = this.isDefaultReaction;
        int i2 = (iHashCode9 + (z3 ? 1 : z3)) * 31;
        ForumPostReadState forumPostReadState = this.readState;
        int iHashCode10 = (i2 + (forumPostReadState != null ? forumPostReadState.hashCode() : 0)) * 31;
        Integer num2 = this.unreadCount;
        int iHashCode11 = (iHashCode10 + (num2 != null ? num2.hashCode() : 0)) * 31;
        List<UserGuildMember> list = this.typingUsers;
        return iHashCode11 + (list != null ? list.hashCode() : 0);
    }

    /* JADX INFO: renamed from: isActivePost, reason: from getter */
    public final boolean getIsActivePost() {
        return this.isActivePost;
    }

    public final boolean isDefaultReaction() {
        return this.isDefaultReaction;
    }

    public final boolean isFirstMessageBlocked() {
        return this.isFirstMessageBlocked;
    }

    /* JADX INFO: renamed from: isMe, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    /* JADX INFO: renamed from: isPinned, reason: from getter */
    public final boolean getIsPinned() {
        return this.isPinned;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("PostData(channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", owner=");
        sbM833U.append(this.owner);
        sbM833U.append(", myUserId=");
        sbM833U.append(this.myUserId);
        sbM833U.append(", guildMembers=");
        sbM833U.append(this.guildMembers);
        sbM833U.append(", guildRoles=");
        sbM833U.append(this.guildRoles);
        sbM833U.append(", channelNames=");
        sbM833U.append(this.channelNames);
        sbM833U.append(", firstMessage=");
        sbM833U.append(this.firstMessage);
        sbM833U.append(", isFirstMessageBlocked=");
        sbM833U.append(this.isFirstMessageBlocked);
        sbM833U.append(", mostRecentMessageTimestamp=");
        sbM833U.append(this.mostRecentMessageTimestamp);
        sbM833U.append(", messageCount=");
        sbM833U.append(this.messageCount);
        sbM833U.append(", tag=");
        sbM833U.append(this.tag);
        sbM833U.append(", mostCommonReaction=");
        sbM833U.append(this.mostCommonReaction);
        sbM833U.append(", isDefaultReaction=");
        sbM833U.append(this.isDefaultReaction);
        sbM833U.append(", readState=");
        sbM833U.append(this.readState);
        sbM833U.append(", unreadCount=");
        sbM833U.append(this.unreadCount);
        sbM833U.append(", typingUsers=");
        return C1643a.m824L(sbM833U, this.typingUsers, ")");
    }
}
