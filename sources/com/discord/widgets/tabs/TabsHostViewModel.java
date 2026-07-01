package com.discord.widgets.tabs;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.panels.PanelState$c;
import com.discord.panels.PanelState$d;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.k;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: TabsHostViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostViewModel extends d0<TabsHostViewModel$ViewState> {
    private static final Set<NavigationTab> AT_LEAST_ONE_GUILD_TABS;
    public static final TabsHostViewModel$Companion Companion = new TabsHostViewModel$Companion(null);
    private static final List<NavigationTab> NON_HOME_TAB_DESTINATIONS;
    private static final Set<NavigationTab> NO_GUILD_TABS;
    private static final List<NavigationTab> TAB_DESTINATIONS;
    private final PublishSubject<TabsHostViewModel$Event> eventSubject;
    private final StoreNavigation storeNavigation;
    private TabsHostViewModel$StoreState storeState;
    private final StoreTabsNavigation storeTabsNavigation;

    static {
        List<NavigationTab> list = k.toList(NavigationTab.values());
        TAB_DESTINATIONS = list;
        NavigationTab navigationTab = NavigationTab.HOME;
        NON_HOME_TAB_DESTINATIONS = u.minus(list, navigationTab);
        NavigationTab navigationTab2 = NavigationTab.FRIENDS;
        NavigationTab navigationTab3 = NavigationTab.SETTINGS;
        NO_GUILD_TABS = n0.setOf((Object[]) new NavigationTab[]{navigationTab, navigationTab2, navigationTab3});
        AT_LEAST_ONE_GUILD_TABS = n0.setOf((Object[]) new NavigationTab[]{navigationTab, navigationTab2, NavigationTab.SEARCH, NavigationTab.MENTIONS, navigationTab3});
    }

    public TabsHostViewModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TabsHostViewModel(BottomNavViewObserver bottomNavViewObserver, StoreTabsNavigation storeTabsNavigation, StoreNavigation storeNavigation, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        bottomNavViewObserver = (i & 1) != 0 ? BottomNavViewObserver.Companion.getINSTANCE() : bottomNavViewObserver;
        storeTabsNavigation = (i & 2) != 0 ? StoreStream.Companion.getTabsNavigation() : storeTabsNavigation;
        storeNavigation = (i & 4) != 0 ? StoreStream.Companion.getNavigation() : storeNavigation;
        if ((i & 8) != 0) {
            TabsHostViewModel$Companion tabsHostViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = TabsHostViewModel$Companion.access$observeStoreState(tabsHostViewModel$Companion, storeNavigation, storeTabsNavigation, storeStream$Companion.getUsers(), storeStream$Companion.getGuilds(), storeStream$Companion.getMentions(), storeStream$Companion.getUserRelationships());
        }
        this(bottomNavViewObserver, storeTabsNavigation, storeNavigation, observable);
    }

    public static final /* synthetic */ void access$dismissSearchDialog(TabsHostViewModel tabsHostViewModel) {
        tabsHostViewModel.dismissSearchDialog();
    }

    public static final /* synthetic */ Set access$getAT_LEAST_ONE_GUILD_TABS$cp() {
        return AT_LEAST_ONE_GUILD_TABS;
    }

    public static final /* synthetic */ List access$getNON_HOME_TAB_DESTINATIONS$cp() {
        return NON_HOME_TAB_DESTINATIONS;
    }

    public static final /* synthetic */ Set access$getNO_GUILD_TABS$cp() {
        return NO_GUILD_TABS;
    }

    public static final /* synthetic */ List access$getTAB_DESTINATIONS$cp() {
        return TAB_DESTINATIONS;
    }

    public static final /* synthetic */ void access$handleBottomNavHeight(TabsHostViewModel tabsHostViewModel, int i) {
        tabsHostViewModel.handleBottomNavHeight(i);
    }

    public static final /* synthetic */ void access$handleStoreState(TabsHostViewModel tabsHostViewModel, TabsHostViewModel$StoreState tabsHostViewModel$StoreState) {
        tabsHostViewModel.handleStoreState(tabsHostViewModel$StoreState);
    }

    private final void dismissSearchDialog() {
        PublishSubject<TabsHostViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(TabsHostViewModel$Event$DismissSearchDialog.INSTANCE);
    }

    private final void emitTrackFriendsListShown() {
        PublishSubject<TabsHostViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(TabsHostViewModel$Event$TrackFriendsListShown.INSTANCE);
    }

    @MainThread
    private final void handleBottomNavHeight(int height) {
        updateViewState(TabsHostViewModel$ViewState.copy$default(requireViewState(), null, false, height, 0L, null, 0, 0, 123, null));
    }

    @MainThread
    private final void handleStoreState(TabsHostViewModel$StoreState storeState) {
        this.storeState = storeState;
        NavigationTab selectedTab = storeState.getSelectedTab();
        boolean z2 = NON_HOME_TAB_DESTINATIONS.contains(selectedTab) || (selectedTab == NavigationTab.HOME && (m.areEqual(storeState.getLeftPanelState(), PanelState$c.a) || m.areEqual(storeState.getLeftPanelState(), PanelState$d.a)));
        Set<NavigationTab> set = storeState.getGuildIdToGuildMap().values().isEmpty() ^ true ? AT_LEAST_ONE_GUILD_TABS : NO_GUILD_TABS;
        Map<Long, Integer> userRelationships = storeState.getUserRelationships();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Integer> map$Entry : userRelationships.entrySet()) {
            if (map$Entry.getValue().intValue() == 3) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        updateViewState(TabsHostViewModel$ViewState.copy$default(requireViewState(), selectedTab, z2, 0, storeState.getMyUserId(), set, storeState.getNumTotalMentions(), linkedHashMap.size(), 4, null));
    }

    @MainThread
    public final boolean handleBackPress() {
        NavigationTab navigationTab;
        NavigationTab selectedTab = requireViewState().getSelectedTab();
        if (!TAB_DESTINATIONS.contains(selectedTab) || selectedTab == (navigationTab = NavigationTab.HOME)) {
            return false;
        }
        selectTab(navigationTab);
        return true;
    }

    public final Observable<TabsHostViewModel$Event> observeEvents() {
        PublishSubject<TabsHostViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003f  */
    @MainThread
    public final void selectTab(NavigationTab tab) {
        StoreNavigation$PanelAction storeNavigation$PanelAction;
        m.checkNotNullParameter(tab, "tab");
        NavigationTab selectedTab = requireViewState().getSelectedTab();
        StoreTabsNavigation.selectTab$default(this.storeTabsNavigation, tab, false, 2, null);
        int iOrdinal = tab.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                return;
            }
            emitTrackFriendsListShown();
            return;
        }
        if (selectedTab != NavigationTab.HOME) {
            storeNavigation$PanelAction = StoreNavigation$PanelAction.OPEN;
        } else {
            TabsHostViewModel$StoreState tabsHostViewModel$StoreState = this.storeState;
            if (m.areEqual(tabsHostViewModel$StoreState != null ? tabsHostViewModel$StoreState.getLeftPanelState() : null, PanelState$c.a)) {
                storeNavigation$PanelAction = StoreNavigation$PanelAction.CLOSE;
            } else {
                storeNavigation$PanelAction = StoreNavigation$PanelAction.OPEN;
            }
        }
        StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, storeNavigation$PanelAction, null, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostViewModel(BottomNavViewObserver bottomNavViewObserver, StoreTabsNavigation storeTabsNavigation, StoreNavigation storeNavigation, Observable<TabsHostViewModel$StoreState> observable) {
        super(new TabsHostViewModel$ViewState(NavigationTab.HOME, false, 0, 0L, NO_GUILD_TABS, 0, 0));
        m.checkNotNullParameter(bottomNavViewObserver, "bottomNavViewObserver");
        m.checkNotNullParameter(storeTabsNavigation, "storeTabsNavigation");
        m.checkNotNullParameter(storeNavigation, "storeNavigation");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.storeTabsNavigation = storeTabsNavigation;
        this.storeNavigation = storeNavigation;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), TabsHostViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new TabsHostViewModel$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(bottomNavViewObserver.observeHeight(), this, null, 2, null), TabsHostViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new TabsHostViewModel$2(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeTabsNavigation.observeDismissTabsDialogEvent(), this, null, 2, null), TabsHostViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new TabsHostViewModel$3(this), 62, (Object) null);
    }
}
