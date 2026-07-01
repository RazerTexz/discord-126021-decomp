package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAppCrashed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppCrashed implements AnalyticsSchema, TrackBaseReceiver, TrackOverlayClientMetadataReceiver {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final CharSequence path = null;
    private final CharSequence extra = null;
    private final transient String analyticsSchemaTypeName = "app_crashed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppCrashed)) {
            return false;
        }
        TrackAppCrashed trackAppCrashed = (TrackAppCrashed) other;
        return m.areEqual(this.path, trackAppCrashed.path) && m.areEqual(this.extra, trackAppCrashed.extra);
    }

    public int hashCode() {
        CharSequence charSequence = this.path;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.extra;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackAppCrashed(path=");
        sbU.append(this.path);
        sbU.append(", extra=");
        return a.E(sbU, this.extra, ")");
    }
}
