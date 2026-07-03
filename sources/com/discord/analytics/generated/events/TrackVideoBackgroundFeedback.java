package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.reason, trackVideoBackgroundFeedback.reason) && C12238m.areEqual(this.rating, trackVideoBackgroundFeedback.rating) && C12238m.areEqual(this.feedback, trackVideoBackgroundFeedback.feedback) && C12238m.areEqual(this.guildId, trackVideoBackgroundFeedback.guildId) && C12238m.areEqual(this.channelId, trackVideoBackgroundFeedback.channelId) && C12238m.areEqual(this.channelType, trackVideoBackgroundFeedback.channelType) && C12238m.areEqual(this.mediaSessionId, trackVideoBackgroundFeedback.mediaSessionId) && C12238m.areEqual(this.rtcConnectionId, trackVideoBackgroundFeedback.rtcConnectionId) && C12238m.areEqual(this.duration, trackVideoBackgroundFeedback.duration) && C12238m.areEqual(this.videoDeviceName, trackVideoBackgroundFeedback.videoDeviceName) && C12238m.areEqual(this.videoEnabled, trackVideoBackgroundFeedback.videoEnabled) && C12238m.areEqual(this.videoHardwareScalingEnabled, trackVideoBackgroundFeedback.videoHardwareScalingEnabled) && C12238m.areEqual(this.videoStreamCount, trackVideoBackgroundFeedback.videoStreamCount) && C12238m.areEqual(this.voiceStateCount, trackVideoBackgroundFeedback.voiceStateCount) && C12238m.areEqual(this.videoEffectType, trackVideoBackgroundFeedback.videoEffectType) && C12238m.areEqual(this.videoEffectDetail, trackVideoBackgroundFeedback.videoEffectDetail);
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
        StringBuilder sbM833U = C1643a.m833U("TrackVideoBackgroundFeedback(reason=");
        sbM833U.append(this.reason);
        sbM833U.append(", rating=");
        sbM833U.append(this.rating);
        sbM833U.append(", feedback=");
        sbM833U.append(this.feedback);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", duration=");
        sbM833U.append(this.duration);
        sbM833U.append(", videoDeviceName=");
        sbM833U.append(this.videoDeviceName);
        sbM833U.append(", videoEnabled=");
        sbM833U.append(this.videoEnabled);
        sbM833U.append(", videoHardwareScalingEnabled=");
        sbM833U.append(this.videoHardwareScalingEnabled);
        sbM833U.append(", videoStreamCount=");
        sbM833U.append(this.videoStreamCount);
        sbM833U.append(", voiceStateCount=");
        sbM833U.append(this.voiceStateCount);
        sbM833U.append(", videoEffectType=");
        sbM833U.append(this.videoEffectType);
        sbM833U.append(", videoEffectDetail=");
        return C1643a.m817E(sbM833U, this.videoEffectDetail, ")");
    }
}
