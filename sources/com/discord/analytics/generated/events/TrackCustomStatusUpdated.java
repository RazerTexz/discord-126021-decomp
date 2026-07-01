package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackCustomStatusUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCustomStatusUpdated implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackLocationMetadata2, TrackSourceMetadata2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private final Boolean hasEmoji = null;
    private final CharSequence emojiType = null;
    private final Long textLen = null;
    private final CharSequence clearAfter = null;
    private final Long voiceChannelId = null;
    private final Long voiceChannelVoiceStateCount = null;
    private final transient String analyticsSchemaTypeName = "custom_status_updated";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCustomStatusUpdated)) {
            return false;
        }
        TrackCustomStatusUpdated trackCustomStatusUpdated = (TrackCustomStatusUpdated) other;
        return Intrinsics3.areEqual(this.hasEmoji, trackCustomStatusUpdated.hasEmoji) && Intrinsics3.areEqual(this.emojiType, trackCustomStatusUpdated.emojiType) && Intrinsics3.areEqual(this.textLen, trackCustomStatusUpdated.textLen) && Intrinsics3.areEqual(this.clearAfter, trackCustomStatusUpdated.clearAfter) && Intrinsics3.areEqual(this.voiceChannelId, trackCustomStatusUpdated.voiceChannelId) && Intrinsics3.areEqual(this.voiceChannelVoiceStateCount, trackCustomStatusUpdated.voiceChannelVoiceStateCount);
    }

    public int hashCode() {
        Boolean bool = this.hasEmoji;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.emojiType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.textLen;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.clearAfter;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.voiceChannelId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.voiceChannelVoiceStateCount;
        return iHashCode5 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCustomStatusUpdated(hasEmoji=");
        sbU.append(this.hasEmoji);
        sbU.append(", emojiType=");
        sbU.append(this.emojiType);
        sbU.append(", textLen=");
        sbU.append(this.textLen);
        sbU.append(", clearAfter=");
        sbU.append(this.clearAfter);
        sbU.append(", voiceChannelId=");
        sbU.append(this.voiceChannelId);
        sbU.append(", voiceChannelVoiceStateCount=");
        return outline.G(sbU, this.voiceChannelVoiceStateCount, ")");
    }
}
