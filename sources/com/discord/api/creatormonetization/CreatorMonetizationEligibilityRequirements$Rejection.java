package com.discord.api.creatormonetization;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Date;

/* JADX INFO: compiled from: CreatorMonetizationEligibilityRequirements.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CreatorMonetizationEligibilityRequirements$Rejection {
    private final Date canReapplyAt;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Date getCanReapplyAt() {
        return this.canReapplyAt;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CreatorMonetizationEligibilityRequirements$Rejection) && m.areEqual(this.canReapplyAt, ((CreatorMonetizationEligibilityRequirements$Rejection) other).canReapplyAt);
        }
        return true;
    }

    public int hashCode() {
        Date date = this.canReapplyAt;
        if (date != null) {
            return date.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Rejection(canReapplyAt=");
        sbU.append(this.canReapplyAt);
        sbU.append(")");
        return sbU.toString();
    }
}
