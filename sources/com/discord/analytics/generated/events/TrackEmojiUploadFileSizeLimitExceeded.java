package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackEmojiUploadFileSizeLimitExceeded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEmojiUploadFileSizeLimitExceeded implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long fileSize = null;
    private final CharSequence uploadId = null;
    private final transient String analyticsSchemaTypeName = "emoji_upload_file_size_limit_exceeded";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        return C12238m.areEqual(this.fileSize, trackEmojiUploadFileSizeLimitExceeded.fileSize) && C12238m.areEqual(this.uploadId, trackEmojiUploadFileSizeLimitExceeded.uploadId);
    }

    public int hashCode() {
        Long l = this.fileSize;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.uploadId;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackEmojiUploadFileSizeLimitExceeded(fileSize=");
        sbM833U.append(this.fileSize);
        sbM833U.append(", uploadId=");
        return C1643a.m817E(sbM833U, this.uploadId, ")");
    }
}
