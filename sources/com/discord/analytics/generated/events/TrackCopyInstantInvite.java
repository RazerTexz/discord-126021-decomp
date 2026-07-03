package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCopyInstantInvite.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCopyInstantInvite implements AnalyticsSchema, TrackBaseReceiver, TrackOverlayClientMetadataReceiver {
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
        return C12238m.areEqual(this.channel, trackCopyInstantInvite.channel) && C12238m.areEqual(this.channelType, trackCopyInstantInvite.channelType) && C12238m.areEqual(this.group, trackCopyInstantInvite.group) && C12238m.areEqual(this.server, trackCopyInstantInvite.server) && C12238m.areEqual(this.code, trackCopyInstantInvite.code) && C12238m.areEqual(this.guildScheduledEventId, trackCopyInstantInvite.guildScheduledEventId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackCopyInstantInvite(channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", group=");
        sbM833U.append(this.group);
        sbM833U.append(", server=");
        sbM833U.append(this.server);
        sbM833U.append(", code=");
        sbM833U.append(this.code);
        sbM833U.append(", guildScheduledEventId=");
        return C1643a.m819G(sbM833U, this.guildScheduledEventId, ")");
    }
}
