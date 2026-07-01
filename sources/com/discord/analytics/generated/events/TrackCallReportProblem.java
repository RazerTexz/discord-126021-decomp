package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackCallReportProblem.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCallReportProblem implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final CharSequence rtcConnectionId = null;
    private final Long duration = null;
    private final Long voiceStateCount = null;
    private final Long videoStreamCount = null;
    private final Boolean videoEnabled = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rating = null;
    private final CharSequence feedback = null;
    private final Long reasonCode = null;
    private final CharSequence reasonDescription = null;
    private final CharSequence audioInputMode = null;
    private final Boolean automaticAudioInputSensitivityEnabled = null;
    private final Float audioInputSensitivity = null;
    private final Boolean echoCancellationEnabled = null;
    private final Boolean noiseSuppressionEnabled = null;
    private final Boolean noiseCancellationEnabled = null;
    private final Boolean automaticGainControlEnabled = null;
    private final CharSequence audioOutputMode = null;
    private final Float voiceOutputVolume = null;
    private final Boolean videoHardwareScalingEnabled = null;
    private final CharSequence audioMode = null;
    private final CharSequence inputDeviceName = null;
    private final CharSequence outputDeviceName = null;
    private final CharSequence videoDeviceName = null;
    private final transient String analyticsSchemaTypeName = "call_report_problem";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCallReportProblem)) {
            return false;
        }
        TrackCallReportProblem trackCallReportProblem = (TrackCallReportProblem) other;
        return m.areEqual(this.channelId, trackCallReportProblem.channelId) && m.areEqual(this.channelType, trackCallReportProblem.channelType) && m.areEqual(this.guildId, trackCallReportProblem.guildId) && m.areEqual(this.rtcConnectionId, trackCallReportProblem.rtcConnectionId) && m.areEqual(this.duration, trackCallReportProblem.duration) && m.areEqual(this.voiceStateCount, trackCallReportProblem.voiceStateCount) && m.areEqual(this.videoStreamCount, trackCallReportProblem.videoStreamCount) && m.areEqual(this.videoEnabled, trackCallReportProblem.videoEnabled) && m.areEqual(this.mediaSessionId, trackCallReportProblem.mediaSessionId) && m.areEqual(this.rating, trackCallReportProblem.rating) && m.areEqual(this.feedback, trackCallReportProblem.feedback) && m.areEqual(this.reasonCode, trackCallReportProblem.reasonCode) && m.areEqual(this.reasonDescription, trackCallReportProblem.reasonDescription) && m.areEqual(this.audioInputMode, trackCallReportProblem.audioInputMode) && m.areEqual(this.automaticAudioInputSensitivityEnabled, trackCallReportProblem.automaticAudioInputSensitivityEnabled) && m.areEqual(this.audioInputSensitivity, trackCallReportProblem.audioInputSensitivity) && m.areEqual(this.echoCancellationEnabled, trackCallReportProblem.echoCancellationEnabled) && m.areEqual(this.noiseSuppressionEnabled, trackCallReportProblem.noiseSuppressionEnabled) && m.areEqual(this.noiseCancellationEnabled, trackCallReportProblem.noiseCancellationEnabled) && m.areEqual(this.automaticGainControlEnabled, trackCallReportProblem.automaticGainControlEnabled) && m.areEqual(this.audioOutputMode, trackCallReportProblem.audioOutputMode) && m.areEqual(this.voiceOutputVolume, trackCallReportProblem.voiceOutputVolume) && m.areEqual(this.videoHardwareScalingEnabled, trackCallReportProblem.videoHardwareScalingEnabled) && m.areEqual(this.audioMode, trackCallReportProblem.audioMode) && m.areEqual(this.inputDeviceName, trackCallReportProblem.inputDeviceName) && m.areEqual(this.outputDeviceName, trackCallReportProblem.outputDeviceName) && m.areEqual(this.videoDeviceName, trackCallReportProblem.videoDeviceName);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.rtcConnectionId;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.duration;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.voiceStateCount;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.videoStreamCount;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mediaSessionId;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.rating;
        int iHashCode10 = (iHashCode9 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.feedback;
        int iHashCode11 = (iHashCode10 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l7 = this.reasonCode;
        int iHashCode12 = (iHashCode11 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.reasonDescription;
        int iHashCode13 = (iHashCode12 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.audioInputMode;
        int iHashCode14 = (iHashCode13 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool2 = this.automaticAudioInputSensitivityEnabled;
        int iHashCode15 = (iHashCode14 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Float f = this.audioInputSensitivity;
        int iHashCode16 = (iHashCode15 + (f != null ? f.hashCode() : 0)) * 31;
        Boolean bool3 = this.echoCancellationEnabled;
        int iHashCode17 = (iHashCode16 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.noiseSuppressionEnabled;
        int iHashCode18 = (iHashCode17 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.noiseCancellationEnabled;
        int iHashCode19 = (iHashCode18 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.automaticGainControlEnabled;
        int iHashCode20 = (iHashCode19 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.audioOutputMode;
        int iHashCode21 = (iHashCode20 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Float f2 = this.voiceOutputVolume;
        int iHashCode22 = (iHashCode21 + (f2 != null ? f2.hashCode() : 0)) * 31;
        Boolean bool7 = this.videoHardwareScalingEnabled;
        int iHashCode23 = (iHashCode22 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.audioMode;
        int iHashCode24 = (iHashCode23 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.inputDeviceName;
        int iHashCode25 = (iHashCode24 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.outputDeviceName;
        int iHashCode26 = (iHashCode25 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        CharSequence charSequence11 = this.videoDeviceName;
        return iHashCode26 + (charSequence11 != null ? charSequence11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackCallReportProblem(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rating=");
        sbU.append(this.rating);
        sbU.append(", feedback=");
        sbU.append(this.feedback);
        sbU.append(", reasonCode=");
        sbU.append(this.reasonCode);
        sbU.append(", reasonDescription=");
        sbU.append(this.reasonDescription);
        sbU.append(", audioInputMode=");
        sbU.append(this.audioInputMode);
        sbU.append(", automaticAudioInputSensitivityEnabled=");
        sbU.append(this.automaticAudioInputSensitivityEnabled);
        sbU.append(", audioInputSensitivity=");
        sbU.append(this.audioInputSensitivity);
        sbU.append(", echoCancellationEnabled=");
        sbU.append(this.echoCancellationEnabled);
        sbU.append(", noiseSuppressionEnabled=");
        sbU.append(this.noiseSuppressionEnabled);
        sbU.append(", noiseCancellationEnabled=");
        sbU.append(this.noiseCancellationEnabled);
        sbU.append(", automaticGainControlEnabled=");
        sbU.append(this.automaticGainControlEnabled);
        sbU.append(", audioOutputMode=");
        sbU.append(this.audioOutputMode);
        sbU.append(", voiceOutputVolume=");
        sbU.append(this.voiceOutputVolume);
        sbU.append(", videoHardwareScalingEnabled=");
        sbU.append(this.videoHardwareScalingEnabled);
        sbU.append(", audioMode=");
        sbU.append(this.audioMode);
        sbU.append(", inputDeviceName=");
        sbU.append(this.inputDeviceName);
        sbU.append(", outputDeviceName=");
        sbU.append(this.outputDeviceName);
        sbU.append(", videoDeviceName=");
        return a.E(sbU, this.videoDeviceName, ")");
    }
}
