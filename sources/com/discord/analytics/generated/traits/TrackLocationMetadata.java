package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.locationPage, trackLocationMetadata.locationPage) && C12238m.areEqual(this.locationSection, trackLocationMetadata.locationSection) && C12238m.areEqual(this.locationObject, trackLocationMetadata.locationObject) && C12238m.areEqual(this.locationObjectType, trackLocationMetadata.locationObjectType) && C12238m.areEqual(this.locationPromotionId, trackLocationMetadata.locationPromotionId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackLocationMetadata(locationPage=");
        sbM833U.append(this.locationPage);
        sbM833U.append(", locationSection=");
        sbM833U.append(this.locationSection);
        sbM833U.append(", locationObject=");
        sbM833U.append(this.locationObject);
        sbM833U.append(", locationObjectType=");
        sbM833U.append(this.locationObjectType);
        sbM833U.append(", locationPromotionId=");
        return C1643a.m819G(sbM833U, this.locationPromotionId, ")");
    }
}
