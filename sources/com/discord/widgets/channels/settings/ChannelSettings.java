package com.discord.widgets.channels.settings;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelSettings {
    public static final ChannelSettings$Companion Companion = new ChannelSettings$Companion(null);
    private final Channel channel;
    private final boolean isMuted;
    private final String muteEndTime;

    public ChannelSettings(Channel channel, boolean z2, String str) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.isMuted = z2;
        this.muteEndTime = str;
    }

    public static /* synthetic */ ChannelSettings copy$default(ChannelSettings channelSettings, Channel channel, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelSettings.channel;
        }
        if ((i & 2) != 0) {
            z2 = channelSettings.isMuted;
        }
        if ((i & 4) != 0) {
            str = channelSettings.muteEndTime;
        }
        return channelSettings.copy(channel, z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMuteEndTime() {
        return this.muteEndTime;
    }

    public final ChannelSettings copy(Channel channel, boolean isMuted, String muteEndTime) {
        m.checkNotNullParameter(channel, "channel");
        return new ChannelSettings(channel, isMuted, muteEndTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelSettings)) {
            return false;
        }
        ChannelSettings channelSettings = (ChannelSettings) other;
        return m.areEqual(this.channel, channelSettings.channel) && this.isMuted == channelSettings.isMuted && m.areEqual(this.muteEndTime, channelSettings.muteEndTime);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getMuteEndTime() {
        return this.muteEndTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.isMuted;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        String str = this.muteEndTime;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelSettings(channel=");
        sbU.append(this.channel);
        sbU.append(", isMuted=");
        sbU.append(this.isMuted);
        sbU.append(", muteEndTime=");
        return a.J(sbU, this.muteEndTime, ")");
    }
}
