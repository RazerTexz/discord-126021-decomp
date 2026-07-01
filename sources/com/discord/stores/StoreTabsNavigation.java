package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreTabsNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreTabsNavigation extends StoreV2 {
    private final PublishSubject<Unit> dismissTabsDialogEventSubject;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private NavigationTab selectedTab;
    private final StoreStream storeStream;

    public /* synthetic */ StoreTabsNavigation(Dispatcher dispatcher, StoreStream storeStream, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeStream, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ void access$dismissTabsDialogs(StoreTabsNavigation storeTabsNavigation) {
        storeTabsNavigation.dismissTabsDialogs();
    }

    public static final /* synthetic */ void access$handleTabSelection(StoreTabsNavigation storeTabsNavigation, NavigationTab navigationTab) {
        storeTabsNavigation.handleTabSelection(navigationTab);
    }

    public static final /* synthetic */ void access$notifyHomeTabSelected(StoreTabsNavigation storeTabsNavigation, StoreNavigation$PanelAction storeNavigation$PanelAction) {
        storeTabsNavigation.notifyHomeTabSelected(storeNavigation$PanelAction);
    }

    private final void dismissTabsDialogs() {
        PublishSubject<Unit> publishSubject = this.dismissTabsDialogEventSubject;
        publishSubject.k.onNext(Unit.a);
    }

    @StoreThread
    private final void handleTabSelection(NavigationTab navigationTab) {
        this.selectedTab = navigationTab;
        markChanged();
    }

    @StoreThread
    private final void notifyHomeTabSelected(StoreNavigation$PanelAction panelAction) {
        this.storeStream.handleHomeTabSelected(panelAction);
    }

    public static /* synthetic */ void selectHomeTab$default(StoreTabsNavigation storeTabsNavigation, StoreNavigation$PanelAction storeNavigation$PanelAction, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeTabsNavigation.selectHomeTab(storeNavigation$PanelAction, z2);
    }

    public static /* synthetic */ void selectTab$default(StoreTabsNavigation storeTabsNavigation, NavigationTab navigationTab, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeTabsNavigation.selectTab(navigationTab, z2);
    }

    public static /* synthetic */ void selectTabInternal$app_productionGoogleRelease$default(StoreTabsNavigation storeTabsNavigation, NavigationTab navigationTab, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeTabsNavigation.selectTabInternal$app_productionGoogleRelease(navigationTab, z2);
    }

    public final NavigationTab getSelectedTab() {
        return this.selectedTab;
    }

    @StoreThread
    public final void handlePreLogout() {
        selectTabInternal$app_productionGoogleRelease$default(this, NavigationTab.HOME, false, 2, null);
    }

    public final Observable<Unit> observeDismissTabsDialogEvent() {
        PublishSubject<Unit> publishSubject = this.dismissTabsDialogEventSubject;
        m.checkNotNullExpressionValue(publishSubject, "dismissTabsDialogEventSubject");
        return publishSubject;
    }

    public final Observable<NavigationTab> observeSelectedTab() {
        Observable<NavigationTab> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreTabsNavigation$observeSelectedTab$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void selectHomeTab(StoreNavigation$PanelAction panelAction, boolean dismissTabsDialogs) {
        m.checkNotNullParameter(panelAction, "panelAction");
        this.dispatcher.schedule(new StoreTabsNavigation$selectHomeTab$1(this, panelAction, dismissTabsDialogs));
    }

    public final void selectTab(NavigationTab navigationTab, boolean dismissTabsDialogs) {
        m.checkNotNullParameter(navigationTab, "navigationTab");
        this.dispatcher.schedule(new StoreTabsNavigation$selectTab$1(this, navigationTab, dismissTabsDialogs));
    }

    @StoreThread
    public final void selectTabInternal$app_productionGoogleRelease(NavigationTab navigationTab, boolean dismissTabsDialogs) {
        m.checkNotNullParameter(navigationTab, "navigationTab");
        handleTabSelection(navigationTab);
        if (dismissTabsDialogs) {
            dismissTabsDialogs();
        }
    }

    public StoreTabsNavigation(Dispatcher dispatcher, StoreStream storeStream, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeStream = storeStream;
        this.observationDeck = observationDeck;
        this.selectedTab = NavigationTab.HOME;
        this.dismissTabsDialogEventSubject = PublishSubject.k0();
    }
}
