package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

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
        return Intrinsics3.areEqual(this.applicationId, trackDispatchBase.applicationId) && Intrinsics3.areEqual(this.branchId, trackDispatchBase.branchId) && Intrinsics3.areEqual(this.buildId, trackDispatchBase.buildId) && Intrinsics3.areEqual(this.manifestIds, trackDispatchBase.manifestIds) && Intrinsics3.areEqual(this.nonce, trackDispatchBase.nonce);
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
        StringBuilder sbU = outline.U("TrackDispatchBase(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", branchId=");
        sbU.append(this.branchId);
        sbU.append(", buildId=");
        sbU.append(this.buildId);
        sbU.append(", manifestIds=");
        sbU.append(this.manifestIds);
        sbU.append(", nonce=");
        return outline.E(sbU, this.nonce, ")");
    }
}
