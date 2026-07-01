package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackEmojiUploadFileSizeLimitExceeded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEmojiUploadFileSizeLimitExceeded implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long fileSize = null;
    private final CharSequence uploadId = null;
    private final transient String analyticsSchemaTypeName = "emoji_upload_file_size_limit_exceeded";

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
        if (!(other instanceof TrackEmojiUploadFileSizeLimitExceeded)) {
            return false;
        }
        TrackEmojiUploadFileSizeLimitExceeded trackEmojiUploadFileSizeLimitExceeded = (TrackEmojiUploadFileSizeLimitExceeded) other;
        return Intrinsics3.areEqual(this.fileSize, trackEmojiUploadFileSizeLimitExceeded.fileSize) && Intrinsics3.areEqual(this.uploadId, trackEmojiUploadFileSizeLimitExceeded.uploadId);
    }

    public int hashCode() {
        Long l = this.fileSize;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.uploadId;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackEmojiUploadFileSizeLimitExceeded(fileSize=");
        sbU.append(this.fileSize);
        sbU.append(", uploadId=");
        return outline.E(sbU, this.uploadId, ")");
    }
}
