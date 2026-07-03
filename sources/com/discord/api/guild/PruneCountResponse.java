package com.discord.api.guild;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: compiled from: PruneCountResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PruneCountResponse {
    private final int pruned;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getPruned() {
        return this.pruned;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PruneCountResponse) && this.pruned == ((PruneCountResponse) other).pruned;
        }
        return true;
    }

    public int hashCode() {
        return this.pruned;
    }

    public String toString() {
        return C1643a.m814B(C1643a.m833U("PruneCountResponse(pruned="), this.pruned, ")");
    }
}
