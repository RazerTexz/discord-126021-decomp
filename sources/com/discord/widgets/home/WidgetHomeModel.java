package com.discord.widgets.home;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreStream;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHomeModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHomeModel {
    public static final WidgetHomeModel$Companion Companion = new WidgetHomeModel$Companion(null);
    private final Channel channel;
    private final long channelId;
    private final Presence dmPresence;
    private final boolean isCallConnected;
    private final boolean isFriend;
    private final NsfwAllowance nsfwAllowed;
    private final Channel parentChannel;
    private final StoreChannelsSelected$ResolvedSelectedChannel selectedChannel;
    private final Channel selectedVoiceChannel;
    private final int threadCount;
    private final boolean threadExperimentEnabled;
    private final int unreadCount;

    public WidgetHomeModel(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, Channel channel, Channel channel2, Presence presence, int i, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, int i2, boolean z4) {
        m.checkNotNullParameter(storeChannelsSelected$ResolvedSelectedChannel, "selectedChannel");
        this.selectedChannel = storeChannelsSelected$ResolvedSelectedChannel;
        this.selectedVoiceChannel = channel;
        this.parentChannel = channel2;
        this.dmPresence = presence;
        this.unreadCount = i;
        this.isFriend = z2;
        this.isCallConnected = z3;
        this.nsfwAllowed = nsfwAllowance;
        this.threadCount = i2;
        this.threadExperimentEnabled = z4;
        this.channel = storeChannelsSelected$ResolvedSelectedChannel.getMaybeChannel();
        Channel maybeChannel = storeChannelsSelected$ResolvedSelectedChannel.getMaybeChannel();
        this.channelId = maybeChannel != null ? maybeChannel.getId() : 0L;
    }

    public static /* synthetic */ WidgetHomeModel copy$default(WidgetHomeModel widgetHomeModel, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, Channel channel, Channel channel2, Presence presence, int i, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, int i2, boolean z4, int i3, Object obj) {
        return widgetHomeModel.copy((i3 & 1) != 0 ? widgetHomeModel.selectedChannel : storeChannelsSelected$ResolvedSelectedChannel, (i3 & 2) != 0 ? widgetHomeModel.selectedVoiceChannel : channel, (i3 & 4) != 0 ? widgetHomeModel.parentChannel : channel2, (i3 & 8) != 0 ? widgetHomeModel.dmPresence : presence, (i3 & 16) != 0 ? widgetHomeModel.unreadCount : i, (i3 & 32) != 0 ? widgetHomeModel.isFriend : z2, (i3 & 64) != 0 ? widgetHomeModel.isCallConnected : z3, (i3 & 128) != 0 ? widgetHomeModel.nsfwAllowed : nsfwAllowance, (i3 & 256) != 0 ? widgetHomeModel.threadCount : i2, (i3 & 512) != 0 ? widgetHomeModel.threadExperimentEnabled : z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreChannelsSelected$ResolvedSelectedChannel getSelectedChannel() {
        return this.selectedChannel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getThreadExperimentEnabled() {
        return this.threadExperimentEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Presence getDmPresence() {
        return this.dmPresence;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsFriend() {
        return this.isFriend;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsCallConnected() {
        return this.isCallConnected;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getThreadCount() {
        return this.threadCount;
    }

    public final WidgetHomeModel copy(StoreChannelsSelected$ResolvedSelectedChannel selectedChannel, Channel selectedVoiceChannel, Channel parentChannel, Presence dmPresence, int unreadCount, boolean isFriend, boolean isCallConnected, NsfwAllowance nsfwAllowed, int threadCount, boolean threadExperimentEnabled) {
        m.checkNotNullParameter(selectedChannel, "selectedChannel");
        return new WidgetHomeModel(selectedChannel, selectedVoiceChannel, parentChannel, dmPresence, unreadCount, isFriend, isCallConnected, nsfwAllowed, threadCount, threadExperimentEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHomeModel)) {
            return false;
        }
        WidgetHomeModel widgetHomeModel = (WidgetHomeModel) other;
        return m.areEqual(this.selectedChannel, widgetHomeModel.selectedChannel) && m.areEqual(this.selectedVoiceChannel, widgetHomeModel.selectedVoiceChannel) && m.areEqual(this.parentChannel, widgetHomeModel.parentChannel) && m.areEqual(this.dmPresence, widgetHomeModel.dmPresence) && this.unreadCount == widgetHomeModel.unreadCount && this.isFriend == widgetHomeModel.isFriend && this.isCallConnected == widgetHomeModel.isCallConnected && m.areEqual(this.nsfwAllowed, widgetHomeModel.nsfwAllowed) && this.threadCount == widgetHomeModel.threadCount && this.threadExperimentEnabled == widgetHomeModel.threadExperimentEnabled;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Presence getDmPresence() {
        return this.dmPresence;
    }

    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    public final StoreChannelsSelected$ResolvedSelectedChannel getSelectedChannel() {
        return this.selectedChannel;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final int getThreadCount() {
        return this.threadCount;
    }

    public final boolean getThreadExperimentEnabled() {
        return this.threadExperimentEnabled;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel = this.selectedChannel;
        int iHashCode = (storeChannelsSelected$ResolvedSelectedChannel != null ? storeChannelsSelected$ResolvedSelectedChannel.hashCode() : 0) * 31;
        Channel channel = this.selectedVoiceChannel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Channel channel2 = this.parentChannel;
        int iHashCode3 = (iHashCode2 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        Presence presence = this.dmPresence;
        int iHashCode4 = (((iHashCode3 + (presence != null ? presence.hashCode() : 0)) * 31) + this.unreadCount) * 31;
        boolean z2 = this.isFriend;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        boolean z3 = this.isCallConnected;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowed;
        int iHashCode5 = (((i2 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31) + this.threadCount) * 31;
        boolean z4 = this.threadExperimentEnabled;
        return iHashCode5 + (z4 ? 1 : z4);
    }

    public final boolean isCallConnected() {
        return this.isCallConnected;
    }

    public final boolean isChannelNsfw() {
        Channel channel = this.channel;
        return channel != null && channel.getNsfw();
    }

    public final boolean isFriend() {
        return this.isFriend;
    }

    public final boolean isNsfwUnConsented() {
        return (this.channel == null || StoreStream.Companion.getGuildsNsfw().isGuildNsfwGateAgreed(this.channel.getGuildId())) ? false : true;
    }

    public String toString() {
        StringBuilder sbU = a.U("WidgetHomeModel(selectedChannel=");
        sbU.append(this.selectedChannel);
        sbU.append(", selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(", parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", dmPresence=");
        sbU.append(this.dmPresence);
        sbU.append(", unreadCount=");
        sbU.append(this.unreadCount);
        sbU.append(", isFriend=");
        sbU.append(this.isFriend);
        sbU.append(", isCallConnected=");
        sbU.append(this.isCallConnected);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(", threadCount=");
        sbU.append(this.threadCount);
        sbU.append(", threadExperimentEnabled=");
        return a.O(sbU, this.threadExperimentEnabled, ")");
    }
}
