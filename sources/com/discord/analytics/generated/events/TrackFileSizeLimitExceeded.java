package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackFileSizeLimitExceeded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFileSizeLimitExceeded implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackGuild2, TrackLocationMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final Long limit = null;
    private final Long filesize = null;
    private final CharSequence type = null;
    private final transient String analyticsSchemaTypeName = "file_size_limit_exceeded";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFileSizeLimitExceeded)) {
            return false;
        }
        TrackFileSizeLimitExceeded trackFileSizeLimitExceeded = (TrackFileSizeLimitExceeded) other;
        return Intrinsics3.areEqual(this.limit, trackFileSizeLimitExceeded.limit) && Intrinsics3.areEqual(this.filesize, trackFileSizeLimitExceeded.filesize) && Intrinsics3.areEqual(this.type, trackFileSizeLimitExceeded.type);
    }

    public int hashCode() {
        Long l = this.limit;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.filesize;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.type;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackFileSizeLimitExceeded(limit=");
        sbU.append(this.limit);
        sbU.append(", filesize=");
        sbU.append(this.filesize);
        sbU.append(", type=");
        return outline.E(sbU, this.type, ")");
    }
}
