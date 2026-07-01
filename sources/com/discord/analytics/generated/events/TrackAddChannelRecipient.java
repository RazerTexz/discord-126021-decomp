package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuildLfgGroup;
import com.discord.analytics.generated.traits.TrackGuildLfgGroup2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackAddChannelRecipient.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAddChannelRecipient implements AnalyticsSchema, TrackBase2, TrackGuildLfgGroup2 {
    private TrackBase trackBase;
    private TrackGuildLfgGroup trackGuildLfgGroup;
    private final Long channelType = null;
    private final Long channelId = null;
    private final Long recipientId = null;
    private final List<Long> recipientIds = null;
    private final transient String analyticsSchemaTypeName = "add_channel_recipient";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAddChannelRecipient)) {
            return false;
        }
        TrackAddChannelRecipient trackAddChannelRecipient = (TrackAddChannelRecipient) other;
        return Intrinsics3.areEqual(this.channelType, trackAddChannelRecipient.channelType) && Intrinsics3.areEqual(this.channelId, trackAddChannelRecipient.channelId) && Intrinsics3.areEqual(this.recipientId, trackAddChannelRecipient.recipientId) && Intrinsics3.areEqual(this.recipientIds, trackAddChannelRecipient.recipientIds);
    }

    public int hashCode() {
        Long l = this.channelType;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.recipientId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAddChannelRecipient(channelType=");
        sbU.append(this.channelType);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", recipientId=");
        sbU.append(this.recipientId);
        sbU.append(", recipientIds=");
        return outline.L(sbU, this.recipientIds, ")");
    }
}
