package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackOverlayLocked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayLocked implements AnalyticsSchema, TrackBaseReceiver, TrackOverlayClientMetadataReceiver {
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
            return (other instanceof TrackOverlayLocked) && C12238m.areEqual(this.unlockedDuration, ((TrackOverlayLocked) other).unlockedDuration);
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
        return C1643a.m819G(C1643a.m833U("TrackOverlayLocked(unlockedDuration="), this.unlockedDuration, ")");
    }
}
