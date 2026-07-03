package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackLeaveStageInstance.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLeaveStageInstance implements AnalyticsSchema, TrackBaseReceiver {
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
    private final transient String analyticsSchemaTypeName = "leave_stage_instance";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLeaveStageInstance)) {
            return false;
        }
        TrackLeaveStageInstance trackLeaveStageInstance = (TrackLeaveStageInstance) other;
        return C12238m.areEqual(this.channelId, trackLeaveStageInstance.channelId) && C12238m.areEqual(this.channelType, trackLeaveStageInstance.channelType) && C12238m.areEqual(this.channelBitrate, trackLeaveStageInstance.channelBitrate) && C12238m.areEqual(this.guildId, trackLeaveStageInstance.guildId) && C12238m.areEqual(this.nonce, trackLeaveStageInstance.nonce) && C12238m.areEqual(this.rtcConnectionId, trackLeaveStageInstance.rtcConnectionId) && C12238m.areEqual(this.mediaSessionId, trackLeaveStageInstance.mediaSessionId) && C12238m.areEqual(this.duration, trackLeaveStageInstance.duration) && C12238m.areEqual(this.voiceStateCount, trackLeaveStageInstance.voiceStateCount) && C12238m.areEqual(this.videoStreamCount, trackLeaveStageInstance.videoStreamCount) && C12238m.areEqual(this.videoEnabled, trackLeaveStageInstance.videoEnabled) && C12238m.areEqual(this.gameName, trackLeaveStageInstance.gameName) && C12238m.areEqual(this.gamePlatform, trackLeaveStageInstance.gamePlatform) && C12238m.areEqual(this.gameId, trackLeaveStageInstance.gameId) && C12238m.areEqual(this.maxVoiceStateCount, trackLeaveStageInstance.maxVoiceStateCount) && C12238m.areEqual(this.totalVoiceStateCount, trackLeaveStageInstance.totalVoiceStateCount) && C12238m.areEqual(this.maxSpeakerCount, trackLeaveStageInstance.maxSpeakerCount) && C12238m.areEqual(this.totalSpeakerCount, trackLeaveStageInstance.totalSpeakerCount) && C12238m.areEqual(this.maxListenerCount, trackLeaveStageInstance.maxListenerCount) && C12238m.areEqual(this.totalListenerCount, trackLeaveStageInstance.totalListenerCount) && C12238m.areEqual(this.stageInstanceId, trackLeaveStageInstance.stageInstanceId);
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
        return iHashCode20 + (l15 != null ? l15.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackLeaveStageInstance(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", channelBitrate=");
        sbM833U.append(this.channelBitrate);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", nonce=");
        sbM833U.append(this.nonce);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", duration=");
        sbM833U.append(this.duration);
        sbM833U.append(", voiceStateCount=");
        sbM833U.append(this.voiceStateCount);
        sbM833U.append(", videoStreamCount=");
        sbM833U.append(this.videoStreamCount);
        sbM833U.append(", videoEnabled=");
        sbM833U.append(this.videoEnabled);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", gamePlatform=");
        sbM833U.append(this.gamePlatform);
        sbM833U.append(", gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", maxVoiceStateCount=");
        sbM833U.append(this.maxVoiceStateCount);
        sbM833U.append(", totalVoiceStateCount=");
        sbM833U.append(this.totalVoiceStateCount);
        sbM833U.append(", maxSpeakerCount=");
        sbM833U.append(this.maxSpeakerCount);
        sbM833U.append(", totalSpeakerCount=");
        sbM833U.append(this.totalSpeakerCount);
        sbM833U.append(", maxListenerCount=");
        sbM833U.append(this.maxListenerCount);
        sbM833U.append(", totalListenerCount=");
        sbM833U.append(this.totalListenerCount);
        sbM833U.append(", stageInstanceId=");
        return C1643a.m819G(sbM833U, this.stageInstanceId, ")");
    }
}
