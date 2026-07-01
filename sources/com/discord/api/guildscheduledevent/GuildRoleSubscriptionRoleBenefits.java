package com.discord.api.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GuildRoleSubscriptionRoleBenefits.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionRoleBenefits {
    private final List<GuildRoleSubscriptionBenefit> benefits;
    private final long skuId;

    public final List<GuildRoleSubscriptionBenefit> a() {
        return this.benefits;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionRoleBenefits)) {
            return false;
        }
        GuildRoleSubscriptionRoleBenefits guildRoleSubscriptionRoleBenefits = (GuildRoleSubscriptionRoleBenefits) other;
        return this.skuId == guildRoleSubscriptionRoleBenefits.skuId && m.areEqual(this.benefits, guildRoleSubscriptionRoleBenefits.benefits);
    }

    public int hashCode() {
        long j = this.skuId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<GuildRoleSubscriptionBenefit> list = this.benefits;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildRoleSubscriptionRoleBenefits(skuId=");
        sbU.append(this.skuId);
        sbU.append(", benefits=");
        return a.L(sbU, this.benefits, ")");
    }
}
