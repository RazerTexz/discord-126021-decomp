package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivityInternalLaunchStepCompleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalLaunchStepCompleted implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence step = null;
    private final CharSequence nextStep = null;
    private final Long durationMs = null;
    private final Boolean success = null;
    private final Long errorCode = null;
    private final CharSequence errorMessage = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_launch_step_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalLaunchStepCompleted)) {
            return false;
        }
        TrackActivityInternalLaunchStepCompleted trackActivityInternalLaunchStepCompleted = (TrackActivityInternalLaunchStepCompleted) other;
        return Intrinsics3.areEqual(this.step, trackActivityInternalLaunchStepCompleted.step) && Intrinsics3.areEqual(this.nextStep, trackActivityInternalLaunchStepCompleted.nextStep) && Intrinsics3.areEqual(this.durationMs, trackActivityInternalLaunchStepCompleted.durationMs) && Intrinsics3.areEqual(this.success, trackActivityInternalLaunchStepCompleted.success) && Intrinsics3.areEqual(this.errorCode, trackActivityInternalLaunchStepCompleted.errorCode) && Intrinsics3.areEqual(this.errorMessage, trackActivityInternalLaunchStepCompleted.errorMessage);
    }

    public int hashCode() {
        CharSequence charSequence = this.step;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.nextStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.durationMs;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool = this.success;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.errorCode;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.errorMessage;
        return iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalLaunchStepCompleted(step=");
        sbU.append(this.step);
        sbU.append(", nextStep=");
        sbU.append(this.nextStep);
        sbU.append(", durationMs=");
        sbU.append(this.durationMs);
        sbU.append(", success=");
        sbU.append(this.success);
        sbU.append(", errorCode=");
        sbU.append(this.errorCode);
        sbU.append(", errorMessage=");
        return outline.E(sbU, this.errorMessage, ")");
    }
}
