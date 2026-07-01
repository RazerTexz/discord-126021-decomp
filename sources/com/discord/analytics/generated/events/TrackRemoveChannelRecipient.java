package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuildLfgGroup;
import com.discord.analytics.generated.traits.TrackGuildLfgGroupReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackRemoveChannelRecipient.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRemoveChannelRecipient implements AnalyticsSchema, TrackBaseReceiver, TrackGuildLfgGroupReceiver {
    private TrackBase trackBase;
    private TrackGuildLfgGroup trackGuildLfgGroup;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Boolean owner = null;
    private final Long recipientId = null;
    private final List<Long> recipientIds = null;
    private final CharSequence removeType = null;
    private final transient String analyticsSchemaTypeName = "remove_channel_recipient";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRemoveChannelRecipient)) {
            return false;
        }
        TrackRemoveChannelRecipient trackRemoveChannelRecipient = (TrackRemoveChannelRecipient) other;
        return m.areEqual(this.channelId, trackRemoveChannelRecipient.channelId) && m.areEqual(this.channelType, trackRemoveChannelRecipient.channelType) && m.areEqual(this.owner, trackRemoveChannelRecipient.owner) && m.areEqual(this.recipientId, trackRemoveChannelRecipient.recipientId) && m.areEqual(this.recipientIds, trackRemoveChannelRecipient.recipientIds) && m.areEqual(this.removeType, trackRemoveChannelRecipient.removeType);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.owner;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.recipientId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence = this.removeType;
        return iHashCode5 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackRemoveChannelRecipient(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", owner=");
        sbU.append(this.owner);
        sbU.append(", recipientId=");
        sbU.append(this.recipientId);
        sbU.append(", recipientIds=");
        sbU.append(this.recipientIds);
        sbU.append(", removeType=");
        return a.E(sbU, this.removeType, ")");
    }
}
