package com.discord.api.interaction;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InteractionStateUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InteractionStateUpdate {
    private final Long id;
    private final String nonce;

    public InteractionStateUpdate(Long l, String str) {
        C12238m.checkNotNullParameter(str, "nonce");
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
        return C12238m.areEqual(this.id, interactionStateUpdate.id) && C12238m.areEqual(this.nonce, interactionStateUpdate.nonce);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.nonce;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("InteractionStateUpdate(id=");
        sbM833U.append(this.id);
        sbM833U.append(", nonce=");
        return C1643a.m822J(sbM833U, this.nonce, ")");
    }
}
