package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackLeaveVoiceChannel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLeaveVoiceChannel implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long channelBitrate = null;
    private final Long guildId = null;
    private final CharSequence nonce = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence mediaSessionId = null;
    private final Long duration = null;
    private final Long voiceStateCount = null;
    private final Long videoStreamCount = null;
    private final Boolean videoEnabled = null;
    private final CharSequence gameName = null;
    private final CharSequence gamePlatform = null;
    private final Long gameId = null;
    private final Long maxVoiceStateCount = null;
    private final Long totalVoiceStateCount = null;
    private final Long maxSpeakerCount = null;
    private final Long totalSpeakerCount = null;
    private final Long maxListenerCount = null;
    private final Long totalListenerCount = null;
    private final Long stageInstanceId = null;
    private final Long guildScheduledEventId = null;
    private final Long viewModeGridDurationMs = null;
    private final Long viewModeFocusDurationMs = null;
    private final Long viewModeToggleCount = null;
    private final transient String analyticsSchemaTypeName = "leave_voice_channel";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLeaveVoiceChannel)) {
            return false;
        }
        TrackLeaveVoiceChannel trackLeaveVoiceChannel = (TrackLeaveVoiceChannel) other;
        return Intrinsics3.areEqual(this.channelId, trackLeaveVoiceChannel.channelId) && Intrinsics3.areEqual(this.channelType, trackLeaveVoiceChannel.channelType) && Intrinsics3.areEqual(this.channelBitrate, trackLeaveVoiceChannel.channelBitrate) && Intrinsics3.areEqual(this.guildId, trackLeaveVoiceChannel.guildId) && Intrinsics3.areEqual(this.nonce, trackLeaveVoiceChannel.nonce) && Intrinsics3.areEqual(this.rtcConnectionId, trackLeaveVoiceChannel.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, trackLeaveVoiceChannel.mediaSessionId) && Intrinsics3.areEqual(this.duration, trackLeaveVoiceChannel.duration) && Intrinsics3.areEqual(this.voiceStateCount, trackLeaveVoiceChannel.voiceStateCount) && Intrinsics3.areEqual(this.videoStreamCount, trackLeaveVoiceChannel.videoStreamCount) && Intrinsics3.areEqual(this.videoEnabled, trackLeaveVoiceChannel.videoEnabled) && Intrinsics3.areEqual(this.gameName, trackLeaveVoiceChannel.gameName) && Intrinsics3.areEqual(this.gamePlatform, trackLeaveVoiceChannel.gamePlatform) && Intrinsics3.areEqual(this.gameId, trackLeaveVoiceChannel.gameId) && Intrinsics3.areEqual(this.maxVoiceStateCount, trackLeaveVoiceChannel.maxVoiceStateCount) && Intrinsics3.areEqual(this.totalVoiceStateCount, trackLeaveVoiceChannel.totalVoiceStateCount) && Intrinsics3.areEqual(this.maxSpeakerCount, trackLeaveVoiceChannel.maxSpeakerCount) && Intrinsics3.areEqual(this.totalSpeakerCount, trackLeaveVoiceChannel.totalSpeakerCount) && Intrinsics3.areEqual(this.maxListenerCount, trackLeaveVoiceChannel.maxListenerCount) && Intrinsics3.areEqual(this.totalListenerCount, trackLeaveVoiceChannel.totalListenerCount) && Intrinsics3.areEqual(this.stageInstanceId, trackLeaveVoiceChannel.stageInstanceId) && Intrinsics3.areEqual(this.guildScheduledEventId, trackLeaveVoiceChannel.guildScheduledEventId) && Intrinsics3.areEqual(this.viewModeGridDurationMs, trackLeaveVoiceChannel.viewModeGridDurationMs) && Intrinsics3.areEqual(this.viewModeFocusDurationMs, trackLeaveVoiceChannel.viewModeFocusDurationMs) && Intrinsics3.areEqual(this.viewModeToggleCount, trackLeaveVoiceChannel.viewModeToggleCount);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelBitrate;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence = this.nonce;
        int iHashCode5 = (iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.rtcConnectionId;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.mediaSessionId;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l5 = this.duration;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.voiceStateCount;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.videoStreamCount;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gameName;
        int iHashCode12 = (iHashCode11 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.gamePlatform;
        int iHashCode13 = (iHashCode12 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l8 = this.gameId;
        int iHashCode14 = (iHashCode13 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.maxVoiceStateCount;
        int iHashCode15 = (iHashCode14 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.totalVoiceStateCount;
        int iHashCode16 = (iHashCode15 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.maxSpeakerCount;
        int iHashCode17 = (iHashCode16 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.totalSpeakerCount;
        int iHashCode18 = (iHashCode17 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.maxListenerCount;
        int iHashCode19 = (iHashCode18 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.totalListenerCount;
        int iHashCode20 = (iHashCode19 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.stageInstanceId;
        int iHashCode21 = (iHashCode20 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.guildScheduledEventId;
        int iHashCode22 = (iHashCode21 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.viewModeGridDurationMs;
        int iHashCode23 = (iHashCode22 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.viewModeFocusDurationMs;
        int iHashCode24 = (iHashCode23 + (l18 != null ? l18.hashCode() : 0)) * 31;
        Long l19 = this.viewModeToggleCount;
        return iHashCode24 + (l19 != null ? l19.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackLeaveVoiceChannel(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", channelBitrate=");
        sbU.append(this.channelBitrate);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", nonce=");
        sbU.append(this.nonce);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", maxVoiceStateCount=");
        sbU.append(this.maxVoiceStateCount);
        sbU.append(", totalVoiceStateCount=");
        sbU.append(this.totalVoiceStateCount);
        sbU.append(", maxSpeakerCount=");
        sbU.append(this.maxSpeakerCount);
        sbU.append(", totalSpeakerCount=");
        sbU.append(this.totalSpeakerCount);
        sbU.append(", maxListenerCount=");
        sbU.append(this.maxListenerCount);
        sbU.append(", totalListenerCount=");
        sbU.append(this.totalListenerCount);
        sbU.append(", stageInstanceId=");
        sbU.append(this.stageInstanceId);
        sbU.append(", guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", viewModeGridDurationMs=");
        sbU.append(this.viewModeGridDurationMs);
        sbU.append(", viewModeFocusDurationMs=");
        sbU.append(this.viewModeFocusDurationMs);
        sbU.append(", viewModeToggleCount=");
        return outline.G(sbU, this.viewModeToggleCount, ")");
    }
}
