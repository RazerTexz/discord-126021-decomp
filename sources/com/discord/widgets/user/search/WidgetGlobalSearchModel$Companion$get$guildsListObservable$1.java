package com.discord.widgets.user.search;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$get$guildsListObservable$1<T1, T2, T3, T4, R> implements Func4<WidgetGlobalSearchModel$SearchContext, WidgetGlobalSearchModel$ChannelContext, Map<Long, ? extends ModelNotificationSettings>, LinkedHashMap<Long, Guild>, WidgetGlobalSearchGuildsModel> {
    public static final WidgetGlobalSearchModel$Companion$get$guildsListObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$guildsListObservable$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetGlobalSearchGuildsModel call(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext, WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext, Map<Long, ? extends ModelNotificationSettings> map, LinkedHashMap<Long, Guild> linkedHashMap) {
        return call2(widgetGlobalSearchModel$SearchContext, widgetGlobalSearchModel$ChannelContext, map, linkedHashMap);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchGuildsModel call2(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext, WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext, Map<Long, ? extends ModelNotificationSettings> map, LinkedHashMap<Long, Guild> linkedHashMap) {
        WidgetGlobalSearchGuildsModel$Companion widgetGlobalSearchGuildsModel$Companion = WidgetGlobalSearchGuildsModel.Companion;
        List<Long> recentGuildIds = widgetGlobalSearchModel$SearchContext.getRecentGuildIds();
        long selectedVoiceChannelId = widgetGlobalSearchModel$SearchContext.getSelectedVoiceChannelId();
        Set<Long> unreadGuildIds = widgetGlobalSearchModel$ChannelContext.getUnreadGuildIds();
        Map<Long, Integer> mentionCounts = widgetGlobalSearchModel$SearchContext.getMentionCounts();
        Map<Long, Channel> channelsPrivate = widgetGlobalSearchModel$ChannelContext.getChannelsPrivate();
        m.checkNotNullExpressionValue(linkedHashMap, "sortedGuilds");
        Map<Long, List<Long>> guildToChannels = widgetGlobalSearchModel$ChannelContext.getGuildToChannels();
        m.checkNotNullExpressionValue(map, "guildSettings");
        return widgetGlobalSearchGuildsModel$Companion.create(recentGuildIds, selectedVoiceChannelId, unreadGuildIds, mentionCounts, channelsPrivate, linkedHashMap, guildToChannels, map);
    }
}
