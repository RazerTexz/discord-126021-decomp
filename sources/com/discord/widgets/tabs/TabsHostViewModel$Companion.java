package com.discord.widgets.tabs;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import d0.z.d.m;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: TabsHostViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostViewModel$Companion {
    private TabsHostViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(TabsHostViewModel$Companion tabsHostViewModel$Companion, StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation, StoreUser storeUser, StoreGuilds storeGuilds, StoreMentions storeMentions, StoreUserRelationships storeUserRelationships) {
        return tabsHostViewModel$Companion.observeStoreState(storeNavigation, storeTabsNavigation, storeUser, storeGuilds, storeMentions, storeUserRelationships);
    }

    private final Observable<TabsHostViewModel$StoreState> observeStoreState(StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation, StoreUser storeUser, StoreGuilds storeGuilds, StoreMentions storeMentions, StoreUserRelationships storeUserRelationships) {
        Observable<TabsHostViewModel$StoreState> observableF = Observable.f(storeNavigation.observeLeftPanelState(), storeTabsNavigation.observeSelectedTab(), storeUser.observeMeId(), storeGuilds.observeGuilds(), storeMentions.observeTotalMentions(), storeUserRelationships.observe(), TabsHostViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableF, "Observable.combineLatest…nships,\n        )\n      }");
        return observableF;
    }

    public final Set<NavigationTab> getAT_LEAST_ONE_GUILD_TABS() {
        return TabsHostViewModel.access$getAT_LEAST_ONE_GUILD_TABS$cp();
    }

    public final List<NavigationTab> getNON_HOME_TAB_DESTINATIONS() {
        return TabsHostViewModel.access$getNON_HOME_TAB_DESTINATIONS$cp();
    }

    public final Set<NavigationTab> getNO_GUILD_TABS() {
        return TabsHostViewModel.access$getNO_GUILD_TABS$cp();
    }

    public final List<NavigationTab> getTAB_DESTINATIONS() {
        return TabsHostViewModel.access$getTAB_DESTINATIONS$cp();
    }

    public /* synthetic */ TabsHostViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
