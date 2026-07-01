package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.models.guild.Guild;
import com.discord.stores.NotificationTextUtils;
import com.discord.stores.StoreGuildProfiles$GuildProfileData;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import com.discord.utilities.channel.ChannelNotificationSettingsUtils;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.m;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$Model$Companion$get$1$$special$$inlined$let$lambda$1<T1, T2, T3, T4, T5, T6, R> implements Func6<StoreThreadsJoined$JoinedThread, Channel, Guild, ModelNotificationSettings, StoreGuildProfiles$GuildProfileData, Boolean, WidgetChannelNotificationSettings$Model> {
    public final /* synthetic */ Channel $channel$inlined;

    public WidgetChannelNotificationSettings$Model$Companion$get$1$$special$$inlined$let$lambda$1(Channel channel) {
        this.$channel$inlined = channel;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetChannelNotificationSettings$Model call(StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, Channel channel, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData, Boolean bool) {
        return call2(storeThreadsJoined$JoinedThread, channel, guild, modelNotificationSettings, storeGuildProfiles$GuildProfileData, bool);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0088  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelNotificationSettings$Model call2(StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, Channel channel, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData, Boolean bool) {
        int iComputeNotificationSetting;
        String muteEndTime;
        String str;
        GuildPreview data;
        ModelMuteConfig muteConfig;
        if (guild == null) {
            return null;
        }
        NotificationTextUtils notificationTextUtils = NotificationTextUtils.INSTANCE;
        Integer numChannelMessageNotificationLevel = notificationTextUtils.channelMessageNotificationLevel(modelNotificationSettings, channel, guild);
        if (ChannelUtils.H(this.$channel$inlined)) {
            int iComputeThreadNotificationSetting = ThreadUtils.INSTANCE.computeThreadNotificationSetting(storeThreadsJoined$JoinedThread, notificationTextUtils.isGuildOrCategoryOrChannelMuted(modelNotificationSettings, channel), numChannelMessageNotificationLevel);
            if (iComputeThreadNotificationSetting != 4) {
                iComputeNotificationSetting = iComputeThreadNotificationSetting != 8 ? ModelNotificationSettings.FREQUENCY_ALL : ModelNotificationSettings.FREQUENCY_NOTHING;
            } else {
                iComputeNotificationSetting = ModelNotificationSettings.FREQUENCY_MENTIONS;
            }
        } else {
            ChannelNotificationSettingsUtils channelNotificationSettingsUtils = ChannelNotificationSettingsUtils.INSTANCE;
            Channel channel2 = this.$channel$inlined;
            m.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
            iComputeNotificationSetting = channelNotificationSettingsUtils.computeNotificationSetting(guild, channel2, modelNotificationSettings);
        }
        int i = iComputeNotificationSetting;
        ModelNotificationSettings$ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(this.$channel$inlined.getId());
        boolean z2 = !ChannelUtils.H(this.$channel$inlined) ? channelOverride == null || !channelOverride.isMuted() : storeThreadsJoined$JoinedThread == null || !storeThreadsJoined$JoinedThread.getMuted();
        if (ChannelUtils.H(this.$channel$inlined)) {
            if (storeThreadsJoined$JoinedThread == null || (muteConfig = storeThreadsJoined$JoinedThread.getMuteConfig()) == null) {
                str = null;
            } else {
                muteEndTime = muteConfig.getEndTime();
                str = muteEndTime;
            }
        } else if (channelOverride != null) {
            muteEndTime = channelOverride.getMuteEndTime();
            str = muteEndTime;
        } else {
            str = null;
        }
        boolean z3 = i == ModelNotificationSettings.FREQUENCY_UNSET;
        Integer numValueOf = channelOverride != null ? Integer.valueOf(channelOverride.getForumPostNotificationSetting()) : null;
        Integer approximateMemberCount = (storeGuildProfiles$GuildProfileData == null || (data = storeGuildProfiles$GuildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
        boolean z4 = approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
        Channel channel3 = this.$channel$inlined;
        m.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
        boolean zIsMuted = modelNotificationSettings.isMuted();
        Integer numValueOf2 = channelOverride != null ? Integer.valueOf(channelOverride.getFlags()) : null;
        m.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
        return new WidgetChannelNotificationSettings$Model(channel3, z2, str, zIsMuted, i, numValueOf2, numValueOf, numChannelMessageNotificationLevel, z3, z4, bool.booleanValue());
    }
}
