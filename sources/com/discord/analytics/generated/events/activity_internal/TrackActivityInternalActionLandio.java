package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivityInternalActionLandio.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionLandio implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
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
        return Intrinsics3.areEqual(this.actionName, trackActivityInternalActionLandio.actionName) && Intrinsics3.areEqual(this.ping, trackActivityInternalActionLandio.ping) && Intrinsics3.areEqual(this.server, trackActivityInternalActionLandio.server) && Intrinsics3.areEqual(this.pingPeak, trackActivityInternalActionLandio.pingPeak) && Intrinsics3.areEqual(this.frame, trackActivityInternalActionLandio.frame) && Intrinsics3.areEqual(this.framePeak, trackActivityInternalActionLandio.framePeak) && Intrinsics3.areEqual(this.numPlayers, trackActivityInternalActionLandio.numPlayers) && Intrinsics3.areEqual(this.numVotesYes, trackActivityInternalActionLandio.numVotesYes) && Intrinsics3.areEqual(this.numVotesNo, trackActivityInternalActionLandio.numVotesNo) && Intrinsics3.areEqual(this.turnLifespan, trackActivityInternalActionLandio.turnLifespan) && Intrinsics3.areEqual(this.turnKills, trackActivityInternalActionLandio.turnKills) && Intrinsics3.areEqual(this.turnClaimed, trackActivityInternalActionLandio.turnClaimed) && Intrinsics3.areEqual(this.toggleEnable, trackActivityInternalActionLandio.toggleEnable);
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
        StringBuilder sbU = outline.U("TrackActivityInternalActionLandio(actionName=");
        sbU.append(this.actionName);
        sbU.append(", ping=");
        sbU.append(this.ping);
        sbU.append(", server=");
        sbU.append(this.server);
        sbU.append(", pingPeak=");
        sbU.append(this.pingPeak);
        sbU.append(", frame=");
        sbU.append(this.frame);
        sbU.append(", framePeak=");
        sbU.append(this.framePeak);
        sbU.append(", numPlayers=");
        sbU.append(this.numPlayers);
        sbU.append(", numVotesYes=");
        sbU.append(this.numVotesYes);
        sbU.append(", numVotesNo=");
        sbU.append(this.numVotesNo);
        sbU.append(", turnLifespan=");
        sbU.append(this.turnLifespan);
        sbU.append(", turnKills=");
        sbU.append(this.turnKills);
        sbU.append(", turnClaimed=");
        sbU.append(this.turnClaimed);
        sbU.append(", toggleEnable=");
        return outline.D(sbU, this.toggleEnable, ")");
    }
}
