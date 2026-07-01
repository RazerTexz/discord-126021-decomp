package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPasswordAction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPasswordAction implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence action = null;
    private final Boolean isSuccess = null;
    private final CharSequence compliance = null;
    private final Boolean isCompliant = null;
    private final transient String analyticsSchemaTypeName = "password_action";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPasswordAction)) {
            return false;
        }
        TrackPasswordAction trackPasswordAction = (TrackPasswordAction) other;
        return m.areEqual(this.action, trackPasswordAction.action) && m.areEqual(this.isSuccess, trackPasswordAction.isSuccess) && m.areEqual(this.compliance, trackPasswordAction.compliance) && m.areEqual(this.isCompliant, trackPasswordAction.isCompliant);
    }

    public int hashCode() {
        CharSequence charSequence = this.action;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isSuccess;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.compliance;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool2 = this.isCompliant;
        return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPasswordAction(action=");
        sbU.append(this.action);
        sbU.append(", isSuccess=");
        sbU.append(this.isSuccess);
        sbU.append(", compliance=");
        sbU.append(this.compliance);
        sbU.append(", isCompliant=");
        return a.D(sbU, this.isCompliant, ")");
    }
}
