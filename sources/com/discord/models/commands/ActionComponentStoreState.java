package com.discord.models.commands;

import b.d.b.a.outline;
import com.discord.stores.StoreApplicationInteractions;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ActionComponentStoreState.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ActionComponentStoreState extends ActionComponentStoreState2 {
    private final boolean disabled;
    private final StoreApplicationInteractions.InteractionSendState.Failed failed;
    private final boolean loading;

    public ActionComponentStoreState(boolean z2, StoreApplicationInteractions.InteractionSendState.Failed failed, boolean z3) {
        super(null);
        this.loading = z2;
        this.failed = failed;
        this.disabled = z3;
    }

    public static /* synthetic */ ActionComponentStoreState copy$default(ActionComponentStoreState actionComponentStoreState, boolean z2, StoreApplicationInteractions.InteractionSendState.Failed failed, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = actionComponentStoreState.loading;
        }
        if ((i & 2) != 0) {
            failed = actionComponentStoreState.failed;
        }
        if ((i & 4) != 0) {
            z3 = actionComponentStoreState.disabled;
        }
        return actionComponentStoreState.copy(z2, failed, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getLoading() {
        return this.loading;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreApplicationInteractions.InteractionSendState.Failed getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    public final ActionComponentStoreState copy(boolean loading, StoreApplicationInteractions.InteractionSendState.Failed failed, boolean disabled) {
        return new ActionComponentStoreState(loading, failed, disabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionComponentStoreState)) {
            return false;
        }
        ActionComponentStoreState actionComponentStoreState = (ActionComponentStoreState) other;
        return this.loading == actionComponentStoreState.loading && Intrinsics3.areEqual(this.failed, actionComponentStoreState.failed) && this.disabled == actionComponentStoreState.disabled;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final StoreApplicationInteractions.InteractionSendState.Failed getFailed() {
        return this.failed;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.loading;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        StoreApplicationInteractions.InteractionSendState.Failed failed = this.failed;
        int iHashCode = (i + (failed != null ? failed.hashCode() : 0)) * 31;
        boolean z3 = this.disabled;
        return iHashCode + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ActionComponentStoreState(loading=");
        sbU.append(this.loading);
        sbU.append(", failed=");
        sbU.append(this.failed);
        sbU.append(", disabled=");
        return outline.O(sbU, this.disabled, ")");
    }
}
