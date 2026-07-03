package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.flowType, trackNuoTransition.flowType) && C12238m.areEqual(this.fromStep, trackNuoTransition.fromStep) && C12238m.areEqual(this.toStep, trackNuoTransition.toStep) && C12238m.areEqual(this.skip, trackNuoTransition.skip) && C12238m.areEqual(this.secondsOnFromStep, trackNuoTransition.secondsOnFromStep) && C12238m.areEqual(this.skipAttempt, trackNuoTransition.skipAttempt) && C12238m.areEqual(this.back, trackNuoTransition.back);
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
        StringBuilder sbM833U = C1643a.m833U("TrackNuoTransition(flowType=");
        sbM833U.append(this.flowType);
        sbM833U.append(", fromStep=");
        sbM833U.append(this.fromStep);
        sbM833U.append(", toStep=");
        sbM833U.append(this.toStep);
        sbM833U.append(", skip=");
        sbM833U.append(this.skip);
        sbM833U.append(", secondsOnFromStep=");
        sbM833U.append(this.secondsOnFromStep);
        sbM833U.append(", skipAttempt=");
        sbM833U.append(this.skipAttempt);
        sbM833U.append(", back=");
        return C1643a.m816D(sbM833U, this.back, ")");
    }
}
