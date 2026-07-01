package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackMktgApplicationStep.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMktgApplicationStep implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence applicationType = null;
    private final CharSequence pageName = null;
    private final CharSequence step = null;
    private final transient String analyticsSchemaTypeName = "mktg_application_step";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMktgApplicationStep)) {
            return false;
        }
        TrackMktgApplicationStep trackMktgApplicationStep = (TrackMktgApplicationStep) other;
        return m.areEqual(this.applicationType, trackMktgApplicationStep.applicationType) && m.areEqual(this.pageName, trackMktgApplicationStep.pageName) && m.areEqual(this.step, trackMktgApplicationStep.step);
    }

    public int hashCode() {
        CharSequence charSequence = this.applicationType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.pageName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.step;
        return iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackMktgApplicationStep(applicationType=");
        sbU.append(this.applicationType);
        sbU.append(", pageName=");
        sbU.append(this.pageName);
        sbU.append(", step=");
        return a.E(sbU, this.step, ")");
    }
}
