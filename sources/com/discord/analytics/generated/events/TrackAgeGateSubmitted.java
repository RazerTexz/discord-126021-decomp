package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAgeGateSubmitted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAgeGateSubmitted implements AnalyticsSchema, TrackBaseReceiver, TrackSourceMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long dob;
    private final Long dobDay;
    private final Long dobMonth;
    private final Long dobYear;
    private TrackBase trackBase;
    private TrackSourceMetadata trackSourceMetadata;

    public TrackAgeGateSubmitted() {
        this.dob = null;
        this.dobDay = null;
        this.dobMonth = null;
        this.dobYear = null;
        this.analyticsSchemaTypeName = "age_gate_submitted";
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    /* JADX INFO: renamed from: e */
    public void m7509e(TrackSourceMetadata trackSourceMetadata) {
        this.trackSourceMetadata = trackSourceMetadata;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAgeGateSubmitted)) {
            return false;
        }
        TrackAgeGateSubmitted trackAgeGateSubmitted = (TrackAgeGateSubmitted) other;
        return C12238m.areEqual(this.dob, trackAgeGateSubmitted.dob) && C12238m.areEqual(this.dobDay, trackAgeGateSubmitted.dobDay) && C12238m.areEqual(this.dobMonth, trackAgeGateSubmitted.dobMonth) && C12238m.areEqual(this.dobYear, trackAgeGateSubmitted.dobYear);
    }

    public int hashCode() {
        Long l = this.dob;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.dobDay;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.dobMonth;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.dobYear;
        return iHashCode3 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackAgeGateSubmitted(dob=");
        sbM833U.append(this.dob);
        sbM833U.append(", dobDay=");
        sbM833U.append(this.dobDay);
        sbM833U.append(", dobMonth=");
        sbM833U.append(this.dobMonth);
        sbM833U.append(", dobYear=");
        return C1643a.m819G(sbM833U, this.dobYear, ")");
    }

    public TrackAgeGateSubmitted(Long l, Long l2, Long l3, Long l4) {
        this.dob = l;
        this.dobDay = l2;
        this.dobMonth = l3;
        this.dobYear = l4;
        this.analyticsSchemaTypeName = "age_gate_submitted";
    }
}
