package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionBenefitAdapterItem$BenefitItem extends GuildRoleSubscriptionBenefitAdapterItem {
    private final Benefit benefit;
    private final long guildId;
    private final String key;
    private final String tierName;
    private final GuildRoleSubscriptionBenefitType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitAdapterItem$BenefitItem(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, Benefit benefit, long j, String str) {
        super(null);
        m.checkNotNullParameter(guildRoleSubscriptionBenefitType, "type");
        m.checkNotNullParameter(benefit, "benefit");
        this.type = guildRoleSubscriptionBenefitType;
        this.benefit = benefit;
        this.guildId = j;
        this.tierName = str;
        this.key = String.valueOf(benefit.hashCode());
    }

    public static /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem$BenefitItem copy$default(GuildRoleSubscriptionBenefitAdapterItem$BenefitItem guildRoleSubscriptionBenefitAdapterItem$BenefitItem, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, Benefit benefit, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRoleSubscriptionBenefitType = guildRoleSubscriptionBenefitAdapterItem$BenefitItem.type;
        }
        if ((i & 2) != 0) {
            benefit = guildRoleSubscriptionBenefitAdapterItem$BenefitItem.benefit;
        }
        Benefit benefit2 = benefit;
        if ((i & 4) != 0) {
            j = guildRoleSubscriptionBenefitAdapterItem$BenefitItem.guildId;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str = guildRoleSubscriptionBenefitAdapterItem$BenefitItem.tierName;
        }
        return guildRoleSubscriptionBenefitAdapterItem$BenefitItem.copy(guildRoleSubscriptionBenefitType, benefit2, j2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRoleSubscriptionBenefitType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Benefit getBenefit() {
        return this.benefit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTierName() {
        return this.tierName;
    }

    public final GuildRoleSubscriptionBenefitAdapterItem$BenefitItem copy(GuildRoleSubscriptionBenefitType type, Benefit benefit, long guildId, String tierName) {
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(benefit, "benefit");
        return new GuildRoleSubscriptionBenefitAdapterItem$BenefitItem(type, benefit, guildId, tierName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionBenefitAdapterItem$BenefitItem)) {
            return false;
        }
        GuildRoleSubscriptionBenefitAdapterItem$BenefitItem guildRoleSubscriptionBenefitAdapterItem$BenefitItem = (GuildRoleSubscriptionBenefitAdapterItem$BenefitItem) other;
        return m.areEqual(this.type, guildRoleSubscriptionBenefitAdapterItem$BenefitItem.type) && m.areEqual(this.benefit, guildRoleSubscriptionBenefitAdapterItem$BenefitItem.benefit) && this.guildId == guildRoleSubscriptionBenefitAdapterItem$BenefitItem.guildId && m.areEqual(this.tierName, guildRoleSubscriptionBenefitAdapterItem$BenefitItem.tierName);
    }

    public final Benefit getBenefit() {
        return this.benefit;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getTierName() {
        return this.tierName;
    }

    public final GuildRoleSubscriptionBenefitType getType() {
        return this.type;
    }

    public int hashCode() {
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.type;
        int iHashCode = (guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType.hashCode() : 0) * 31;
        Benefit benefit = this.benefit;
        int iA = (b.a(this.guildId) + ((iHashCode + (benefit != null ? benefit.hashCode() : 0)) * 31)) * 31;
        String str = this.tierName;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("BenefitItem(type=");
        sbU.append(this.type);
        sbU.append(", benefit=");
        sbU.append(this.benefit);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", tierName=");
        return a.J(sbU, this.tierName, ")");
    }
}
