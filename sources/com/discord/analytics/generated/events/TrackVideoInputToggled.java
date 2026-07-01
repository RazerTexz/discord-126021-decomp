package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackVideoInputToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoInputToggled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final CharSequence nonce = null;
    private final Long voiceStateCount = null;
    private final Long videoStreamCount = null;
    private final Boolean videoEnabled = null;
    private final CharSequence gameName = null;
    private final CharSequence gameExeName = null;
    private final Long gameId = null;
    private final CharSequence videoInputType = null;
    private final Long videoInputResolution = null;
    private final Long videoInputFrameRate = null;
    private final CharSequence soundshareSession = null;
    private final CharSequence shareGameName = null;
    private final Long shareGameId = null;
    private final CharSequence gamePlatform = null;
    private final CharSequence source = null;
    private final CharSequence videoToggleSource = null;
    private final CharSequence mediaSessionId = null;
    private final List<CharSequence> enabledInputs = null;
    private final Boolean previewEnabled = null;
    private final transient String analyticsSchemaTypeName = "video_input_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoInputToggled)) {
            return false;
        }
        TrackVideoInputToggled trackVideoInputToggled = (TrackVideoInputToggled) other;
        return Intrinsics3.areEqual(this.channelId, trackVideoInputToggled.channelId) && Intrinsics3.areEqual(this.channelType, trackVideoInputToggled.channelType) && Intrinsics3.areEqual(this.guildId, trackVideoInputToggled.guildId) && Intrinsics3.areEqual(this.nonce, trackVideoInputToggled.nonce) && Intrinsics3.areEqual(this.voiceStateCount, trackVideoInputToggled.voiceStateCount) && Intrinsics3.areEqual(this.videoStreamCount, trackVideoInputToggled.videoStreamCount) && Intrinsics3.areEqual(this.videoEnabled, trackVideoInputToggled.videoEnabled) && Intrinsics3.areEqual(this.gameName, trackVideoInputToggled.gameName) && Intrinsics3.areEqual(this.gameExeName, trackVideoInputToggled.gameExeName) && Intrinsics3.areEqual(this.gameId, trackVideoInputToggled.gameId) && Intrinsics3.areEqual(this.videoInputType, trackVideoInputToggled.videoInputType) && Intrinsics3.areEqual(this.videoInputResolution, trackVideoInputToggled.videoInputResolution) && Intrinsics3.areEqual(this.videoInputFrameRate, trackVideoInputToggled.videoInputFrameRate) && Intrinsics3.areEqual(this.soundshareSession, trackVideoInputToggled.soundshareSession) && Intrinsics3.areEqual(this.shareGameName, trackVideoInputToggled.shareGameName) && Intrinsics3.areEqual(this.shareGameId, trackVideoInputToggled.shareGameId) && Intrinsics3.areEqual(this.gamePlatform, trackVideoInputToggled.gamePlatform) && Intrinsics3.areEqual(this.source, trackVideoInputToggled.source) && Intrinsics3.areEqual(this.videoToggleSource, trackVideoInputToggled.videoToggleSource) && Intrinsics3.areEqual(this.mediaSessionId, trackVideoInputToggled.mediaSessionId) && Intrinsics3.areEqual(this.enabledInputs, trackVideoInputToggled.enabledInputs) && Intrinsics3.areEqual(this.previewEnabled, trackVideoInputToggled.previewEnabled);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.nonce;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.voiceStateCount;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.videoStreamCount;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.gameName;
        int iHashCode8 = (iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gameExeName;
        int iHashCode9 = (iHashCode8 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l6 = this.gameId;
        int iHashCode10 = (iHashCode9 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.videoInputType;
        int iHashCode11 = (iHashCode10 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l7 = this.videoInputResolution;
        int iHashCode12 = (iHashCode11 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.videoInputFrameRate;
        int iHashCode13 = (iHashCode12 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.soundshareSession;
        int iHashCode14 = (iHashCode13 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.shareGameName;
        int iHashCode15 = (iHashCode14 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l9 = this.shareGameId;
        int iHashCode16 = (iHashCode15 + (l9 != null ? l9.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.gamePlatform;
        int iHashCode17 = (iHashCode16 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.source;
        int iHashCode18 = (iHashCode17 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.videoToggleSource;
        int iHashCode19 = (iHashCode18 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.mediaSessionId;
        int iHashCode20 = (iHashCode19 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        List<CharSequence> list = this.enabledInputs;
        int iHashCode21 = (iHashCode20 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool2 = this.previewEnabled;
        return iHashCode21 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoInputToggled(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", nonce=");
        sbU.append(this.nonce);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameExeName=");
        sbU.append(this.gameExeName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", videoInputType=");
        sbU.append(this.videoInputType);
        sbU.append(", videoInputResolution=");
        sbU.append(this.videoInputResolution);
        sbU.append(", videoInputFrameRate=");
        sbU.append(this.videoInputFrameRate);
        sbU.append(", soundshareSession=");
        sbU.append(this.soundshareSession);
        sbU.append(", shareGameName=");
        sbU.append(this.shareGameName);
        sbU.append(", shareGameId=");
        sbU.append(this.shareGameId);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", videoToggleSource=");
        sbU.append(this.videoToggleSource);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", enabledInputs=");
        sbU.append(this.enabledInputs);
        sbU.append(", previewEnabled=");
        return outline.D(sbU, this.previewEnabled, ")");
    }
}
