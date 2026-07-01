package com.discord.widgets.settings.guildboost;

import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func4;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGuildBoostViewModel$Companion {
    private SettingsGuildBoostViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(SettingsGuildBoostViewModel$Companion settingsGuildBoostViewModel$Companion) {
        return settingsGuildBoostViewModel$Companion.observeStores();
    }

    private final Observable<SettingsGuildBoostViewModel$StoreState> observeStores() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableObserveGuildBoostState$default = StoreGuildBoost.observeGuildBoostState$default(storeStream$Companion.getGuildBoosts(), null, 1, null);
        Observable<StoreSubscriptions$SubscriptionsState> observableObserveSubscriptions = storeStream$Companion.getSubscriptions().observeSubscriptions();
        Observable<LinkedHashMap<Long, Guild>> observableObserveOrderedGuilds = storeStream$Companion.getGuildsSorted().observeOrderedGuilds();
        Observable observableR = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null).G(SettingsGuildBoostViewModel$Companion$observeStores$1.INSTANCE).r();
        SettingsGuildBoostViewModel$Companion$observeStores$2 settingsGuildBoostViewModel$Companion$observeStores$2 = SettingsGuildBoostViewModel$Companion$observeStores$2.INSTANCE;
        Object settingsGuildBoostViewModel$sam$rx_functions_Func4$0 = settingsGuildBoostViewModel$Companion$observeStores$2;
        if (settingsGuildBoostViewModel$Companion$observeStores$2 != null) {
            settingsGuildBoostViewModel$sam$rx_functions_Func4$0 = new SettingsGuildBoostViewModel$sam$rx_functions_Func4$0(settingsGuildBoostViewModel$Companion$observeStores$2);
        }
        Observable<SettingsGuildBoostViewModel$StoreState> observableH = Observable.h(observableObserveGuildBoostState$default, observableObserveSubscriptions, observableObserveOrderedGuilds, observableR, (Func4) settingsGuildBoostViewModel$sam$rx_functions_Func4$0);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…     ::StoreState\n      )");
        return observableH;
    }

    public /* synthetic */ SettingsGuildBoostViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
