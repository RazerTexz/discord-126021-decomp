package com.discord.widgets.forums;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;

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
    private final PostData2 tag;
    private final List<UserGuildMember> typingUsers;
    private final Integer unreadCount;

    public PostData(Channel channel, User user, long j, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, String> map3, Message message, boolean z2, Long l, Integer num, PostData2 postData2, MessageReaction messageReaction, boolean z3, ForumPostReadState forumPostReadState, Integer num2, List<UserGuildMember> list) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, "guildMembers");
        Intrinsics3.checkNotNullParameter(map2, "guildRoles");
        Intrinsics3.checkNotNullParameter(map3, "channelNames");
        Intrinsics3.checkNotNullParameter(forumPostReadState, "readState");
        Intrinsics3.checkNotNullParameter(list, "typingUsers");
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
        this.tag = postData2;
        this.mostCommonReaction = messageReaction;
        this.isDefaultReaction = z3;
        this.readState = forumPostReadState;
        this.unreadCount = num2;
        this.typingUsers = list;
        this.isActivePost = !ChannelUtils.j(channel);
        this.isPinned = ChannelUtils.A(channel);
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
    public final PostData2 getTag() {
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

    public final PostData copy(Channel channel, User owner, long myUserId, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, Message firstMessage, boolean isFirstMessageBlocked, Long mostRecentMessageTimestamp, Integer messageCount, PostData2 tag, MessageReaction mostCommonReaction, boolean isDefaultReaction, ForumPostReadState readState, Integer unreadCount, List<UserGuildMember> typingUsers) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
        Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
        Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
        Intrinsics3.checkNotNullParameter(readState, "readState");
        Intrinsics3.checkNotNullParameter(typingUsers, "typingUsers");
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
        return Intrinsics3.areEqual(this.channel, postData.channel) && Intrinsics3.areEqual(this.owner, postData.owner) && this.myUserId == postData.myUserId && Intrinsics3.areEqual(this.guildMembers, postData.guildMembers) && Intrinsics3.areEqual(this.guildRoles, postData.guildRoles) && Intrinsics3.areEqual(this.channelNames, postData.channelNames) && Intrinsics3.areEqual(this.firstMessage, postData.firstMessage) && this.isFirstMessageBlocked == postData.isFirstMessageBlocked && Intrinsics3.areEqual(this.mostRecentMessageTimestamp, postData.mostRecentMessageTimestamp) && Intrinsics3.areEqual(this.messageCount, postData.messageCount) && Intrinsics3.areEqual(this.tag, postData.tag) && Intrinsics3.areEqual(this.mostCommonReaction, postData.mostCommonReaction) && this.isDefaultReaction == postData.isDefaultReaction && Intrinsics3.areEqual(this.readState, postData.readState) && Intrinsics3.areEqual(this.unreadCount, postData.unreadCount) && Intrinsics3.areEqual(this.typingUsers, postData.typingUsers);
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

    public final PostData2 getTag() {
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
        int iA = (b.a(this.myUserId) + ((iHashCode + (user != null ? user.hashCode() : 0)) * 31)) * 31;
        Map<Long, GuildMember> map = this.guildMembers;
        int iHashCode2 = (iA + (map != null ? map.hashCode() : 0)) * 31;
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
        PostData2 postData2 = this.tag;
        int iHashCode8 = (iHashCode7 + (postData2 != null ? postData2.hashCode() : 0)) * 31;
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
        StringBuilder sbU = outline.U("PostData(channel=");
        sbU.append(this.channel);
        sbU.append(", owner=");
        sbU.append(this.owner);
        sbU.append(", myUserId=");
        sbU.append(this.myUserId);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", guildRoles=");
        sbU.append(this.guildRoles);
        sbU.append(", channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", firstMessage=");
        sbU.append(this.firstMessage);
        sbU.append(", isFirstMessageBlocked=");
        sbU.append(this.isFirstMessageBlocked);
        sbU.append(", mostRecentMessageTimestamp=");
        sbU.append(this.mostRecentMessageTimestamp);
        sbU.append(", messageCount=");
        sbU.append(this.messageCount);
        sbU.append(", tag=");
        sbU.append(this.tag);
        sbU.append(", mostCommonReaction=");
        sbU.append(this.mostCommonReaction);
        sbU.append(", isDefaultReaction=");
        sbU.append(this.isDefaultReaction);
        sbU.append(", readState=");
        sbU.append(this.readState);
        sbU.append(", unreadCount=");
        sbU.append(this.unreadCount);
        sbU.append(", typingUsers=");
        return outline.L(sbU, this.typingUsers, ")");
    }
}
