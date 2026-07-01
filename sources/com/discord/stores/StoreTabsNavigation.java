package com.discord.stores;

import com.discord.stores.StoreNavigation;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreTabsNavigation$observeSelectedTab$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreTabsNavigation.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<NavigationTab> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NavigationTab invoke() {
            return StoreTabsNavigation.this.getSelectedTab();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreTabsNavigation$selectHomeTab$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreTabsNavigation.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $dismissTabsDialogs;
        public final /* synthetic */ StoreNavigation.PanelAction $panelAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreNavigation.PanelAction panelAction, boolean z2) {
            super(0);
            this.$panelAction = panelAction;
            this.$dismissTabsDialogs = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreTabsNavigation$selectTab$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreTabsNavigation.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $dismissTabsDialogs;
        public final /* synthetic */ NavigationTab $navigationTab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(NavigationTab navigationTab, boolean z2) {
            super(0);
            this.$navigationTab = navigationTab;
            this.$dismissTabsDialogs = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreTabsNavigation.this.selectTabInternal$app_productionGoogleRelease(this.$navigationTab, this.$dismissTabsDialogs);
        }
    }

    public /* synthetic */ StoreTabsNavigation(Dispatcher dispatcher, StoreStream storeStream, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeStream, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    private final void dismissTabsDialogs() {
        PublishSubject<Unit> publishSubject = this.dismissTabsDialogEventSubject;
        publishSubject.k.onNext(Unit.a);
    }

    @Store3
    private final void handleTabSelection(NavigationTab navigationTab) {
        this.selectedTab = navigationTab;
        markChanged();
    }

    @Store3
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

    @Store3
    public final void handlePreLogout() {
        selectTabInternal$app_productionGoogleRelease$default(this, NavigationTab.HOME, false, 2, null);
    }

    public final Observable<Unit> observeDismissTabsDialogEvent() {
        PublishSubject<Unit> publishSubject = this.dismissTabsDialogEventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "dismissTabsDialogEventSubject");
        return publishSubject;
    }

    public final Observable<NavigationTab> observeSelectedTab() {
        Observable<NavigationTab> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void selectHomeTab(StoreNavigation.PanelAction panelAction, boolean dismissTabsDialogs) {
        Intrinsics3.checkNotNullParameter(panelAction, "panelAction");
        this.dispatcher.schedule(new AnonymousClass1(panelAction, dismissTabsDialogs));
    }

    public final void selectTab(NavigationTab navigationTab, boolean dismissTabsDialogs) {
        Intrinsics3.checkNotNullParameter(navigationTab, "navigationTab");
        this.dispatcher.schedule(new AnonymousClass1(navigationTab, dismissTabsDialogs));
    }

    @Store3
    public final void selectTabInternal$app_productionGoogleRelease(NavigationTab navigationTab, boolean dismissTabsDialogs) {
        Intrinsics3.checkNotNullParameter(navigationTab, "navigationTab");
        handleTabSelection(navigationTab);
        if (dismissTabsDialogs) {
            dismissTabsDialogs();
        }
    }

    public StoreTabsNavigation(Dispatcher dispatcher, StoreStream storeStream, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeStream = storeStream;
        this.observationDeck = observationDeck;
        this.selectedTab = NavigationTab.HOME;
        this.dismissTabsDialogEventSubject = PublishSubject.k0();
    }
}
