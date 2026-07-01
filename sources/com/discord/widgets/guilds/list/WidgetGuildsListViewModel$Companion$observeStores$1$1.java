package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreGuildsSorted$Entry;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func9;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion$observeStores$1$1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Long, Long, Map<Long, ? extends ModelNotificationSettings>, Set<? extends Long>, Map<Long, ? extends Integer>, Map<Long, ? extends List<? extends Long>>, Set<? extends Long>, Map<Long, ? extends Channel>, List<? extends StoreGuildsSorted$Entry>, WidgetGuildsListViewModel$Companion$Chunk> {
    public static final WidgetGuildsListViewModel$Companion$observeStores$1$1 INSTANCE = new WidgetGuildsListViewModel$Companion$observeStores$1$1();

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetGuildsListViewModel$Companion$Chunk call(Long l, Long l2, Map<Long, ? extends ModelNotificationSettings> map, Set<? extends Long> set, Map<Long, ? extends Integer> map2, Map<Long, ? extends List<? extends Long>> map3, Set<? extends Long> set2, Map<Long, ? extends Channel> map4, List<? extends StoreGuildsSorted$Entry> list) {
        return call2(l, l2, map, (Set<Long>) set, (Map<Long, Integer>) map2, (Map<Long, ? extends List<Long>>) map3, (Set<Long>) set2, (Map<Long, Channel>) map4, list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildsListViewModel$Companion$Chunk call2(Long l, Long l2, Map<Long, ? extends ModelNotificationSettings> map, Set<Long> set, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3, Set<Long> set2, Map<Long, Channel> map4, List<? extends StoreGuildsSorted$Entry> list) {
        m.checkNotNullExpressionValue(l, "selectedGuildId");
        long jLongValue = l.longValue();
        m.checkNotNullExpressionValue(l2, "selectedVoiceChannelId");
        long jLongValue2 = l2.longValue();
        m.checkNotNullExpressionValue(map, "guildSettings");
        m.checkNotNullExpressionValue(set, "unreadGuildIds");
        m.checkNotNullExpressionValue(map2, "mentionCounts");
        m.checkNotNullExpressionValue(map3, "channelIds");
        m.checkNotNullExpressionValue(set2, "unavailableGuilds");
        m.checkNotNullExpressionValue(map4, "privateChannels");
        m.checkNotNullExpressionValue(list, "sortedGuilds");
        return new WidgetGuildsListViewModel$Companion$Chunk(jLongValue, jLongValue2, map, set, map2, map3, set2, map4, list);
    }
}
