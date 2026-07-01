package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackLfgBrowserViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLfgBrowserViewed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long gameId = null;
    private final CharSequence gameName = null;
    private final Boolean isRefresh = null;
    private final Long numGroups = null;
    private final transient String analyticsSchemaTypeName = "lfg_browser_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgBrowserViewed)) {
            return false;
        }
        TrackLfgBrowserViewed trackLfgBrowserViewed = (TrackLfgBrowserViewed) other;
        return m.areEqual(this.gameId, trackLfgBrowserViewed.gameId) && m.areEqual(this.gameName, trackLfgBrowserViewed.gameName) && m.areEqual(this.isRefresh, trackLfgBrowserViewed.isRefresh) && m.areEqual(this.numGroups, trackLfgBrowserViewed.numGroups);
    }

    public int hashCode() {
        Long l = this.gameId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.gameName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.isRefresh;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.numGroups;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackLfgBrowserViewed(gameId=");
        sbU.append(this.gameId);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", isRefresh=");
        sbU.append(this.isRefresh);
        sbU.append(", numGroups=");
        return a.G(sbU, this.numGroups, ")");
    }
}
