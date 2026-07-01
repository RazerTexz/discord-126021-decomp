package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChannelListItemVoiceUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelListItemVoiceUser implements ChannelListItem {
    private final Channel channel;
    private final GuildMember computed;
    private final boolean hasChannelConnectPermission;
    private final boolean isApplicationStreaming;
    private final String key;
    private final int type;
    private final User user;
    private final VoiceState voiceState;

    public ChannelListItemVoiceUser(Channel channel, VoiceState voiceState, User user, GuildMember guildMember, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(guildMember, "computed");
        this.channel = channel;
        this.voiceState = voiceState;
        this.user = user;
        this.computed = guildMember;
        this.isApplicationStreaming = z2;
        this.hasChannelConnectPermission = z3;
        this.type = 2;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(voiceState.getChannelId());
        sb.append(voiceState.getUserId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemVoiceUser copy$default(ChannelListItemVoiceUser channelListItemVoiceUser, Channel channel, VoiceState voiceState, User user, GuildMember guildMember, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelListItemVoiceUser.channel;
        }
        if ((i & 2) != 0) {
            voiceState = channelListItemVoiceUser.voiceState;
        }
        VoiceState voiceState2 = voiceState;
        if ((i & 4) != 0) {
            user = channelListItemVoiceUser.user;
        }
        User user2 = user;
        if ((i & 8) != 0) {
            guildMember = channelListItemVoiceUser.computed;
        }
        GuildMember guildMember2 = guildMember;
        if ((i & 16) != 0) {
            z2 = channelListItemVoiceUser.isApplicationStreaming;
        }
        boolean z4 = z2;
        if ((i & 32) != 0) {
            z3 = channelListItemVoiceUser.hasChannelConnectPermission;
        }
        return channelListItemVoiceUser.copy(channel, voiceState2, user2, guildMember2, z4, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final VoiceState getVoiceState() {
        return this.voiceState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildMember getComputed() {
        return this.computed;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getHasChannelConnectPermission() {
        return this.hasChannelConnectPermission;
    }

    public final ChannelListItemVoiceUser copy(Channel channel, VoiceState voiceState, User user, GuildMember computed, boolean isApplicationStreaming, boolean hasChannelConnectPermission) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(computed, "computed");
        return new ChannelListItemVoiceUser(channel, voiceState, user, computed, isApplicationStreaming, hasChannelConnectPermission);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemVoiceUser)) {
            return false;
        }
        ChannelListItemVoiceUser channelListItemVoiceUser = (ChannelListItemVoiceUser) other;
        return Intrinsics3.areEqual(this.channel, channelListItemVoiceUser.channel) && Intrinsics3.areEqual(this.voiceState, channelListItemVoiceUser.voiceState) && Intrinsics3.areEqual(this.user, channelListItemVoiceUser.user) && Intrinsics3.areEqual(this.computed, channelListItemVoiceUser.computed) && this.isApplicationStreaming == channelListItemVoiceUser.isApplicationStreaming && this.hasChannelConnectPermission == channelListItemVoiceUser.hasChannelConnectPermission;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final GuildMember getComputed() {
        return this.computed;
    }

    public final boolean getHasChannelConnectPermission() {
        return this.hasChannelConnectPermission;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public final VoiceState getVoiceState() {
        return this.voiceState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        VoiceState voiceState = this.voiceState;
        int iHashCode2 = (iHashCode + (voiceState != null ? voiceState.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
        GuildMember guildMember = this.computed;
        int iHashCode4 = (iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        boolean z2 = this.isApplicationStreaming;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode4 + r1) * 31;
        boolean z3 = this.hasChannelConnectPermission;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemVoiceUser(channel=");
        sbU.append(this.channel);
        sbU.append(", voiceState=");
        sbU.append(this.voiceState);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", computed=");
        sbU.append(this.computed);
        sbU.append(", isApplicationStreaming=");
        sbU.append(this.isApplicationStreaming);
        sbU.append(", hasChannelConnectPermission=");
        return outline.O(sbU, this.hasChannelConnectPermission, ")");
    }
}
