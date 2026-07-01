package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUserAvatarUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserAvatarUpdated implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Boolean animated = null;
    private final Long defaultAvatarSelected = null;
    private final transient String analyticsSchemaTypeName = "user_avatar_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserAvatarUpdated)) {
            return false;
        }
        TrackUserAvatarUpdated trackUserAvatarUpdated = (TrackUserAvatarUpdated) other;
        return Intrinsics3.areEqual(this.animated, trackUserAvatarUpdated.animated) && Intrinsics3.areEqual(this.defaultAvatarSelected, trackUserAvatarUpdated.defaultAvatarSelected);
    }

    public int hashCode() {
        Boolean bool = this.animated;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.defaultAvatarSelected;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserAvatarUpdated(animated=");
        sbU.append(this.animated);
        sbU.append(", defaultAvatarSelected=");
        return outline.G(sbU, this.defaultAvatarSelected, ")");
    }
}
