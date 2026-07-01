package com.discord.widgets.guilds.list;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.functions.Func9;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel2 extends Lambda implements Function0<Observable<WidgetGuildsListViewModel.Companion.Chunk>> {
    public static final WidgetGuildsListViewModel2 INSTANCE = new WidgetGuildsListViewModel2();

    public WidgetGuildsListViewModel2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Observable<WidgetGuildsListViewModel.Companion.Chunk> invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<WidgetGuildsListViewModel.Companion.Chunk> observableC = Observable.c(companion.getGuildSelected().observeSelectedGuildId(), companion.getVoiceChannelSelected().observeSelectedVoiceChannelId(), companion.getUserGuildSettings().observeGuildSettings(), companion.getReadStates().getUnreadGuildIds(), ObservableExtensionsKt.leadingEdgeThrottle(companion.getMentions().observeMentionCounts(), 500L, TimeUnit.MILLISECONDS).r(), companion.getChannels().observeIds(true), companion.getGuilds().observeUnavailableGuilds(), companion.getChannels().observePrivateChannels(), companion.getGuildsSorted().observeEntries(), new Func9<Long, Long, Map<Long, ? extends ModelNotificationSettings>, Set<? extends Long>, Map<Long, ? extends Integer>, Map<Long, ? extends List<? extends Long>>, Set<? extends Long>, Map<Long, ? extends Channel>, List<? extends StoreGuildsSorted.Entry>, WidgetGuildsListViewModel.Companion.Chunk>() { // from class: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$1.1
            @Override // rx.functions.Func9
            public /* bridge */ /* synthetic */ WidgetGuildsListViewModel.Companion.Chunk call(Long l, Long l2, Map<Long, ? extends ModelNotificationSettings> map, Set<? extends Long> set, Map<Long, ? extends Integer> map2, Map<Long, ? extends List<? extends Long>> map3, Set<? extends Long> set2, Map<Long, ? extends Channel> map4, List<? extends StoreGuildsSorted.Entry> list) {
                return call2(l, l2, map, (Set<Long>) set, (Map<Long, Integer>) map2, (Map<Long, ? extends List<Long>>) map3, (Set<Long>) set2, (Map<Long, Channel>) map4, list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetGuildsListViewModel.Companion.Chunk call2(Long l, Long l2, Map<Long, ? extends ModelNotificationSettings> map, Set<Long> set, Map<Long, Integer> map2, Map<Long, ? extends List<Long>> map3, Set<Long> set2, Map<Long, Channel> map4, List<? extends StoreGuildsSorted.Entry> list) {
                Intrinsics3.checkNotNullExpressionValue(l, "selectedGuildId");
                long jLongValue = l.longValue();
                Intrinsics3.checkNotNullExpressionValue(l2, "selectedVoiceChannelId");
                long jLongValue2 = l2.longValue();
                Intrinsics3.checkNotNullExpressionValue(map, "guildSettings");
                Intrinsics3.checkNotNullExpressionValue(set, "unreadGuildIds");
                Intrinsics3.checkNotNullExpressionValue(map2, "mentionCounts");
                Intrinsics3.checkNotNullExpressionValue(map3, "channelIds");
                Intrinsics3.checkNotNullExpressionValue(set2, "unavailableGuilds");
                Intrinsics3.checkNotNullExpressionValue(map4, "privateChannels");
                Intrinsics3.checkNotNullExpressionValue(list, "sortedGuilds");
                return new WidgetGuildsListViewModel.Companion.Chunk(jLongValue, jLongValue2, map, set, map2, map3, set2, map4, list);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableC, "Observable.combineLatest…lds\n          )\n        }");
        return observableC;
    }
}
