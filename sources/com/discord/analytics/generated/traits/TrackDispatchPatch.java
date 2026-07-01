package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

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
        return m.areEqual(this.targetBuildId, trackDispatchPatch.targetBuildId) && m.areEqual(this.targetManifestIds, trackDispatchPatch.targetManifestIds) && m.areEqual(this.patchType, trackDispatchPatch.patchType);
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
        StringBuilder sbU = a.U("TrackDispatchPatch(targetBuildId=");
        sbU.append(this.targetBuildId);
        sbU.append(", targetManifestIds=");
        sbU.append(this.targetManifestIds);
        sbU.append(", patchType=");
        return a.E(sbU, this.patchType, ")");
    }
}
