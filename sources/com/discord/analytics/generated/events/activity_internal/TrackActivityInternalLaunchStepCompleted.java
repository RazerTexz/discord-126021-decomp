package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityInternalLaunchStepCompleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalLaunchStepCompleted implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
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
        return C12238m.areEqual(this.step, trackActivityInternalLaunchStepCompleted.step) && C12238m.areEqual(this.nextStep, trackActivityInternalLaunchStepCompleted.nextStep) && C12238m.areEqual(this.durationMs, trackActivityInternalLaunchStepCompleted.durationMs) && C12238m.areEqual(this.success, trackActivityInternalLaunchStepCompleted.success) && C12238m.areEqual(this.errorCode, trackActivityInternalLaunchStepCompleted.errorCode) && C12238m.areEqual(this.errorMessage, trackActivityInternalLaunchStepCompleted.errorMessage);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalLaunchStepCompleted(step=");
        sbM833U.append(this.step);
        sbM833U.append(", nextStep=");
        sbM833U.append(this.nextStep);
        sbM833U.append(", durationMs=");
        sbM833U.append(this.durationMs);
        sbM833U.append(", success=");
        sbM833U.append(this.success);
        sbM833U.append(", errorCode=");
        sbM833U.append(this.errorCode);
        sbM833U.append(", errorMessage=");
        return C1643a.m817E(sbM833U, this.errorMessage, ")");
    }
}
