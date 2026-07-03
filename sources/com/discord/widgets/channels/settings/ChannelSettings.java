package com.discord.widgets.channels.settings;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelSettings {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Channel channel;
    private final boolean isMuted;
    private final String muteEndTime;

    /* JADX INFO: compiled from: ChannelSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ChannelSettings createFromNotificationSettings(Channel channel, ModelNotificationSettings notificationSettings) {
            C12238m.checkNotNullParameter(channel, "channel");
            C12238m.checkNotNullParameter(notificationSettings, "notificationSettings");
            boolean zIsMuted = notificationSettings.isMuted();
            String muteEndTime = notificationSettings.getMuteEndTime();
            for (ModelNotificationSettings.ChannelOverride channelOverride : notificationSettings.getChannelOverrides()) {
                C12238m.checkNotNullExpressionValue(channelOverride, "override");
                if (channelOverride.getChannelId() == channel.getId()) {
                    zIsMuted = channelOverride.isMuted();
                    muteEndTime = channelOverride.getMuteEndTime();
                    break;
                }
            }
            return new ChannelSettings(channel, zIsMuted, muteEndTime);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChannelSettings(Channel channel, boolean z2, String str) {
        C12238m.checkNotNullParameter(channel, "channel");
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
        C12238m.checkNotNullParameter(channel, "channel");
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
        return C12238m.areEqual(this.channel, channelSettings.channel) && this.isMuted == channelSettings.isMuted && C12238m.areEqual(this.muteEndTime, channelSettings.muteEndTime);
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
        StringBuilder sbM833U = C1643a.m833U("ChannelSettings(channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", isMuted=");
        sbM833U.append(this.isMuted);
        sbM833U.append(", muteEndTime=");
        return C1643a.m822J(sbM833U, this.muteEndTime, ")");
    }
}
