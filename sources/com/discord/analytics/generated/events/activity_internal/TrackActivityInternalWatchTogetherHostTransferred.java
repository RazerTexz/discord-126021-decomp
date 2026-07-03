package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityInternalWatchTogetherHostTransferred.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalWatchTogetherHostTransferred implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
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
        return C12238m.areEqual(this.isHostMode, trackActivityInternalWatchTogetherHostTransferred.isHostMode) && C12238m.areEqual(this.hostType, trackActivityInternalWatchTogetherHostTransferred.hostType);
    }

    public int hashCode() {
        Boolean bool = this.isHostMode;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.hostType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalWatchTogetherHostTransferred(isHostMode=");
        sbM833U.append(this.isHostMode);
        sbM833U.append(", hostType=");
        return C1643a.m817E(sbM833U, this.hostType, ")");
    }
}
