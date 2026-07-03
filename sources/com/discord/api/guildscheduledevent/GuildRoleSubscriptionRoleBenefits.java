package com.discord.api.guildscheduledevent;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefit;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleSubscriptionRoleBenefits.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildRoleSubscriptionRoleBenefits {
    private final List<GuildRoleSubscriptionBenefit> benefits;
    private final long skuId;

    /* JADX INFO: renamed from: a */
    public final List<GuildRoleSubscriptionBenefit> m7971a() {
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
        return this.skuId == guildRoleSubscriptionRoleBenefits.skuId && C12238m.areEqual(this.benefits, guildRoleSubscriptionRoleBenefits.benefits);
    }

    public int hashCode() {
        long j = this.skuId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<GuildRoleSubscriptionBenefit> list = this.benefits;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildRoleSubscriptionRoleBenefits(skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", benefits=");
        return C1643a.m824L(sbM833U, this.benefits, ")");
    }
}
