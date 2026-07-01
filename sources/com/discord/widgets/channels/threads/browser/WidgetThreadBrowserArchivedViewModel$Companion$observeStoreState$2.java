package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState$Listing;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.t.o;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2<T, R> implements b<Pair<? extends ArchivedThreadsStore$ThreadListingState, ? extends Channel>, Observable<? extends WidgetThreadBrowserArchivedViewModel$StoreState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ WidgetThreadBrowserArchivedViewModel$ViewMode $viewMode;

    public WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2(StoreUser storeUser, StoreGuilds storeGuilds, long j, StorePermissions storePermissions, WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewMode) {
        this.$storeUser = storeUser;
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$storePermissions = storePermissions;
        this.$viewMode = widgetThreadBrowserArchivedViewModel$ViewMode;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserArchivedViewModel$StoreState> call(Pair<? extends ArchivedThreadsStore$ThreadListingState, ? extends Channel> pair) {
        return call2((Pair<? extends ArchivedThreadsStore$ThreadListingState, Channel>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserArchivedViewModel$StoreState> call2(Pair<? extends ArchivedThreadsStore$ThreadListingState, Channel> pair) {
        Observable<Map<Long, User>> kVar;
        ArchivedThreadsStore$ThreadListingState archivedThreadsStore$ThreadListingStateComponent1 = pair.component1();
        Channel channelComponent2 = pair.component2();
        if (archivedThreadsStore$ThreadListingStateComponent1 instanceof ArchivedThreadsStore$ThreadListingState$Listing) {
            StoreUser storeUser = this.$storeUser;
            List<Channel> threads = ((ArchivedThreadsStore$ThreadListingState$Listing) archivedThreadsStore$ThreadListingStateComponent1).getThreads();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(threads, 10));
            Iterator<T> it = threads.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Channel) it.next()).getOwnerId()));
            }
            kVar = storeUser.observeUsers(arrayList);
        } else {
            kVar = new k(h0.emptyMap());
        }
        Observable<R> observableG = this.$storeGuilds.observeComputed().G(new WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$1(this));
        m.checkNotNullExpressionValue(observableG, "storeGuilds\n            …[guildId] ?: emptyMap() }");
        Observable<T> observableR = ObservableExtensionsKt.leadingEdgeThrottle(observableG, 1L, TimeUnit.SECONDS).r();
        Observable<Guild> observableObserveGuild = this.$storeGuilds.observeGuild(this.$guildId);
        StorePermissions storePermissions = this.$storePermissions;
        Long lValueOf = channelComponent2 != null ? Long.valueOf(channelComponent2.getParentId()) : null;
        Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.Snowflake /* = kotlin.Long */");
        return Observable.h(observableR, observableObserveGuild, kVar, storePermissions.observePermissionsForChannel(lValueOf.longValue()), new WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$2(this, archivedThreadsStore$ThreadListingStateComponent1, channelComponent2));
    }
}
