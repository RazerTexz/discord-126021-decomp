package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThread2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackChannelDeleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelDeleted implements AnalyticsSchema, TrackBase2, TrackChannel2, TrackThread2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackThread trackThread;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final CharSequence channelName = null;
    private final transient String analyticsSchemaTypeName = "channel_deleted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChannelDeleted)) {
            return false;
        }
        TrackChannelDeleted trackChannelDeleted = (TrackChannelDeleted) other;
        return Intrinsics3.areEqual(this.guildId, trackChannelDeleted.guildId) && Intrinsics3.areEqual(this.guildName, trackChannelDeleted.guildName) && Intrinsics3.areEqual(this.channelName, trackChannelDeleted.channelName);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.channelName;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackChannelDeleted(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", channelName=");
        return outline.E(sbU, this.channelName, ")");
    }
}
