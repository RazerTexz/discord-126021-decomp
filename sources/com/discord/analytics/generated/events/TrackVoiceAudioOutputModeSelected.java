package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.channelId, trackVoiceAudioOutputModeSelected.channelId) && C12238m.areEqual(this.channelType, trackVoiceAudioOutputModeSelected.channelType) && C12238m.areEqual(this.guildId, trackVoiceAudioOutputModeSelected.guildId) && C12238m.areEqual(this.rtcConnectionId, trackVoiceAudioOutputModeSelected.rtcConnectionId) && C12238m.areEqual(this.mediaSessionId, trackVoiceAudioOutputModeSelected.mediaSessionId) && C12238m.areEqual(this.fromAudioOutputMode, trackVoiceAudioOutputModeSelected.fromAudioOutputMode) && C12238m.areEqual(this.toAudioOutputMode, trackVoiceAudioOutputModeSelected.toAudioOutputMode);
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
        StringBuilder sbM833U = C1643a.m833U("TrackVoiceAudioOutputModeSelected(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", fromAudioOutputMode=");
        sbM833U.append(this.fromAudioOutputMode);
        sbM833U.append(", toAudioOutputMode=");
        return C1643a.m817E(sbM833U, this.toAudioOutputMode, ")");
    }
}
