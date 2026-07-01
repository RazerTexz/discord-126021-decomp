package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem extends GuildRoleSubscriptionBenefitAdapterItem {
    private final long guildId;
    private final String key;
    private final String tierName;
    private final GuildRoleSubscriptionBenefitType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, long j, String str) {
        super(null);
        m.checkNotNullParameter(guildRoleSubscriptionBenefitType, "type");
        this.type = guildRoleSubscriptionBenefitType;
        this.guildId = j;
        this.tierName = str;
        this.key = "AddBenefitItem" + guildRoleSubscriptionBenefitType;
    }

    public static /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem copy$default(GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRoleSubscriptionBenefitType = guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem.type;
        }
        if ((i & 2) != 0) {
            j = guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem.guildId;
        }
        if ((i & 4) != 0) {
            str = guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem.tierName;
        }
        return guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem.copy(guildRoleSubscriptionBenefitType, j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRoleSubscriptionBenefitType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTierName() {
        return this.tierName;
    }

    public final GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem copy(GuildRoleSubscriptionBenefitType type, long guildId, String tierName) {
        m.checkNotNullParameter(type, "type");
        return new GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem(type, guildId, tierName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem)) {
            return false;
        }
        GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem = (GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem) other;
        return m.areEqual(this.type, guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem.type) && this.guildId == guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem.guildId && m.areEqual(this.tierName, guildRoleSubscriptionBenefitAdapterItem$AddBenefitItem.tierName);
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
        int iA = (b.a(this.guildId) + ((guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType.hashCode() : 0) * 31)) * 31;
        String str = this.tierName;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("AddBenefitItem(type=");
        sbU.append(this.type);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", tierName=");
        return a.J(sbU, this.tierName, ")");
    }
}
