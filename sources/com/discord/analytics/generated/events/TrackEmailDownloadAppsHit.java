package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackEmailDownloadAppsHit.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEmailDownloadAppsHit implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long trackingPixelUuid = null;
    private final CharSequence platform = null;
    private final transient String analyticsSchemaTypeName = "email_download_apps_hit";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEmailDownloadAppsHit)) {
            return false;
        }
        TrackEmailDownloadAppsHit trackEmailDownloadAppsHit = (TrackEmailDownloadAppsHit) other;
        return C12238m.areEqual(this.trackingPixelUuid, trackEmailDownloadAppsHit.trackingPixelUuid) && C12238m.areEqual(this.platform, trackEmailDownloadAppsHit.platform);
    }

    public int hashCode() {
        Long l = this.trackingPixelUuid;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.platform;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackEmailDownloadAppsHit(trackingPixelUuid=");
        sbM833U.append(this.trackingPixelUuid);
        sbM833U.append(", platform=");
        return C1643a.m817E(sbM833U, this.platform, ")");
    }
}
