package com.discord.analytics.generated.events.impression;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.generated.traits.TrackImpressionMetadataReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackImpressionGuildInvite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackImpressionGuildInvite implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver, TrackLocationMetadataReceiver, TrackImpressionMetadataReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long inviteChannelId;
    private final Long inviteGuildId;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private TrackImpressionMetadata trackImpressionMetadata;
    private TrackLocationMetadata trackLocationMetadata;

    public TrackImpressionGuildInvite(Long l, Long l2) {
        this.inviteGuildId = l;
        this.inviteChannelId = l2;
        this.analyticsSchemaTypeName = "impression_guild_invite";
    }

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
        if (!(other instanceof TrackImpressionGuildInvite)) {
            return false;
        }
        TrackImpressionGuildInvite trackImpressionGuildInvite = (TrackImpressionGuildInvite) other;
        return C12238m.areEqual(this.inviteGuildId, trackImpressionGuildInvite.inviteGuildId) && C12238m.areEqual(this.inviteChannelId, trackImpressionGuildInvite.inviteChannelId);
    }

    public int hashCode() {
        Long l = this.inviteGuildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.inviteChannelId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackImpressionGuildInvite(inviteGuildId=");
        sbM833U.append(this.inviteGuildId);
        sbM833U.append(", inviteChannelId=");
        return C1643a.m819G(sbM833U, this.inviteChannelId, ")");
    }

    public TrackImpressionGuildInvite() {
        this(null, null);
    }
}
