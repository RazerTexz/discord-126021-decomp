package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.widgets.tabs.NavigationTab;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreTabsNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreTabsNavigation extends StoreV2 {
    private final PublishSubject<Unit> dismissTabsDialogEventSubject;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private NavigationTab selectedTab;
    private final StoreStream storeStream;

    /* JADX INFO: renamed from: com.discord.stores.StoreTabsNavigation$observeSelectedTab$1 */
    /* JADX INFO: compiled from: StoreTabsNavigation.kt */
    public static final class C65261 extends AbstractC12240o implements Function0<NavigationTab> {
        public C65261() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NavigationTab invoke() {
            return StoreTabsNavigation.this.getSelectedTab();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreTabsNavigation$selectHomeTab$1 */
    /* JADX INFO: compiled from: StoreTabsNavigation.kt */
    public static final class C65271 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ boolean $dismissTabsDialogs;
        public final /* synthetic */ StoreNavigation.PanelAction $panelAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65271(StoreNavigation.PanelAction panelAction, boolean z2) {
            super(0);
            this.$panelAction = panelAction;
            this.$dismissTabsDialogs = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreTabsNavigation.this.handleTabSelection(NavigationTab.HOME);
            StoreTabsNavigation.this.notifyHomeTabSelected(this.$panelAction);
            if (this.$dismissTabsDialogs) {
                StoreTabsNavigation.this.dismissTabsDialogs();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreTabsNavigation$selectTab$1 */
    /* JADX INFO: compiled from: StoreTabsNavigation.kt */
    public static final class C65281 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ boolean $dismissTabsDialogs;
        public final /* synthetic */ NavigationTab $navigationTab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65281(NavigationTab navigationTab, boolean z2) {
            super(0);
            this.$navigationTab = navigationTab;
            this.$dismissTabsDialogs = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreTabsNavigation.this.selectTabInternal$app_productionGoogleRelease(this.$navigationTab, this.$dismissTabsDialogs);
        }
    }

    public /* synthetic */ StoreTabsNavigation(Dispatcher dispatcher, StoreStream storeStream, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeStream, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    private final void dismissTabsDialogs() {
        PublishSubject<Unit> publishSubject = this.dismissTabsDialogEventSubject;
        publishSubject.f27650k.onNext(Unit.f27425a);
    }

    @StoreThread
    private final void handleTabSelection(NavigationTab navigationTab) {
        this.selectedTab = navigationTab;
        markChanged();
    }

    @StoreThread
    private final void notifyHomeTabSelected(StoreNavigation.PanelAction panelAction) {
        this.storeStream.handleHomeTabSelected(panelAction);
    }

    public static /* synthetic */ void selectHomeTab$default(StoreTabsNavigation storeTabsNavigation, StoreNavigation.PanelAction panelAction, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        storeTabsNavigation.selectHomeTab(panelAction, z2);
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
        C12238m.checkNotNullExpressionValue(publishSubject, "dismissTabsDialogEventSubject");
        return publishSubject;
    }

    public final Observable<NavigationTab> observeSelectedTab() {
        Observable<NavigationTab> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65261(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void selectHomeTab(StoreNavigation.PanelAction panelAction, boolean dismissTabsDialogs) {
        C12238m.checkNotNullParameter(panelAction, "panelAction");
        this.dispatcher.schedule(new C65271(panelAction, dismissTabsDialogs));
    }

    public final void selectTab(NavigationTab navigationTab, boolean dismissTabsDialogs) {
        C12238m.checkNotNullParameter(navigationTab, "navigationTab");
        this.dispatcher.schedule(new C65281(navigationTab, dismissTabsDialogs));
    }

    @StoreThread
    public final void selectTabInternal$app_productionGoogleRelease(NavigationTab navigationTab, boolean dismissTabsDialogs) {
        C12238m.checkNotNullParameter(navigationTab, "navigationTab");
        handleTabSelection(navigationTab);
        if (dismissTabsDialogs) {
            dismissTabsDialogs();
        }
    }

    public StoreTabsNavigation(Dispatcher dispatcher, StoreStream storeStream, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeStream, "storeStream");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeStream = storeStream;
        this.observationDeck = observationDeck;
        this.selectedTab = NavigationTab.HOME;
        this.dismissTabsDialogEventSubject = PublishSubject.m11133k0();
    }
}
