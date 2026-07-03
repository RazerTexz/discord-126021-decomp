package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUserAvatarUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserAvatarUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
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
        return C12238m.areEqual(this.animated, trackUserAvatarUpdated.animated) && C12238m.areEqual(this.defaultAvatarSelected, trackUserAvatarUpdated.defaultAvatarSelected);
    }

    public int hashCode() {
        Boolean bool = this.animated;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.defaultAvatarSelected;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackUserAvatarUpdated(animated=");
        sbM833U.append(this.animated);
        sbM833U.append(", defaultAvatarSelected=");
        return C1643a.m819G(sbM833U, this.defaultAvatarSelected, ")");
    }
}
