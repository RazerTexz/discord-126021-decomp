package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreThreadsActive;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel$Companion$observeMinimalStoreState$1<T, R> implements b<StoreChannelsSelected$ResolvedSelectedChannel, Observable<? extends WidgetForumBrowserViewModel$MinimalStoreState>> {
    public final /* synthetic */ StoreExperiments $storeExperiments;
    public final /* synthetic */ StoreTabsNavigation $storeTabsNavigation;
    public final /* synthetic */ StoreThreadsActive $storeThreadsActive;

    public WidgetForumBrowserViewModel$Companion$observeMinimalStoreState$1(StoreTabsNavigation storeTabsNavigation, StoreThreadsActive storeThreadsActive, StoreExperiments storeExperiments) {
        this.$storeTabsNavigation = storeTabsNavigation;
        this.$storeThreadsActive = storeThreadsActive;
        this.$storeExperiments = storeExperiments;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetForumBrowserViewModel$MinimalStoreState> call(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return call2(storeChannelsSelected$ResolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetForumBrowserViewModel$MinimalStoreState> call2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        Channel maybeChannel = storeChannelsSelected$ResolvedSelectedChannel.getMaybeChannel();
        return maybeChannel == null ? new k(WidgetForumBrowserViewModel$MinimalStoreState$Invalid.INSTANCE) : Observable.i(this.$storeTabsNavigation.observeSelectedTab(), this.$storeThreadsActive.observeActiveThreadsForChannel(maybeChannel.getGuildId(), Long.valueOf(maybeChannel.getId())), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, maybeChannel.getGuildId(), this.$storeExperiments, null, 4, null), new WidgetForumBrowserViewModel$Companion$observeMinimalStoreState$1$1(maybeChannel));
    }
}
