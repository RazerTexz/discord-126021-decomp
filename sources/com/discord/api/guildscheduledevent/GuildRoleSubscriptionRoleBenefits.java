package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import d0.z.d.Intrinsics3;
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
        return this.skuId == guildRoleSubscriptionRoleBenefits.skuId && Intrinsics3.areEqual(this.benefits, guildRoleSubscriptionRoleBenefits.benefits);
    }

    public int hashCode() {
        long j = this.skuId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<GuildRoleSubscriptionBenefit> list = this.benefits;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleSubscriptionRoleBenefits(skuId=");
        sbU.append(this.skuId);
        sbU.append(", benefits=");
        return outline.L(sbU, this.benefits, ")");
    }
}
