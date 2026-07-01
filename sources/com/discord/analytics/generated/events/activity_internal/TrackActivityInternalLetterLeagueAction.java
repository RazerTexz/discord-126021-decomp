package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackActivityInternalLetterLeagueAction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalLetterLeagueAction implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final CharSequence bag = null;
    private final CharSequence scoringMode = null;
    private final Long numPlayers = null;
    private final Long numSpectators = null;
    private final CharSequence phase = null;
    private final Long durationS = null;
    private final Long score = null;
    private final CharSequence turnType = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_letter_league_action";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalLetterLeagueAction)) {
            return false;
        }
        TrackActivityInternalLetterLeagueAction trackActivityInternalLetterLeagueAction = (TrackActivityInternalLetterLeagueAction) other;
        return m.areEqual(this.actionName, trackActivityInternalLetterLeagueAction.actionName) && m.areEqual(this.bag, trackActivityInternalLetterLeagueAction.bag) && m.areEqual(this.scoringMode, trackActivityInternalLetterLeagueAction.scoringMode) && m.areEqual(this.numPlayers, trackActivityInternalLetterLeagueAction.numPlayers) && m.areEqual(this.numSpectators, trackActivityInternalLetterLeagueAction.numSpectators) && m.areEqual(this.phase, trackActivityInternalLetterLeagueAction.phase) && m.areEqual(this.durationS, trackActivityInternalLetterLeagueAction.durationS) && m.areEqual(this.score, trackActivityInternalLetterLeagueAction.score) && m.areEqual(this.turnType, trackActivityInternalLetterLeagueAction.turnType);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.bag;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.scoringMode;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.numPlayers;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numSpectators;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.phase;
        int iHashCode6 = (iHashCode5 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.durationS;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.score;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.turnType;
        return iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackActivityInternalLetterLeagueAction(actionName=");
        sbU.append(this.actionName);
        sbU.append(", bag=");
        sbU.append(this.bag);
        sbU.append(", scoringMode=");
        sbU.append(this.scoringMode);
        sbU.append(", numPlayers=");
        sbU.append(this.numPlayers);
        sbU.append(", numSpectators=");
        sbU.append(this.numSpectators);
        sbU.append(", phase=");
        sbU.append(this.phase);
        sbU.append(", durationS=");
        sbU.append(this.durationS);
        sbU.append(", score=");
        sbU.append(this.score);
        sbU.append(", turnType=");
        return a.E(sbU, this.turnType, ")");
    }
}
