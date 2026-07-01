package com.discord.widgets.guild_role_subscriptions.tier;

import b.d.b.a.a;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierAdapterItem$BenefitItem extends GuildRoleSubscriptionTierAdapterItem {
    private final Benefit benefit;
    private final int index;
    private final String key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierAdapterItem$BenefitItem(int i, Benefit benefit) {
        super(null);
        m.checkNotNullParameter(benefit, "benefit");
        this.index = i;
        this.benefit = benefit;
        this.key = String.valueOf(i);
    }

    public static /* synthetic */ GuildRoleSubscriptionTierAdapterItem$BenefitItem copy$default(GuildRoleSubscriptionTierAdapterItem$BenefitItem guildRoleSubscriptionTierAdapterItem$BenefitItem, int i, Benefit benefit, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildRoleSubscriptionTierAdapterItem$BenefitItem.index;
        }
        if ((i2 & 2) != 0) {
            benefit = guildRoleSubscriptionTierAdapterItem$BenefitItem.benefit;
        }
        return guildRoleSubscriptionTierAdapterItem$BenefitItem.copy(i, benefit);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Benefit getBenefit() {
        return this.benefit;
    }

    public final GuildRoleSubscriptionTierAdapterItem$BenefitItem copy(int index, Benefit benefit) {
        m.checkNotNullParameter(benefit, "benefit");
        return new GuildRoleSubscriptionTierAdapterItem$BenefitItem(index, benefit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierAdapterItem$BenefitItem)) {
            return false;
        }
        GuildRoleSubscriptionTierAdapterItem$BenefitItem guildRoleSubscriptionTierAdapterItem$BenefitItem = (GuildRoleSubscriptionTierAdapterItem$BenefitItem) other;
        return this.index == guildRoleSubscriptionTierAdapterItem$BenefitItem.index && m.areEqual(this.benefit, guildRoleSubscriptionTierAdapterItem$BenefitItem.benefit);
    }

    public final Benefit getBenefit() {
        return this.benefit;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        int i = this.index * 31;
        Benefit benefit = this.benefit;
        return i + (benefit != null ? benefit.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("BenefitItem(index=");
        sbU.append(this.index);
        sbU.append(", benefit=");
        sbU.append(this.benefit);
        sbU.append(")");
        return sbU.toString();
    }
}
