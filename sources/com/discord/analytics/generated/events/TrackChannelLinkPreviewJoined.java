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

/* JADX INFO: compiled from: TrackChannelLinkPreviewJoined.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelLinkPreviewJoined implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence authorId = null;
    private final CharSequence linkGuildId = null;
    private final CharSequence linkChannelId = null;
    private final CharSequence linkMessageId = null;
    private final Long linkChannelType = null;
    private final transient String analyticsSchemaTypeName = "channel_link_preview_joined";

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
        if (!(other instanceof TrackChannelLinkPreviewJoined)) {
            return false;
        }
        TrackChannelLinkPreviewJoined trackChannelLinkPreviewJoined = (TrackChannelLinkPreviewJoined) other;
        return m.areEqual(this.authorId, trackChannelLinkPreviewJoined.authorId) && m.areEqual(this.linkGuildId, trackChannelLinkPreviewJoined.linkGuildId) && m.areEqual(this.linkChannelId, trackChannelLinkPreviewJoined.linkChannelId) && m.areEqual(this.linkMessageId, trackChannelLinkPreviewJoined.linkMessageId) && m.areEqual(this.linkChannelType, trackChannelLinkPreviewJoined.linkChannelType);
    }

    public int hashCode() {
        CharSequence charSequence = this.authorId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.linkGuildId;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.linkChannelId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.linkMessageId;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.linkChannelType;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackChannelLinkPreviewJoined(authorId=");
        sbU.append(this.authorId);
        sbU.append(", linkGuildId=");
        sbU.append(this.linkGuildId);
        sbU.append(", linkChannelId=");
        sbU.append(this.linkChannelId);
        sbU.append(", linkMessageId=");
        sbU.append(this.linkMessageId);
        sbU.append(", linkChannelType=");
        return a.G(sbU, this.linkChannelType, ")");
    }
}
