package com.discord.widgets.guilds.list;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion$observeStores$1 extends o implements Function0<Observable<WidgetGuildsListViewModel$Companion$Chunk>> {
    public static final WidgetGuildsListViewModel$Companion$observeStores$1 INSTANCE = new WidgetGuildsListViewModel$Companion$observeStores$1();

    public WidgetGuildsListViewModel$Companion$observeStores$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Observable<WidgetGuildsListViewModel$Companion$Chunk> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Observable<WidgetGuildsListViewModel$Companion$Chunk> invoke2() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetGuildsListViewModel$Companion$Chunk> observableC = Observable.c(storeStream$Companion.getGuildSelected().observeSelectedGuildId(), storeStream$Companion.getVoiceChannelSelected().observeSelectedVoiceChannelId(), storeStream$Companion.getUserGuildSettings().observeGuildSettings(), storeStream$Companion.getReadStates().getUnreadGuildIds(), ObservableExtensionsKt.leadingEdgeThrottle(storeStream$Companion.getMentions().observeMentionCounts(), 500L, TimeUnit.MILLISECONDS).r(), storeStream$Companion.getChannels().observeIds(true), storeStream$Companion.getGuilds().observeUnavailableGuilds(), storeStream$Companion.getChannels().observePrivateChannels(), storeStream$Companion.getGuildsSorted().observeEntries(), WidgetGuildsListViewModel$Companion$observeStores$1$1.INSTANCE);
        m.checkNotNullExpressionValue(observableC, "Observable.combineLatest…lds\n          )\n        }");
        return observableC;
    }
}
