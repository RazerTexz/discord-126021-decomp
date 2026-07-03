package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityInternalActionCheckers.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionCheckers implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final CharSequence phase = null;
    private final CharSequence moveType = null;
    private final CharSequence interestingMoveType = null;
    private final Boolean lockedGame = null;
    private final Boolean timedGame = null;
    private final Boolean againstBot = null;
    private final CharSequence background = null;
    private final CharSequence pieceSet = null;
    private final Long numSpectators = null;
    private final CharSequence playerColor = null;
    private final CharSequence lastScreen = null;
    private final Long jumpCount = null;
    private final Long reconnectTime = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_checkers";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionCheckers)) {
            return false;
        }
        TrackActivityInternalActionCheckers trackActivityInternalActionCheckers = (TrackActivityInternalActionCheckers) other;
        return C12238m.areEqual(this.actionName, trackActivityInternalActionCheckers.actionName) && C12238m.areEqual(this.phase, trackActivityInternalActionCheckers.phase) && C12238m.areEqual(this.moveType, trackActivityInternalActionCheckers.moveType) && C12238m.areEqual(this.interestingMoveType, trackActivityInternalActionCheckers.interestingMoveType) && C12238m.areEqual(this.lockedGame, trackActivityInternalActionCheckers.lockedGame) && C12238m.areEqual(this.timedGame, trackActivityInternalActionCheckers.timedGame) && C12238m.areEqual(this.againstBot, trackActivityInternalActionCheckers.againstBot) && C12238m.areEqual(this.background, trackActivityInternalActionCheckers.background) && C12238m.areEqual(this.pieceSet, trackActivityInternalActionCheckers.pieceSet) && C12238m.areEqual(this.numSpectators, trackActivityInternalActionCheckers.numSpectators) && C12238m.areEqual(this.playerColor, trackActivityInternalActionCheckers.playerColor) && C12238m.areEqual(this.lastScreen, trackActivityInternalActionCheckers.lastScreen) && C12238m.areEqual(this.jumpCount, trackActivityInternalActionCheckers.jumpCount) && C12238m.areEqual(this.reconnectTime, trackActivityInternalActionCheckers.reconnectTime);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.phase;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.moveType;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.interestingMoveType;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Boolean bool = this.lockedGame;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.timedGame;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.againstBot;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.background;
        int iHashCode8 = (iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.pieceSet;
        int iHashCode9 = (iHashCode8 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l = this.numSpectators;
        int iHashCode10 = (iHashCode9 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.playerColor;
        int iHashCode11 = (iHashCode10 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.lastScreen;
        int iHashCode12 = (iHashCode11 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        Long l2 = this.jumpCount;
        int iHashCode13 = (iHashCode12 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.reconnectTime;
        return iHashCode13 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalActionCheckers(actionName=");
        sbM833U.append(this.actionName);
        sbM833U.append(", phase=");
        sbM833U.append(this.phase);
        sbM833U.append(", moveType=");
        sbM833U.append(this.moveType);
        sbM833U.append(", interestingMoveType=");
        sbM833U.append(this.interestingMoveType);
        sbM833U.append(", lockedGame=");
        sbM833U.append(this.lockedGame);
        sbM833U.append(", timedGame=");
        sbM833U.append(this.timedGame);
        sbM833U.append(", againstBot=");
        sbM833U.append(this.againstBot);
        sbM833U.append(", background=");
        sbM833U.append(this.background);
        sbM833U.append(", pieceSet=");
        sbM833U.append(this.pieceSet);
        sbM833U.append(", numSpectators=");
        sbM833U.append(this.numSpectators);
        sbM833U.append(", playerColor=");
        sbM833U.append(this.playerColor);
        sbM833U.append(", lastScreen=");
        sbM833U.append(this.lastScreen);
        sbM833U.append(", jumpCount=");
        sbM833U.append(this.jumpCount);
        sbM833U.append(", reconnectTime=");
        return C1643a.m819G(sbM833U, this.reconnectTime, ")");
    }
}
