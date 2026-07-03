package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlay;
import com.discord.analytics.generated.traits.TrackOverlayReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackOverlayHookResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayHookResult implements AnalyticsSchema, TrackBaseReceiver, TrackOverlayReceiver {
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
            return (other instanceof TrackOverlayHookResult) && C12238m.areEqual(this.success, ((TrackOverlayHookResult) other).success);
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
        return C1643a.m816D(C1643a.m833U("TrackOverlayHookResult(success="), this.success, ")");
    }
}
