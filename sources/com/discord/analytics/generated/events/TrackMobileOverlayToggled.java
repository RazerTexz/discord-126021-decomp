package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackMobileOverlayToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMobileOverlayToggled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean enabled = null;
    private final transient String analyticsSchemaTypeName = "mobile_overlay_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackMobileOverlayToggled) && Intrinsics3.areEqual(this.enabled, ((TrackMobileOverlayToggled) other).enabled);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.D(outline.U("TrackMobileOverlayToggled(enabled="), this.enabled, ")");
    }
}
