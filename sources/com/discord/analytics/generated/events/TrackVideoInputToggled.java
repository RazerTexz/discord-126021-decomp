package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.channelId, trackVideoInputToggled.channelId) && C12238m.areEqual(this.channelType, trackVideoInputToggled.channelType) && C12238m.areEqual(this.guildId, trackVideoInputToggled.guildId) && C12238m.areEqual(this.nonce, trackVideoInputToggled.nonce) && C12238m.areEqual(this.voiceStateCount, trackVideoInputToggled.voiceStateCount) && C12238m.areEqual(this.videoStreamCount, trackVideoInputToggled.videoStreamCount) && C12238m.areEqual(this.videoEnabled, trackVideoInputToggled.videoEnabled) && C12238m.areEqual(this.gameName, trackVideoInputToggled.gameName) && C12238m.areEqual(this.gameExeName, trackVideoInputToggled.gameExeName) && C12238m.areEqual(this.gameId, trackVideoInputToggled.gameId) && C12238m.areEqual(this.videoInputType, trackVideoInputToggled.videoInputType) && C12238m.areEqual(this.videoInputResolution, trackVideoInputToggled.videoInputResolution) && C12238m.areEqual(this.videoInputFrameRate, trackVideoInputToggled.videoInputFrameRate) && C12238m.areEqual(this.soundshareSession, trackVideoInputToggled.soundshareSession) && C12238m.areEqual(this.shareGameName, trackVideoInputToggled.shareGameName) && C12238m.areEqual(this.shareGameId, trackVideoInputToggled.shareGameId) && C12238m.areEqual(this.gamePlatform, trackVideoInputToggled.gamePlatform) && C12238m.areEqual(this.source, trackVideoInputToggled.source) && C12238m.areEqual(this.videoToggleSource, trackVideoInputToggled.videoToggleSource) && C12238m.areEqual(this.mediaSessionId, trackVideoInputToggled.mediaSessionId) && C12238m.areEqual(this.enabledInputs, trackVideoInputToggled.enabledInputs) && C12238m.areEqual(this.previewEnabled, trackVideoInputToggled.previewEnabled);
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
        StringBuilder sbM833U = C1643a.m833U("TrackVideoInputToggled(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", nonce=");
        sbM833U.append(this.nonce);
        sbM833U.append(", voiceStateCount=");
        sbM833U.append(this.voiceStateCount);
        sbM833U.append(", videoStreamCount=");
        sbM833U.append(this.videoStreamCount);
        sbM833U.append(", videoEnabled=");
        sbM833U.append(this.videoEnabled);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", gameExeName=");
        sbM833U.append(this.gameExeName);
        sbM833U.append(", gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", videoInputType=");
        sbM833U.append(this.videoInputType);
        sbM833U.append(", videoInputResolution=");
        sbM833U.append(this.videoInputResolution);
        sbM833U.append(", videoInputFrameRate=");
        sbM833U.append(this.videoInputFrameRate);
        sbM833U.append(", soundshareSession=");
        sbM833U.append(this.soundshareSession);
        sbM833U.append(", shareGameName=");
        sbM833U.append(this.shareGameName);
        sbM833U.append(", shareGameId=");
        sbM833U.append(this.shareGameId);
        sbM833U.append(", gamePlatform=");
        sbM833U.append(this.gamePlatform);
        sbM833U.append(", source=");
        sbM833U.append(this.source);
        sbM833U.append(", videoToggleSource=");
        sbM833U.append(this.videoToggleSource);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", enabledInputs=");
        sbM833U.append(this.enabledInputs);
        sbM833U.append(", previewEnabled=");
        return C1643a.m816D(sbM833U, this.previewEnabled, ")");
    }
}
