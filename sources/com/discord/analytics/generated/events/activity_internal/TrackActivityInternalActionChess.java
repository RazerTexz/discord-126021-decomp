package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackActivityInternalActionChess.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionChess implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final CharSequence phase = null;
    private final CharSequence moveType = null;
    private final Boolean lockedGame = null;
    private final Boolean timedGame = null;
    private final Boolean againstBot = null;
    private final CharSequence background = null;
    private final CharSequence pieceSet = null;
    private final Long numSpectators = null;
    private final CharSequence playerColor = null;
    private final CharSequence lastScreen = null;
    private final Long reconnectTime = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_chess";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionChess)) {
            return false;
        }
        TrackActivityInternalActionChess trackActivityInternalActionChess = (TrackActivityInternalActionChess) other;
        return m.areEqual(this.actionName, trackActivityInternalActionChess.actionName) && m.areEqual(this.phase, trackActivityInternalActionChess.phase) && m.areEqual(this.moveType, trackActivityInternalActionChess.moveType) && m.areEqual(this.lockedGame, trackActivityInternalActionChess.lockedGame) && m.areEqual(this.timedGame, trackActivityInternalActionChess.timedGame) && m.areEqual(this.againstBot, trackActivityInternalActionChess.againstBot) && m.areEqual(this.background, trackActivityInternalActionChess.background) && m.areEqual(this.pieceSet, trackActivityInternalActionChess.pieceSet) && m.areEqual(this.numSpectators, trackActivityInternalActionChess.numSpectators) && m.areEqual(this.playerColor, trackActivityInternalActionChess.playerColor) && m.areEqual(this.lastScreen, trackActivityInternalActionChess.lastScreen) && m.areEqual(this.reconnectTime, trackActivityInternalActionChess.reconnectTime);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.phase;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.moveType;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Boolean bool = this.lockedGame;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.timedGame;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.againstBot;
        int iHashCode6 = (iHashCode5 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.background;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.pieceSet;
        int iHashCode8 = (iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l = this.numSpectators;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.playerColor;
        int iHashCode10 = (iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.lastScreen;
        int iHashCode11 = (iHashCode10 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Long l2 = this.reconnectTime;
        return iHashCode11 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackActivityInternalActionChess(actionName=");
        sbU.append(this.actionName);
        sbU.append(", phase=");
        sbU.append(this.phase);
        sbU.append(", moveType=");
        sbU.append(this.moveType);
        sbU.append(", lockedGame=");
        sbU.append(this.lockedGame);
        sbU.append(", timedGame=");
        sbU.append(this.timedGame);
        sbU.append(", againstBot=");
        sbU.append(this.againstBot);
        sbU.append(", background=");
        sbU.append(this.background);
        sbU.append(", pieceSet=");
        sbU.append(this.pieceSet);
        sbU.append(", numSpectators=");
        sbU.append(this.numSpectators);
        sbU.append(", playerColor=");
        sbU.append(this.playerColor);
        sbU.append(", lastScreen=");
        sbU.append(this.lastScreen);
        sbU.append(", reconnectTime=");
        return a.G(sbU, this.reconnectTime, ")");
    }
}
