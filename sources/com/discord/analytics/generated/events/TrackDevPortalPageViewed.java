package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDevPortalPageViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDevPortalPageViewed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence pageName = null;
    private final CharSequence previousPageName = null;
    private final CharSequence previousLinkLocation = null;
    private final Boolean hasSession = null;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence applicationName = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_page_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDevPortalPageViewed)) {
            return false;
        }
        TrackDevPortalPageViewed trackDevPortalPageViewed = (TrackDevPortalPageViewed) other;
        return C12238m.areEqual(this.pageName, trackDevPortalPageViewed.pageName) && C12238m.areEqual(this.previousPageName, trackDevPortalPageViewed.previousPageName) && C12238m.areEqual(this.previousLinkLocation, trackDevPortalPageViewed.previousLinkLocation) && C12238m.areEqual(this.hasSession, trackDevPortalPageViewed.hasSession) && C12238m.areEqual(this.applicationId, trackDevPortalPageViewed.applicationId) && C12238m.areEqual(this.botId, trackDevPortalPageViewed.botId) && C12238m.areEqual(this.applicationName, trackDevPortalPageViewed.applicationName) && C12238m.areEqual(this.hasBot, trackDevPortalPageViewed.hasBot) && C12238m.areEqual(this.hasRedirectUri, trackDevPortalPageViewed.hasRedirectUri) && C12238m.areEqual(this.guildId, trackDevPortalPageViewed.guildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.pageName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.previousPageName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.previousLinkLocation;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.hasSession;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.applicationId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.botId;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.applicationName;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasBot;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.hasRedirectUri;
        int iHashCode9 = (iHashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        return iHashCode9 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDevPortalPageViewed(pageName=");
        sbM833U.append(this.pageName);
        sbM833U.append(", previousPageName=");
        sbM833U.append(this.previousPageName);
        sbM833U.append(", previousLinkLocation=");
        sbM833U.append(this.previousLinkLocation);
        sbM833U.append(", hasSession=");
        sbM833U.append(this.hasSession);
        sbM833U.append(", applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", hasBot=");
        sbM833U.append(this.hasBot);
        sbM833U.append(", hasRedirectUri=");
        sbM833U.append(this.hasRedirectUri);
        sbM833U.append(", guildId=");
        return C1643a.m819G(sbM833U, this.guildId, ")");
    }
}
