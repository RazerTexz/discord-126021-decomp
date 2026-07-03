package com.discord.api.creatormonetization;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CreatorMonetizationEnableRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CreatorMonetizationEnableRequest {
    private final long id;
    private final State state;

    /* JADX INFO: compiled from: CreatorMonetizationEnableRequest.kt */
    public enum State {
        OPEN,
        REJECTED,
        APPROVED
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final State getState() {
        return this.state;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreatorMonetizationEnableRequest)) {
            return false;
        }
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest = (CreatorMonetizationEnableRequest) other;
        return this.id == creatorMonetizationEnableRequest.id && C12238m.areEqual(this.state, creatorMonetizationEnableRequest.state);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        State state = this.state;
        return i + (state != null ? state.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CreatorMonetizationEnableRequest(id=");
        sbM833U.append(this.id);
        sbM833U.append(", state=");
        sbM833U.append(this.state);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
