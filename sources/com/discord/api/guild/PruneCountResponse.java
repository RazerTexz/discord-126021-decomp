package com.discord.api.guild;

import b.d.b.a.outline;

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
        return outline.B(outline.U("PruneCountResponse(pruned="), this.pruned, ")");
    }
}
