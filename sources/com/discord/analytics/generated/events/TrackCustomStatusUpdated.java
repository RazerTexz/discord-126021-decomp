package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackCustomStatusUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackCustomStatusUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackLocationMetadataReceiver, TrackSourceMetadataReceiver {
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

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        return C12238m.areEqual(this.hasEmoji, trackCustomStatusUpdated.hasEmoji) && C12238m.areEqual(this.emojiType, trackCustomStatusUpdated.emojiType) && C12238m.areEqual(this.textLen, trackCustomStatusUpdated.textLen) && C12238m.areEqual(this.clearAfter, trackCustomStatusUpdated.clearAfter) && C12238m.areEqual(this.voiceChannelId, trackCustomStatusUpdated.voiceChannelId) && C12238m.areEqual(this.voiceChannelVoiceStateCount, trackCustomStatusUpdated.voiceChannelVoiceStateCount);
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
        StringBuilder sbM833U = C1643a.m833U("TrackCustomStatusUpdated(hasEmoji=");
        sbM833U.append(this.hasEmoji);
        sbM833U.append(", emojiType=");
        sbM833U.append(this.emojiType);
        sbM833U.append(", textLen=");
        sbM833U.append(this.textLen);
        sbM833U.append(", clearAfter=");
        sbM833U.append(this.clearAfter);
        sbM833U.append(", voiceChannelId=");
        sbM833U.append(this.voiceChannelId);
        sbM833U.append(", voiceChannelVoiceStateCount=");
        return C1643a.m819G(sbM833U, this.voiceChannelVoiceStateCount, ")");
    }
}
