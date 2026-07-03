package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUserFlowTransition.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserFlowTransition implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence flowType = null;
    private final CharSequence fromStep = null;
    private final CharSequence toStep = null;
    private final Boolean skip = null;
    private final Float secondsOnFromStep = null;
    private final transient String analyticsSchemaTypeName = "user_flow_transition";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        return C12238m.areEqual(this.flowType, trackUserFlowTransition.flowType) && C12238m.areEqual(this.fromStep, trackUserFlowTransition.fromStep) && C12238m.areEqual(this.toStep, trackUserFlowTransition.toStep) && C12238m.areEqual(this.skip, trackUserFlowTransition.skip) && C12238m.areEqual(this.secondsOnFromStep, trackUserFlowTransition.secondsOnFromStep);
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
        StringBuilder sbM833U = C1643a.m833U("TrackUserFlowTransition(flowType=");
        sbM833U.append(this.flowType);
        sbM833U.append(", fromStep=");
        sbM833U.append(this.fromStep);
        sbM833U.append(", toStep=");
        sbM833U.append(this.toStep);
        sbM833U.append(", skip=");
        sbM833U.append(this.skip);
        sbM833U.append(", secondsOnFromStep=");
        sbM833U.append(this.secondsOnFromStep);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
