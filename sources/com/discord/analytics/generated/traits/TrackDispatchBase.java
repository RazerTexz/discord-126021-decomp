package com.discord.analytics.generated.traits;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDispatchBase.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDispatchBase {
    private final Long applicationId = null;
    private final Long branchId = null;
    private final Long buildId = null;
    private final List<Long> manifestIds = null;
    private final CharSequence nonce = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDispatchBase)) {
            return false;
        }
        TrackDispatchBase trackDispatchBase = (TrackDispatchBase) other;
        return C12238m.areEqual(this.applicationId, trackDispatchBase.applicationId) && C12238m.areEqual(this.branchId, trackDispatchBase.branchId) && C12238m.areEqual(this.buildId, trackDispatchBase.buildId) && C12238m.areEqual(this.manifestIds, trackDispatchBase.manifestIds) && C12238m.areEqual(this.nonce, trackDispatchBase.nonce);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.branchId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.buildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.manifestIds;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence = this.nonce;
        return iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDispatchBase(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", branchId=");
        sbM833U.append(this.branchId);
        sbM833U.append(", buildId=");
        sbM833U.append(this.buildId);
        sbM833U.append(", manifestIds=");
        sbM833U.append(this.manifestIds);
        sbM833U.append(", nonce=");
        return C1643a.m817E(sbM833U, this.nonce, ")");
    }
}
