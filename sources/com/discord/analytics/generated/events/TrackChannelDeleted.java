package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThreadReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackChannelDeleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChannelDeleted implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackThreadReceiver {
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
        return C12238m.areEqual(this.guildId, trackChannelDeleted.guildId) && C12238m.areEqual(this.guildName, trackChannelDeleted.guildName) && C12238m.areEqual(this.channelName, trackChannelDeleted.channelName);
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
        StringBuilder sbM833U = C1643a.m833U("TrackChannelDeleted(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", channelName=");
        return C1643a.m817E(sbM833U, this.channelName, ")");
    }
}
