package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import rx.functions.Func7;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion$observeStores$2$1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Map<Long, ? extends GuildJoinRequest>, Map<Long, ? extends Guild>, Set<? extends Long>, Set<? extends Long>, Set<? extends Long>, Map<Long, ? extends Channel>, Boolean, WidgetGuildsListViewModel$Companion$SecondChunk> {
    public static final WidgetGuildsListViewModel$Companion$observeStores$2$1 INSTANCE = new WidgetGuildsListViewModel$Companion$observeStores$2$1();

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetGuildsListViewModel$Companion$SecondChunk call(Map<Long, ? extends GuildJoinRequest> map, Map<Long, ? extends Guild> map2, Set<? extends Long> set, Set<? extends Long> set2, Set<? extends Long> set3, Map<Long, ? extends Channel> map3, Boolean bool) {
        return call2((Map<Long, GuildJoinRequest>) map, (Map<Long, Guild>) map2, (Set<Long>) set, (Set<Long>) set2, (Set<Long>) set3, (Map<Long, Channel>) map3, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildsListViewModel$Companion$SecondChunk call2(Map<Long, GuildJoinRequest> map, Map<Long, Guild> map2, Set<Long> set, Set<Long> set2, Set<Long> set3, Map<Long, Channel> map3, Boolean bool) {
        m.checkNotNullExpressionValue(map, "guildJoinRequests");
        ArrayList arrayList = new ArrayList(map2.values());
        m.checkNotNullExpressionValue(set, "guildIds");
        m.checkNotNullExpressionValue(set2, "guildIdsWithActiveStageEvents");
        m.checkNotNullExpressionValue(set3, "guildIdsWithActiveScheduledEvents");
        m.checkNotNullExpressionValue(map3, "channels");
        return new WidgetGuildsListViewModel$Companion$SecondChunk(map, arrayList, set, set2, set3, map3, !bool.booleanValue());
    }
}
