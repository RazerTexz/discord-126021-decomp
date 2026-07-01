package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackVoiceProcessing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceProcessing implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Boolean noiseCancellerCpuOveruse = null;
    private final Long noiseCancellerError = null;
    private final Boolean noiseCancellation = null;
    private final Boolean echoCancellation = null;
    private final Boolean noiseSuppression = null;
    private final Boolean automaticGainControl = null;
    private final transient String analyticsSchemaTypeName = "voice_processing";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceProcessing)) {
            return false;
        }
        TrackVoiceProcessing trackVoiceProcessing = (TrackVoiceProcessing) other;
        return m.areEqual(this.noiseCancellerCpuOveruse, trackVoiceProcessing.noiseCancellerCpuOveruse) && m.areEqual(this.noiseCancellerError, trackVoiceProcessing.noiseCancellerError) && m.areEqual(this.noiseCancellation, trackVoiceProcessing.noiseCancellation) && m.areEqual(this.echoCancellation, trackVoiceProcessing.echoCancellation) && m.areEqual(this.noiseSuppression, trackVoiceProcessing.noiseSuppression) && m.areEqual(this.automaticGainControl, trackVoiceProcessing.automaticGainControl);
    }

    public int hashCode() {
        Boolean bool = this.noiseCancellerCpuOveruse;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Long l = this.noiseCancellerError;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.noiseCancellation;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.echoCancellation;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.noiseSuppression;
        int iHashCode5 = (iHashCode4 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.automaticGainControl;
        return iHashCode5 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackVoiceProcessing(noiseCancellerCpuOveruse=");
        sbU.append(this.noiseCancellerCpuOveruse);
        sbU.append(", noiseCancellerError=");
        sbU.append(this.noiseCancellerError);
        sbU.append(", noiseCancellation=");
        sbU.append(this.noiseCancellation);
        sbU.append(", echoCancellation=");
        sbU.append(this.echoCancellation);
        sbU.append(", noiseSuppression=");
        sbU.append(this.noiseSuppression);
        sbU.append(", automaticGainControl=");
        return a.D(sbU, this.automaticGainControl, ")");
    }
}
