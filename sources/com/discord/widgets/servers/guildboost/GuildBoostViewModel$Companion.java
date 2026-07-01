package com.discord.widgets.servers.guildboost;

import com.discord.models.guild.Guild;
import com.discord.stores.StoreGooglePlayPurchases$State;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func5;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostViewModel$Companion {
    private GuildBoostViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(GuildBoostViewModel$Companion guildBoostViewModel$Companion, long j) {
        return guildBoostViewModel$Companion.observeStores(j);
    }

    private final Observable<GuildBoostViewModel$StoreState> observeStores(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableObserveGuildBoostState$default = StoreGuildBoost.observeGuildBoostState$default(storeStream$Companion.getGuildBoosts(), null, 1, null);
        Observable<StoreSubscriptions$SubscriptionsState> observableObserveSubscriptions = storeStream$Companion.getSubscriptions().observeSubscriptions();
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null);
        Observable<Guild> observableObserveGuild = storeStream$Companion.getGuilds().observeGuild(guildId);
        Observable<StoreGooglePlayPurchases$State> observableObserveState = storeStream$Companion.getGooglePlayPurchases().observeState();
        GuildBoostViewModel$Companion$observeStores$1 guildBoostViewModel$Companion$observeStores$1 = GuildBoostViewModel$Companion$observeStores$1.INSTANCE;
        Object guildBoostViewModel$sam$rx_functions_Func5$0 = guildBoostViewModel$Companion$observeStores$1;
        if (guildBoostViewModel$Companion$observeStores$1 != null) {
            guildBoostViewModel$sam$rx_functions_Func5$0 = new GuildBoostViewModel$sam$rx_functions_Func5$0(guildBoostViewModel$Companion$observeStores$1);
        }
        Observable<GuildBoostViewModel$StoreState> observableG = Observable.g(observableObserveGuildBoostState$default, observableObserveSubscriptions, observableObserveMe$default, observableObserveGuild, observableObserveState, (Func5) guildBoostViewModel$sam$rx_functions_Func5$0);
        m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…     ::StoreState\n      )");
        return observableG;
    }

    public /* synthetic */ GuildBoostViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
