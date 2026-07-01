package com.discord.widgets.tabs;

import a0.a.a.b;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.panels.PanelState;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.tabs.TabsHostViewModel;
import d0.t.Sets5;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func6;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: TabsHostViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TabsHostViewModel extends AppViewModel<ViewState> {
    private static final Set<NavigationTab> AT_LEAST_ONE_GUILD_TABS;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<NavigationTab> NON_HOME_TAB_DESTINATIONS;
    private static final Set<NavigationTab> NO_GUILD_TABS;
    private static final List<NavigationTab> TAB_DESTINATIONS;
    private final PublishSubject<Event> eventSubject;
    private final StoreNavigation storeNavigation;
    private StoreState storeState;
    private final StoreTabsNavigation storeTabsNavigation;

    /* JADX INFO: renamed from: com.discord.widgets.tabs.TabsHostViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: TabsHostViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            TabsHostViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tabs.TabsHostViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: TabsHostViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            TabsHostViewModel.this.handleBottomNavHeight(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tabs.TabsHostViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: TabsHostViewModel.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
            TabsHostViewModel.this.dismissSearchDialog();
        }
    }

    /* JADX INFO: compiled from: TabsHostViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation, StoreUser storeUser, StoreGuilds storeGuilds, StoreMentions storeMentions, StoreUserRelationships storeUserRelationships) {
            Observable<StoreState> observableF = Observable.f(storeNavigation.observeLeftPanelState(), storeTabsNavigation.observeSelectedTab(), storeUser.observeMeId(), storeGuilds.observeGuilds(), storeMentions.observeTotalMentions(), storeUserRelationships.observe(), new Func6<PanelState, NavigationTab, Long, Map<Long, ? extends Guild>, Integer, Map<Long, ? extends Integer>, StoreState>() { // from class: com.discord.widgets.tabs.TabsHostViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func6
                public /* bridge */ /* synthetic */ TabsHostViewModel.StoreState call(PanelState panelState, NavigationTab navigationTab, Long l, Map<Long, ? extends Guild> map, Integer num, Map<Long, ? extends Integer> map2) {
                    return call2(panelState, navigationTab, l, (Map<Long, Guild>) map, num, (Map<Long, Integer>) map2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final TabsHostViewModel.StoreState call2(PanelState panelState, NavigationTab navigationTab, Long l, Map<Long, Guild> map, Integer num, Map<Long, Integer> map2) {
                    Intrinsics3.checkNotNullExpressionValue(panelState, "leftPanelState");
                    Intrinsics3.checkNotNullExpressionValue(navigationTab, "selectedTab");
                    Intrinsics3.checkNotNullExpressionValue(l, "myUserId");
                    long jLongValue = l.longValue();
                    Intrinsics3.checkNotNullExpressionValue(map, "guildIdToGuildMap");
                    Intrinsics3.checkNotNullExpressionValue(num, "numTotalMentions");
                    int iIntValue = num.intValue();
                    Intrinsics3.checkNotNullExpressionValue(map2, "userRelationships");
                    return new TabsHostViewModel.StoreState(panelState, navigationTab, jLongValue, map, iIntValue, map2);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableF, "Observable.combineLatest…nships,\n        )\n      }");
            return observableF;
        }

        public final Set<NavigationTab> getAT_LEAST_ONE_GUILD_TABS() {
            return TabsHostViewModel.AT_LEAST_ONE_GUILD_TABS;
        }

        public final List<NavigationTab> getNON_HOME_TAB_DESTINATIONS() {
            return TabsHostViewModel.NON_HOME_TAB_DESTINATIONS;
        }

        public final Set<NavigationTab> getNO_GUILD_TABS() {
            return TabsHostViewModel.NO_GUILD_TABS;
        }

        public final List<NavigationTab> getTAB_DESTINATIONS() {
            return TabsHostViewModel.TAB_DESTINATIONS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: TabsHostViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: TabsHostViewModel.kt */
        public static final class DismissSearchDialog extends Event {
            public static final DismissSearchDialog INSTANCE = new DismissSearchDialog();

            private DismissSearchDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: TabsHostViewModel.kt */
        public static final class TrackFriendsListShown extends Event {
            public static final TrackFriendsListShown INSTANCE = new TrackFriendsListShown();

            private TrackFriendsListShown() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: TabsHostViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, Guild> guildIdToGuildMap;
        private final PanelState leftPanelState;
        private final long myUserId;
        private final int numTotalMentions;
        private final NavigationTab selectedTab;
        private final Map<Long, Integer> userRelationships;

        public StoreState(PanelState panelState, NavigationTab navigationTab, long j, Map<Long, Guild> map, int i, Map<Long, Integer> map2) {
            Intrinsics3.checkNotNullParameter(panelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(navigationTab, "selectedTab");
            Intrinsics3.checkNotNullParameter(map, "guildIdToGuildMap");
            Intrinsics3.checkNotNullParameter(map2, "userRelationships");
            this.leftPanelState = panelState;
            this.selectedTab = navigationTab;
            this.myUserId = j;
            this.guildIdToGuildMap = map;
            this.numTotalMentions = i;
            this.userRelationships = map2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, PanelState panelState, NavigationTab navigationTab, long j, Map map, int i, Map map2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                panelState = storeState.leftPanelState;
            }
            if ((i2 & 2) != 0) {
                navigationTab = storeState.selectedTab;
            }
            NavigationTab navigationTab2 = navigationTab;
            if ((i2 & 4) != 0) {
                j = storeState.myUserId;
            }
            long j2 = j;
            if ((i2 & 8) != 0) {
                map = storeState.guildIdToGuildMap;
            }
            Map map3 = map;
            if ((i2 & 16) != 0) {
                i = storeState.numTotalMentions;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                map2 = storeState.userRelationships;
            }
            return storeState.copy(panelState, navigationTab2, j2, map3, i3, map2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getMyUserId() {
            return this.myUserId;
        }

        public final Map<Long, Guild> component4() {
            return this.guildIdToGuildMap;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getNumTotalMentions() {
            return this.numTotalMentions;
        }

        public final Map<Long, Integer> component6() {
            return this.userRelationships;
        }

        public final StoreState copy(PanelState leftPanelState, NavigationTab selectedTab, long myUserId, Map<Long, Guild> guildIdToGuildMap, int numTotalMentions, Map<Long, Integer> userRelationships) {
            Intrinsics3.checkNotNullParameter(leftPanelState, "leftPanelState");
            Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
            Intrinsics3.checkNotNullParameter(guildIdToGuildMap, "guildIdToGuildMap");
            Intrinsics3.checkNotNullParameter(userRelationships, "userRelationships");
            return new StoreState(leftPanelState, selectedTab, myUserId, guildIdToGuildMap, numTotalMentions, userRelationships);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.leftPanelState, storeState.leftPanelState) && Intrinsics3.areEqual(this.selectedTab, storeState.selectedTab) && this.myUserId == storeState.myUserId && Intrinsics3.areEqual(this.guildIdToGuildMap, storeState.guildIdToGuildMap) && this.numTotalMentions == storeState.numTotalMentions && Intrinsics3.areEqual(this.userRelationships, storeState.userRelationships);
        }

        public final Map<Long, Guild> getGuildIdToGuildMap() {
            return this.guildIdToGuildMap;
        }

        public final PanelState getLeftPanelState() {
            return this.leftPanelState;
        }

        public final long getMyUserId() {
            return this.myUserId;
        }

        public final int getNumTotalMentions() {
            return this.numTotalMentions;
        }

        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        public final Map<Long, Integer> getUserRelationships() {
            return this.userRelationships;
        }

        public int hashCode() {
            PanelState panelState = this.leftPanelState;
            int iHashCode = (panelState != null ? panelState.hashCode() : 0) * 31;
            NavigationTab navigationTab = this.selectedTab;
            int iA = (b.a(this.myUserId) + ((iHashCode + (navigationTab != null ? navigationTab.hashCode() : 0)) * 31)) * 31;
            Map<Long, Guild> map = this.guildIdToGuildMap;
            int iHashCode2 = (((iA + (map != null ? map.hashCode() : 0)) * 31) + this.numTotalMentions) * 31;
            Map<Long, Integer> map2 = this.userRelationships;
            return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(leftPanelState=");
            sbU.append(this.leftPanelState);
            sbU.append(", selectedTab=");
            sbU.append(this.selectedTab);
            sbU.append(", myUserId=");
            sbU.append(this.myUserId);
            sbU.append(", guildIdToGuildMap=");
            sbU.append(this.guildIdToGuildMap);
            sbU.append(", numTotalMentions=");
            sbU.append(this.numTotalMentions);
            sbU.append(", userRelationships=");
            return outline.M(sbU, this.userRelationships, ")");
        }
    }

    /* JADX INFO: compiled from: TabsHostViewModel.kt */
    public static final /* data */ class ViewState {
        private final int bottomNavHeight;
        private final long myUserId;
        private final int numFriendsNotifications;
        private final int numHomeNotifications;
        private final NavigationTab selectedTab;
        private final boolean showBottomNav;
        private final Set<NavigationTab> visibleTabs;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(NavigationTab navigationTab, boolean z2, int i, long j, Set<? extends NavigationTab> set, int i2, int i3) {
            Intrinsics3.checkNotNullParameter(navigationTab, "selectedTab");
            Intrinsics3.checkNotNullParameter(set, "visibleTabs");
            this.selectedTab = navigationTab;
            this.showBottomNav = z2;
            this.bottomNavHeight = i;
            this.myUserId = j;
            this.visibleTabs = set;
            this.numHomeNotifications = i2;
            this.numFriendsNotifications = i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, NavigationTab navigationTab, boolean z2, int i, long j, Set set, int i2, int i3, int i4, Object obj) {
            return viewState.copy((i4 & 1) != 0 ? viewState.selectedTab : navigationTab, (i4 & 2) != 0 ? viewState.showBottomNav : z2, (i4 & 4) != 0 ? viewState.bottomNavHeight : i, (i4 & 8) != 0 ? viewState.myUserId : j, (i4 & 16) != 0 ? viewState.visibleTabs : set, (i4 & 32) != 0 ? viewState.numHomeNotifications : i2, (i4 & 64) != 0 ? viewState.numFriendsNotifications : i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getShowBottomNav() {
            return this.showBottomNav;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getBottomNavHeight() {
            return this.bottomNavHeight;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getMyUserId() {
            return this.myUserId;
        }

        public final Set<NavigationTab> component5() {
            return this.visibleTabs;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getNumHomeNotifications() {
            return this.numHomeNotifications;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getNumFriendsNotifications() {
            return this.numFriendsNotifications;
        }

        public final ViewState copy(NavigationTab selectedTab, boolean showBottomNav, int bottomNavHeight, long myUserId, Set<? extends NavigationTab> visibleTabs, int numHomeNotifications, int numFriendsNotifications) {
            Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
            Intrinsics3.checkNotNullParameter(visibleTabs, "visibleTabs");
            return new ViewState(selectedTab, showBottomNav, bottomNavHeight, myUserId, visibleTabs, numHomeNotifications, numFriendsNotifications);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.selectedTab, viewState.selectedTab) && this.showBottomNav == viewState.showBottomNav && this.bottomNavHeight == viewState.bottomNavHeight && this.myUserId == viewState.myUserId && Intrinsics3.areEqual(this.visibleTabs, viewState.visibleTabs) && this.numHomeNotifications == viewState.numHomeNotifications && this.numFriendsNotifications == viewState.numFriendsNotifications;
        }

        public final int getBottomNavHeight() {
            return this.bottomNavHeight;
        }

        public final long getMyUserId() {
            return this.myUserId;
        }

        public final int getNumFriendsNotifications() {
            return this.numFriendsNotifications;
        }

        public final int getNumHomeNotifications() {
            return this.numHomeNotifications;
        }

        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        public final boolean getShowBottomNav() {
            return this.showBottomNav;
        }

        public final Set<NavigationTab> getVisibleTabs() {
            return this.visibleTabs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        public int hashCode() {
            NavigationTab navigationTab = this.selectedTab;
            int iHashCode = (navigationTab != null ? navigationTab.hashCode() : 0) * 31;
            boolean z2 = this.showBottomNav;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int iA = (b.a(this.myUserId) + ((((iHashCode + r2) * 31) + this.bottomNavHeight) * 31)) * 31;
            Set<NavigationTab> set = this.visibleTabs;
            return ((((iA + (set != null ? set.hashCode() : 0)) * 31) + this.numHomeNotifications) * 31) + this.numFriendsNotifications;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(selectedTab=");
            sbU.append(this.selectedTab);
            sbU.append(", showBottomNav=");
            sbU.append(this.showBottomNav);
            sbU.append(", bottomNavHeight=");
            sbU.append(this.bottomNavHeight);
            sbU.append(", myUserId=");
            sbU.append(this.myUserId);
            sbU.append(", visibleTabs=");
            sbU.append(this.visibleTabs);
            sbU.append(", numHomeNotifications=");
            sbU.append(this.numHomeNotifications);
            sbU.append(", numFriendsNotifications=");
            return outline.B(sbU, this.numFriendsNotifications, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            NavigationTab.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[NavigationTab.HOME.ordinal()] = 1;
            iArr[NavigationTab.FRIENDS.ordinal()] = 2;
        }
    }

    static {
        List<NavigationTab> list = _Arrays.toList(NavigationTab.values());
        TAB_DESTINATIONS = list;
        NavigationTab navigationTab = NavigationTab.HOME;
        NON_HOME_TAB_DESTINATIONS = _Collections.minus(list, navigationTab);
        NavigationTab navigationTab2 = NavigationTab.FRIENDS;
        NavigationTab navigationTab3 = NavigationTab.SETTINGS;
        NO_GUILD_TABS = Sets5.setOf((Object[]) new NavigationTab[]{navigationTab, navigationTab2, navigationTab3});
        AT_LEAST_ONE_GUILD_TABS = Sets5.setOf((Object[]) new NavigationTab[]{navigationTab, navigationTab2, NavigationTab.SEARCH, NavigationTab.MENTIONS, navigationTab3});
    }

    public TabsHostViewModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TabsHostViewModel(BottomNavViewObserver bottomNavViewObserver, StoreTabsNavigation storeTabsNavigation, StoreNavigation storeNavigation, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        bottomNavViewObserver = (i & 1) != 0 ? BottomNavViewObserver.INSTANCE.getINSTANCE() : bottomNavViewObserver;
        storeTabsNavigation = (i & 2) != 0 ? StoreStream.INSTANCE.getTabsNavigation() : storeTabsNavigation;
        storeNavigation = (i & 4) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation;
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStoreState(storeNavigation, storeTabsNavigation, companion2.getUsers(), companion2.getGuilds(), companion2.getMentions(), companion2.getUserRelationships());
        }
        this(bottomNavViewObserver, storeTabsNavigation, storeNavigation, observable);
    }

    private final void dismissSearchDialog() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.DismissSearchDialog.INSTANCE);
    }

    private final void emitTrackFriendsListShown() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.TrackFriendsListShown.INSTANCE);
    }

    @MainThread
    private final void handleBottomNavHeight(int height) {
        updateViewState(ViewState.copy$default(requireViewState(), null, false, height, 0L, null, 0, 0, 123, null));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        this.storeState = storeState;
        NavigationTab selectedTab = storeState.getSelectedTab();
        boolean z2 = NON_HOME_TAB_DESTINATIONS.contains(selectedTab) || (selectedTab == NavigationTab.HOME && (Intrinsics3.areEqual(storeState.getLeftPanelState(), PanelState.c.a) || Intrinsics3.areEqual(storeState.getLeftPanelState(), PanelState.d.a)));
        Set<NavigationTab> set = storeState.getGuildIdToGuildMap().values().isEmpty() ^ true ? AT_LEAST_ONE_GUILD_TABS : NO_GUILD_TABS;
        Map<Long, Integer> userRelationships = storeState.getUserRelationships();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Integer> entry : userRelationships.entrySet()) {
            if (entry.getValue().intValue() == 3) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        updateViewState(ViewState.copy$default(requireViewState(), selectedTab, z2, 0, storeState.getMyUserId(), set, storeState.getNumTotalMentions(), linkedHashMap.size(), 4, null));
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

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003f  */
    @MainThread
    public final void selectTab(NavigationTab tab) {
        StoreNavigation.PanelAction panelAction;
        Intrinsics3.checkNotNullParameter(tab, "tab");
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
            panelAction = StoreNavigation.PanelAction.OPEN;
        } else {
            StoreState storeState = this.storeState;
            if (Intrinsics3.areEqual(storeState != null ? storeState.getLeftPanelState() : null, PanelState.c.a)) {
                panelAction = StoreNavigation.PanelAction.CLOSE;
            } else {
                panelAction = StoreNavigation.PanelAction.OPEN;
            }
        }
        StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, panelAction, null, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostViewModel(BottomNavViewObserver bottomNavViewObserver, StoreTabsNavigation storeTabsNavigation, StoreNavigation storeNavigation, Observable<StoreState> observable) {
        super(new ViewState(NavigationTab.HOME, false, 0, 0L, NO_GUILD_TABS, 0, 0));
        Intrinsics3.checkNotNullParameter(bottomNavViewObserver, "bottomNavViewObserver");
        Intrinsics3.checkNotNullParameter(storeTabsNavigation, "storeTabsNavigation");
        Intrinsics3.checkNotNullParameter(storeNavigation, "storeNavigation");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.storeTabsNavigation = storeTabsNavigation;
        this.storeNavigation = storeNavigation;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) TabsHostViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(bottomNavViewObserver.observeHeight(), this, null, 2, null), (Class<?>) TabsHostViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(storeTabsNavigation.observeDismissTabsDialogEvent(), this, null, 2, null), (Class<?>) TabsHostViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }
}
