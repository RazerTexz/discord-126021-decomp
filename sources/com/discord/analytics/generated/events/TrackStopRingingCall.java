package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStopRingingCall.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStopRingingCall implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long messageId = null;
    private final Long channelType = null;
    private final Boolean self = null;
    private final List<Long> recipientIds = null;
    private final transient String analyticsSchemaTypeName = "stop_ringing_call";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStopRingingCall)) {
            return false;
        }
        TrackStopRingingCall trackStopRingingCall = (TrackStopRingingCall) other;
        return C12238m.areEqual(this.channelId, trackStopRingingCall.channelId) && C12238m.areEqual(this.messageId, trackStopRingingCall.messageId) && C12238m.areEqual(this.channelType, trackStopRingingCall.channelType) && C12238m.areEqual(this.self, trackStopRingingCall.self) && C12238m.areEqual(this.recipientIds, trackStopRingingCall.recipientIds);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.messageId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.self;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        List<Long> list = this.recipientIds;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackStopRingingCall(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", self=");
        sbM833U.append(this.self);
        sbM833U.append(", recipientIds=");
        return C1643a.m824L(sbM833U, this.recipientIds, ")");
    }
}
