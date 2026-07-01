package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackOverlayClientMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayClientMetadata {
    private final Long overlayGameId = null;
    private final CharSequence overlayGameName = null;
    private final Long overlayAppId = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayClientMetadata)) {
            return false;
        }
        TrackOverlayClientMetadata trackOverlayClientMetadata = (TrackOverlayClientMetadata) other;
        return Intrinsics3.areEqual(this.overlayGameId, trackOverlayClientMetadata.overlayGameId) && Intrinsics3.areEqual(this.overlayGameName, trackOverlayClientMetadata.overlayGameName) && Intrinsics3.areEqual(this.overlayAppId, trackOverlayClientMetadata.overlayAppId);
    }

    public int hashCode() {
        Long l = this.overlayGameId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.overlayGameName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.overlayAppId;
        return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackOverlayClientMetadata(overlayGameId=");
        sbU.append(this.overlayGameId);
        sbU.append(", overlayGameName=");
        sbU.append(this.overlayGameName);
        sbU.append(", overlayAppId=");
        return outline.G(sbU, this.overlayAppId, ")");
    }
}
