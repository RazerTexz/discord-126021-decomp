package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.channelId, trackCallReportProblem.channelId) && C12238m.areEqual(this.channelType, trackCallReportProblem.channelType) && C12238m.areEqual(this.guildId, trackCallReportProblem.guildId) && C12238m.areEqual(this.rtcConnectionId, trackCallReportProblem.rtcConnectionId) && C12238m.areEqual(this.duration, trackCallReportProblem.duration) && C12238m.areEqual(this.voiceStateCount, trackCallReportProblem.voiceStateCount) && C12238m.areEqual(this.videoStreamCount, trackCallReportProblem.videoStreamCount) && C12238m.areEqual(this.videoEnabled, trackCallReportProblem.videoEnabled) && C12238m.areEqual(this.mediaSessionId, trackCallReportProblem.mediaSessionId) && C12238m.areEqual(this.rating, trackCallReportProblem.rating) && C12238m.areEqual(this.feedback, trackCallReportProblem.feedback) && C12238m.areEqual(this.reasonCode, trackCallReportProblem.reasonCode) && C12238m.areEqual(this.reasonDescription, trackCallReportProblem.reasonDescription) && C12238m.areEqual(this.audioInputMode, trackCallReportProblem.audioInputMode) && C12238m.areEqual(this.automaticAudioInputSensitivityEnabled, trackCallReportProblem.automaticAudioInputSensitivityEnabled) && C12238m.areEqual(this.audioInputSensitivity, trackCallReportProblem.audioInputSensitivity) && C12238m.areEqual(this.echoCancellationEnabled, trackCallReportProblem.echoCancellationEnabled) && C12238m.areEqual(this.noiseSuppressionEnabled, trackCallReportProblem.noiseSuppressionEnabled) && C12238m.areEqual(this.noiseCancellationEnabled, trackCallReportProblem.noiseCancellationEnabled) && C12238m.areEqual(this.automaticGainControlEnabled, trackCallReportProblem.automaticGainControlEnabled) && C12238m.areEqual(this.audioOutputMode, trackCallReportProblem.audioOutputMode) && C12238m.areEqual(this.voiceOutputVolume, trackCallReportProblem.voiceOutputVolume) && C12238m.areEqual(this.videoHardwareScalingEnabled, trackCallReportProblem.videoHardwareScalingEnabled) && C12238m.areEqual(this.audioMode, trackCallReportProblem.audioMode) && C12238m.areEqual(this.inputDeviceName, trackCallReportProblem.inputDeviceName) && C12238m.areEqual(this.outputDeviceName, trackCallReportProblem.outputDeviceName) && C12238m.areEqual(this.videoDeviceName, trackCallReportProblem.videoDeviceName);
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
        StringBuilder sbM833U = C1643a.m833U("TrackCallReportProblem(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", duration=");
        sbM833U.append(this.duration);
        sbM833U.append(", voiceStateCount=");
        sbM833U.append(this.voiceStateCount);
        sbM833U.append(", videoStreamCount=");
        sbM833U.append(this.videoStreamCount);
        sbM833U.append(", videoEnabled=");
        sbM833U.append(this.videoEnabled);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", rating=");
        sbM833U.append(this.rating);
        sbM833U.append(", feedback=");
        sbM833U.append(this.feedback);
        sbM833U.append(", reasonCode=");
        sbM833U.append(this.reasonCode);
        sbM833U.append(", reasonDescription=");
        sbM833U.append(this.reasonDescription);
        sbM833U.append(", audioInputMode=");
        sbM833U.append(this.audioInputMode);
        sbM833U.append(", automaticAudioInputSensitivityEnabled=");
        sbM833U.append(this.automaticAudioInputSensitivityEnabled);
        sbM833U.append(", audioInputSensitivity=");
        sbM833U.append(this.audioInputSensitivity);
        sbM833U.append(", echoCancellationEnabled=");
        sbM833U.append(this.echoCancellationEnabled);
        sbM833U.append(", noiseSuppressionEnabled=");
        sbM833U.append(this.noiseSuppressionEnabled);
        sbM833U.append(", noiseCancellationEnabled=");
        sbM833U.append(this.noiseCancellationEnabled);
        sbM833U.append(", automaticGainControlEnabled=");
        sbM833U.append(this.automaticGainControlEnabled);
        sbM833U.append(", audioOutputMode=");
        sbM833U.append(this.audioOutputMode);
        sbM833U.append(", voiceOutputVolume=");
        sbM833U.append(this.voiceOutputVolume);
        sbM833U.append(", videoHardwareScalingEnabled=");
        sbM833U.append(this.videoHardwareScalingEnabled);
        sbM833U.append(", audioMode=");
        sbM833U.append(this.audioMode);
        sbM833U.append(", inputDeviceName=");
        sbM833U.append(this.inputDeviceName);
        sbM833U.append(", outputDeviceName=");
        sbM833U.append(this.outputDeviceName);
        sbM833U.append(", videoDeviceName=");
        return C1643a.m817E(sbM833U, this.videoDeviceName, ")");
    }
}
