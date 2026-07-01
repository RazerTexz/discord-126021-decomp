package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAuthorizedAppConnected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAuthorizedAppConnected implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long appId = null;
    private final CharSequence transport = null;
    private final transient String analyticsSchemaTypeName = "authorized_app_connected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAuthorizedAppConnected)) {
            return false;
        }
        TrackAuthorizedAppConnected trackAuthorizedAppConnected = (TrackAuthorizedAppConnected) other;
        return Intrinsics3.areEqual(this.appId, trackAuthorizedAppConnected.appId) && Intrinsics3.areEqual(this.transport, trackAuthorizedAppConnected.transport);
    }

    public int hashCode() {
        Long l = this.appId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.transport;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAuthorizedAppConnected(appId=");
        sbU.append(this.appId);
        sbU.append(", transport=");
        return outline.E(sbU, this.transport, ")");
    }
}
