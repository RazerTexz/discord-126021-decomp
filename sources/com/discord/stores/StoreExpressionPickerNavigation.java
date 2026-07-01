package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.chat.input.expression.ExpressionTrayTab;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: StoreExpressionPickerNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreExpressionPickerNavigation extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private ExpressionTrayTab selectedTab;
    private final Persister<ExpressionTrayTab> selectedTabPersister;

    /* JADX INFO: renamed from: com.discord.stores.StoreExpressionPickerNavigation$observeSelectedTab$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExpressionPickerNavigation.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ExpressionTrayTab> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ExpressionTrayTab invoke() {
            return StoreExpressionPickerNavigation.this.selectedTab;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreExpressionPickerNavigation$onSelectTab$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreExpressionPickerNavigation.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ExpressionTrayTab $expressionTrayTab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ExpressionTrayTab expressionTrayTab) {
            super(0);
            this.$expressionTrayTab = expressionTrayTab;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExpressionPickerNavigation.this.selectedTab = this.$expressionTrayTab;
            StoreExpressionPickerNavigation.this.markChanged();
        }
    }

    public StoreExpressionPickerNavigation(ObservationDeck observationDeck, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.selectedTab = ExpressionTrayTab.EMOJI;
        Persister<ExpressionTrayTab> persister = new Persister<>("CACHE_KEY_SELECTED_EXPRESSION_TRAY_TAB", this.selectedTab);
        this.selectedTabPersister = persister;
        this.selectedTab = persister.get();
    }

    public final Observable<ExpressionTrayTab> observeSelectedTab() {
        Observable<ExpressionTrayTab> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void onSelectTab(ExpressionTrayTab expressionTrayTab) {
        Intrinsics3.checkNotNullParameter(expressionTrayTab, "expressionTrayTab");
        this.dispatcher.schedule(new AnonymousClass1(expressionTrayTab));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.selectedTabPersister.set(this.selectedTab, true);
    }
}
