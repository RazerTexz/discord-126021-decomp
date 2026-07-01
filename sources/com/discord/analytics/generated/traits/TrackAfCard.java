package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import d0.z.d.m;

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
        return m.areEqual(this.loadId, trackAfCard.loadId) && m.areEqual(this.cardIndex, trackAfCard.cardIndex) && m.areEqual(this.cardType, trackAfCard.cardType);
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
        StringBuilder sbU = a.U("TrackAfCard(loadId=");
        sbU.append(this.loadId);
        sbU.append(", cardIndex=");
        sbU.append(this.cardIndex);
        sbU.append(", cardType=");
        return a.E(sbU, this.cardType, ")");
    }
}
