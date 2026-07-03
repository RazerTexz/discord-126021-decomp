package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuildLfgGroup;
import com.discord.analytics.generated.traits.TrackGuildLfgGroupReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAddChannelRecipient.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAddChannelRecipient implements AnalyticsSchema, TrackBaseReceiver, TrackGuildLfgGroupReceiver {
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
        return C12238m.areEqual(this.channelType, trackAddChannelRecipient.channelType) && C12238m.areEqual(this.channelId, trackAddChannelRecipient.channelId) && C12238m.areEqual(this.recipientId, trackAddChannelRecipient.recipientId) && C12238m.areEqual(this.recipientIds, trackAddChannelRecipient.recipientIds);
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
        StringBuilder sbM833U = C1643a.m833U("TrackAddChannelRecipient(channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", recipientId=");
        sbM833U.append(this.recipientId);
        sbM833U.append(", recipientIds=");
        return C1643a.m824L(sbM833U, this.recipientIds, ")");
    }
}
