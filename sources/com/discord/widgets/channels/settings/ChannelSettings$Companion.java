package com.discord.widgets.channels.settings;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSettings$Companion {
    private ChannelSettings$Companion() {
    }

    public final ChannelSettings createFromNotificationSettings(Channel channel, ModelNotificationSettings notificationSettings) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(notificationSettings, "notificationSettings");
        boolean zIsMuted = notificationSettings.isMuted();
        String muteEndTime = notificationSettings.getMuteEndTime();
        for (ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride : notificationSettings.getChannelOverrides()) {
            m.checkNotNullExpressionValue(modelNotificationSettings$ChannelOverride, "override");
            if (modelNotificationSettings$ChannelOverride.getChannelId() == channel.getId()) {
                zIsMuted = modelNotificationSettings$ChannelOverride.isMuted();
                muteEndTime = modelNotificationSettings$ChannelOverride.getMuteEndTime();
                break;
            }
        }
        return new ChannelSettings(channel, zIsMuted, muteEndTime);
    }

    public /* synthetic */ ChannelSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
