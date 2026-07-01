package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreLurking;
import com.discord.stores.StorePermissions;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1<T, R> implements b<Long, Observable<? extends WidgetHomeViewModel$GuildInfo>> {
    public final /* synthetic */ StoreGuildWelcomeScreens $storeGuildWelcomeScreens;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreGuildsNsfw $storeGuildsNsfw;
    public final /* synthetic */ StoreLurking $storeLurking;
    public final /* synthetic */ StorePermissions $storePermissions;

    public WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1(StoreGuilds storeGuilds, StoreLurking storeLurking, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StorePermissions storePermissions, StoreGuildsNsfw storeGuildsNsfw) {
        this.$storeGuilds = storeGuilds;
        this.$storeLurking = storeLurking;
        this.$storeGuildWelcomeScreens = storeGuildWelcomeScreens;
        this.$storePermissions = storePermissions;
        this.$storeGuildsNsfw = storeGuildsNsfw;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetHomeViewModel$GuildInfo> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetHomeViewModel$GuildInfo> call2(Long l) {
        StoreGuilds storeGuilds = this.$storeGuilds;
        m.checkNotNullExpressionValue(l, "selectedGuildId");
        return Observable.g(storeGuilds.observeGuild(l.longValue()), this.$storeLurking.isLurkingObs(l.longValue()), this.$storeGuildWelcomeScreens.observeGuildWelcomeScreen(l.longValue()), this.$storePermissions.observePermissionsForGuild(l.longValue()), this.$storeGuildsNsfw.observeIsGuildNsfwGateAgreed(l.longValue()), new WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1$1(l));
    }
}
