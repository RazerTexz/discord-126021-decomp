package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVideoLayoutToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoLayoutToggled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long voiceStateCount = null;
    private final Long videoStreamCount = null;
    private final Boolean videoEnabled = null;
    private final CharSequence gameName = null;
    private final Long gameId = null;
    private final CharSequence videoLayout = null;
    private final CharSequence gamePlatform = null;
    private final Long streamerUserId = null;
    private final CharSequence videoStreamState = null;
    private final CharSequence mediaSessionId = null;
    private final transient String analyticsSchemaTypeName = "video_layout_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoLayoutToggled)) {
            return false;
        }
        TrackVideoLayoutToggled trackVideoLayoutToggled = (TrackVideoLayoutToggled) other;
        return Intrinsics3.areEqual(this.guildId, trackVideoLayoutToggled.guildId) && Intrinsics3.areEqual(this.channelId, trackVideoLayoutToggled.channelId) && Intrinsics3.areEqual(this.channelType, trackVideoLayoutToggled.channelType) && Intrinsics3.areEqual(this.voiceStateCount, trackVideoLayoutToggled.voiceStateCount) && Intrinsics3.areEqual(this.videoStreamCount, trackVideoLayoutToggled.videoStreamCount) && Intrinsics3.areEqual(this.videoEnabled, trackVideoLayoutToggled.videoEnabled) && Intrinsics3.areEqual(this.gameName, trackVideoLayoutToggled.gameName) && Intrinsics3.areEqual(this.gameId, trackVideoLayoutToggled.gameId) && Intrinsics3.areEqual(this.videoLayout, trackVideoLayoutToggled.videoLayout) && Intrinsics3.areEqual(this.gamePlatform, trackVideoLayoutToggled.gamePlatform) && Intrinsics3.areEqual(this.streamerUserId, trackVideoLayoutToggled.streamerUserId) && Intrinsics3.areEqual(this.videoStreamState, trackVideoLayoutToggled.videoStreamState) && Intrinsics3.areEqual(this.mediaSessionId, trackVideoLayoutToggled.mediaSessionId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.voiceStateCount;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.videoStreamCount;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence = this.gameName;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l6 = this.gameId;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.videoLayout;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gamePlatform;
        int iHashCode10 = (iHashCode9 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l7 = this.streamerUserId;
        int iHashCode11 = (iHashCode10 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.videoStreamState;
        int iHashCode12 = (iHashCode11 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.mediaSessionId;
        return iHashCode12 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoLayoutToggled(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", videoLayout=");
        sbU.append(this.videoLayout);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", streamerUserId=");
        sbU.append(this.streamerUserId);
        sbU.append(", videoStreamState=");
        sbU.append(this.videoStreamState);
        sbU.append(", mediaSessionId=");
        return outline.E(sbU, this.mediaSessionId, ")");
    }
}
