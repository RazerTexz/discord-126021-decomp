package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGameJoined.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGameJoined implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence source = null;
    private final Long applicationId = null;
    private final CharSequence partyId = null;
    private final transient String analyticsSchemaTypeName = "game_joined";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGameJoined)) {
            return false;
        }
        TrackGameJoined trackGameJoined = (TrackGameJoined) other;
        return C12238m.areEqual(this.source, trackGameJoined.source) && C12238m.areEqual(this.applicationId, trackGameJoined.applicationId) && C12238m.areEqual(this.partyId, trackGameJoined.partyId);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.applicationId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.partyId;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGameJoined(source=");
        sbM833U.append(this.source);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", partyId=");
        return C1643a.m817E(sbM833U, this.partyId, ")");
    }
}
