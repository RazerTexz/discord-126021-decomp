package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackStreamerModeToggle.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStreamerModeToggle implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean automatic = null;
    private final Boolean enabled = null;
    private final transient String analyticsSchemaTypeName = "streamer_mode_toggle";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStreamerModeToggle)) {
            return false;
        }
        TrackStreamerModeToggle trackStreamerModeToggle = (TrackStreamerModeToggle) other;
        return m.areEqual(this.automatic, trackStreamerModeToggle.automatic) && m.areEqual(this.enabled, trackStreamerModeToggle.enabled);
    }

    public int hashCode() {
        Boolean bool = this.automatic;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.enabled;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackStreamerModeToggle(automatic=");
        sbU.append(this.automatic);
        sbU.append(", enabled=");
        return a.D(sbU, this.enabled, ")");
    }
}
