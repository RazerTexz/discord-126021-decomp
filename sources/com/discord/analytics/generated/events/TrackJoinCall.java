package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackJoinCall.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackJoinCall implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long messageId = null;
    private final List<Long> recipientIds = null;
    private final List<Long> participantIds = null;
    private final transient String analyticsSchemaTypeName = "join_call";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinCall)) {
            return false;
        }
        TrackJoinCall trackJoinCall = (TrackJoinCall) other;
        return Intrinsics3.areEqual(this.channelId, trackJoinCall.channelId) && Intrinsics3.areEqual(this.channelType, trackJoinCall.channelType) && Intrinsics3.areEqual(this.messageId, trackJoinCall.messageId) && Intrinsics3.areEqual(this.recipientIds, trackJoinCall.recipientIds) && Intrinsics3.areEqual(this.participantIds, trackJoinCall.participantIds);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.messageId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.participantIds;
        return iHashCode4 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackJoinCall(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", recipientIds=");
        sbU.append(this.recipientIds);
        sbU.append(", participantIds=");
        return outline.L(sbU, this.participantIds, ")");
    }
}
