package com.discord.stores;

import com.discord.api.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import rx.Observable;

/* JADX INFO: compiled from: StoreMFA.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMFA extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private StoreMFA$State state;
    private final StoreStream stream;

    public StoreMFA(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.state = new StoreMFA$State(StoreMFA$MFAActivationState.NONE, false);
    }

    public static final /* synthetic */ StoreMFA$State access$getState$p(StoreMFA storeMFA) {
        return storeMFA.state;
    }

    public static final /* synthetic */ void access$setState$p(StoreMFA storeMFA, StoreMFA$State storeMFA$State) {
        storeMFA.state = storeMFA$State;
    }

    @StoreThread
    public final void handleUserUpdated(User user) {
        m.checkNotNullParameter(user, "user");
        if (user.getId() == this.stream.getUsers().getMe().getId()) {
            this.state = new StoreMFA$State(StoreMFA$MFAActivationState.NONE, false);
            markChanged();
        }
    }

    public final Observable<StoreMFA$State> observeState() {
        Observable<StoreMFA$State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreMFA$observeState$1(this), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void togglingSMSBackup() {
        this.dispatcher.schedule(new StoreMFA$togglingSMSBackup$1(this));
    }

    public final void updatePendingMFAState(StoreMFA$MFAActivationState newActivationState) {
        m.checkNotNullParameter(newActivationState, "newActivationState");
        this.dispatcher.schedule(new StoreMFA$updatePendingMFAState$1(this, newActivationState));
    }
}
