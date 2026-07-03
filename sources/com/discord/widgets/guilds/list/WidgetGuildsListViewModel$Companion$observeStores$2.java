package com.discord.widgets.guilds.list;

import com.discord.api.channel.Channel;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel;
import com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.functions.Func7;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion$observeStores$2 extends AbstractC12240o implements Function0<Observable<WidgetGuildsListViewModel.Companion.SecondChunk>> {
    public static final WidgetGuildsListViewModel$Companion$observeStores$2 INSTANCE = new WidgetGuildsListViewModel$Companion$observeStores$2();

    public WidgetGuildsListViewModel$Companion$observeStores$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Observable<WidgetGuildsListViewModel.Companion.SecondChunk> invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<WidgetGuildsListViewModel.Companion.SecondChunk> observableM11069e = Observable.m11069e(companion.getGuildJoinRequests().observeGuildJoinRequests(), companion.getGuildJoinRequests().observePendingGuilds(), companion.getGuilds().observeGuildIds(), GuildIdsWithVisibleStageInstanceModel.observe$default(GuildIdsWithVisibleStageInstanceModel.INSTANCE, null, null, null, 7, null), GuildIdsWithActiveEventsModel.observe$default(GuildIdsWithActiveEventsModel.INSTANCE, null, null, 3, null), companion.getChannels().observeGuildAndPrivateChannels(), companion.getDirectories().observeDiscordHubClicked(), new Func7<Map<Long, ? extends GuildJoinRequest>, Map<Long, ? extends Guild>, Set<? extends Long>, Set<? extends Long>, Set<? extends Long>, Map<Long, ? extends Channel>, Boolean, WidgetGuildsListViewModel.Companion.SecondChunk>() { // from class: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$2.1
            @Override // p658rx.functions.Func7
            public /* bridge */ /* synthetic */ WidgetGuildsListViewModel.Companion.SecondChunk call(Map<Long, ? extends GuildJoinRequest> map, Map<Long, ? extends Guild> map2, Set<? extends Long> set, Set<? extends Long> set2, Set<? extends Long> set3, Map<Long, ? extends Channel> map3, Boolean bool) {
                return call2((Map<Long, GuildJoinRequest>) map, (Map<Long, Guild>) map2, (Set<Long>) set, (Set<Long>) set2, (Set<Long>) set3, (Map<Long, Channel>) map3, bool);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetGuildsListViewModel.Companion.SecondChunk call2(Map<Long, GuildJoinRequest> map, Map<Long, Guild> map2, Set<Long> set, Set<Long> set2, Set<Long> set3, Map<Long, Channel> map3, Boolean bool) {
                C12238m.checkNotNullExpressionValue(map, "guildJoinRequests");
                ArrayList arrayList = new ArrayList(map2.values());
                C12238m.checkNotNullExpressionValue(set, "guildIds");
                C12238m.checkNotNullExpressionValue(set2, "guildIdsWithActiveStageEvents");
                C12238m.checkNotNullExpressionValue(set3, "guildIdsWithActiveScheduledEvents");
                C12238m.checkNotNullExpressionValue(map3, "channels");
                return new WidgetGuildsListViewModel.Companion.SecondChunk(map, arrayList, set, set2, set3, map3, !bool.booleanValue());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11069e, "Observable.combineLatest…ked\n          )\n        }");
        return observableM11069e;
    }
}
