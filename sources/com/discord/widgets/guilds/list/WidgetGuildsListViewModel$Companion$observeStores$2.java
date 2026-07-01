package com.discord.widgets.guilds.list;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel;
import com.discord.widgets.stage.GuildIdsWithVisibleStageInstanceModel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion$observeStores$2 extends o implements Function0<Observable<WidgetGuildsListViewModel$Companion$SecondChunk>> {
    public static final WidgetGuildsListViewModel$Companion$observeStores$2 INSTANCE = new WidgetGuildsListViewModel$Companion$observeStores$2();

    public WidgetGuildsListViewModel$Companion$observeStores$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Observable<WidgetGuildsListViewModel$Companion$SecondChunk> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Observable<WidgetGuildsListViewModel$Companion$SecondChunk> invoke2() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetGuildsListViewModel$Companion$SecondChunk> observableE = Observable.e(storeStream$Companion.getGuildJoinRequests().observeGuildJoinRequests(), storeStream$Companion.getGuildJoinRequests().observePendingGuilds(), storeStream$Companion.getGuilds().observeGuildIds(), GuildIdsWithVisibleStageInstanceModel.observe$default(GuildIdsWithVisibleStageInstanceModel.INSTANCE, null, null, null, 7, null), GuildIdsWithActiveEventsModel.observe$default(GuildIdsWithActiveEventsModel.INSTANCE, null, null, 3, null), storeStream$Companion.getChannels().observeGuildAndPrivateChannels(), storeStream$Companion.getDirectories().observeDiscordHubClicked(), WidgetGuildsListViewModel$Companion$observeStores$2$1.INSTANCE);
        m.checkNotNullExpressionValue(observableE, "Observable.combineLatest…ked\n          )\n        }");
        return observableE;
    }
}
