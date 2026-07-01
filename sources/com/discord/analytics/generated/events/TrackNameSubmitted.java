package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.numWords, trackNameSubmitted.numWords) && m.areEqual(this.numChars, trackNameSubmitted.numChars);
    }

    public int hashCode() {
        Long l = this.numWords;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numChars;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNameSubmitted(numWords=");
        sbU.append(this.numWords);
        sbU.append(", numChars=");
        return a.G(sbU, this.numChars, ")");
    }
}
