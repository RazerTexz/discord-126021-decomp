package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPermissionsAcked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPermissionsAcked implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence type = null;
    private final CharSequence action = null;
    private final CharSequence previousAction = null;
    private final transient String analyticsSchemaTypeName = "permissions_acked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPermissionsAcked)) {
            return false;
        }
        TrackPermissionsAcked trackPermissionsAcked = (TrackPermissionsAcked) other;
        return m.areEqual(this.type, trackPermissionsAcked.type) && m.areEqual(this.action, trackPermissionsAcked.action) && m.areEqual(this.previousAction, trackPermissionsAcked.previousAction);
    }

    public int hashCode() {
        CharSequence charSequence = this.type;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.action;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.previousAction;
        return iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPermissionsAcked(type=");
        sbU.append(this.type);
        sbU.append(", action=");
        sbU.append(this.action);
        sbU.append(", previousAction=");
        return a.E(sbU, this.previousAction, ")");
    }
}
