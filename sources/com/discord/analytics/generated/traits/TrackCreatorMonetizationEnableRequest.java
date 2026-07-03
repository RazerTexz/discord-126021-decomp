package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.creatorMonetizationEnableRequestId, trackCreatorMonetizationEnableRequest.creatorMonetizationEnableRequestId) && C12238m.areEqual(this.state, trackCreatorMonetizationEnableRequest.state) && C12238m.areEqual(this.actionedReason, trackCreatorMonetizationEnableRequest.actionedReason) && C12238m.areEqual(this.actionedNote, trackCreatorMonetizationEnableRequest.actionedNote) && C12238m.areEqual(this.actionedAt, trackCreatorMonetizationEnableRequest.actionedAt) && C12238m.areEqual(this.termsAckedAt, trackCreatorMonetizationEnableRequest.termsAckedAt);
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
        StringBuilder sbM833U = C1643a.m833U("TrackCreatorMonetizationEnableRequest(creatorMonetizationEnableRequestId=");
        sbM833U.append(this.creatorMonetizationEnableRequestId);
        sbM833U.append(", state=");
        sbM833U.append(this.state);
        sbM833U.append(", actionedReason=");
        sbM833U.append(this.actionedReason);
        sbM833U.append(", actionedNote=");
        sbM833U.append(this.actionedNote);
        sbM833U.append(", actionedAt=");
        sbM833U.append(this.actionedAt);
        sbM833U.append(", termsAckedAt=");
        return C1643a.m819G(sbM833U, this.termsAckedAt, ")");
    }
}
