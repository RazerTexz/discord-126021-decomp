package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVideoEffectUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoEffectUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence effectType = null;
    private final CharSequence effectDetail = null;
    private final CharSequence effectState = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final Long videoStreamCount = null;
    private final Long voiceStateCount = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rtcConnectionId = null;
    private final Boolean isAnimated = null;
    private final transient String analyticsSchemaTypeName = "video_effect_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoEffectUpdated)) {
            return false;
        }
        TrackVideoEffectUpdated trackVideoEffectUpdated = (TrackVideoEffectUpdated) other;
        return C12238m.areEqual(this.effectType, trackVideoEffectUpdated.effectType) && C12238m.areEqual(this.effectDetail, trackVideoEffectUpdated.effectDetail) && C12238m.areEqual(this.effectState, trackVideoEffectUpdated.effectState) && C12238m.areEqual(this.channelId, trackVideoEffectUpdated.channelId) && C12238m.areEqual(this.channelType, trackVideoEffectUpdated.channelType) && C12238m.areEqual(this.guildId, trackVideoEffectUpdated.guildId) && C12238m.areEqual(this.videoStreamCount, trackVideoEffectUpdated.videoStreamCount) && C12238m.areEqual(this.voiceStateCount, trackVideoEffectUpdated.voiceStateCount) && C12238m.areEqual(this.mediaSessionId, trackVideoEffectUpdated.mediaSessionId) && C12238m.areEqual(this.rtcConnectionId, trackVideoEffectUpdated.rtcConnectionId) && C12238m.areEqual(this.isAnimated, trackVideoEffectUpdated.isAnimated);
    }

    public int hashCode() {
        CharSequence charSequence = this.effectType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.effectDetail;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.effectState;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.channelId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelType;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.videoStreamCount;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.voiceStateCount;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.mediaSessionId;
        int iHashCode9 = (iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.rtcConnectionId;
        int iHashCode10 = (iHashCode9 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Boolean bool = this.isAnimated;
        return iHashCode10 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackVideoEffectUpdated(effectType=");
        sbM833U.append(this.effectType);
        sbM833U.append(", effectDetail=");
        sbM833U.append(this.effectDetail);
        sbM833U.append(", effectState=");
        sbM833U.append(this.effectState);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", videoStreamCount=");
        sbM833U.append(this.videoStreamCount);
        sbM833U.append(", voiceStateCount=");
        sbM833U.append(this.voiceStateCount);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", isAnimated=");
        return C1643a.m816D(sbM833U, this.isAnimated, ")");
    }
}
