package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlay;
import com.discord.analytics.generated.traits.TrackOverlay2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackOverlayHookResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayHookResult implements AnalyticsSchema, TrackBase2, TrackOverlay2 {
    private TrackBase trackBase;
    private TrackOverlay trackOverlay;
    private final Boolean success = null;
    private final transient String analyticsSchemaTypeName = "overlay_hook_result";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackOverlayHookResult) && Intrinsics3.areEqual(this.success, ((TrackOverlayHookResult) other).success);
        }
        return true;
    }

    public int hashCode() {
        Boolean bool = this.success;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.D(outline.U("TrackOverlayHookResult(success="), this.success, ")");
    }
}
