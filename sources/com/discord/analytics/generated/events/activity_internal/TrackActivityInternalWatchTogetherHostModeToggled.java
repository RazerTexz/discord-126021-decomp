package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivityInternalWatchTogetherHostModeToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalWatchTogetherHostModeToggled implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Boolean isHost = null;
    private final Boolean isHostMode = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_watch_together_host_mode_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalWatchTogetherHostModeToggled)) {
            return false;
        }
        TrackActivityInternalWatchTogetherHostModeToggled trackActivityInternalWatchTogetherHostModeToggled = (TrackActivityInternalWatchTogetherHostModeToggled) other;
        return Intrinsics3.areEqual(this.isHost, trackActivityInternalWatchTogetherHostModeToggled.isHost) && Intrinsics3.areEqual(this.isHostMode, trackActivityInternalWatchTogetherHostModeToggled.isHostMode);
    }

    public int hashCode() {
        Boolean bool = this.isHost;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.isHostMode;
        return iHashCode + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalWatchTogetherHostModeToggled(isHost=");
        sbU.append(this.isHost);
        sbU.append(", isHostMode=");
        return outline.D(sbU, this.isHostMode, ")");
    }
}
