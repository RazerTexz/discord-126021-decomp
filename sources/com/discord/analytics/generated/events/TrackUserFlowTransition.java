package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUserFlowTransition.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserFlowTransition implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence flowType = null;
    private final CharSequence fromStep = null;
    private final CharSequence toStep = null;
    private final Boolean skip = null;
    private final Float secondsOnFromStep = null;
    private final transient String analyticsSchemaTypeName = "user_flow_transition";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserFlowTransition)) {
            return false;
        }
        TrackUserFlowTransition trackUserFlowTransition = (TrackUserFlowTransition) other;
        return Intrinsics3.areEqual(this.flowType, trackUserFlowTransition.flowType) && Intrinsics3.areEqual(this.fromStep, trackUserFlowTransition.fromStep) && Intrinsics3.areEqual(this.toStep, trackUserFlowTransition.toStep) && Intrinsics3.areEqual(this.skip, trackUserFlowTransition.skip) && Intrinsics3.areEqual(this.secondsOnFromStep, trackUserFlowTransition.secondsOnFromStep);
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
        return iHashCode4 + (f != null ? f.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserFlowTransition(flowType=");
        sbU.append(this.flowType);
        sbU.append(", fromStep=");
        sbU.append(this.fromStep);
        sbU.append(", toStep=");
        sbU.append(this.toStep);
        sbU.append(", skip=");
        sbU.append(this.skip);
        sbU.append(", secondsOnFromStep=");
        sbU.append(this.secondsOnFromStep);
        sbU.append(")");
        return sbU.toString();
    }
}
