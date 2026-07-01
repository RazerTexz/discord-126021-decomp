package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.channelId, trackVideoStreamQualityChanged.channelId) && m.areEqual(this.guildId, trackVideoStreamQualityChanged.guildId) && m.areEqual(this.rtcConnectionId, trackVideoStreamQualityChanged.rtcConnectionId) && m.areEqual(this.mediaSessionId, trackVideoStreamQualityChanged.mediaSessionId) && m.areEqual(this.senderUserId, trackVideoStreamQualityChanged.senderUserId) && m.areEqual(this.previousQuality, trackVideoStreamQualityChanged.previousQuality) && m.areEqual(this.quality, trackVideoStreamQualityChanged.quality);
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
        StringBuilder sbU = a.U("TrackVideoStreamQualityChanged(channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", senderUserId=");
        sbU.append(this.senderUserId);
        sbU.append(", previousQuality=");
        sbU.append(this.previousQuality);
        sbU.append(", quality=");
        return a.E(sbU, this.quality, ")");
    }
}
