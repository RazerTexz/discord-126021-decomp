package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.pageName, trackMktgPageViewed.pageName) && C12238m.areEqual(this.previousPageName, trackMktgPageViewed.previousPageName) && C12238m.areEqual(this.previousLinkLocation, trackMktgPageViewed.previousLinkLocation) && C12238m.areEqual(this.queryReferrer, trackMktgPageViewed.queryReferrer) && C12238m.areEqual(this.hasSession, trackMktgPageViewed.hasSession) && C12238m.areEqual(this.staticExperimentUuid, trackMktgPageViewed.staticExperimentUuid);
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
        StringBuilder sbM833U = C1643a.m833U("TrackMktgPageViewed(pageName=");
        sbM833U.append(this.pageName);
        sbM833U.append(", previousPageName=");
        sbM833U.append(this.previousPageName);
        sbM833U.append(", previousLinkLocation=");
        sbM833U.append(this.previousLinkLocation);
        sbM833U.append(", queryReferrer=");
        sbM833U.append(this.queryReferrer);
        sbM833U.append(", hasSession=");
        sbM833U.append(this.hasSession);
        sbM833U.append(", staticExperimentUuid=");
        return C1643a.m817E(sbM833U, this.staticExperimentUuid, ")");
    }
}
