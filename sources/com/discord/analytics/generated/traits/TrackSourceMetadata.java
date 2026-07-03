package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSourceMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSourceMetadata {
    private final CharSequence sourceObject;
    private final CharSequence sourceObjectType;
    private final CharSequence sourcePage;
    private final Long sourcePromotionId;
    private final CharSequence sourceSection;

    public TrackSourceMetadata() {
        this(null, null, null, null, null, 31);
    }

    public TrackSourceMetadata(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Long l, int i) {
        int i2 = i & 2;
        int i3 = i & 4;
        int i4 = i & 8;
        int i5 = i & 16;
        this.sourcePage = (i & 1) != 0 ? null : charSequence;
        this.sourceSection = null;
        this.sourceObject = null;
        this.sourceObjectType = null;
        this.sourcePromotionId = null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSourceMetadata)) {
            return false;
        }
        TrackSourceMetadata trackSourceMetadata = (TrackSourceMetadata) other;
        return C12238m.areEqual(this.sourcePage, trackSourceMetadata.sourcePage) && C12238m.areEqual(this.sourceSection, trackSourceMetadata.sourceSection) && C12238m.areEqual(this.sourceObject, trackSourceMetadata.sourceObject) && C12238m.areEqual(this.sourceObjectType, trackSourceMetadata.sourceObjectType) && C12238m.areEqual(this.sourcePromotionId, trackSourceMetadata.sourcePromotionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.sourcePage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.sourceSection;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.sourceObject;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.sourceObjectType;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.sourcePromotionId;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSourceMetadata(sourcePage=");
        sbM833U.append(this.sourcePage);
        sbM833U.append(", sourceSection=");
        sbM833U.append(this.sourceSection);
        sbM833U.append(", sourceObject=");
        sbM833U.append(this.sourceObject);
        sbM833U.append(", sourceObjectType=");
        sbM833U.append(this.sourceObjectType);
        sbM833U.append(", sourcePromotionId=");
        return C1643a.m819G(sbM833U, this.sourcePromotionId, ")");
    }
}
