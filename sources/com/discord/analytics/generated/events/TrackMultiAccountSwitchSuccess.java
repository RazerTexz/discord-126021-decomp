package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMultiAccountSwitchSuccess.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMultiAccountSwitchSuccess implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.fromUserId, trackMultiAccountSwitchSuccess.fromUserId) && C12238m.areEqual(this.linkedUserIds, trackMultiAccountSwitchSuccess.linkedUserIds);
    }

    public int hashCode() {
        Long l = this.fromUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.linkedUserIds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackMultiAccountSwitchSuccess(fromUserId=");
        sbM833U.append(this.fromUserId);
        sbM833U.append(", linkedUserIds=");
        return C1643a.m824L(sbM833U, this.linkedUserIds, ")");
    }
}
