package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreMFA.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMFA$State {
    private final StoreMFA$MFAActivationState activationState;
    private final boolean isTogglingSMSBackup;

    public StoreMFA$State(StoreMFA$MFAActivationState storeMFA$MFAActivationState, boolean z2) {
        m.checkNotNullParameter(storeMFA$MFAActivationState, "activationState");
        this.activationState = storeMFA$MFAActivationState;
        this.isTogglingSMSBackup = z2;
    }

    public static /* synthetic */ StoreMFA$State copy$default(StoreMFA$State storeMFA$State, StoreMFA$MFAActivationState storeMFA$MFAActivationState, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            storeMFA$MFAActivationState = storeMFA$State.activationState;
        }
        if ((i & 2) != 0) {
            z2 = storeMFA$State.isTogglingSMSBackup;
        }
        return storeMFA$State.copy(storeMFA$MFAActivationState, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreMFA$MFAActivationState getActivationState() {
        return this.activationState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsTogglingSMSBackup() {
        return this.isTogglingSMSBackup;
    }

    public final StoreMFA$State copy(StoreMFA$MFAActivationState activationState, boolean isTogglingSMSBackup) {
        m.checkNotNullParameter(activationState, "activationState");
        return new StoreMFA$State(activationState, isTogglingSMSBackup);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreMFA$State)) {
            return false;
        }
        StoreMFA$State storeMFA$State = (StoreMFA$State) other;
        return m.areEqual(this.activationState, storeMFA$State.activationState) && this.isTogglingSMSBackup == storeMFA$State.isTogglingSMSBackup;
    }

    public final StoreMFA$MFAActivationState getActivationState() {
        return this.activationState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        StoreMFA$MFAActivationState storeMFA$MFAActivationState = this.activationState;
        int iHashCode = (storeMFA$MFAActivationState != null ? storeMFA$MFAActivationState.hashCode() : 0) * 31;
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
        StringBuilder sbU = a.U("State(activationState=");
        sbU.append(this.activationState);
        sbU.append(", isTogglingSMSBackup=");
        return a.O(sbU, this.isTogglingSMSBackup, ")");
    }
}
