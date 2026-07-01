package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDevPortalCsatSurveyResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDevPortalCsatSurveyResponse implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence ctaName = null;
    private final Long csatResponse = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_csat_survey_response";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDevPortalCsatSurveyResponse)) {
            return false;
        }
        TrackDevPortalCsatSurveyResponse trackDevPortalCsatSurveyResponse = (TrackDevPortalCsatSurveyResponse) other;
        return Intrinsics3.areEqual(this.ctaName, trackDevPortalCsatSurveyResponse.ctaName) && Intrinsics3.areEqual(this.csatResponse, trackDevPortalCsatSurveyResponse.csatResponse);
    }

    public int hashCode() {
        CharSequence charSequence = this.ctaName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.csatResponse;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDevPortalCsatSurveyResponse(ctaName=");
        sbU.append(this.ctaName);
        sbU.append(", csatResponse=");
        return outline.G(sbU, this.csatResponse, ")");
    }
}
