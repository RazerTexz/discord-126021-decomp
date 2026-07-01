package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDispatchStats.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDispatchStats {
    private final CharSequence stage = null;
    private final Long progressPercent = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDispatchStats)) {
            return false;
        }
        TrackDispatchStats trackDispatchStats = (TrackDispatchStats) other;
        return Intrinsics3.areEqual(this.stage, trackDispatchStats.stage) && Intrinsics3.areEqual(this.progressPercent, trackDispatchStats.progressPercent);
    }

    public int hashCode() {
        CharSequence charSequence = this.stage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.progressPercent;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDispatchStats(stage=");
        sbU.append(this.stage);
        sbU.append(", progressPercent=");
        return outline.G(sbU, this.progressPercent, ")");
    }
}
