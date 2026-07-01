package com.discord.widgets.channels.threads.browser;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel$Companion {
    private WidgetThreadBrowserActiveViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetThreadBrowserActiveViewModel$Companion widgetThreadBrowserActiveViewModel$Companion, long j, long j2, StoreUser storeUser, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions) {
        return widgetThreadBrowserActiveViewModel$Companion.observeStoreState(j, j2, storeUser, storeThreadsActive, storeThreadsActiveJoined, storeThreadMessages, storeGuilds, storeChannels, storePermissions);
    }

    private final Observable<WidgetThreadBrowserActiveViewModel$StoreState> observeStoreState(long guildId, long channelId, StoreUser storeUser, StoreThreadsActive storeThreadsActive, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions) {
        Observable<WidgetThreadBrowserActiveViewModel$StoreState> observableY = Observable.j(storeThreadsActiveJoined.observeActiveJoinedThreadsForChannel(guildId, channelId).G(WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$1.INSTANCE), storeThreadsActive.observeActiveThreadsForChannel(guildId, Long.valueOf(channelId)), WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$2.INSTANCE).Y(new WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3(storeUser, storeThreadMessages, storeGuilds, guildId, storeChannels, storePermissions, channelId));
        m.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            }\n          }");
        return observableY;
    }

    public /* synthetic */ WidgetThreadBrowserActiveViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
