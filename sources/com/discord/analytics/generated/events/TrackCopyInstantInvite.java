package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackCopyInstantInvite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCopyInstantInvite implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Long channel = null;
    private final Long channelType = null;
    private final CharSequence group = null;
    private final Long server = null;
    private final CharSequence code = null;
    private final Long guildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "copy_instant_invite";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCopyInstantInvite)) {
            return false;
        }
        TrackCopyInstantInvite trackCopyInstantInvite = (TrackCopyInstantInvite) other;
        return Intrinsics3.areEqual(this.channel, trackCopyInstantInvite.channel) && Intrinsics3.areEqual(this.channelType, trackCopyInstantInvite.channelType) && Intrinsics3.areEqual(this.group, trackCopyInstantInvite.group) && Intrinsics3.areEqual(this.server, trackCopyInstantInvite.server) && Intrinsics3.areEqual(this.code, trackCopyInstantInvite.code) && Intrinsics3.areEqual(this.guildScheduledEventId, trackCopyInstantInvite.guildScheduledEventId);
    }

    public int hashCode() {
        Long l = this.channel;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.group;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.server;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.code;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.guildScheduledEventId;
        return iHashCode5 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCopyInstantInvite(channel=");
        sbU.append(this.channel);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", group=");
        sbU.append(this.group);
        sbU.append(", server=");
        sbU.append(this.server);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", guildScheduledEventId=");
        return outline.G(sbU, this.guildScheduledEventId, ")");
    }
}
