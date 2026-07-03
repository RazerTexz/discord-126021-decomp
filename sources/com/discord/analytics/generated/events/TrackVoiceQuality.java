package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceQuality implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.averagePing, trackVoiceQuality.averagePing) && C12238m.areEqual(this.channelId, trackVoiceQuality.channelId) && C12238m.areEqual(this.duration, trackVoiceQuality.duration) && C12238m.areEqual(this.guildId, trackVoiceQuality.guildId) && C12238m.areEqual(this.maximumPing, trackVoiceQuality.maximumPing) && C12238m.areEqual(this.minimumPing, trackVoiceQuality.minimumPing) && C12238m.areEqual(this.previousTier, trackVoiceQuality.previousTier) && C12238m.areEqual(this.quality, trackVoiceQuality.quality) && C12238m.areEqual(this.sessionId, trackVoiceQuality.sessionId) && C12238m.areEqual(this.speaker, trackVoiceQuality.speaker) && C12238m.areEqual(this.tier, trackVoiceQuality.tier);
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
        StringBuilder sbM833U = C1643a.m833U("TrackVoiceQuality(averagePing=");
        sbM833U.append(this.averagePing);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", duration=");
        sbM833U.append(this.duration);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", maximumPing=");
        sbM833U.append(this.maximumPing);
        sbM833U.append(", minimumPing=");
        sbM833U.append(this.minimumPing);
        sbM833U.append(", previousTier=");
        sbM833U.append(this.previousTier);
        sbM833U.append(", quality=");
        sbM833U.append(this.quality);
        sbM833U.append(", sessionId=");
        sbM833U.append(this.sessionId);
        sbM833U.append(", speaker=");
        sbM833U.append(this.speaker);
        sbM833U.append(", tier=");
        return C1643a.m819G(sbM833U, this.tier, ")");
    }
}
