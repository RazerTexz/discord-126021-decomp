package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNameSubmitted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNameSubmitted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long numWords = null;
    private final Long numChars = null;
    private final transient String analyticsSchemaTypeName = "name_submitted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNameSubmitted)) {
            return false;
        }
        TrackNameSubmitted trackNameSubmitted = (TrackNameSubmitted) other;
        return C12238m.areEqual(this.numWords, trackNameSubmitted.numWords) && C12238m.areEqual(this.numChars, trackNameSubmitted.numChars);
    }

    public int hashCode() {
        Long l = this.numWords;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numChars;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNameSubmitted(numWords=");
        sbM833U.append(this.numWords);
        sbM833U.append(", numChars=");
        return C1643a.m819G(sbM833U, this.numChars, ")");
    }
}
