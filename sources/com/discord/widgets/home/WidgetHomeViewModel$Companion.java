package com.discord.widgets.home;

import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeViewModel$Companion {
    private WidgetHomeViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetHomeViewModel$Companion widgetHomeViewModel$Companion, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreNavigation storeNavigation, StoreLurking storeLurking, StoreUser storeUser, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreUserConnections storeUserConnections, StoreGuildsNsfw storeGuildsNsfw) {
        return widgetHomeViewModel$Companion.observeStoreState(storeGuilds, storeGuildSelected, storeNavigation, storeLurking, storeUser, storeGuildWelcomeScreens, storeChannelsSelected, storeExperiments, storePermissions, storeUserConnections, storeGuildsNsfw);
    }

    private final Observable<WidgetHomeViewModel$StoreState> observeStoreState(StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StoreNavigation storeNavigation, StoreLurking storeLurking, StoreUser storeUser, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StoreChannelsSelected storeChannelsSelected, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreUserConnections storeUserConnections, StoreGuildsNsfw storeGuildsNsfw) {
        Observable<WidgetHomeViewModel$StoreState> observableD = Observable.d(storeNavigation.observeLeftPanelState(), storeNavigation.observeRightPanelState(), storeGuildSelected.observeSelectedGuildId().Y(new WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1(storeGuilds, storeLurking, storeGuildWelcomeScreens, storePermissions, storeGuildsNsfw)), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannelsSelected.observeResolvedSelectedChannel(), storeExperiments.observeUserExperiment("2021-09_events_upsell", false), storeUserConnections.observeConnectedAccounts(), storeExperiments.observeUserExperiment("2021-12_connected_accounts_playstation", false), WidgetHomeViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableD, "Observable.combineLatest…counts,\n        )\n      }");
        return observableD;
    }

    public /* synthetic */ WidgetHomeViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
