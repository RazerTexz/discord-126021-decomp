package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackMktgPageViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMktgPageViewed implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence pageName = null;
    private final CharSequence previousPageName = null;
    private final CharSequence previousLinkLocation = null;
    private final CharSequence queryReferrer = null;
    private final Boolean hasSession = null;
    private final CharSequence staticExperimentUuid = null;
    private final transient String analyticsSchemaTypeName = "mktg_page_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMktgPageViewed)) {
            return false;
        }
        TrackMktgPageViewed trackMktgPageViewed = (TrackMktgPageViewed) other;
        return m.areEqual(this.pageName, trackMktgPageViewed.pageName) && m.areEqual(this.previousPageName, trackMktgPageViewed.previousPageName) && m.areEqual(this.previousLinkLocation, trackMktgPageViewed.previousLinkLocation) && m.areEqual(this.queryReferrer, trackMktgPageViewed.queryReferrer) && m.areEqual(this.hasSession, trackMktgPageViewed.hasSession) && m.areEqual(this.staticExperimentUuid, trackMktgPageViewed.staticExperimentUuid);
    }

    public int hashCode() {
        CharSequence charSequence = this.pageName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.previousPageName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.previousLinkLocation;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.queryReferrer;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.hasSession;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.staticExperimentUuid;
        return iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackMktgPageViewed(pageName=");
        sbU.append(this.pageName);
        sbU.append(", previousPageName=");
        sbU.append(this.previousPageName);
        sbU.append(", previousLinkLocation=");
        sbU.append(this.previousLinkLocation);
        sbU.append(", queryReferrer=");
        sbU.append(this.queryReferrer);
        sbU.append(", hasSession=");
        sbU.append(this.hasSession);
        sbU.append(", staticExperimentUuid=");
        return a.E(sbU, this.staticExperimentUuid, ")");
    }
}
