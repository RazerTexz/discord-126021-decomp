package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackNetworkInformation;
import com.discord.analytics.generated.traits.TrackNetworkInformation2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVideoStreamStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoStreamStarted implements AnalyticsSchema, TrackBase2, TrackNetworkInformation2 {
    private TrackBase trackBase;
    private TrackNetworkInformation trackNetworkInformation;
    private final Long guildId = null;
    private final Long channelId = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence parentMediaSessionId = null;
    private final Long senderUserId = null;
    private final CharSequence context = null;
    private final CharSequence participantType = null;
    private final CharSequence shareApplicationName = null;
    private final Long shareApplicationId = null;
    private final CharSequence shareApplicationExecutable = null;
    private final CharSequence streamRegion = null;
    private final CharSequence guildRegion = null;
    private final CharSequence videoLayout = null;
    private final Long videoInputResolution = null;
    private final Long videoInputFrameRate = null;
    private final CharSequence soundshareSession = null;
    private final CharSequence shareGameName = null;
    private final Long shareGameId = null;
    private final transient String analyticsSchemaTypeName = "video_stream_started";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoStreamStarted)) {
            return false;
        }
        TrackVideoStreamStarted trackVideoStreamStarted = (TrackVideoStreamStarted) other;
        return Intrinsics3.areEqual(this.guildId, trackVideoStreamStarted.guildId) && Intrinsics3.areEqual(this.channelId, trackVideoStreamStarted.channelId) && Intrinsics3.areEqual(this.rtcConnectionId, trackVideoStreamStarted.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, trackVideoStreamStarted.mediaSessionId) && Intrinsics3.areEqual(this.parentMediaSessionId, trackVideoStreamStarted.parentMediaSessionId) && Intrinsics3.areEqual(this.senderUserId, trackVideoStreamStarted.senderUserId) && Intrinsics3.areEqual(this.context, trackVideoStreamStarted.context) && Intrinsics3.areEqual(this.participantType, trackVideoStreamStarted.participantType) && Intrinsics3.areEqual(this.shareApplicationName, trackVideoStreamStarted.shareApplicationName) && Intrinsics3.areEqual(this.shareApplicationId, trackVideoStreamStarted.shareApplicationId) && Intrinsics3.areEqual(this.shareApplicationExecutable, trackVideoStreamStarted.shareApplicationExecutable) && Intrinsics3.areEqual(this.streamRegion, trackVideoStreamStarted.streamRegion) && Intrinsics3.areEqual(this.guildRegion, trackVideoStreamStarted.guildRegion) && Intrinsics3.areEqual(this.videoLayout, trackVideoStreamStarted.videoLayout) && Intrinsics3.areEqual(this.videoInputResolution, trackVideoStreamStarted.videoInputResolution) && Intrinsics3.areEqual(this.videoInputFrameRate, trackVideoStreamStarted.videoInputFrameRate) && Intrinsics3.areEqual(this.soundshareSession, trackVideoStreamStarted.soundshareSession) && Intrinsics3.areEqual(this.shareGameName, trackVideoStreamStarted.shareGameName) && Intrinsics3.areEqual(this.shareGameId, trackVideoStreamStarted.shareGameId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.rtcConnectionId;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mediaSessionId;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.parentMediaSessionId;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l3 = this.senderUserId;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.context;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.participantType;
        int iHashCode8 = (iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.shareApplicationName;
        int iHashCode9 = (iHashCode8 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l4 = this.shareApplicationId;
        int iHashCode10 = (iHashCode9 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.shareApplicationExecutable;
        int iHashCode11 = (iHashCode10 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.streamRegion;
        int iHashCode12 = (iHashCode11 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.guildRegion;
        int iHashCode13 = (iHashCode12 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.videoLayout;
        int iHashCode14 = (iHashCode13 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        Long l5 = this.videoInputResolution;
        int iHashCode15 = (iHashCode14 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.videoInputFrameRate;
        int iHashCode16 = (iHashCode15 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence11 = this.soundshareSession;
        int iHashCode17 = (iHashCode16 + (charSequence11 != null ? charSequence11.hashCode() : 0)) * 31;
        CharSequence charSequence12 = this.shareGameName;
        int iHashCode18 = (iHashCode17 + (charSequence12 != null ? charSequence12.hashCode() : 0)) * 31;
        Long l7 = this.shareGameId;
        return iHashCode18 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoStreamStarted(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", parentMediaSessionId=");
        sbU.append(this.parentMediaSessionId);
        sbU.append(", senderUserId=");
        sbU.append(this.senderUserId);
        sbU.append(", context=");
        sbU.append(this.context);
        sbU.append(", participantType=");
        sbU.append(this.participantType);
        sbU.append(", shareApplicationName=");
        sbU.append(this.shareApplicationName);
        sbU.append(", shareApplicationId=");
        sbU.append(this.shareApplicationId);
        sbU.append(", shareApplicationExecutable=");
        sbU.append(this.shareApplicationExecutable);
        sbU.append(", streamRegion=");
        sbU.append(this.streamRegion);
        sbU.append(", guildRegion=");
        sbU.append(this.guildRegion);
        sbU.append(", videoLayout=");
        sbU.append(this.videoLayout);
        sbU.append(", videoInputResolution=");
        sbU.append(this.videoInputResolution);
        sbU.append(", videoInputFrameRate=");
        sbU.append(this.videoInputFrameRate);
        sbU.append(", soundshareSession=");
        sbU.append(this.soundshareSession);
        sbU.append(", shareGameName=");
        sbU.append(this.shareGameName);
        sbU.append(", shareGameId=");
        return outline.G(sbU, this.shareGameId, ")");
    }
}
