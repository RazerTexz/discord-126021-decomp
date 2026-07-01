package com.discord.widgets.channels.threads.browser;

import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel$Companion {
    private WidgetThreadBrowserArchivedViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetThreadBrowserArchivedViewModel$Companion widgetThreadBrowserArchivedViewModel$Companion, WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode, long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions) {
        return widgetThreadBrowserArchivedViewModel$Companion.observeStoreState(widgetThreadBrowserArchivedViewModel$ViewMode, j, j2, storeGuilds, storeChannels, storeUser, archivedThreadsStore, storePermissions);
    }

    private final Observable<WidgetThreadBrowserArchivedViewModel$StoreState> observeStoreState(WidgetThreadBrowserArchivedViewModel$ViewMode viewMode, long guildId, long channelId, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore storeArchivedThreads, StorePermissions storePermissions) {
        Observable<WidgetThreadBrowserArchivedViewModel$StoreState> observableY = Observable.j(storeArchivedThreads.loadAndObserveThreadListing(channelId, viewMode.getThreadListingType()), storeChannels.observeChannel(channelId), WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1.INSTANCE).Y(new WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2(storeUser, storeGuilds, guildId, storePermissions, viewMode));
        m.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            }\n          }");
        return observableY;
    }

    public /* synthetic */ WidgetThreadBrowserArchivedViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
