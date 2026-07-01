package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackFileSizeLimitExceeded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackFileSizeLimitExceeded implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackGuildReceiver, TrackLocationMetadataReceiver, TrackSourceMetadataReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final Long limit = null;
    private final Long filesize = null;
    private final CharSequence type = null;
    private final transient String analyticsSchemaTypeName = "file_size_limit_exceeded";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
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
        return m.areEqual(this.limit, trackFileSizeLimitExceeded.limit) && m.areEqual(this.filesize, trackFileSizeLimitExceeded.filesize) && m.areEqual(this.type, trackFileSizeLimitExceeded.type);
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
        StringBuilder sbU = a.U("TrackFileSizeLimitExceeded(limit=");
        sbU.append(this.limit);
        sbU.append(", filesize=");
        sbU.append(this.filesize);
        sbU.append(", type=");
        return a.E(sbU, this.type, ")");
    }
}
