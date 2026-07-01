package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackEnableNotifications.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEnableNotifications implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean enabled = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "enable_notifications";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEnableNotifications)) {
            return false;
        }
        TrackEnableNotifications trackEnableNotifications = (TrackEnableNotifications) other;
        return Intrinsics3.areEqual(this.enabled, trackEnableNotifications.enabled) && Intrinsics3.areEqual(this.source, trackEnableNotifications.source);
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.source;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackEnableNotifications(enabled=");
        sbU.append(this.enabled);
        sbU.append(", source=");
        return outline.E(sbU, this.source, ")");
    }
}
