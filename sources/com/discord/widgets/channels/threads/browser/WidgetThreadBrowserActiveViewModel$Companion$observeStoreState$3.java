package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadMessages$ThreadState;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.k.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadBrowserActiveViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3<T, R> implements b<Pair<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>>, Observable<? extends WidgetThreadBrowserActiveViewModel$StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadMessages $storeThreadMessages;
    public final /* synthetic */ StoreUser $storeUser;

    public WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3(StoreUser storeUser, StoreThreadMessages storeThreadMessages, StoreGuilds storeGuilds, long j, StoreChannels storeChannels, StorePermissions storePermissions, long j2) {
        this.$storeUser = storeUser;
        this.$storeThreadMessages = storeThreadMessages;
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
        this.$storePermissions = storePermissions;
        this.$channelId = j2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserActiveViewModel$StoreState> call(Pair<? extends Map<Long, ? extends Channel>, ? extends Map<Long, ? extends Channel>> pair) {
        return call2((Pair<? extends Map<Long, Channel>, ? extends Map<Long, Channel>>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadBrowserActiveViewModel$StoreState> call2(Pair<? extends Map<Long, Channel>, ? extends Map<Long, Channel>> pair) {
        Map<Long, Channel> mapComponent1 = pair.component1();
        Map<Long, Channel> mapComponent2 = pair.component2();
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUser, false, 1, null);
        StoreUser storeUser = this.$storeUser;
        HashSet hashSet = new HashSet();
        m.checkNotNullExpressionValue(mapComponent1, "activeJoinedThreads");
        Iterator<Map$Entry<Long, Channel>> it = mapComponent1.entrySet().iterator();
        while (it.hasNext()) {
            hashSet.add(Long.valueOf(it.next().getValue().getOwnerId()));
        }
        m.checkNotNullExpressionValue(mapComponent2, "activeThreads");
        Iterator<Map$Entry<Long, Channel>> it2 = mapComponent2.entrySet().iterator();
        while (it2.hasNext()) {
            hashSet.add(Long.valueOf(it2.next().getValue().getOwnerId()));
        }
        Observable<Map<Long, User>> observableObserveUsers = storeUser.observeUsers(hashSet);
        Observable<Map<Long, StoreThreadMessages$ThreadState>> observableObserveThreadCountAndLatestMessage = this.$storeThreadMessages.observeThreadCountAndLatestMessage();
        Observable<Map<Long, GuildMember>> observableObserveGuildMembers = this.$storeGuilds.observeGuildMembers(this.$guildId);
        m.checkNotNullExpressionValue(observableObserveGuildMembers, "storeGuilds\n            …erveGuildMembers(guildId)");
        Observable<T> observableR = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMembers, 1L, TimeUnit.SECONDS).r();
        m.checkNotNullExpressionValue(observableR, "storeGuilds\n            …  .distinctUntilChanged()");
        return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMe$default, observableObserveUsers, observableObserveThreadCountAndLatestMessage, observableR, this.$storeGuilds.observeRoles(this.$guildId), this.$storeChannels.observeNames(), this.$storePermissions.observePermissionsForChannel(this.$channelId), StoreStream.Companion.getUserRelationships().observeForType(2), this.$storeChannels.observeChannel(this.$channelId), this.$storeGuilds.observeGuild(this.$guildId), new WidgetThreadBrowserActiveViewModel$Companion$observeStoreState$3$2(mapComponent1, mapComponent2));
    }
}
