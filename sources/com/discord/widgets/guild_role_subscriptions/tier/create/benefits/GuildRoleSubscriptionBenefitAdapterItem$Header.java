package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionBenefitAdapterItem$Header extends GuildRoleSubscriptionBenefitAdapterItem {
    private final String key;
    private final GuildRoleSubscriptionBenefitType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitAdapterItem$Header(GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType) {
        super(null);
        m.checkNotNullParameter(guildRoleSubscriptionBenefitType, "type");
        this.type = guildRoleSubscriptionBenefitType;
        this.key = "BenefitHeader" + guildRoleSubscriptionBenefitType;
    }

    public static /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem$Header copy$default(GuildRoleSubscriptionBenefitAdapterItem$Header guildRoleSubscriptionBenefitAdapterItem$Header, GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRoleSubscriptionBenefitType = guildRoleSubscriptionBenefitAdapterItem$Header.type;
        }
        return guildRoleSubscriptionBenefitAdapterItem$Header.copy(guildRoleSubscriptionBenefitType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRoleSubscriptionBenefitType getType() {
        return this.type;
    }

    public final GuildRoleSubscriptionBenefitAdapterItem$Header copy(GuildRoleSubscriptionBenefitType type) {
        m.checkNotNullParameter(type, "type");
        return new GuildRoleSubscriptionBenefitAdapterItem$Header(type);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildRoleSubscriptionBenefitAdapterItem$Header) && m.areEqual(this.type, ((GuildRoleSubscriptionBenefitAdapterItem$Header) other).type);
        }
        return true;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final GuildRoleSubscriptionBenefitType getType() {
        return this.type;
    }

    public int hashCode() {
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = this.type;
        if (guildRoleSubscriptionBenefitType != null) {
            return guildRoleSubscriptionBenefitType.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Header(type=");
        sbU.append(this.type);
        sbU.append(")");
        return sbU.toString();
    }
}
