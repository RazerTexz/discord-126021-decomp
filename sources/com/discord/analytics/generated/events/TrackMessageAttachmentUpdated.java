package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackMessageAttachmentUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageAttachmentUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence source = null;
    private final Long actionType = null;
    private final CharSequence mimeType = null;
    private final Long totalAttachments = null;
    private final transient String analyticsSchemaTypeName = "message_attachment_updated";

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
        if (!(other instanceof TrackMessageAttachmentUpdated)) {
            return false;
        }
        TrackMessageAttachmentUpdated trackMessageAttachmentUpdated = (TrackMessageAttachmentUpdated) other;
        return m.areEqual(this.source, trackMessageAttachmentUpdated.source) && m.areEqual(this.actionType, trackMessageAttachmentUpdated.actionType) && m.areEqual(this.mimeType, trackMessageAttachmentUpdated.mimeType) && m.areEqual(this.totalAttachments, trackMessageAttachmentUpdated.totalAttachments);
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
        StringBuilder sbU = a.U("TrackMessageAttachmentUpdated(source=");
        sbU.append(this.source);
        sbU.append(", actionType=");
        sbU.append(this.actionType);
        sbU.append(", mimeType=");
        sbU.append(this.mimeType);
        sbU.append(", totalAttachments=");
        return a.G(sbU, this.totalAttachments, ")");
    }
}
