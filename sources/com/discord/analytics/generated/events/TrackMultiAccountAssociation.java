package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackMultiAccountAssociation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMultiAccountAssociation implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long lastUserId = null;
    private final List<Long> linkedUserIds = null;
    private final transient String analyticsSchemaTypeName = "multi_account_association";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMultiAccountAssociation)) {
            return false;
        }
        TrackMultiAccountAssociation trackMultiAccountAssociation = (TrackMultiAccountAssociation) other;
        return m.areEqual(this.lastUserId, trackMultiAccountAssociation.lastUserId) && m.areEqual(this.linkedUserIds, trackMultiAccountAssociation.linkedUserIds);
    }

    public int hashCode() {
        Long l = this.lastUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.linkedUserIds;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackMultiAccountAssociation(lastUserId=");
        sbU.append(this.lastUserId);
        sbU.append(", linkedUserIds=");
        return a.L(sbU, this.linkedUserIds, ")");
    }
}
