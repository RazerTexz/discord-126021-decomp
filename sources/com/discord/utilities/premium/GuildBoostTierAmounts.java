package com.discord.utilities.premium;

import b.d.b.a.a;

/* JADX INFO: compiled from: GuildBoostTierAmounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostTierAmounts {
    private final int tier1Boosts;
    private final int tier2Boosts;
    private final int tier3Boosts;

    public GuildBoostTierAmounts(int i, int i2, int i3) {
        this.tier1Boosts = i;
        this.tier2Boosts = i2;
        this.tier3Boosts = i3;
    }

    public static /* synthetic */ GuildBoostTierAmounts copy$default(GuildBoostTierAmounts guildBoostTierAmounts, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = guildBoostTierAmounts.tier1Boosts;
        }
        if ((i4 & 2) != 0) {
            i2 = guildBoostTierAmounts.tier2Boosts;
        }
        if ((i4 & 4) != 0) {
            i3 = guildBoostTierAmounts.tier3Boosts;
        }
        return guildBoostTierAmounts.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTier1Boosts() {
        return this.tier1Boosts;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTier2Boosts() {
        return this.tier2Boosts;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTier3Boosts() {
        return this.tier3Boosts;
    }

    public final GuildBoostTierAmounts copy(int tier1Boosts, int tier2Boosts, int tier3Boosts) {
        return new GuildBoostTierAmounts(tier1Boosts, tier2Boosts, tier3Boosts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostTierAmounts)) {
            return false;
        }
        GuildBoostTierAmounts guildBoostTierAmounts = (GuildBoostTierAmounts) other;
        return this.tier1Boosts == guildBoostTierAmounts.tier1Boosts && this.tier2Boosts == guildBoostTierAmounts.tier2Boosts && this.tier3Boosts == guildBoostTierAmounts.tier3Boosts;
    }

    public final int getTier1Boosts() {
        return this.tier1Boosts;
    }

    public final int getTier2Boosts() {
        return this.tier2Boosts;
    }

    public final int getTier3Boosts() {
        return this.tier3Boosts;
    }

    public int hashCode() {
        return (((this.tier1Boosts * 31) + this.tier2Boosts) * 31) + this.tier3Boosts;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildBoostTierAmounts(tier1Boosts=");
        sbU.append(this.tier1Boosts);
        sbU.append(", tier2Boosts=");
        sbU.append(this.tier2Boosts);
        sbU.append(", tier3Boosts=");
        return a.B(sbU, this.tier3Boosts, ")");
    }
}
