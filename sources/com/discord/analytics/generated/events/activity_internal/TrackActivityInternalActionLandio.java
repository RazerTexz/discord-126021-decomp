package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityInternalActionLandio.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionLandio implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final Long ping = null;
    private final CharSequence server = null;
    private final Long pingPeak = null;
    private final Long frame = null;
    private final Long framePeak = null;
    private final Long numPlayers = null;
    private final Long numVotesYes = null;
    private final Long numVotesNo = null;
    private final Long turnLifespan = null;
    private final Long turnKills = null;
    private final Long turnClaimed = null;
    private final Boolean toggleEnable = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_landio";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionLandio)) {
            return false;
        }
        TrackActivityInternalActionLandio trackActivityInternalActionLandio = (TrackActivityInternalActionLandio) other;
        return C12238m.areEqual(this.actionName, trackActivityInternalActionLandio.actionName) && C12238m.areEqual(this.ping, trackActivityInternalActionLandio.ping) && C12238m.areEqual(this.server, trackActivityInternalActionLandio.server) && C12238m.areEqual(this.pingPeak, trackActivityInternalActionLandio.pingPeak) && C12238m.areEqual(this.frame, trackActivityInternalActionLandio.frame) && C12238m.areEqual(this.framePeak, trackActivityInternalActionLandio.framePeak) && C12238m.areEqual(this.numPlayers, trackActivityInternalActionLandio.numPlayers) && C12238m.areEqual(this.numVotesYes, trackActivityInternalActionLandio.numVotesYes) && C12238m.areEqual(this.numVotesNo, trackActivityInternalActionLandio.numVotesNo) && C12238m.areEqual(this.turnLifespan, trackActivityInternalActionLandio.turnLifespan) && C12238m.areEqual(this.turnKills, trackActivityInternalActionLandio.turnKills) && C12238m.areEqual(this.turnClaimed, trackActivityInternalActionLandio.turnClaimed) && C12238m.areEqual(this.toggleEnable, trackActivityInternalActionLandio.toggleEnable);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.ping;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.server;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l2 = this.pingPeak;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.frame;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.framePeak;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.numPlayers;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.numVotesYes;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.numVotesNo;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.turnLifespan;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.turnKills;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.turnClaimed;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Boolean bool = this.toggleEnable;
        return iHashCode12 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalActionLandio(actionName=");
        sbM833U.append(this.actionName);
        sbM833U.append(", ping=");
        sbM833U.append(this.ping);
        sbM833U.append(", server=");
        sbM833U.append(this.server);
        sbM833U.append(", pingPeak=");
        sbM833U.append(this.pingPeak);
        sbM833U.append(", frame=");
        sbM833U.append(this.frame);
        sbM833U.append(", framePeak=");
        sbM833U.append(this.framePeak);
        sbM833U.append(", numPlayers=");
        sbM833U.append(this.numPlayers);
        sbM833U.append(", numVotesYes=");
        sbM833U.append(this.numVotesYes);
        sbM833U.append(", numVotesNo=");
        sbM833U.append(this.numVotesNo);
        sbM833U.append(", turnLifespan=");
        sbM833U.append(this.turnLifespan);
        sbM833U.append(", turnKills=");
        sbM833U.append(this.turnKills);
        sbM833U.append(", turnClaimed=");
        sbM833U.append(this.turnClaimed);
        sbM833U.append(", toggleEnable=");
        return C1643a.m816D(sbM833U, this.toggleEnable, ")");
    }
}
