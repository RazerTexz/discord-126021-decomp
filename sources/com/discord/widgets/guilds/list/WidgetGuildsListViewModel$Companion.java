package com.discord.widgets.guilds.list;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion {
    private WidgetGuildsListViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(WidgetGuildsListViewModel$Companion widgetGuildsListViewModel$Companion, Clock clock) {
        return widgetGuildsListViewModel$Companion.observeStores(clock);
    }

    private final Observable<WidgetGuildsListViewModel$StoreState> observeStores(Clock clock) {
        WidgetGuildsListViewModel$Companion$observeStores$1 widgetGuildsListViewModel$Companion$observeStores$1 = WidgetGuildsListViewModel$Companion$observeStores$1.INSTANCE;
        WidgetGuildsListViewModel$Companion$observeStores$2 widgetGuildsListViewModel$Companion$observeStores$2 = WidgetGuildsListViewModel$Companion$observeStores$2.INSTANCE;
        Observable<WidgetGuildsListViewModel$Companion$Chunk> observableInvoke2 = widgetGuildsListViewModel$Companion$observeStores$1.invoke2();
        Observable<WidgetGuildsListViewModel$Companion$SecondChunk> observableInvoke3 = widgetGuildsListViewModel$Companion$observeStores$2.invoke2();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableC = Observable.c(observableInvoke2, observableInvoke3, storeStream$Companion.getLurking().getLurkingGuildIds(), storeStream$Companion.getExpandedGuildFolders().observeOpenFolderIds(), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null).r().G(new WidgetGuildsListViewModel$Companion$observeStores$3(clock)), new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForAllStreamingUsers(), storeStream$Companion.getPermissions().observePermissionsForAllChannels(), storeStream$Companion.getNavigation().observeLeftPanelState().G(WidgetGuildsListViewModel$Companion$observeStores$4.INSTANCE), storeStream$Companion.getTabsNavigation().observeSelectedTab().G(WidgetGuildsListViewModel$Companion$observeStores$5.INSTANCE), WidgetGuildsListViewModel$Companion$observeStores$6.INSTANCE);
        m.checkNotNullExpressionValue(observableC, "Observable.combineLatest…Sparkle\n        )\n      }");
        return ObservableExtensionsKt.leadingEdgeThrottle(observableC, 100L, TimeUnit.MILLISECONDS);
    }

    public /* synthetic */ WidgetGuildsListViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
