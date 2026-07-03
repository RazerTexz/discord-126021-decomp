package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityInternalActionPoker.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalActionPoker implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
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
        return C12238m.areEqual(this.actionName, trackActivityInternalActionPoker.actionName) && C12238m.areEqual(this.numBots, trackActivityInternalActionPoker.numBots) && C12238m.areEqual(this.numPlayers, trackActivityInternalActionPoker.numPlayers) && C12238m.areEqual(this.numSpectators, trackActivityInternalActionPoker.numSpectators) && C12238m.areEqual(this.phase, trackActivityInternalActionPoker.phase) && C12238m.areEqual(this.turnDurationS, trackActivityInternalActionPoker.turnDurationS) && C12238m.areEqual(this.betAction, trackActivityInternalActionPoker.betAction) && C12238m.areEqual(this.betAmount, trackActivityInternalActionPoker.betAmount) && C12238m.areEqual(this.winnings, trackActivityInternalActionPoker.winnings) && C12238m.areEqual(this.startingWallet, trackActivityInternalActionPoker.startingWallet) && C12238m.areEqual(this.currentWallet, trackActivityInternalActionPoker.currentWallet) && C12238m.areEqual(this.potSize, trackActivityInternalActionPoker.potSize) && C12238m.areEqual(this.tableRank, trackActivityInternalActionPoker.tableRank) && C12238m.areEqual(this.cosmeticType, trackActivityInternalActionPoker.cosmeticType) && C12238m.areEqual(this.cosmeticId, trackActivityInternalActionPoker.cosmeticId) && C12238m.areEqual(this.cosmeticLocked, trackActivityInternalActionPoker.cosmeticLocked);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalActionPoker(actionName=");
        sbM833U.append(this.actionName);
        sbM833U.append(", numBots=");
        sbM833U.append(this.numBots);
        sbM833U.append(", numPlayers=");
        sbM833U.append(this.numPlayers);
        sbM833U.append(", numSpectators=");
        sbM833U.append(this.numSpectators);
        sbM833U.append(", phase=");
        sbM833U.append(this.phase);
        sbM833U.append(", turnDurationS=");
        sbM833U.append(this.turnDurationS);
        sbM833U.append(", betAction=");
        sbM833U.append(this.betAction);
        sbM833U.append(", betAmount=");
        sbM833U.append(this.betAmount);
        sbM833U.append(", winnings=");
        sbM833U.append(this.winnings);
        sbM833U.append(", startingWallet=");
        sbM833U.append(this.startingWallet);
        sbM833U.append(", currentWallet=");
        sbM833U.append(this.currentWallet);
        sbM833U.append(", potSize=");
        sbM833U.append(this.potSize);
        sbM833U.append(", tableRank=");
        sbM833U.append(this.tableRank);
        sbM833U.append(", cosmeticType=");
        sbM833U.append(this.cosmeticType);
        sbM833U.append(", cosmeticId=");
        sbM833U.append(this.cosmeticId);
        sbM833U.append(", cosmeticLocked=");
        return C1643a.m816D(sbM833U, this.cosmeticLocked, ")");
    }
}
