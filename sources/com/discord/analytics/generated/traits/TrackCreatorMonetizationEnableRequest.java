package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackCreatorMonetizationEnableRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCreatorMonetizationEnableRequest {
    private final Long creatorMonetizationEnableRequestId = null;
    private final CharSequence state = null;
    private final CharSequence actionedReason = null;
    private final CharSequence actionedNote = null;
    private final Long actionedAt = null;
    private final Long termsAckedAt = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreatorMonetizationEnableRequest)) {
            return false;
        }
        TrackCreatorMonetizationEnableRequest trackCreatorMonetizationEnableRequest = (TrackCreatorMonetizationEnableRequest) other;
        return m.areEqual(this.creatorMonetizationEnableRequestId, trackCreatorMonetizationEnableRequest.creatorMonetizationEnableRequestId) && m.areEqual(this.state, trackCreatorMonetizationEnableRequest.state) && m.areEqual(this.actionedReason, trackCreatorMonetizationEnableRequest.actionedReason) && m.areEqual(this.actionedNote, trackCreatorMonetizationEnableRequest.actionedNote) && m.areEqual(this.actionedAt, trackCreatorMonetizationEnableRequest.actionedAt) && m.areEqual(this.termsAckedAt, trackCreatorMonetizationEnableRequest.termsAckedAt);
    }

    public int hashCode() {
        Long l = this.creatorMonetizationEnableRequestId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.state;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.actionedReason;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.actionedNote;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.actionedAt;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.termsAckedAt;
        return iHashCode5 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackCreatorMonetizationEnableRequest(creatorMonetizationEnableRequestId=");
        sbU.append(this.creatorMonetizationEnableRequestId);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(", actionedReason=");
        sbU.append(this.actionedReason);
        sbU.append(", actionedNote=");
        sbU.append(this.actionedNote);
        sbU.append(", actionedAt=");
        sbU.append(this.actionedAt);
        sbU.append(", termsAckedAt=");
        return a.G(sbU, this.termsAckedAt, ")");
    }
}
