package com.discord.widgets.channels.settings;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelGroupDMSettingsViewModel$StoreState$Valid extends ChannelGroupDMSettingsViewModel$StoreState {
    private final Channel channel;
    private final ModelNotificationSettings notificationSettings;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelGroupDMSettingsViewModel$StoreState$Valid(Channel channel, ModelNotificationSettings modelNotificationSettings) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(modelNotificationSettings, "notificationSettings");
        this.channel = channel;
        this.notificationSettings = modelNotificationSettings;
    }

    public static /* synthetic */ ChannelGroupDMSettingsViewModel$StoreState$Valid copy$default(ChannelGroupDMSettingsViewModel$StoreState$Valid channelGroupDMSettingsViewModel$StoreState$Valid, Channel channel, ModelNotificationSettings modelNotificationSettings, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelGroupDMSettingsViewModel$StoreState$Valid.channel;
        }
        if ((i & 2) != 0) {
            modelNotificationSettings = channelGroupDMSettingsViewModel$StoreState$Valid.notificationSettings;
        }
        return channelGroupDMSettingsViewModel$StoreState$Valid.copy(channel, modelNotificationSettings);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelNotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    public final ChannelGroupDMSettingsViewModel$StoreState$Valid copy(Channel channel, ModelNotificationSettings notificationSettings) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(notificationSettings, "notificationSettings");
        return new ChannelGroupDMSettingsViewModel$StoreState$Valid(channel, notificationSettings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelGroupDMSettingsViewModel$StoreState$Valid)) {
            return false;
        }
        ChannelGroupDMSettingsViewModel$StoreState$Valid channelGroupDMSettingsViewModel$StoreState$Valid = (ChannelGroupDMSettingsViewModel$StoreState$Valid) other;
        return m.areEqual(this.channel, channelGroupDMSettingsViewModel$StoreState$Valid.channel) && m.areEqual(this.notificationSettings, channelGroupDMSettingsViewModel$StoreState$Valid.notificationSettings);
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final ModelNotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        ModelNotificationSettings modelNotificationSettings = this.notificationSettings;
        return iHashCode + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(channel=");
        sbU.append(this.channel);
        sbU.append(", notificationSettings=");
        sbU.append(this.notificationSettings);
        sbU.append(")");
        return sbU.toString();
    }
}
