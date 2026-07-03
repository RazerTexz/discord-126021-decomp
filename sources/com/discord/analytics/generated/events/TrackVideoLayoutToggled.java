package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVideoLayoutToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoLayoutToggled implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.guildId, trackVideoLayoutToggled.guildId) && C12238m.areEqual(this.channelId, trackVideoLayoutToggled.channelId) && C12238m.areEqual(this.channelType, trackVideoLayoutToggled.channelType) && C12238m.areEqual(this.voiceStateCount, trackVideoLayoutToggled.voiceStateCount) && C12238m.areEqual(this.videoStreamCount, trackVideoLayoutToggled.videoStreamCount) && C12238m.areEqual(this.videoEnabled, trackVideoLayoutToggled.videoEnabled) && C12238m.areEqual(this.gameName, trackVideoLayoutToggled.gameName) && C12238m.areEqual(this.gameId, trackVideoLayoutToggled.gameId) && C12238m.areEqual(this.videoLayout, trackVideoLayoutToggled.videoLayout) && C12238m.areEqual(this.gamePlatform, trackVideoLayoutToggled.gamePlatform) && C12238m.areEqual(this.streamerUserId, trackVideoLayoutToggled.streamerUserId) && C12238m.areEqual(this.videoStreamState, trackVideoLayoutToggled.videoStreamState) && C12238m.areEqual(this.mediaSessionId, trackVideoLayoutToggled.mediaSessionId);
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
        StringBuilder sbM833U = C1643a.m833U("TrackVideoLayoutToggled(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", voiceStateCount=");
        sbM833U.append(this.voiceStateCount);
        sbM833U.append(", videoStreamCount=");
        sbM833U.append(this.videoStreamCount);
        sbM833U.append(", videoEnabled=");
        sbM833U.append(this.videoEnabled);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", videoLayout=");
        sbM833U.append(this.videoLayout);
        sbM833U.append(", gamePlatform=");
        sbM833U.append(this.gamePlatform);
        sbM833U.append(", streamerUserId=");
        sbM833U.append(this.streamerUserId);
        sbM833U.append(", videoStreamState=");
        sbM833U.append(this.videoStreamState);
        sbM833U.append(", mediaSessionId=");
        return C1643a.m817E(sbM833U, this.mediaSessionId, ")");
    }
}
