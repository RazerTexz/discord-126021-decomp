package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackActivityInternalActionPoker.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionPoker implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence actionName = null;
    private final Long numBots = null;
    private final Long numPlayers = null;
    private final Long numSpectators = null;
    private final CharSequence phase = null;
    private final Long turnDurationS = null;
    private final CharSequence betAction = null;
    private final Long betAmount = null;
    private final Long winnings = null;
    private final Long startingWallet = null;
    private final Long currentWallet = null;
    private final Long potSize = null;
    private final Long tableRank = null;
    private final CharSequence cosmeticType = null;
    private final CharSequence cosmeticId = null;
    private final Boolean cosmeticLocked = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_action_poker";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalActionPoker)) {
            return false;
        }
        TrackActivityInternalActionPoker trackActivityInternalActionPoker = (TrackActivityInternalActionPoker) other;
        return Intrinsics3.areEqual(this.actionName, trackActivityInternalActionPoker.actionName) && Intrinsics3.areEqual(this.numBots, trackActivityInternalActionPoker.numBots) && Intrinsics3.areEqual(this.numPlayers, trackActivityInternalActionPoker.numPlayers) && Intrinsics3.areEqual(this.numSpectators, trackActivityInternalActionPoker.numSpectators) && Intrinsics3.areEqual(this.phase, trackActivityInternalActionPoker.phase) && Intrinsics3.areEqual(this.turnDurationS, trackActivityInternalActionPoker.turnDurationS) && Intrinsics3.areEqual(this.betAction, trackActivityInternalActionPoker.betAction) && Intrinsics3.areEqual(this.betAmount, trackActivityInternalActionPoker.betAmount) && Intrinsics3.areEqual(this.winnings, trackActivityInternalActionPoker.winnings) && Intrinsics3.areEqual(this.startingWallet, trackActivityInternalActionPoker.startingWallet) && Intrinsics3.areEqual(this.currentWallet, trackActivityInternalActionPoker.currentWallet) && Intrinsics3.areEqual(this.potSize, trackActivityInternalActionPoker.potSize) && Intrinsics3.areEqual(this.tableRank, trackActivityInternalActionPoker.tableRank) && Intrinsics3.areEqual(this.cosmeticType, trackActivityInternalActionPoker.cosmeticType) && Intrinsics3.areEqual(this.cosmeticId, trackActivityInternalActionPoker.cosmeticId) && Intrinsics3.areEqual(this.cosmeticLocked, trackActivityInternalActionPoker.cosmeticLocked);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numBots;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numPlayers;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numSpectators;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.phase;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l4 = this.turnDurationS;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.betAction;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l5 = this.betAmount;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.winnings;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.startingWallet;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.currentWallet;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.potSize;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.tableRank;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.cosmeticType;
        int iHashCode14 = (iHashCode13 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.cosmeticId;
        int iHashCode15 = (iHashCode14 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Boolean bool = this.cosmeticLocked;
        return iHashCode15 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalActionPoker(actionName=");
        sbU.append(this.actionName);
        sbU.append(", numBots=");
        sbU.append(this.numBots);
        sbU.append(", numPlayers=");
        sbU.append(this.numPlayers);
        sbU.append(", numSpectators=");
        sbU.append(this.numSpectators);
        sbU.append(", phase=");
        sbU.append(this.phase);
        sbU.append(", turnDurationS=");
        sbU.append(this.turnDurationS);
        sbU.append(", betAction=");
        sbU.append(this.betAction);
        sbU.append(", betAmount=");
        sbU.append(this.betAmount);
        sbU.append(", winnings=");
        sbU.append(this.winnings);
        sbU.append(", startingWallet=");
        sbU.append(this.startingWallet);
        sbU.append(", currentWallet=");
        sbU.append(this.currentWallet);
        sbU.append(", potSize=");
        sbU.append(this.potSize);
        sbU.append(", tableRank=");
        sbU.append(this.tableRank);
        sbU.append(", cosmeticType=");
        sbU.append(this.cosmeticType);
        sbU.append(", cosmeticId=");
        sbU.append(this.cosmeticId);
        sbU.append(", cosmeticLocked=");
        return outline.D(sbU, this.cosmeticLocked, ")");
    }
}
