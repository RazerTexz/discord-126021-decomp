package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelNotificationSettingsUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$onThreadNotificationSettingsUpdated$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ int $flags;
    public final /* synthetic */ int $oldFlags;
    public final /* synthetic */ long $parentChannelId;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$onThreadNotificationSettingsUpdated$1(StoreAnalytics storeAnalytics, long j, long j2, int i, int i2) {
        super(0);
        this.this$0 = storeAnalytics;
        this.$channelId = j;
        this.$parentChannelId = j2;
        this.$oldFlags = i;
        this.$flags = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease;
        ModelNotificationSettings modelNotificationSettings;
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease2 = StoreAnalytics.access$getStores$p(this.this$0).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease2 == null || (channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(this.this$0).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$parentChannelId)) == null) {
            return;
        }
        boolean z2 = (this.$oldFlags & 1) != 0;
        long guildId = channelFindChannelByIdInternal$app_productionGoogleRelease2.getGuildId();
        Guild guild = StoreAnalytics.access$getStores$p(this.this$0).getGuilds().getGuild(guildId);
        if (guild == null || (modelNotificationSettings = StoreAnalytics.access$getStores$p(this.this$0).getGuildSettings().getGuildSettingsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) == null) {
            return;
        }
        AnalyticsTracker.INSTANCE.threadNotificationSettingsUpdated(StoreAnalytics.access$getThreadSnapshotAnalyticsProperties(this.this$0, channelFindChannelByIdInternal$app_productionGoogleRelease2), z2, NotificationTextUtils.INSTANCE.isGuildOrCategoryOrChannelMuted(modelNotificationSettings, channelFindChannelByIdInternal$app_productionGoogleRelease), ChannelNotificationSettingsUtils.INSTANCE.computeNotificationSetting(guild, channelFindChannelByIdInternal$app_productionGoogleRelease2, modelNotificationSettings), this.$oldFlags, this.$flags);
    }
}
