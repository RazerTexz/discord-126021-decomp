package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackA11yRuntimeViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackA11yRuntimeViolation implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence ruleId = null;
    private final CharSequence trace = null;
    private final CharSequence message = null;
    private final CharSequence hash = null;
    private final transient String analyticsSchemaTypeName = "a11y_runtime_violation";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackA11yRuntimeViolation)) {
            return false;
        }
        TrackA11yRuntimeViolation trackA11yRuntimeViolation = (TrackA11yRuntimeViolation) other;
        return m.areEqual(this.ruleId, trackA11yRuntimeViolation.ruleId) && m.areEqual(this.trace, trackA11yRuntimeViolation.trace) && m.areEqual(this.message, trackA11yRuntimeViolation.message) && m.areEqual(this.hash, trackA11yRuntimeViolation.hash);
    }

    public int hashCode() {
        CharSequence charSequence = this.ruleId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.trace;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.message;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.hash;
        return iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackA11yRuntimeViolation(ruleId=");
        sbU.append(this.ruleId);
        sbU.append(", trace=");
        sbU.append(this.trace);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", hash=");
        return a.E(sbU, this.hash, ")");
    }
}
