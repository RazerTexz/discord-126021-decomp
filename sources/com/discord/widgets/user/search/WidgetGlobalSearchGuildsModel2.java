package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel$Companion$asDirectMessageItems$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel2 extends Lambda implements Function1<Channel, Boolean> {
    public final /* synthetic */ ModelNotificationSettings $dmSettings;
    public final /* synthetic */ Map $mentionCounts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsModel2(ModelNotificationSettings modelNotificationSettings, Map map) {
        super(1);
        this.$dmSettings = modelNotificationSettings;
        this.$mentionCounts = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        ModelNotificationSettings modelNotificationSettings;
        ModelNotificationSettings.ChannelOverride channelOverride;
        Intrinsics3.checkNotNullParameter(channel, "it");
        return this.$mentionCounts.containsKey(Long.valueOf(channel.getId())) && ((modelNotificationSettings = this.$dmSettings) == null || (channelOverride = modelNotificationSettings.getChannelOverride(channel.getId())) == null || !channelOverride.isMuted());
    }
}
