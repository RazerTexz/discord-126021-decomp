package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackLocationMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLocationMetadata {
    private final CharSequence locationPage = null;
    private final CharSequence locationSection = null;
    private final CharSequence locationObject = null;
    private final CharSequence locationObjectType = null;
    private final Long locationPromotionId = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLocationMetadata)) {
            return false;
        }
        TrackLocationMetadata trackLocationMetadata = (TrackLocationMetadata) other;
        return m.areEqual(this.locationPage, trackLocationMetadata.locationPage) && m.areEqual(this.locationSection, trackLocationMetadata.locationSection) && m.areEqual(this.locationObject, trackLocationMetadata.locationObject) && m.areEqual(this.locationObjectType, trackLocationMetadata.locationObjectType) && m.areEqual(this.locationPromotionId, trackLocationMetadata.locationPromotionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.locationPage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.locationSection;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.locationObject;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.locationObjectType;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.locationPromotionId;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackLocationMetadata(locationPage=");
        sbU.append(this.locationPage);
        sbU.append(", locationSection=");
        sbU.append(this.locationSection);
        sbU.append(", locationObject=");
        sbU.append(this.locationObject);
        sbU.append(", locationObjectType=");
        sbU.append(this.locationObjectType);
        sbU.append(", locationPromotionId=");
        return a.G(sbU, this.locationPromotionId, ")");
    }
}
