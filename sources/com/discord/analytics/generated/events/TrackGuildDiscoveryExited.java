package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildDiscoveryExited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryExited implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence loadId = null;
    private final List<Long> guildIdsViewed = null;
    private final CharSequence recommendationsSource = null;
    private final transient String analyticsSchemaTypeName = "guild_discovery_exited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDiscoveryExited)) {
            return false;
        }
        TrackGuildDiscoveryExited trackGuildDiscoveryExited = (TrackGuildDiscoveryExited) other;
        return C12238m.areEqual(this.loadId, trackGuildDiscoveryExited.loadId) && C12238m.areEqual(this.guildIdsViewed, trackGuildDiscoveryExited.guildIdsViewed) && C12238m.areEqual(this.recommendationsSource, trackGuildDiscoveryExited.recommendationsSource);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        List<Long> list = this.guildIdsViewed;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.recommendationsSource;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildDiscoveryExited(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", guildIdsViewed=");
        sbM833U.append(this.guildIdsViewed);
        sbM833U.append(", recommendationsSource=");
        return C1643a.m817E(sbM833U, this.recommendationsSource, ")");
    }
}
