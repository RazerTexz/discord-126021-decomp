package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import d0.f0.n;
import d0.f0.q;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel$Companion {
    private WidgetGlobalSearchGuildsModel$Companion() {
    }

    private final Sequence<WidgetGlobalSearchGuildsModel$Item> asDirectMessageItems(Map<Long, Channel> map, Map<Long, Integer> map2, ModelNotificationSettings modelNotificationSettings) {
        return q.map(q.sortedWith(q.filter(q.filterNotNull(u.asSequence(map.values())), new WidgetGlobalSearchGuildsModel$Companion$asDirectMessageItems$1(modelNotificationSettings, map2)), ChannelUtils.h(Channel.Companion)), new WidgetGlobalSearchGuildsModel$Companion$asDirectMessageItems$2(map2));
    }

    private final Sequence<WidgetGlobalSearchGuildsModel$Item> asGuildItems(Sequence<Guild> sequence, Long l, long j, Set<Long> set, Map<Long, ? extends ModelNotificationSettings> map, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3) {
        return q.map(sequence, new WidgetGlobalSearchGuildsModel$Companion$asGuildItems$1(map3, map2, map, set, l, j));
    }

    public final WidgetGlobalSearchGuildsModel create(List<Long> recentGuildIds, long selectedVoiceChannelId, Set<Long> unreadGuildIds, Map<Long, Integer> mentionCounts, Map<Long, Channel> privateChannels, Map<Long, Guild> guilds, Map<Long, ? extends List<Long>> channelIds, Map<Long, ? extends ModelNotificationSettings> guildSettings) {
        m.checkNotNullParameter(recentGuildIds, "recentGuildIds");
        m.checkNotNullParameter(unreadGuildIds, "unreadGuildIds");
        m.checkNotNullParameter(mentionCounts, "mentionCounts");
        m.checkNotNullParameter(privateChannels, "privateChannels");
        m.checkNotNullParameter(guilds, "guilds");
        m.checkNotNullParameter(channelIds, "channelIds");
        m.checkNotNullParameter(guildSettings, "guildSettings");
        Sequence<WidgetGlobalSearchGuildsModel$Item> sequenceAsDirectMessageItems = asDirectMessageItems(privateChannels, mentionCounts, guildSettings.get(0L));
        return new WidgetGlobalSearchGuildsModel(q.toList(q.plus(q.plus((Sequence) sequenceAsDirectMessageItems, q.any(sequenceAsDirectMessageItems) ? n.sequenceOf(WidgetGlobalSearchGuildsModel$Item.Companion.createDivider$app_productionGoogleRelease()) : n.emptySequence()), q.sortedWith(asGuildItems(q.mapNotNull(q.drop(q.distinct(u.asSequence(u.plus((Collection) recentGuildIds, (Iterable) guilds.keySet()))), 1), new WidgetGlobalSearchGuildsModel$Companion$create$guildItems$1(guilds)), (Long) u.firstOrNull((List) recentGuildIds), selectedVoiceChannelId, unreadGuildIds, guildSettings, mentionCounts, channelIds), new WidgetGlobalSearchGuildsModel$Companion$create$$inlined$sortedByDescending$1()))), !channelIds.isEmpty());
    }

    public /* synthetic */ WidgetGlobalSearchGuildsModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
