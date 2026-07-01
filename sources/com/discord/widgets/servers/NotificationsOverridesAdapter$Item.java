package com.discord.widgets.servers;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import d0.z.d.m;

/* JADX INFO: compiled from: NotificationsOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationsOverridesAdapter$Item {
    private final Channel channel;
    private final ModelNotificationSettings$ChannelOverride overrideSettings;
    private final Channel parent;

    public NotificationsOverridesAdapter$Item(Channel channel, Channel channel2, ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(modelNotificationSettings$ChannelOverride, "overrideSettings");
        this.channel = channel;
        this.parent = channel2;
        this.overrideSettings = modelNotificationSettings$ChannelOverride;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final ModelNotificationSettings$ChannelOverride getOverrideSettings() {
        return this.overrideSettings;
    }

    public final Channel getParent() {
        return this.parent;
    }
}
