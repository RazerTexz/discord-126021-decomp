package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackVoiceAudioOutputModeSelected.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceAudioOutputModeSelected implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence fromAudioOutputMode = null;
    private final CharSequence toAudioOutputMode = null;
    private final transient String analyticsSchemaTypeName = "voice_audio_output_mode_selected";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceAudioOutputModeSelected)) {
            return false;
        }
        TrackVoiceAudioOutputModeSelected trackVoiceAudioOutputModeSelected = (TrackVoiceAudioOutputModeSelected) other;
        return m.areEqual(this.channelId, trackVoiceAudioOutputModeSelected.channelId) && m.areEqual(this.channelType, trackVoiceAudioOutputModeSelected.channelType) && m.areEqual(this.guildId, trackVoiceAudioOutputModeSelected.guildId) && m.areEqual(this.rtcConnectionId, trackVoiceAudioOutputModeSelected.rtcConnectionId) && m.areEqual(this.mediaSessionId, trackVoiceAudioOutputModeSelected.mediaSessionId) && m.areEqual(this.fromAudioOutputMode, trackVoiceAudioOutputModeSelected.fromAudioOutputMode) && m.areEqual(this.toAudioOutputMode, trackVoiceAudioOutputModeSelected.toAudioOutputMode);
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
        return iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackVoiceAudioOutputModeSelected(channelId=");
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
        return a.E(sbU, this.toAudioOutputMode, ")");
    }
}
