package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: StoreAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAutocomplete extends StoreV2 {
    private boolean autocompleteVisible;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreAutocomplete$observeAutocompleteVisibility$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAutocomplete.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreAutocomplete.this.autocompleteVisible;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreAutocomplete$setAutocompleteVisible$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreAutocomplete.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $visible;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$visible = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAutocomplete.this.autocompleteVisible = this.$visible;
            StoreAutocomplete.this.markChanged();
        }
    }

    public StoreAutocomplete(ObservationDeck observationDeck, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
    }

    public final Observable<Boolean> observeAutocompleteVisibility() {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setAutocompleteVisible(boolean visible) {
        this.dispatcher.schedule(new AnonymousClass1(visible));
    }
}
