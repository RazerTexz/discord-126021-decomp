package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.chat.input.expression.ExpressionTrayTab;
import d0.z.d.m;
import rx.Observable;

/* JADX INFO: compiled from: StoreExpressionPickerNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpressionPickerNavigation extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private ExpressionTrayTab selectedTab;
    private final Persister<ExpressionTrayTab> selectedTabPersister;

    public StoreExpressionPickerNavigation(ObservationDeck observationDeck, Dispatcher dispatcher) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.selectedTab = ExpressionTrayTab.EMOJI;
        Persister<ExpressionTrayTab> persister = new Persister<>("CACHE_KEY_SELECTED_EXPRESSION_TRAY_TAB", this.selectedTab);
        this.selectedTabPersister = persister;
        this.selectedTab = persister.get();
    }

    public static final /* synthetic */ ExpressionTrayTab access$getSelectedTab$p(StoreExpressionPickerNavigation storeExpressionPickerNavigation) {
        return storeExpressionPickerNavigation.selectedTab;
    }

    public static final /* synthetic */ void access$setSelectedTab$p(StoreExpressionPickerNavigation storeExpressionPickerNavigation, ExpressionTrayTab expressionTrayTab) {
        storeExpressionPickerNavigation.selectedTab = expressionTrayTab;
    }

    public final Observable<ExpressionTrayTab> observeSelectedTab() {
        Observable<ExpressionTrayTab> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreExpressionPickerNavigation$observeSelectedTab$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void onSelectTab(ExpressionTrayTab expressionTrayTab) {
        m.checkNotNullParameter(expressionTrayTab, "expressionTrayTab");
        this.dispatcher.schedule(new StoreExpressionPickerNavigation$onSelectTab$1(this, expressionTrayTab));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.selectedTabPersister.set(this.selectedTab, true);
    }
}
