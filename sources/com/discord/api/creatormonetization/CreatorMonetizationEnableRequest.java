package com.discord.api.creatormonetization;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: CreatorMonetizationEnableRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CreatorMonetizationEnableRequest {
    private final long id;
    private final CreatorMonetizationEnableRequest$State state;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final CreatorMonetizationEnableRequest$State getState() {
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
        return this.id == creatorMonetizationEnableRequest.id && m.areEqual(this.state, creatorMonetizationEnableRequest.state);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        CreatorMonetizationEnableRequest$State creatorMonetizationEnableRequest$State = this.state;
        return i + (creatorMonetizationEnableRequest$State != null ? creatorMonetizationEnableRequest$State.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CreatorMonetizationEnableRequest(id=");
        sbU.append(this.id);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(")");
        return sbU.toString();
    }
}
