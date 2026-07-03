package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        if (!(other instanceof TrackChannelLinkPreviewJoined)) {
            return false;
        }
        TrackChannelLinkPreviewJoined trackChannelLinkPreviewJoined = (TrackChannelLinkPreviewJoined) other;
        return C12238m.areEqual(this.authorId, trackChannelLinkPreviewJoined.authorId) && C12238m.areEqual(this.linkGuildId, trackChannelLinkPreviewJoined.linkGuildId) && C12238m.areEqual(this.linkChannelId, trackChannelLinkPreviewJoined.linkChannelId) && C12238m.areEqual(this.linkMessageId, trackChannelLinkPreviewJoined.linkMessageId) && C12238m.areEqual(this.linkChannelType, trackChannelLinkPreviewJoined.linkChannelType);
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
        StringBuilder sbM833U = C1643a.m833U("TrackChannelLinkPreviewJoined(authorId=");
        sbM833U.append(this.authorId);
        sbM833U.append(", linkGuildId=");
        sbM833U.append(this.linkGuildId);
        sbM833U.append(", linkChannelId=");
        sbM833U.append(this.linkChannelId);
        sbM833U.append(", linkMessageId=");
        sbM833U.append(this.linkMessageId);
        sbM833U.append(", linkChannelType=");
        return C1643a.m819G(sbM833U, this.linkChannelType, ")");
    }
}
