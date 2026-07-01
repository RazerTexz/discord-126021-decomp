package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ChannelListItemStageVoiceChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelListItemStageVoiceChannel implements ChannelListItem, ChannelListVocalItem {
    private final Channel channel;
    private final boolean hasSpeakers;
    private final boolean isGuildRoleSubscriptionChannel;
    private final boolean isGuildRoleSubscriptionLockedChannel;
    private final boolean isLocked;
    private final String key;
    private final int numUsersConnected;
    private final Long permission;
    private final boolean selected;
    private final StageInstance stageInstance;
    private final int type;

    public ChannelListItemStageVoiceChannel(Channel channel, boolean z2, Long l, boolean z3, int i, StageInstance stageInstance, boolean z4, boolean z5, boolean z6) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.selected = z2;
        this.permission = l;
        this.isLocked = z3;
        this.numUsersConnected = i;
        this.stageInstance = stageInstance;
        this.hasSpeakers = z4;
        this.isGuildRoleSubscriptionLockedChannel = z5;
        this.isGuildRoleSubscriptionChannel = z6;
        this.type = 13;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(getChannel().getId());
        this.key = sb.toString();
    }

    public final Channel component1() {
        return getChannel();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getPermission() {
        return this.permission;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    public final int component5() {
        return getNumUsersConnected();
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getHasSpeakers() {
        return this.hasSpeakers;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    public final ChannelListItemStageVoiceChannel copy(Channel channel, boolean selected, Long permission, boolean isLocked, int numUsersConnected, StageInstance stageInstance, boolean hasSpeakers, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemStageVoiceChannel(channel, selected, permission, isLocked, numUsersConnected, stageInstance, hasSpeakers, isGuildRoleSubscriptionLockedChannel, isGuildRoleSubscriptionChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemStageVoiceChannel)) {
            return false;
        }
        ChannelListItemStageVoiceChannel channelListItemStageVoiceChannel = (ChannelListItemStageVoiceChannel) other;
        return Intrinsics3.areEqual(getChannel(), channelListItemStageVoiceChannel.getChannel()) && this.selected == channelListItemStageVoiceChannel.selected && Intrinsics3.areEqual(this.permission, channelListItemStageVoiceChannel.permission) && this.isLocked == channelListItemStageVoiceChannel.isLocked && getNumUsersConnected() == channelListItemStageVoiceChannel.getNumUsersConnected() && Intrinsics3.areEqual(this.stageInstance, channelListItemStageVoiceChannel.stageInstance) && this.hasSpeakers == channelListItemStageVoiceChannel.hasSpeakers && this.isGuildRoleSubscriptionLockedChannel == channelListItemStageVoiceChannel.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == channelListItemStageVoiceChannel.isGuildRoleSubscriptionChannel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListVocalItem
    public Channel getChannel() {
        return this.channel;
    }

    public final boolean getHasActiveEvent() {
        return this.stageInstance != null;
    }

    public final boolean getHasSpeakers() {
        return this.hasSpeakers;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListVocalItem
    public int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    public final Long getPermission() {
        return this.permission;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = getChannel();
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        Long l = this.permission;
        int iHashCode2 = (i + (l != null ? l.hashCode() : 0)) * 31;
        boolean z3 = this.isLocked;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int numUsersConnected = (getNumUsersConnected() + ((iHashCode2 + r3) * 31)) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode3 = (numUsersConnected + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        boolean z4 = this.hasSpeakers;
        ?? r0 = z4;
        if (z4) {
            r0 = 1;
        }
        int i2 = (iHashCode3 + r0) * 31;
        boolean z5 = this.isGuildRoleSubscriptionLockedChannel;
        ?? r1 = z5;
        if (z5) {
            r1 = 1;
        }
        int i3 = (i2 + r1) * 31;
        boolean z6 = this.isGuildRoleSubscriptionChannel;
        return i3 + (z6 ? 1 : z6);
    }

    public final boolean isGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    public final boolean isGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemStageVoiceChannel(channel=");
        sbU.append(getChannel());
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", permission=");
        sbU.append(this.permission);
        sbU.append(", isLocked=");
        sbU.append(this.isLocked);
        sbU.append(", numUsersConnected=");
        sbU.append(getNumUsersConnected());
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", hasSpeakers=");
        sbU.append(this.hasSpeakers);
        sbU.append(", isGuildRoleSubscriptionLockedChannel=");
        sbU.append(this.isGuildRoleSubscriptionLockedChannel);
        sbU.append(", isGuildRoleSubscriptionChannel=");
        return outline.O(sbU, this.isGuildRoleSubscriptionChannel, ")");
    }
}
