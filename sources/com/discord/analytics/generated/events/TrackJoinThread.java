package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThreadReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackJoinThread.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackJoinThread implements AnalyticsSchema, TrackBaseReceiver, TrackThreadReceiver {
    private TrackBase trackBase;
    private TrackThread trackThread;
    private final Long channelId = null;
    private final Long parentId = null;
    private final Long guildId = null;
    private final Long channelType = null;
    private final Long targetUserId = null;
    private final Boolean isSelfJoin = null;
    private final transient String analyticsSchemaTypeName = "join_thread";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinThread)) {
            return false;
        }
        TrackJoinThread trackJoinThread = (TrackJoinThread) other;
        return m.areEqual(this.channelId, trackJoinThread.channelId) && m.areEqual(this.parentId, trackJoinThread.parentId) && m.areEqual(this.guildId, trackJoinThread.guildId) && m.areEqual(this.channelType, trackJoinThread.channelType) && m.areEqual(this.targetUserId, trackJoinThread.targetUserId) && m.areEqual(this.isSelfJoin, trackJoinThread.isSelfJoin);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.parentId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelType;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.targetUserId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.isSelfJoin;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackJoinThread(channelId=");
        sbU.append(this.channelId);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", targetUserId=");
        sbU.append(this.targetUserId);
        sbU.append(", isSelfJoin=");
        return a.D(sbU, this.isSelfJoin, ")");
    }
}
