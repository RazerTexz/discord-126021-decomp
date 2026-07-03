package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAfCard.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfCard {
    private final CharSequence loadId = null;
    private final Long cardIndex = null;
    private final CharSequence cardType = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfCard)) {
            return false;
        }
        TrackAfCard trackAfCard = (TrackAfCard) other;
        return C12238m.areEqual(this.loadId, trackAfCard.loadId) && C12238m.areEqual(this.cardIndex, trackAfCard.cardIndex) && C12238m.areEqual(this.cardType, trackAfCard.cardType);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.cardIndex;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.cardType;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackAfCard(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", cardIndex=");
        sbM833U.append(this.cardIndex);
        sbM833U.append(", cardType=");
        return C1643a.m817E(sbM833U, this.cardType, ")");
    }
}
