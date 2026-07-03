package com.discord.stores;

import com.discord.api.user.User;
import com.discord.stores.updates.ObservationDeck;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreMFA.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMFA extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State state;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreMFA.kt */
    public enum MFAActivationState {
        PENDING_ENABLED,
        PENDING_DISABLED,
        NONE
    }

    /* JADX INFO: compiled from: StoreMFA.kt */
    public static final /* data */ class State {
        private final MFAActivationState activationState;
        private final boolean isTogglingSMSBackup;

        public State(MFAActivationState mFAActivationState, boolean z2) {
            C12238m.checkNotNullParameter(mFAActivationState, "activationState");
            this.activationState = mFAActivationState;
            this.isTogglingSMSBackup = z2;
        }

        public static /* synthetic */ State copy$default(State state, MFAActivationState mFAActivationState, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                mFAActivationState = state.activationState;
            }
            if ((i & 2) != 0) {
                z2 = state.isTogglingSMSBackup;
            }
            return state.copy(mFAActivationState, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MFAActivationState getActivationState() {
            return this.activationState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsTogglingSMSBackup() {
            return this.isTogglingSMSBackup;
        }

        public final State copy(MFAActivationState activationState, boolean isTogglingSMSBackup) {
            C12238m.checkNotNullParameter(activationState, "activationState");
            return new State(activationState, isTogglingSMSBackup);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return C12238m.areEqual(this.activationState, state.activationState) && this.isTogglingSMSBackup == state.isTogglingSMSBackup;
        }

        public final MFAActivationState getActivationState() {
            return this.activationState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            MFAActivationState mFAActivationState = this.activationState;
            int iHashCode = (mFAActivationState != null ? mFAActivationState.hashCode() : 0) * 31;
            boolean z2 = this.isTogglingSMSBackup;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final boolean isTogglingSMSBackup() {
            return this.isTogglingSMSBackup;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("State(activationState=");
            sbM833U.append(this.activationState);
            sbM833U.append(", isTogglingSMSBackup=");
            return C1643a.m827O(sbM833U, this.isTogglingSMSBackup, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMFA$observeState$1 */
    /* JADX INFO: compiled from: StoreMFA.kt */
    public static final class C61601 extends AbstractC12240o implements Function0<State> {
        public C61601() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreMFA.this.state;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMFA$togglingSMSBackup$1 */
    /* JADX INFO: compiled from: StoreMFA.kt */
    public static final class C61611 extends AbstractC12240o implements Function0<Unit> {
        public C61611() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMFA storeMFA = StoreMFA.this;
            storeMFA.state = State.copy$default(storeMFA.state, null, true, 1, null);
            StoreMFA.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMFA$updatePendingMFAState$1 */
    /* JADX INFO: compiled from: StoreMFA.kt */
    public static final class C61621 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ MFAActivationState $newActivationState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61621(MFAActivationState mFAActivationState) {
            super(0);
            this.$newActivationState = mFAActivationState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMFA storeMFA = StoreMFA.this;
            storeMFA.state = State.copy$default(storeMFA.state, this.$newActivationState, false, 2, null);
            StoreMFA.this.markChanged();
        }
    }

    public StoreMFA(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.state = new State(MFAActivationState.NONE, false);
    }

    @StoreThread
    public final void handleUserUpdated(User user) {
        C12238m.checkNotNullParameter(user, "user");
        if (user.getId() == this.stream.getUsers().getMe().getId()) {
            this.state = new State(MFAActivationState.NONE, false);
            markChanged();
        }
    }

    public final Observable<State> observeState() {
        Observable<State> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61601(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void togglingSMSBackup() {
        this.dispatcher.schedule(new C61611());
    }

    public final void updatePendingMFAState(MFAActivationState newActivationState) {
        C12238m.checkNotNullParameter(newActivationState, "newActivationState");
        this.dispatcher.schedule(new C61621(newActivationState));
    }
}
