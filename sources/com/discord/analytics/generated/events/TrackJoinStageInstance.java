package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackNetworkInformation;
import com.discord.analytics.generated.traits.TrackNetworkInformationReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackJoinStageInstance.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackJoinStageInstance implements AnalyticsSchema, TrackBaseReceiver, TrackNetworkInformationReceiver {
    private TrackBase trackBase;
    private TrackNetworkInformation trackNetworkInformation;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long channelBitrate = null;
    private final Long guildId = null;
    private final CharSequence nonce = null;
    private final CharSequence rtcConnectionId = null;
    private final Long voiceStateCount = null;
    private final Long videoStreamCount = null;
    private final Boolean videoEnabled = null;
    private final CharSequence gameName = null;
    private final CharSequence gamePlatform = null;
    private final Long gameId = null;
    private final Long customStatusCount = null;
    private final Long stageInstanceId = null;
    private final transient String analyticsSchemaTypeName = "join_stage_instance";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinStageInstance)) {
            return false;
        }
        TrackJoinStageInstance trackJoinStageInstance = (TrackJoinStageInstance) other;
        return C12238m.areEqual(this.channelId, trackJoinStageInstance.channelId) && C12238m.areEqual(this.channelType, trackJoinStageInstance.channelType) && C12238m.areEqual(this.channelBitrate, trackJoinStageInstance.channelBitrate) && C12238m.areEqual(this.guildId, trackJoinStageInstance.guildId) && C12238m.areEqual(this.nonce, trackJoinStageInstance.nonce) && C12238m.areEqual(this.rtcConnectionId, trackJoinStageInstance.rtcConnectionId) && C12238m.areEqual(this.voiceStateCount, trackJoinStageInstance.voiceStateCount) && C12238m.areEqual(this.videoStreamCount, trackJoinStageInstance.videoStreamCount) && C12238m.areEqual(this.videoEnabled, trackJoinStageInstance.videoEnabled) && C12238m.areEqual(this.gameName, trackJoinStageInstance.gameName) && C12238m.areEqual(this.gamePlatform, trackJoinStageInstance.gamePlatform) && C12238m.areEqual(this.gameId, trackJoinStageInstance.gameId) && C12238m.areEqual(this.customStatusCount, trackJoinStageInstance.customStatusCount) && C12238m.areEqual(this.stageInstanceId, trackJoinStageInstance.stageInstanceId);
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
        Long l5 = this.voiceStateCount;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.videoStreamCount;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode9 = (iHashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gameName;
        int iHashCode10 = (iHashCode9 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gamePlatform;
        int iHashCode11 = (iHashCode10 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l7 = this.gameId;
        int iHashCode12 = (iHashCode11 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.customStatusCount;
        int iHashCode13 = (iHashCode12 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.stageInstanceId;
        return iHashCode13 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackJoinStageInstance(channelId=");
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
        sbM833U.append(", customStatusCount=");
        sbM833U.append(this.customStatusCount);
        sbM833U.append(", stageInstanceId=");
        return C1643a.m819G(sbM833U, this.stageInstanceId, ")");
    }
}
