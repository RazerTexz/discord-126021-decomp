package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityInternalActionLetterLeague.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionLetterLeague implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
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
    private final CharSequence word = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_letter_league";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionLetterLeague)) {
            return false;
        }
        TrackActivityInternalActionLetterLeague trackActivityInternalActionLetterLeague = (TrackActivityInternalActionLetterLeague) other;
        return C12238m.areEqual(this.actionName, trackActivityInternalActionLetterLeague.actionName) && C12238m.areEqual(this.bag, trackActivityInternalActionLetterLeague.bag) && C12238m.areEqual(this.scoringMode, trackActivityInternalActionLetterLeague.scoringMode) && C12238m.areEqual(this.numPlayers, trackActivityInternalActionLetterLeague.numPlayers) && C12238m.areEqual(this.numSpectators, trackActivityInternalActionLetterLeague.numSpectators) && C12238m.areEqual(this.phase, trackActivityInternalActionLetterLeague.phase) && C12238m.areEqual(this.durationS, trackActivityInternalActionLetterLeague.durationS) && C12238m.areEqual(this.score, trackActivityInternalActionLetterLeague.score) && C12238m.areEqual(this.turnType, trackActivityInternalActionLetterLeague.turnType) && C12238m.areEqual(this.word, trackActivityInternalActionLetterLeague.word);
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
        int iHashCode9 = (iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.word;
        return iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalActionLetterLeague(actionName=");
        sbM833U.append(this.actionName);
        sbM833U.append(", bag=");
        sbM833U.append(this.bag);
        sbM833U.append(", scoringMode=");
        sbM833U.append(this.scoringMode);
        sbM833U.append(", numPlayers=");
        sbM833U.append(this.numPlayers);
        sbM833U.append(", numSpectators=");
        sbM833U.append(this.numSpectators);
        sbM833U.append(", phase=");
        sbM833U.append(this.phase);
        sbM833U.append(", durationS=");
        sbM833U.append(this.durationS);
        sbM833U.append(", score=");
        sbM833U.append(this.score);
        sbM833U.append(", turnType=");
        sbM833U.append(this.turnType);
        sbM833U.append(", word=");
        return C1643a.m817E(sbM833U, this.word, ")");
    }
}
