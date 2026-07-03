package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityInternalSketchHeadsAction.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalSketchHeadsAction implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final CharSequence mode = null;
    private final CharSequence phase = null;
    private final CharSequence theme = null;
    private final Long numRounds = null;
    private final Long roundLengthMs = null;
    private final Long numPlayers = null;
    private final Long numDrawers = null;
    private final Long numGuessers = null;
    private final Long numSpectators = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_sketch_heads_action";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalSketchHeadsAction)) {
            return false;
        }
        TrackActivityInternalSketchHeadsAction trackActivityInternalSketchHeadsAction = (TrackActivityInternalSketchHeadsAction) other;
        return C12238m.areEqual(this.actionName, trackActivityInternalSketchHeadsAction.actionName) && C12238m.areEqual(this.mode, trackActivityInternalSketchHeadsAction.mode) && C12238m.areEqual(this.phase, trackActivityInternalSketchHeadsAction.phase) && C12238m.areEqual(this.theme, trackActivityInternalSketchHeadsAction.theme) && C12238m.areEqual(this.numRounds, trackActivityInternalSketchHeadsAction.numRounds) && C12238m.areEqual(this.roundLengthMs, trackActivityInternalSketchHeadsAction.roundLengthMs) && C12238m.areEqual(this.numPlayers, trackActivityInternalSketchHeadsAction.numPlayers) && C12238m.areEqual(this.numDrawers, trackActivityInternalSketchHeadsAction.numDrawers) && C12238m.areEqual(this.numGuessers, trackActivityInternalSketchHeadsAction.numGuessers) && C12238m.areEqual(this.numSpectators, trackActivityInternalSketchHeadsAction.numSpectators);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.mode;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.phase;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.theme;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.numRounds;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.roundLengthMs;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numPlayers;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.numDrawers;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numGuessers;
        int iHashCode9 = (iHashCode8 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numSpectators;
        return iHashCode9 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalSketchHeadsAction(actionName=");
        sbM833U.append(this.actionName);
        sbM833U.append(", mode=");
        sbM833U.append(this.mode);
        sbM833U.append(", phase=");
        sbM833U.append(this.phase);
        sbM833U.append(", theme=");
        sbM833U.append(this.theme);
        sbM833U.append(", numRounds=");
        sbM833U.append(this.numRounds);
        sbM833U.append(", roundLengthMs=");
        sbM833U.append(this.roundLengthMs);
        sbM833U.append(", numPlayers=");
        sbM833U.append(this.numPlayers);
        sbM833U.append(", numDrawers=");
        sbM833U.append(this.numDrawers);
        sbM833U.append(", numGuessers=");
        sbM833U.append(this.numGuessers);
        sbM833U.append(", numSpectators=");
        return C1643a.m819G(sbM833U, this.numSpectators, ")");
    }
}
