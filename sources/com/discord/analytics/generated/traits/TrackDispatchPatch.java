package com.discord.analytics.generated.traits;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDispatchPatch.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDispatchPatch {
    private final Long targetBuildId = null;
    private final List<Long> targetManifestIds = null;
    private final CharSequence patchType = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDispatchPatch)) {
            return false;
        }
        TrackDispatchPatch trackDispatchPatch = (TrackDispatchPatch) other;
        return C12238m.areEqual(this.targetBuildId, trackDispatchPatch.targetBuildId) && C12238m.areEqual(this.targetManifestIds, trackDispatchPatch.targetManifestIds) && C12238m.areEqual(this.patchType, trackDispatchPatch.patchType);
    }

    public int hashCode() {
        Long l = this.targetBuildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.targetManifestIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence = this.patchType;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDispatchPatch(targetBuildId=");
        sbM833U.append(this.targetBuildId);
        sbM833U.append(", targetManifestIds=");
        sbM833U.append(this.targetManifestIds);
        sbM833U.append(", patchType=");
        return C1643a.m817E(sbM833U, this.patchType, ")");
    }
}
