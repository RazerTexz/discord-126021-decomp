package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVoiceAudioOutputModeEnabled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceAudioOutputModeEnabled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence fromAudioOutputMode = null;
    private final CharSequence toAudioOutputMode = null;
    private final Long videoStreamCount = null;
    private final Long voiceStateCount = null;
    private final transient String analyticsSchemaTypeName = "voice_audio_output_mode_enabled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceAudioOutputModeEnabled)) {
            return false;
        }
        TrackVoiceAudioOutputModeEnabled trackVoiceAudioOutputModeEnabled = (TrackVoiceAudioOutputModeEnabled) other;
        return Intrinsics3.areEqual(this.channelId, trackVoiceAudioOutputModeEnabled.channelId) && Intrinsics3.areEqual(this.channelType, trackVoiceAudioOutputModeEnabled.channelType) && Intrinsics3.areEqual(this.guildId, trackVoiceAudioOutputModeEnabled.guildId) && Intrinsics3.areEqual(this.rtcConnectionId, trackVoiceAudioOutputModeEnabled.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, trackVoiceAudioOutputModeEnabled.mediaSessionId) && Intrinsics3.areEqual(this.fromAudioOutputMode, trackVoiceAudioOutputModeEnabled.fromAudioOutputMode) && Intrinsics3.areEqual(this.toAudioOutputMode, trackVoiceAudioOutputModeEnabled.toAudioOutputMode) && Intrinsics3.areEqual(this.videoStreamCount, trackVoiceAudioOutputModeEnabled.videoStreamCount) && Intrinsics3.areEqual(this.voiceStateCount, trackVoiceAudioOutputModeEnabled.voiceStateCount);
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
        CharSequence charSequence2 = this.mediaSessionId;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.fromAudioOutputMode;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.toAudioOutputMode;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l4 = this.videoStreamCount;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.voiceStateCount;
        return iHashCode8 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVoiceAudioOutputModeEnabled(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", fromAudioOutputMode=");
        sbU.append(this.fromAudioOutputMode);
        sbU.append(", toAudioOutputMode=");
        sbU.append(this.toAudioOutputMode);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", voiceStateCount=");
        return outline.G(sbU, this.voiceStateCount, ")");
    }
}
