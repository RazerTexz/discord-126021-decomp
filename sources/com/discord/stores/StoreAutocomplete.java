package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import rx.Observable;

/* JADX INFO: compiled from: StoreAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAutocomplete extends StoreV2 {
    private boolean autocompleteVisible;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    public StoreAutocomplete(ObservationDeck observationDeck, Dispatcher dispatcher) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
    }

    public static final /* synthetic */ boolean access$getAutocompleteVisible$p(StoreAutocomplete storeAutocomplete) {
        return storeAutocomplete.autocompleteVisible;
    }

    public static final /* synthetic */ void access$setAutocompleteVisible$p(StoreAutocomplete storeAutocomplete, boolean z2) {
        storeAutocomplete.autocompleteVisible = z2;
    }

    public final Observable<Boolean> observeAutocompleteVisibility() {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreAutocomplete$observeAutocompleteVisibility$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setAutocompleteVisible(boolean visible) {
        this.dispatcher.schedule(new StoreAutocomplete$setAutocompleteVisible$1(this, visible));
    }
}
