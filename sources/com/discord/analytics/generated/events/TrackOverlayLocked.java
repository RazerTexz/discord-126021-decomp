package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackOverlayLocked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayLocked implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Long unlockedDuration = null;
    private final transient String analyticsSchemaTypeName = "overlay_locked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackOverlayLocked) && Intrinsics3.areEqual(this.unlockedDuration, ((TrackOverlayLocked) other).unlockedDuration);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.unlockedDuration;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackOverlayLocked(unlockedDuration="), this.unlockedDuration, ")");
    }
}
