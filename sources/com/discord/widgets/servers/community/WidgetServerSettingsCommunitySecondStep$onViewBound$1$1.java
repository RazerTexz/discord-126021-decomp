package com.discord.widgets.servers.community;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunitySecondStep$onViewBound$1$1 extends o implements Function1<WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $channelId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunitySecondStep$onViewBound$1$1(long j, Channel channel) {
        super(1);
        this.$channelId = j;
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig) {
        return invoke2(widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig) {
        m.checkNotNullParameter(widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, "guildConfig");
        return WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.copy$default(widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, this.$channel, null, Long.valueOf(this.$channelId), null, false, false, false, false, null, false, null, null, 4090, null);
    }
}
