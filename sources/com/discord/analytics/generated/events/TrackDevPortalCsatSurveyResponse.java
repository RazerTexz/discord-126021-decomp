package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackDevPortalCsatSurveyResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDevPortalCsatSurveyResponse implements AnalyticsSchema, TrackBaseReceiver {
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
        return m.areEqual(this.ctaName, trackDevPortalCsatSurveyResponse.ctaName) && m.areEqual(this.csatResponse, trackDevPortalCsatSurveyResponse.csatResponse);
    }

    public int hashCode() {
        CharSequence charSequence = this.ctaName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.csatResponse;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackDevPortalCsatSurveyResponse(ctaName=");
        sbU.append(this.ctaName);
        sbU.append(", csatResponse=");
        return a.G(sbU, this.csatResponse, ")");
    }
}
