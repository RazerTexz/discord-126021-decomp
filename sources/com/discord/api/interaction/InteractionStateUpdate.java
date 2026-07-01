package com.discord.api.interaction;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: InteractionStateUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InteractionStateUpdate {
    private final Long id;
    private final String nonce;

    public InteractionStateUpdate(Long l, String str) {
        Intrinsics3.checkNotNullParameter(str, "nonce");
        this.id = l;
        this.nonce = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionStateUpdate)) {
            return false;
        }
        InteractionStateUpdate interactionStateUpdate = (InteractionStateUpdate) other;
        return Intrinsics3.areEqual(this.id, interactionStateUpdate.id) && Intrinsics3.areEqual(this.nonce, interactionStateUpdate.nonce);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.nonce;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InteractionStateUpdate(id=");
        sbU.append(this.id);
        sbU.append(", nonce=");
        return outline.J(sbU, this.nonce, ")");
    }
}
