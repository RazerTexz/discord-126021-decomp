package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceQuality implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long averagePing = null;
    private final Long channelId = null;
    private final Long duration = null;
    private final Long guildId = null;
    private final Long maximumPing = null;
    private final Long minimumPing = null;
    private final Long previousTier = null;
    private final Float quality = null;
    private final CharSequence sessionId = null;
    private final Long speaker = null;
    private final Long tier = null;
    private final transient String analyticsSchemaTypeName = "voice_quality";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceQuality)) {
            return false;
        }
        TrackVoiceQuality trackVoiceQuality = (TrackVoiceQuality) other;
        return Intrinsics3.areEqual(this.averagePing, trackVoiceQuality.averagePing) && Intrinsics3.areEqual(this.channelId, trackVoiceQuality.channelId) && Intrinsics3.areEqual(this.duration, trackVoiceQuality.duration) && Intrinsics3.areEqual(this.guildId, trackVoiceQuality.guildId) && Intrinsics3.areEqual(this.maximumPing, trackVoiceQuality.maximumPing) && Intrinsics3.areEqual(this.minimumPing, trackVoiceQuality.minimumPing) && Intrinsics3.areEqual(this.previousTier, trackVoiceQuality.previousTier) && Intrinsics3.areEqual(this.quality, trackVoiceQuality.quality) && Intrinsics3.areEqual(this.sessionId, trackVoiceQuality.sessionId) && Intrinsics3.areEqual(this.speaker, trackVoiceQuality.speaker) && Intrinsics3.areEqual(this.tier, trackVoiceQuality.tier);
    }

    public int hashCode() {
        Long l = this.averagePing;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.duration;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.maximumPing;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.minimumPing;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.previousTier;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Float f = this.quality;
        int iHashCode8 = (iHashCode7 + (f != null ? f.hashCode() : 0)) * 31;
        CharSequence charSequence = this.sessionId;
        int iHashCode9 = (iHashCode8 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l8 = this.speaker;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.tier;
        return iHashCode10 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVoiceQuality(averagePing=");
        sbU.append(this.averagePing);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", maximumPing=");
        sbU.append(this.maximumPing);
        sbU.append(", minimumPing=");
        sbU.append(this.minimumPing);
        sbU.append(", previousTier=");
        sbU.append(this.previousTier);
        sbU.append(", quality=");
        sbU.append(this.quality);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", speaker=");
        sbU.append(this.speaker);
        sbU.append(", tier=");
        return outline.G(sbU, this.tier, ")");
    }
}
