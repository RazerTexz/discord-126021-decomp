package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackVideoInputToggled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoInputToggled implements AnalyticsSchema, TrackBaseReceiver {
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
        return m.areEqual(this.channelId, trackVideoInputToggled.channelId) && m.areEqual(this.channelType, trackVideoInputToggled.channelType) && m.areEqual(this.guildId, trackVideoInputToggled.guildId) && m.areEqual(this.nonce, trackVideoInputToggled.nonce) && m.areEqual(this.voiceStateCount, trackVideoInputToggled.voiceStateCount) && m.areEqual(this.videoStreamCount, trackVideoInputToggled.videoStreamCount) && m.areEqual(this.videoEnabled, trackVideoInputToggled.videoEnabled) && m.areEqual(this.gameName, trackVideoInputToggled.gameName) && m.areEqual(this.gameExeName, trackVideoInputToggled.gameExeName) && m.areEqual(this.gameId, trackVideoInputToggled.gameId) && m.areEqual(this.videoInputType, trackVideoInputToggled.videoInputType) && m.areEqual(this.videoInputResolution, trackVideoInputToggled.videoInputResolution) && m.areEqual(this.videoInputFrameRate, trackVideoInputToggled.videoInputFrameRate) && m.areEqual(this.soundshareSession, trackVideoInputToggled.soundshareSession) && m.areEqual(this.shareGameName, trackVideoInputToggled.shareGameName) && m.areEqual(this.shareGameId, trackVideoInputToggled.shareGameId) && m.areEqual(this.gamePlatform, trackVideoInputToggled.gamePlatform) && m.areEqual(this.source, trackVideoInputToggled.source) && m.areEqual(this.videoToggleSource, trackVideoInputToggled.videoToggleSource) && m.areEqual(this.mediaSessionId, trackVideoInputToggled.mediaSessionId) && m.areEqual(this.enabledInputs, trackVideoInputToggled.enabledInputs) && m.areEqual(this.previewEnabled, trackVideoInputToggled.previewEnabled);
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
        StringBuilder sbU = a.U("TrackVideoInputToggled(channelId=");
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
        return a.D(sbU, this.previewEnabled, ")");
    }
}
