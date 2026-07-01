package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackDevPortalRpVizUsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDevPortalRpVizUsed implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.applicationId, trackDevPortalRpVizUsed.applicationId) && Intrinsics3.areEqual(this.botId, trackDevPortalRpVizUsed.botId) && Intrinsics3.areEqual(this.applicationName, trackDevPortalRpVizUsed.applicationName) && Intrinsics3.areEqual(this.hasBot, trackDevPortalRpVizUsed.hasBot) && Intrinsics3.areEqual(this.hasRedirectUri, trackDevPortalRpVizUsed.hasRedirectUri) && Intrinsics3.areEqual(this.currentView, trackDevPortalRpVizUsed.currentView) && Intrinsics3.areEqual(this.prevView, trackDevPortalRpVizUsed.prevView) && Intrinsics3.areEqual(this.codeCopied, trackDevPortalRpVizUsed.codeCopied);
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
        StringBuilder sbU = outline.U("TrackDevPortalRpVizUsed(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", botId=");
        sbU.append(this.botId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", hasBot=");
        sbU.append(this.hasBot);
        sbU.append(", hasRedirectUri=");
        sbU.append(this.hasRedirectUri);
        sbU.append(", currentView=");
        sbU.append(this.currentView);
        sbU.append(", prevView=");
        sbU.append(this.prevView);
        sbU.append(", codeCopied=");
        return outline.D(sbU, this.codeCopied, ")");
    }
}
