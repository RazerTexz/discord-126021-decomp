package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackEmail.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEmail {
    private final CharSequence emailType = null;
    private final CharSequence subjectType = null;
    private final CharSequence emailId = null;
    private final CharSequence category = null;
    private final CharSequence version = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEmail)) {
            return false;
        }
        TrackEmail trackEmail = (TrackEmail) other;
        return Intrinsics3.areEqual(this.emailType, trackEmail.emailType) && Intrinsics3.areEqual(this.subjectType, trackEmail.subjectType) && Intrinsics3.areEqual(this.emailId, trackEmail.emailId) && Intrinsics3.areEqual(this.category, trackEmail.category) && Intrinsics3.areEqual(this.version, trackEmail.version);
    }

    public int hashCode() {
        CharSequence charSequence = this.emailType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.subjectType;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.emailId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.category;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.version;
        return iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackEmail(emailType=");
        sbU.append(this.emailType);
        sbU.append(", subjectType=");
        sbU.append(this.subjectType);
        sbU.append(", emailId=");
        sbU.append(this.emailId);
        sbU.append(", category=");
        sbU.append(this.category);
        sbU.append(", version=");
        return outline.E(sbU, this.version, ")");
    }
}
