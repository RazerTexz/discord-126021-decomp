package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackMessageAttachmentUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageAttachmentUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence source = null;
    private final Long actionType = null;
    private final CharSequence mimeType = null;
    private final Long totalAttachments = null;
    private final transient String analyticsSchemaTypeName = "message_attachment_updated";

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
        if (!(other instanceof TrackMessageAttachmentUpdated)) {
            return false;
        }
        TrackMessageAttachmentUpdated trackMessageAttachmentUpdated = (TrackMessageAttachmentUpdated) other;
        return Intrinsics3.areEqual(this.source, trackMessageAttachmentUpdated.source) && Intrinsics3.areEqual(this.actionType, trackMessageAttachmentUpdated.actionType) && Intrinsics3.areEqual(this.mimeType, trackMessageAttachmentUpdated.mimeType) && Intrinsics3.areEqual(this.totalAttachments, trackMessageAttachmentUpdated.totalAttachments);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.actionType;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mimeType;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.totalAttachments;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMessageAttachmentUpdated(source=");
        sbU.append(this.source);
        sbU.append(", actionType=");
        sbU.append(this.actionType);
        sbU.append(", mimeType=");
        sbU.append(this.mimeType);
        sbU.append(", totalAttachments=");
        return outline.G(sbU, this.totalAttachments, ")");
    }
}
