package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNuoTransition.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNuoTransition implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence flowType = null;
    private final CharSequence fromStep = null;
    private final CharSequence toStep = null;
    private final Boolean skip = null;
    private final Float secondsOnFromStep = null;
    private final Boolean skipAttempt = null;
    private final Boolean back = null;
    private final transient String analyticsSchemaTypeName = "nuo_transition";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNuoTransition)) {
            return false;
        }
        TrackNuoTransition trackNuoTransition = (TrackNuoTransition) other;
        return m.areEqual(this.flowType, trackNuoTransition.flowType) && m.areEqual(this.fromStep, trackNuoTransition.fromStep) && m.areEqual(this.toStep, trackNuoTransition.toStep) && m.areEqual(this.skip, trackNuoTransition.skip) && m.areEqual(this.secondsOnFromStep, trackNuoTransition.secondsOnFromStep) && m.areEqual(this.skipAttempt, trackNuoTransition.skipAttempt) && m.areEqual(this.back, trackNuoTransition.back);
    }

    public int hashCode() {
        CharSequence charSequence = this.flowType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.fromStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.toStep;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.skip;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Float f = this.secondsOnFromStep;
        int iHashCode5 = (iHashCode4 + (f != null ? f.hashCode() : 0)) * 31;
        Boolean bool2 = this.skipAttempt;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.back;
        return iHashCode6 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNuoTransition(flowType=");
        sbU.append(this.flowType);
        sbU.append(", fromStep=");
        sbU.append(this.fromStep);
        sbU.append(", toStep=");
        sbU.append(this.toStep);
        sbU.append(", skip=");
        sbU.append(this.skip);
        sbU.append(", secondsOnFromStep=");
        sbU.append(this.secondsOnFromStep);
        sbU.append(", skipAttempt=");
        sbU.append(this.skipAttempt);
        sbU.append(", back=");
        return a.D(sbU, this.back, ")");
    }
}
