package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDevPortalRpVizUsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDevPortalRpVizUsed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence applicationName = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final CharSequence currentView = null;
    private final CharSequence prevView = null;
    private final Boolean codeCopied = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_rp_viz_used";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDevPortalRpVizUsed)) {
            return false;
        }
        TrackDevPortalRpVizUsed trackDevPortalRpVizUsed = (TrackDevPortalRpVizUsed) other;
        return C12238m.areEqual(this.applicationId, trackDevPortalRpVizUsed.applicationId) && C12238m.areEqual(this.botId, trackDevPortalRpVizUsed.botId) && C12238m.areEqual(this.applicationName, trackDevPortalRpVizUsed.applicationName) && C12238m.areEqual(this.hasBot, trackDevPortalRpVizUsed.hasBot) && C12238m.areEqual(this.hasRedirectUri, trackDevPortalRpVizUsed.hasRedirectUri) && C12238m.areEqual(this.currentView, trackDevPortalRpVizUsed.currentView) && C12238m.areEqual(this.prevView, trackDevPortalRpVizUsed.prevView) && C12238m.areEqual(this.codeCopied, trackDevPortalRpVizUsed.codeCopied);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.botId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.applicationName;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasBot;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasRedirectUri;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.currentView;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.prevView;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool3 = this.codeCopied;
        return iHashCode7 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDevPortalRpVizUsed(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", applicationName=");
        sbM833U.append(this.applicationName);
        sbM833U.append(", hasBot=");
        sbM833U.append(this.hasBot);
        sbM833U.append(", hasRedirectUri=");
        sbM833U.append(this.hasRedirectUri);
        sbM833U.append(", currentView=");
        sbM833U.append(this.currentView);
        sbM833U.append(", prevView=");
        sbM833U.append(this.prevView);
        sbM833U.append(", codeCopied=");
        return C1643a.m816D(sbM833U, this.codeCopied, ")");
    }
}
