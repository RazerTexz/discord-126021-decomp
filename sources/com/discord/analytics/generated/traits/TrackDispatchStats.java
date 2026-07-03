package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.stage, trackDispatchStats.stage) && C12238m.areEqual(this.progressPercent, trackDispatchStats.progressPercent);
    }

    public int hashCode() {
        CharSequence charSequence = this.stage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.progressPercent;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDispatchStats(stage=");
        sbM833U.append(this.stage);
        sbM833U.append(", progressPercent=");
        return C1643a.m819G(sbM833U, this.progressPercent, ")");
    }
}
