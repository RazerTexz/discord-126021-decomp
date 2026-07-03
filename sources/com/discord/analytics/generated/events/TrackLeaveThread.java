package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThreadReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackLeaveThread.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLeaveThread implements AnalyticsSchema, TrackBaseReceiver, TrackThreadReceiver {
    private TrackBase trackBase;
    private TrackThread trackThread;
    private final Long channelId = null;
    private final Long parentId = null;
    private final Long guildId = null;
    private final Long channelType = null;
    private final Long targetUserId = null;
    private final Boolean isSelfLeave = null;
    private final transient String analyticsSchemaTypeName = "leave_thread";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLeaveThread)) {
            return false;
        }
        TrackLeaveThread trackLeaveThread = (TrackLeaveThread) other;
        return C12238m.areEqual(this.channelId, trackLeaveThread.channelId) && C12238m.areEqual(this.parentId, trackLeaveThread.parentId) && C12238m.areEqual(this.guildId, trackLeaveThread.guildId) && C12238m.areEqual(this.channelType, trackLeaveThread.channelType) && C12238m.areEqual(this.targetUserId, trackLeaveThread.targetUserId) && C12238m.areEqual(this.isSelfLeave, trackLeaveThread.isSelfLeave);
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
        Boolean bool = this.isSelfLeave;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackLeaveThread(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", parentId=");
        sbM833U.append(this.parentId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", targetUserId=");
        sbM833U.append(this.targetUserId);
        sbM833U.append(", isSelfLeave=");
        return C1643a.m816D(sbM833U, this.isSelfLeave, ")");
    }
}
