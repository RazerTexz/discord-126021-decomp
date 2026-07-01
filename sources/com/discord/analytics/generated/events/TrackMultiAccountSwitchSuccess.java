package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackMultiAccountSwitchSuccess.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMultiAccountSwitchSuccess implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long fromUserId = null;
    private final List<Long> linkedUserIds = null;
    private final transient String analyticsSchemaTypeName = "multi_account_switch_success";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMultiAccountSwitchSuccess)) {
            return false;
        }
        TrackMultiAccountSwitchSuccess trackMultiAccountSwitchSuccess = (TrackMultiAccountSwitchSuccess) other;
        return Intrinsics3.areEqual(this.fromUserId, trackMultiAccountSwitchSuccess.fromUserId) && Intrinsics3.areEqual(this.linkedUserIds, trackMultiAccountSwitchSuccess.linkedUserIds);
    }

    public int hashCode() {
        Long l = this.fromUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.linkedUserIds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMultiAccountSwitchSuccess(fromUserId=");
        sbU.append(this.fromUserId);
        sbU.append(", linkedUserIds=");
        return outline.L(sbU, this.linkedUserIds, ")");
    }
}
