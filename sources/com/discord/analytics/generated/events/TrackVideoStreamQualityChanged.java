package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVideoStreamQualityChanged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoStreamQualityChanged implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long guildId = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence mediaSessionId = null;
    private final Long senderUserId = null;
    private final CharSequence previousQuality = null;
    private final CharSequence quality = null;
    private final transient String analyticsSchemaTypeName = "video_stream_quality_changed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoStreamQualityChanged)) {
            return false;
        }
        TrackVideoStreamQualityChanged trackVideoStreamQualityChanged = (TrackVideoStreamQualityChanged) other;
        return C12238m.areEqual(this.channelId, trackVideoStreamQualityChanged.channelId) && C12238m.areEqual(this.guildId, trackVideoStreamQualityChanged.guildId) && C12238m.areEqual(this.rtcConnectionId, trackVideoStreamQualityChanged.rtcConnectionId) && C12238m.areEqual(this.mediaSessionId, trackVideoStreamQualityChanged.mediaSessionId) && C12238m.areEqual(this.senderUserId, trackVideoStreamQualityChanged.senderUserId) && C12238m.areEqual(this.previousQuality, trackVideoStreamQualityChanged.previousQuality) && C12238m.areEqual(this.quality, trackVideoStreamQualityChanged.quality);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.rtcConnectionId;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mediaSessionId;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.senderUserId;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.previousQuality;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.quality;
        return iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackVideoStreamQualityChanged(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", senderUserId=");
        sbM833U.append(this.senderUserId);
        sbM833U.append(", previousQuality=");
        sbM833U.append(this.previousQuality);
        sbM833U.append(", quality=");
        return C1643a.m817E(sbM833U, this.quality, ")");
    }
}
