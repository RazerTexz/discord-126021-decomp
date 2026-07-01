package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

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
            Intrinsics3.checkNotNullParameter(mFAActivationState, "activationState");
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
            Intrinsics3.checkNotNullParameter(activationState, "activationState");
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
            return Intrinsics3.areEqual(this.activationState, state.activationState) && this.isTogglingSMSBackup == state.isTogglingSMSBackup;
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
            StringBuilder sbU = outline.U("State(activationState=");
            sbU.append(this.activationState);
            sbU.append(", isTogglingSMSBackup=");
            return outline.O(sbU, this.isTogglingSMSBackup, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMFA$observeState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMFA.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreMFA.this.state;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMFA$togglingSMSBackup$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMFA.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMFA storeMFA = StoreMFA.this;
            storeMFA.state = State.copy$default(storeMFA.state, null, true, 1, null);
            StoreMFA.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMFA$updatePendingMFAState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMFA.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MFAActivationState $newActivationState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MFAActivationState mFAActivationState) {
            super(0);
            this.$newActivationState = mFAActivationState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMFA storeMFA = StoreMFA.this;
            storeMFA.state = State.copy$default(storeMFA.state, this.$newActivationState, false, 2, null);
            StoreMFA.this.markChanged();
        }
    }

    public StoreMFA(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.state = new State(MFAActivationState.NONE, false);
    }

    @Store3
    public final void handleUserUpdated(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        if (user.getId() == this.stream.getUsers().getMe().getId()) {
            this.state = new State(MFAActivationState.NONE, false);
            markChanged();
        }
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void togglingSMSBackup() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void updatePendingMFAState(MFAActivationState newActivationState) {
        Intrinsics3.checkNotNullParameter(newActivationState, "newActivationState");
        this.dispatcher.schedule(new AnonymousClass1(newActivationState));
    }
}
