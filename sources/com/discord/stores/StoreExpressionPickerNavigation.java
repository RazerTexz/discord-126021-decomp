package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.chat.input.expression.ExpressionTrayTab;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreExpressionPickerNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpressionPickerNavigation extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private ExpressionTrayTab selectedTab;
    private final Persister<ExpressionTrayTab> selectedTabPersister;

    /* JADX INFO: renamed from: com.discord.stores.StoreExpressionPickerNavigation$observeSelectedTab$1 */
    /* JADX INFO: compiled from: StoreExpressionPickerNavigation.kt */
    public static final class C59271 extends AbstractC12240o implements Function0<ExpressionTrayTab> {
        public C59271() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ExpressionTrayTab invoke() {
            return StoreExpressionPickerNavigation.this.selectedTab;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExpressionPickerNavigation$onSelectTab$1 */
    /* JADX INFO: compiled from: StoreExpressionPickerNavigation.kt */
    public static final class C59281 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ExpressionTrayTab $expressionTrayTab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59281(ExpressionTrayTab expressionTrayTab) {
            super(0);
            this.$expressionTrayTab = expressionTrayTab;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExpressionPickerNavigation.this.selectedTab = this.$expressionTrayTab;
            StoreExpressionPickerNavigation.this.markChanged();
        }
    }

    public StoreExpressionPickerNavigation(ObservationDeck observationDeck, Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.selectedTab = ExpressionTrayTab.EMOJI;
        Persister<ExpressionTrayTab> persister = new Persister<>("CACHE_KEY_SELECTED_EXPRESSION_TRAY_TAB", this.selectedTab);
        this.selectedTabPersister = persister;
        this.selectedTab = persister.get();
    }

    public final Observable<ExpressionTrayTab> observeSelectedTab() {
        Observable<ExpressionTrayTab> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59271(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void onSelectTab(ExpressionTrayTab expressionTrayTab) {
        C12238m.checkNotNullParameter(expressionTrayTab, "expressionTrayTab");
        this.dispatcher.schedule(new C59281(expressionTrayTab));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.selectedTabPersister.set(this.selectedTab, true);
    }
}
