package com.discord.widgets.user.profile;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.user.UserProfile;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.streams.StreamContext;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.z.d.m;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserProfileHeaderViewModel$StoreState {
    private final boolean allowAnimatedEmojis;
    private final Channel channel;
    private final Collection<Map<Long, GuildMember>> guildMembers;
    private final MeUser me;
    private final boolean reducedMotionEnabled;
    private final ModelRichPresence richPresence;
    private final StreamContext streamContext;
    private final User user;
    private final Map<Long, GuildMember> userIdToGuildMemberMap;
    private final UserProfile userProfile;

    /* JADX WARN: Multi-variable type inference failed */
    public UserProfileHeaderViewModel$StoreState(MeUser meUser, User user, Map<Long, GuildMember> map, Collection<? extends Map<Long, GuildMember>> collection, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, Channel channel) {
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(map, "userIdToGuildMemberMap");
        m.checkNotNullParameter(collection, "guildMembers");
        m.checkNotNullParameter(userProfile, "userProfile");
        this.me = meUser;
        this.user = user;
        this.userIdToGuildMemberMap = map;
        this.guildMembers = collection;
        this.richPresence = modelRichPresence;
        this.streamContext = streamContext;
        this.userProfile = userProfile;
        this.allowAnimatedEmojis = z2;
        this.reducedMotionEnabled = z3;
        this.channel = channel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserProfileHeaderViewModel$StoreState copy$default(UserProfileHeaderViewModel$StoreState userProfileHeaderViewModel$StoreState, MeUser meUser, User user, Map map, Collection collection, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, Channel channel, int i, Object obj) {
        return userProfileHeaderViewModel$StoreState.copy((i & 1) != 0 ? userProfileHeaderViewModel$StoreState.me : meUser, (i & 2) != 0 ? userProfileHeaderViewModel$StoreState.user : user, (i & 4) != 0 ? userProfileHeaderViewModel$StoreState.userIdToGuildMemberMap : map, (i & 8) != 0 ? userProfileHeaderViewModel$StoreState.guildMembers : collection, (i & 16) != 0 ? userProfileHeaderViewModel$StoreState.richPresence : modelRichPresence, (i & 32) != 0 ? userProfileHeaderViewModel$StoreState.streamContext : streamContext, (i & 64) != 0 ? userProfileHeaderViewModel$StoreState.userProfile : userProfile, (i & 128) != 0 ? userProfileHeaderViewModel$StoreState.allowAnimatedEmojis : z2, (i & 256) != 0 ? userProfileHeaderViewModel$StoreState.reducedMotionEnabled : z3, (i & 512) != 0 ? userProfileHeaderViewModel$StoreState.channel : channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final Map<Long, GuildMember> component3() {
        return this.userIdToGuildMemberMap;
    }

    public final Collection<Map<Long, GuildMember>> component4() {
        return this.guildMembers;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ModelRichPresence getRichPresence() {
        return this.richPresence;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getReducedMotionEnabled() {
        return this.reducedMotionEnabled;
    }

    public final UserProfileHeaderViewModel$StoreState copy(MeUser me2, User user, Map<Long, GuildMember> userIdToGuildMemberMap, Collection<? extends Map<Long, GuildMember>> guildMembers, ModelRichPresence richPresence, StreamContext streamContext, UserProfile userProfile, boolean allowAnimatedEmojis, boolean reducedMotionEnabled, Channel channel) {
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(userIdToGuildMemberMap, "userIdToGuildMemberMap");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(userProfile, "userProfile");
        return new UserProfileHeaderViewModel$StoreState(me2, user, userIdToGuildMemberMap, guildMembers, richPresence, streamContext, userProfile, allowAnimatedEmojis, reducedMotionEnabled, channel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfileHeaderViewModel$StoreState)) {
            return false;
        }
        UserProfileHeaderViewModel$StoreState userProfileHeaderViewModel$StoreState = (UserProfileHeaderViewModel$StoreState) other;
        return m.areEqual(this.me, userProfileHeaderViewModel$StoreState.me) && m.areEqual(this.user, userProfileHeaderViewModel$StoreState.user) && m.areEqual(this.userIdToGuildMemberMap, userProfileHeaderViewModel$StoreState.userIdToGuildMemberMap) && m.areEqual(this.guildMembers, userProfileHeaderViewModel$StoreState.guildMembers) && m.areEqual(this.richPresence, userProfileHeaderViewModel$StoreState.richPresence) && m.areEqual(this.streamContext, userProfileHeaderViewModel$StoreState.streamContext) && m.areEqual(this.userProfile, userProfileHeaderViewModel$StoreState.userProfile) && this.allowAnimatedEmojis == userProfileHeaderViewModel$StoreState.allowAnimatedEmojis && this.reducedMotionEnabled == userProfileHeaderViewModel$StoreState.reducedMotionEnabled && m.areEqual(this.channel, userProfileHeaderViewModel$StoreState.channel);
    }

    public final boolean getAllowAnimatedEmojis() {
        return this.allowAnimatedEmojis;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Collection<Map<Long, GuildMember>> getGuildMembers() {
        return this.guildMembers;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final boolean getReducedMotionEnabled() {
        return this.reducedMotionEnabled;
    }

    public final ModelRichPresence getRichPresence() {
        return this.richPresence;
    }

    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    public final User getUser() {
        return this.user;
    }

    public final Map<Long, GuildMember> getUserIdToGuildMemberMap() {
        return this.userIdToGuildMemberMap;
    }

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        MeUser meUser = this.me;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        User user = this.user;
        int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
        Map<Long, GuildMember> map = this.userIdToGuildMemberMap;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Collection<Map<Long, GuildMember>> collection = this.guildMembers;
        int iHashCode4 = (iHashCode3 + (collection != null ? collection.hashCode() : 0)) * 31;
        ModelRichPresence modelRichPresence = this.richPresence;
        int iHashCode5 = (iHashCode4 + (modelRichPresence != null ? modelRichPresence.hashCode() : 0)) * 31;
        StreamContext streamContext = this.streamContext;
        int iHashCode6 = (iHashCode5 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
        UserProfile userProfile = this.userProfile;
        int iHashCode7 = (iHashCode6 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
        boolean z2 = this.allowAnimatedEmojis;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode7 + r2) * 31;
        boolean z3 = this.reducedMotionEnabled;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        Channel channel = this.channel;
        return i2 + (channel != null ? channel.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(me=");
        sbU.append(this.me);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", userIdToGuildMemberMap=");
        sbU.append(this.userIdToGuildMemberMap);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", richPresence=");
        sbU.append(this.richPresence);
        sbU.append(", streamContext=");
        sbU.append(this.streamContext);
        sbU.append(", userProfile=");
        sbU.append(this.userProfile);
        sbU.append(", allowAnimatedEmojis=");
        sbU.append(this.allowAnimatedEmojis);
        sbU.append(", reducedMotionEnabled=");
        sbU.append(this.reducedMotionEnabled);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
