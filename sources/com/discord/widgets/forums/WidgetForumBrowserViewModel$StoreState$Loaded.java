package com.discord.widgets.forums;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState;
import com.discord.stores.StoreThreadMessages$ThreadState;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetForumBrowserViewModel$StoreState$Loaded extends WidgetForumBrowserViewModel$StoreState {
    private final Map<Long, Channel> activeThreads;
    private final ArchivedThreadsStore$ThreadListingState archivedThreadsState;
    private final boolean canCreateForumChannelPosts;
    private final Channel channel;
    private final Map<Long, String> channelNames;
    private final Map<Long, Message> forumPostFirstMessages;
    private final Map<Long, StoreThreadMessages$ThreadState> forumPostMessageCounts;
    private final Map<Long, ForumPostReadState> forumPostReadStates;
    private final Map<Long, Integer> forumPostUnreadCounts;
    private final Map<String, Emoji> guildEmojis;
    private final Map<Long, GuildMember> guildMembers;
    private final Map<Long, GuildRole> guildRoles;
    private final boolean isThreadSyncedGuild;
    private final MeUser meUser;
    private final Map<Long, Long> mostRecentMessageIds;
    private final Set<Long> myBlockedUserIds;
    private final Map<Long, Set<Long>> typingUsers;
    private final Map<Long, User> users;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetForumBrowserViewModel$StoreState$Loaded(MeUser meUser, Map<Long, ? extends User> map, ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState, Map<Long, Channel> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, String> map5, Channel channel, Map<Long, Message> map6, Map<Long, StoreThreadMessages$ThreadState> map7, Set<Long> set, boolean z2, Map<Long, Long> map8, Map<String, ? extends Emoji> map9, Map<Long, ForumPostReadState> map10, Map<Long, Integer> map11, boolean z3, Map<Long, ? extends Set<Long>> map12) {
        super(null);
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(map, "users");
        m.checkNotNullParameter(archivedThreadsStore$ThreadListingState, "archivedThreadsState");
        m.checkNotNullParameter(map2, "activeThreads");
        m.checkNotNullParameter(map3, "guildMembers");
        m.checkNotNullParameter(map4, "guildRoles");
        m.checkNotNullParameter(map5, "channelNames");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map6, "forumPostFirstMessages");
        m.checkNotNullParameter(map7, "forumPostMessageCounts");
        m.checkNotNullParameter(set, "myBlockedUserIds");
        m.checkNotNullParameter(map8, "mostRecentMessageIds");
        m.checkNotNullParameter(map9, "guildEmojis");
        m.checkNotNullParameter(map10, "forumPostReadStates");
        m.checkNotNullParameter(map11, "forumPostUnreadCounts");
        m.checkNotNullParameter(map12, "typingUsers");
        this.meUser = meUser;
        this.users = map;
        this.archivedThreadsState = archivedThreadsStore$ThreadListingState;
        this.activeThreads = map2;
        this.guildMembers = map3;
        this.guildRoles = map4;
        this.channelNames = map5;
        this.channel = channel;
        this.forumPostFirstMessages = map6;
        this.forumPostMessageCounts = map7;
        this.myBlockedUserIds = set;
        this.canCreateForumChannelPosts = z2;
        this.mostRecentMessageIds = map8;
        this.guildEmojis = map9;
        this.forumPostReadStates = map10;
        this.forumPostUnreadCounts = map11;
        this.isThreadSyncedGuild = z3;
        this.typingUsers = map12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetForumBrowserViewModel$StoreState$Loaded copy$default(WidgetForumBrowserViewModel$StoreState$Loaded widgetForumBrowserViewModel$StoreState$Loaded, MeUser meUser, Map map, ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState, Map map2, Map map3, Map map4, Map map5, Channel channel, Map map6, Map map7, Set set, boolean z2, Map map8, Map map9, Map map10, Map map11, boolean z3, Map map12, int i, Object obj) {
        return widgetForumBrowserViewModel$StoreState$Loaded.copy((i & 1) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.meUser : meUser, (i & 2) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.users : map, (i & 4) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.archivedThreadsState : archivedThreadsStore$ThreadListingState, (i & 8) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.activeThreads : map2, (i & 16) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.guildMembers : map3, (i & 32) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.guildRoles : map4, (i & 64) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.channelNames : map5, (i & 128) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.channel : channel, (i & 256) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.forumPostFirstMessages : map6, (i & 512) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.forumPostMessageCounts : map7, (i & 1024) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.myBlockedUserIds : set, (i & 2048) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.canCreateForumChannelPosts : z2, (i & 4096) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.mostRecentMessageIds : map8, (i & 8192) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.guildEmojis : map9, (i & 16384) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.forumPostReadStates : map10, (i & 32768) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.forumPostUnreadCounts : map11, (i & 65536) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.isThreadSyncedGuild : z3, (i & 131072) != 0 ? widgetForumBrowserViewModel$StoreState$Loaded.typingUsers : map12);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final Map<Long, StoreThreadMessages$ThreadState> component10() {
        return this.forumPostMessageCounts;
    }

    public final Set<Long> component11() {
        return this.myBlockedUserIds;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getCanCreateForumChannelPosts() {
        return this.canCreateForumChannelPosts;
    }

    public final Map<Long, Long> component13() {
        return this.mostRecentMessageIds;
    }

    public final Map<String, Emoji> component14() {
        return this.guildEmojis;
    }

    public final Map<Long, ForumPostReadState> component15() {
        return this.forumPostReadStates;
    }

    public final Map<Long, Integer> component16() {
        return this.forumPostUnreadCounts;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getIsThreadSyncedGuild() {
        return this.isThreadSyncedGuild;
    }

    public final Map<Long, Set<Long>> component18() {
        return this.typingUsers;
    }

    public final Map<Long, User> component2() {
        return this.users;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ArchivedThreadsStore$ThreadListingState getArchivedThreadsState() {
        return this.archivedThreadsState;
    }

    public final Map<Long, Channel> component4() {
        return this.activeThreads;
    }

    public final Map<Long, GuildMember> component5() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> component6() {
        return this.guildRoles;
    }

    public final Map<Long, String> component7() {
        return this.channelNames;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, Message> component9() {
        return this.forumPostFirstMessages;
    }

    public final WidgetForumBrowserViewModel$StoreState$Loaded copy(MeUser meUser, Map<Long, ? extends User> users, ArchivedThreadsStore$ThreadListingState archivedThreadsState, Map<Long, Channel> activeThreads, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, Channel channel, Map<Long, Message> forumPostFirstMessages, Map<Long, StoreThreadMessages$ThreadState> forumPostMessageCounts, Set<Long> myBlockedUserIds, boolean canCreateForumChannelPosts, Map<Long, Long> mostRecentMessageIds, Map<String, ? extends Emoji> guildEmojis, Map<Long, ForumPostReadState> forumPostReadStates, Map<Long, Integer> forumPostUnreadCounts, boolean isThreadSyncedGuild, Map<Long, ? extends Set<Long>> typingUsers) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(archivedThreadsState, "archivedThreadsState");
        m.checkNotNullParameter(activeThreads, "activeThreads");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        m.checkNotNullParameter(channelNames, "channelNames");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(forumPostFirstMessages, "forumPostFirstMessages");
        m.checkNotNullParameter(forumPostMessageCounts, "forumPostMessageCounts");
        m.checkNotNullParameter(myBlockedUserIds, "myBlockedUserIds");
        m.checkNotNullParameter(mostRecentMessageIds, "mostRecentMessageIds");
        m.checkNotNullParameter(guildEmojis, "guildEmojis");
        m.checkNotNullParameter(forumPostReadStates, "forumPostReadStates");
        m.checkNotNullParameter(forumPostUnreadCounts, "forumPostUnreadCounts");
        m.checkNotNullParameter(typingUsers, "typingUsers");
        return new WidgetForumBrowserViewModel$StoreState$Loaded(meUser, users, archivedThreadsState, activeThreads, guildMembers, guildRoles, channelNames, channel, forumPostFirstMessages, forumPostMessageCounts, myBlockedUserIds, canCreateForumChannelPosts, mostRecentMessageIds, guildEmojis, forumPostReadStates, forumPostUnreadCounts, isThreadSyncedGuild, typingUsers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetForumBrowserViewModel$StoreState$Loaded)) {
            return false;
        }
        WidgetForumBrowserViewModel$StoreState$Loaded widgetForumBrowserViewModel$StoreState$Loaded = (WidgetForumBrowserViewModel$StoreState$Loaded) other;
        return m.areEqual(this.meUser, widgetForumBrowserViewModel$StoreState$Loaded.meUser) && m.areEqual(this.users, widgetForumBrowserViewModel$StoreState$Loaded.users) && m.areEqual(this.archivedThreadsState, widgetForumBrowserViewModel$StoreState$Loaded.archivedThreadsState) && m.areEqual(this.activeThreads, widgetForumBrowserViewModel$StoreState$Loaded.activeThreads) && m.areEqual(this.guildMembers, widgetForumBrowserViewModel$StoreState$Loaded.guildMembers) && m.areEqual(this.guildRoles, widgetForumBrowserViewModel$StoreState$Loaded.guildRoles) && m.areEqual(this.channelNames, widgetForumBrowserViewModel$StoreState$Loaded.channelNames) && m.areEqual(this.channel, widgetForumBrowserViewModel$StoreState$Loaded.channel) && m.areEqual(this.forumPostFirstMessages, widgetForumBrowserViewModel$StoreState$Loaded.forumPostFirstMessages) && m.areEqual(this.forumPostMessageCounts, widgetForumBrowserViewModel$StoreState$Loaded.forumPostMessageCounts) && m.areEqual(this.myBlockedUserIds, widgetForumBrowserViewModel$StoreState$Loaded.myBlockedUserIds) && this.canCreateForumChannelPosts == widgetForumBrowserViewModel$StoreState$Loaded.canCreateForumChannelPosts && m.areEqual(this.mostRecentMessageIds, widgetForumBrowserViewModel$StoreState$Loaded.mostRecentMessageIds) && m.areEqual(this.guildEmojis, widgetForumBrowserViewModel$StoreState$Loaded.guildEmojis) && m.areEqual(this.forumPostReadStates, widgetForumBrowserViewModel$StoreState$Loaded.forumPostReadStates) && m.areEqual(this.forumPostUnreadCounts, widgetForumBrowserViewModel$StoreState$Loaded.forumPostUnreadCounts) && this.isThreadSyncedGuild == widgetForumBrowserViewModel$StoreState$Loaded.isThreadSyncedGuild && m.areEqual(this.typingUsers, widgetForumBrowserViewModel$StoreState$Loaded.typingUsers);
    }

    public final Map<Long, Channel> getActiveThreads() {
        return this.activeThreads;
    }

    public final ArchivedThreadsStore$ThreadListingState getArchivedThreadsState() {
        return this.archivedThreadsState;
    }

    public final boolean getCanCreateForumChannelPosts() {
        return this.canCreateForumChannelPosts;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    public final Map<Long, Message> getForumPostFirstMessages() {
        return this.forumPostFirstMessages;
    }

    public final Map<Long, StoreThreadMessages$ThreadState> getForumPostMessageCounts() {
        return this.forumPostMessageCounts;
    }

    public final Map<Long, ForumPostReadState> getForumPostReadStates() {
        return this.forumPostReadStates;
    }

    public final Map<Long, Integer> getForumPostUnreadCounts() {
        return this.forumPostUnreadCounts;
    }

    public final Map<String, Emoji> getGuildEmojis() {
        return this.guildEmojis;
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final Map<Long, Long> getMostRecentMessageIds() {
        return this.mostRecentMessageIds;
    }

    public final Set<Long> getMyBlockedUserIds() {
        return this.myBlockedUserIds;
    }

    public final Map<Long, Set<Long>> getTypingUsers() {
        return this.typingUsers;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        MeUser meUser = this.meUser;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        Map<Long, User> map = this.users;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingState = this.archivedThreadsState;
        int iHashCode3 = (iHashCode2 + (archivedThreadsStore$ThreadListingState != null ? archivedThreadsStore$ThreadListingState.hashCode() : 0)) * 31;
        Map<Long, Channel> map2 = this.activeThreads;
        int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, GuildMember> map3 = this.guildMembers;
        int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map4 = this.guildRoles;
        int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
        Map<Long, String> map5 = this.channelNames;
        int iHashCode7 = (iHashCode6 + (map5 != null ? map5.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode8 = (iHashCode7 + (channel != null ? channel.hashCode() : 0)) * 31;
        Map<Long, Message> map6 = this.forumPostFirstMessages;
        int iHashCode9 = (iHashCode8 + (map6 != null ? map6.hashCode() : 0)) * 31;
        Map<Long, StoreThreadMessages$ThreadState> map7 = this.forumPostMessageCounts;
        int iHashCode10 = (iHashCode9 + (map7 != null ? map7.hashCode() : 0)) * 31;
        Set<Long> set = this.myBlockedUserIds;
        int iHashCode11 = (iHashCode10 + (set != null ? set.hashCode() : 0)) * 31;
        boolean z2 = this.canCreateForumChannelPosts;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode11 + r2) * 31;
        Map<Long, Long> map8 = this.mostRecentMessageIds;
        int iHashCode12 = (i + (map8 != null ? map8.hashCode() : 0)) * 31;
        Map<String, Emoji> map9 = this.guildEmojis;
        int iHashCode13 = (iHashCode12 + (map9 != null ? map9.hashCode() : 0)) * 31;
        Map<Long, ForumPostReadState> map10 = this.forumPostReadStates;
        int iHashCode14 = (iHashCode13 + (map10 != null ? map10.hashCode() : 0)) * 31;
        Map<Long, Integer> map11 = this.forumPostUnreadCounts;
        int iHashCode15 = (iHashCode14 + (map11 != null ? map11.hashCode() : 0)) * 31;
        boolean z3 = this.isThreadSyncedGuild;
        int i2 = (iHashCode15 + (z3 ? 1 : z3)) * 31;
        Map<Long, Set<Long>> map12 = this.typingUsers;
        return i2 + (map12 != null ? map12.hashCode() : 0);
    }

    public final boolean isThreadSyncedGuild() {
        return this.isThreadSyncedGuild;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(meUser=");
        sbU.append(this.meUser);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", archivedThreadsState=");
        sbU.append(this.archivedThreadsState);
        sbU.append(", activeThreads=");
        sbU.append(this.activeThreads);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", guildRoles=");
        sbU.append(this.guildRoles);
        sbU.append(", channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", forumPostFirstMessages=");
        sbU.append(this.forumPostFirstMessages);
        sbU.append(", forumPostMessageCounts=");
        sbU.append(this.forumPostMessageCounts);
        sbU.append(", myBlockedUserIds=");
        sbU.append(this.myBlockedUserIds);
        sbU.append(", canCreateForumChannelPosts=");
        sbU.append(this.canCreateForumChannelPosts);
        sbU.append(", mostRecentMessageIds=");
        sbU.append(this.mostRecentMessageIds);
        sbU.append(", guildEmojis=");
        sbU.append(this.guildEmojis);
        sbU.append(", forumPostReadStates=");
        sbU.append(this.forumPostReadStates);
        sbU.append(", forumPostUnreadCounts=");
        sbU.append(this.forumPostUnreadCounts);
        sbU.append(", isThreadSyncedGuild=");
        sbU.append(this.isThreadSyncedGuild);
        sbU.append(", typingUsers=");
        return a.M(sbU, this.typingUsers, ")");
    }
}
