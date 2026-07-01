package com.discord.widgets.channels.threads.browser;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserViewModel$Companion {
    private WidgetThreadBrowserViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetThreadBrowserViewModel$Companion widgetThreadBrowserViewModel$Companion, long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions) {
        return widgetThreadBrowserViewModel$Companion.observeStoreState(j, j2, storeChannels, storeGuilds, storePermissions);
    }

    private final Observable<WidgetThreadBrowserViewModel$StoreState> observeStoreState(long channelId, long guildId, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions) {
        Observable<WidgetThreadBrowserViewModel$StoreState> observableI = Observable.i(storeChannels.observeChannel(channelId), storeGuilds.observeGuild(guildId), storePermissions.observePermissionsForChannel(channelId), WidgetThreadBrowserViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…issions\n        )\n      }");
        return observableI;
    }

    public /* synthetic */ WidgetThreadBrowserViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
