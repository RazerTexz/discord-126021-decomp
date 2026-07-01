package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreConnectivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreConnectivity$DelayedState {
    private final long delay;
    private final StoreConnectivity$State state;

    public StoreConnectivity$DelayedState(StoreConnectivity$State storeConnectivity$State, long j) {
        m.checkNotNullParameter(storeConnectivity$State, "state");
        this.state = storeConnectivity$State;
        this.delay = j;
    }

    public static /* synthetic */ StoreConnectivity$DelayedState copy$default(StoreConnectivity$DelayedState storeConnectivity$DelayedState, StoreConnectivity$State storeConnectivity$State, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            storeConnectivity$State = storeConnectivity$DelayedState.state;
        }
        if ((i & 2) != 0) {
            j = storeConnectivity$DelayedState.delay;
        }
        return storeConnectivity$DelayedState.copy(storeConnectivity$State, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreConnectivity$State getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getDelay() {
        return this.delay;
    }

    public final StoreConnectivity$DelayedState copy(StoreConnectivity$State state, long delay) {
        m.checkNotNullParameter(state, "state");
        return new StoreConnectivity$DelayedState(state, delay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreConnectivity$DelayedState)) {
            return false;
        }
        StoreConnectivity$DelayedState storeConnectivity$DelayedState = (StoreConnectivity$DelayedState) other;
        return m.areEqual(this.state, storeConnectivity$DelayedState.state) && this.delay == storeConnectivity$DelayedState.delay;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final StoreConnectivity$State getState() {
        return this.state;
    }

    public int hashCode() {
        StoreConnectivity$State storeConnectivity$State = this.state;
        return b.a(this.delay) + ((storeConnectivity$State != null ? storeConnectivity$State.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("DelayedState(state=");
        sbU.append(this.state);
        sbU.append(", delay=");
        return a.C(sbU, this.delay, ")");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StoreConnectivity$DelayedState(StoreConnectivity$State storeConnectivity$State, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            StoreConnectivity.access$Companion();
            j = 1000;
        }
        this(storeConnectivity$State, j);
    }
}
