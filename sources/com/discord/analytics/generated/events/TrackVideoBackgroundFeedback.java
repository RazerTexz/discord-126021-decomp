package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackVideoBackgroundFeedback.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoBackgroundFeedback implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence reason = null;
    private final CharSequence rating = null;
    private final CharSequence feedback = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rtcConnectionId = null;
    private final Long duration = null;
    private final CharSequence videoDeviceName = null;
    private final Boolean videoEnabled = null;
    private final Boolean videoHardwareScalingEnabled = null;
    private final Long videoStreamCount = null;
    private final Long voiceStateCount = null;
    private final CharSequence videoEffectType = null;
    private final CharSequence videoEffectDetail = null;
    private final transient String analyticsSchemaTypeName = "video_background_feedback";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoBackgroundFeedback)) {
            return false;
        }
        TrackVideoBackgroundFeedback trackVideoBackgroundFeedback = (TrackVideoBackgroundFeedback) other;
        return m.areEqual(this.reason, trackVideoBackgroundFeedback.reason) && m.areEqual(this.rating, trackVideoBackgroundFeedback.rating) && m.areEqual(this.feedback, trackVideoBackgroundFeedback.feedback) && m.areEqual(this.guildId, trackVideoBackgroundFeedback.guildId) && m.areEqual(this.channelId, trackVideoBackgroundFeedback.channelId) && m.areEqual(this.channelType, trackVideoBackgroundFeedback.channelType) && m.areEqual(this.mediaSessionId, trackVideoBackgroundFeedback.mediaSessionId) && m.areEqual(this.rtcConnectionId, trackVideoBackgroundFeedback.rtcConnectionId) && m.areEqual(this.duration, trackVideoBackgroundFeedback.duration) && m.areEqual(this.videoDeviceName, trackVideoBackgroundFeedback.videoDeviceName) && m.areEqual(this.videoEnabled, trackVideoBackgroundFeedback.videoEnabled) && m.areEqual(this.videoHardwareScalingEnabled, trackVideoBackgroundFeedback.videoHardwareScalingEnabled) && m.areEqual(this.videoStreamCount, trackVideoBackgroundFeedback.videoStreamCount) && m.areEqual(this.voiceStateCount, trackVideoBackgroundFeedback.voiceStateCount) && m.areEqual(this.videoEffectType, trackVideoBackgroundFeedback.videoEffectType) && m.areEqual(this.videoEffectDetail, trackVideoBackgroundFeedback.videoEffectDetail);
    }

    public int hashCode() {
        CharSequence charSequence = this.reason;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.rating;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.feedback;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.mediaSessionId;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.rtcConnectionId;
        int iHashCode8 = (iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l4 = this.duration;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.videoDeviceName;
        int iHashCode10 = (iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.videoHardwareScalingEnabled;
        int iHashCode12 = (iHashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l5 = this.videoStreamCount;
        int iHashCode13 = (iHashCode12 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.voiceStateCount;
        int iHashCode14 = (iHashCode13 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.videoEffectType;
        int iHashCode15 = (iHashCode14 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.videoEffectDetail;
        return iHashCode15 + (charSequence8 != null ? charSequence8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackVideoBackgroundFeedback(reason=");
        sbU.append(this.reason);
        sbU.append(", rating=");
        sbU.append(this.rating);
        sbU.append(", feedback=");
        sbU.append(this.feedback);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", videoDeviceName=");
        sbU.append(this.videoDeviceName);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", videoHardwareScalingEnabled=");
        sbU.append(this.videoHardwareScalingEnabled);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", videoEffectType=");
        sbU.append(this.videoEffectType);
        sbU.append(", videoEffectDetail=");
        return a.E(sbU, this.videoEffectDetail, ")");
    }
}
