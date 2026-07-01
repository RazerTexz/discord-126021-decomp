package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivityInternalWatchTogetherHostTransferred.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalWatchTogetherHostTransferred implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Boolean isHostMode = null;
    private final CharSequence hostType = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_watch_together_host_transferred";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalWatchTogetherHostTransferred)) {
            return false;
        }
        TrackActivityInternalWatchTogetherHostTransferred trackActivityInternalWatchTogetherHostTransferred = (TrackActivityInternalWatchTogetherHostTransferred) other;
        return Intrinsics3.areEqual(this.isHostMode, trackActivityInternalWatchTogetherHostTransferred.isHostMode) && Intrinsics3.areEqual(this.hostType, trackActivityInternalWatchTogetherHostTransferred.hostType);
    }

    public int hashCode() {
        Boolean bool = this.isHostMode;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.hostType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalWatchTogetherHostTransferred(isHostMode=");
        sbU.append(this.isHostMode);
        sbU.append(", hostType=");
        return outline.E(sbU, this.hostType, ")");
    }
}
