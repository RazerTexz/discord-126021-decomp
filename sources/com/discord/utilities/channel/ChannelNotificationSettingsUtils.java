package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelNotificationSettingsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelNotificationSettingsUtils {
    public static final ChannelNotificationSettingsUtils INSTANCE = new ChannelNotificationSettingsUtils();

    private ChannelNotificationSettingsUtils() {
    }

    public final int computeNotificationSetting(Guild guild, Channel channel, ModelNotificationSettings guildSettings) {
        C12238m.checkNotNullParameter(guild, "guild");
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(guildSettings, "guildSettings");
        ModelNotificationSettings.ChannelOverride channelOverride = guildSettings.getChannelOverride(channel.getId());
        int messageNotifications = channelOverride != null ? channelOverride.getMessageNotifications() : ModelNotificationSettings.FREQUENCY_UNSET;
        if (messageNotifications != ModelNotificationSettings.FREQUENCY_UNSET) {
            return messageNotifications;
        }
        int messageNotifications2 = guildSettings.getMessageNotifications();
        return messageNotifications2 == ModelNotificationSettings.FREQUENCY_UNSET ? guild.getDefaultMessageNotifications() : messageNotifications2;
    }
}
