package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAuthorizedAppConnected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAuthorizedAppConnected implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.appId, trackAuthorizedAppConnected.appId) && C12238m.areEqual(this.transport, trackAuthorizedAppConnected.transport);
    }

    public int hashCode() {
        Long l = this.appId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.transport;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackAuthorizedAppConnected(appId=");
        sbM833U.append(this.appId);
        sbM833U.append(", transport=");
        return C1643a.m817E(sbM833U, this.transport, ")");
    }
}
