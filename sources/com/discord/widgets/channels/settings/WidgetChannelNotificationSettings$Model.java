package com.discord.widgets.channels.settings;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelNotificationSettings$Model {
    public static final WidgetChannelNotificationSettings$Model$Companion Companion = new WidgetChannelNotificationSettings$Model$Companion(null);
    public static final float RADIO_DIMMED_ALPHA = 0.3f;
    public static final float RADIO_OPAQUE_ALPHA = 1.0f;
    private final boolean canAccessRedesignedForumChannels;
    private final Channel channel;
    private final boolean channelIsMuted;
    private final String channelMuteEndTime;
    private final Integer channelOverrideFlags;
    private final Integer forumPostNotificationSetting;
    private final boolean isAboveNotifyAllSize;
    private final boolean isGuildMuted;
    private final int notificationSetting;
    private final boolean notificationSettingIsInherited;
    private final Integer parentNotificationSetting;

    public WidgetChannelNotificationSettings$Model(Channel channel, boolean z2, String str, boolean z3, int i, Integer num, Integer num2, Integer num3, boolean z4, boolean z5, boolean z6) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.channelIsMuted = z2;
        this.channelMuteEndTime = str;
        this.isGuildMuted = z3;
        this.notificationSetting = i;
        this.channelOverrideFlags = num;
        this.forumPostNotificationSetting = num2;
        this.parentNotificationSetting = num3;
        this.notificationSettingIsInherited = z4;
        this.isAboveNotifyAllSize = z5;
        this.canAccessRedesignedForumChannels = z6;
    }

    public static /* synthetic */ WidgetChannelNotificationSettings$Model copy$default(WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model, Channel channel, boolean z2, String str, boolean z3, int i, Integer num, Integer num2, Integer num3, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
        return widgetChannelNotificationSettings$Model.copy((i2 & 1) != 0 ? widgetChannelNotificationSettings$Model.channel : channel, (i2 & 2) != 0 ? widgetChannelNotificationSettings$Model.channelIsMuted : z2, (i2 & 4) != 0 ? widgetChannelNotificationSettings$Model.channelMuteEndTime : str, (i2 & 8) != 0 ? widgetChannelNotificationSettings$Model.isGuildMuted : z3, (i2 & 16) != 0 ? widgetChannelNotificationSettings$Model.notificationSetting : i, (i2 & 32) != 0 ? widgetChannelNotificationSettings$Model.channelOverrideFlags : num, (i2 & 64) != 0 ? widgetChannelNotificationSettings$Model.forumPostNotificationSetting : num2, (i2 & 128) != 0 ? widgetChannelNotificationSettings$Model.parentNotificationSetting : num3, (i2 & 256) != 0 ? widgetChannelNotificationSettings$Model.notificationSettingIsInherited : z4, (i2 & 512) != 0 ? widgetChannelNotificationSettings$Model.isAboveNotifyAllSize : z5, (i2 & 1024) != 0 ? widgetChannelNotificationSettings$Model.canAccessRedesignedForumChannels : z6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsAboveNotifyAllSize() {
        return this.isAboveNotifyAllSize;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getCanAccessRedesignedForumChannels() {
        return this.canAccessRedesignedForumChannels;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getChannelIsMuted() {
        return this.channelIsMuted;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getChannelMuteEndTime() {
        return this.channelMuteEndTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsGuildMuted() {
        return this.isGuildMuted;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getNotificationSetting() {
        return this.notificationSetting;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getChannelOverrideFlags() {
        return this.channelOverrideFlags;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getForumPostNotificationSetting() {
        return this.forumPostNotificationSetting;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getParentNotificationSetting() {
        return this.parentNotificationSetting;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getNotificationSettingIsInherited() {
        return this.notificationSettingIsInherited;
    }

    public final WidgetChannelNotificationSettings$Model copy(Channel channel, boolean channelIsMuted, String channelMuteEndTime, boolean isGuildMuted, int notificationSetting, Integer channelOverrideFlags, Integer forumPostNotificationSetting, Integer parentNotificationSetting, boolean notificationSettingIsInherited, boolean isAboveNotifyAllSize, boolean canAccessRedesignedForumChannels) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetChannelNotificationSettings$Model(channel, channelIsMuted, channelMuteEndTime, isGuildMuted, notificationSetting, channelOverrideFlags, forumPostNotificationSetting, parentNotificationSetting, notificationSettingIsInherited, isAboveNotifyAllSize, canAccessRedesignedForumChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelNotificationSettings$Model)) {
            return false;
        }
        WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model = (WidgetChannelNotificationSettings$Model) other;
        return m.areEqual(this.channel, widgetChannelNotificationSettings$Model.channel) && this.channelIsMuted == widgetChannelNotificationSettings$Model.channelIsMuted && m.areEqual(this.channelMuteEndTime, widgetChannelNotificationSettings$Model.channelMuteEndTime) && this.isGuildMuted == widgetChannelNotificationSettings$Model.isGuildMuted && this.notificationSetting == widgetChannelNotificationSettings$Model.notificationSetting && m.areEqual(this.channelOverrideFlags, widgetChannelNotificationSettings$Model.channelOverrideFlags) && m.areEqual(this.forumPostNotificationSetting, widgetChannelNotificationSettings$Model.forumPostNotificationSetting) && m.areEqual(this.parentNotificationSetting, widgetChannelNotificationSettings$Model.parentNotificationSetting) && this.notificationSettingIsInherited == widgetChannelNotificationSettings$Model.notificationSettingIsInherited && this.isAboveNotifyAllSize == widgetChannelNotificationSettings$Model.isAboveNotifyAllSize && this.canAccessRedesignedForumChannels == widgetChannelNotificationSettings$Model.canAccessRedesignedForumChannels;
    }

    public final boolean getCanAccessRedesignedForumChannels() {
        return this.canAccessRedesignedForumChannels;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getChannelIsMuted() {
        return this.channelIsMuted;
    }

    public final String getChannelMuteEndTime() {
        return this.channelMuteEndTime;
    }

    public final Integer getChannelOverrideFlags() {
        return this.channelOverrideFlags;
    }

    public final Integer getForumPostNotificationSetting() {
        return this.forumPostNotificationSetting;
    }

    public final int getNotificationSetting() {
        return this.notificationSetting;
    }

    public final boolean getNotificationSettingIsInherited() {
        return this.notificationSettingIsInherited;
    }

    public final Integer getParentNotificationSetting() {
        return this.parentNotificationSetting;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.channelIsMuted;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        String str = this.channelMuteEndTime;
        int iHashCode2 = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.isGuildMuted;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (((iHashCode2 + r3) * 31) + this.notificationSetting) * 31;
        Integer num = this.channelOverrideFlags;
        int iHashCode3 = (i2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.forumPostNotificationSetting;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.parentNotificationSetting;
        int iHashCode5 = (iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 31;
        boolean z4 = this.notificationSettingIsInherited;
        ?? r1 = z4;
        if (z4) {
            r1 = 1;
        }
        int i3 = (iHashCode5 + r1) * 31;
        boolean z5 = this.isAboveNotifyAllSize;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.canAccessRedesignedForumChannels;
        return i4 + (z6 ? 1 : z6);
    }

    public final boolean isAboveNotifyAllSize() {
        return this.isAboveNotifyAllSize;
    }

    public final boolean isGuildMuted() {
        return this.isGuildMuted;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(channel=");
        sbU.append(this.channel);
        sbU.append(", channelIsMuted=");
        sbU.append(this.channelIsMuted);
        sbU.append(", channelMuteEndTime=");
        sbU.append(this.channelMuteEndTime);
        sbU.append(", isGuildMuted=");
        sbU.append(this.isGuildMuted);
        sbU.append(", notificationSetting=");
        sbU.append(this.notificationSetting);
        sbU.append(", channelOverrideFlags=");
        sbU.append(this.channelOverrideFlags);
        sbU.append(", forumPostNotificationSetting=");
        sbU.append(this.forumPostNotificationSetting);
        sbU.append(", parentNotificationSetting=");
        sbU.append(this.parentNotificationSetting);
        sbU.append(", notificationSettingIsInherited=");
        sbU.append(this.notificationSettingIsInherited);
        sbU.append(", isAboveNotifyAllSize=");
        sbU.append(this.isAboveNotifyAllSize);
        sbU.append(", canAccessRedesignedForumChannels=");
        return a.O(sbU, this.canAccessRedesignedForumChannels, ")");
    }
}
