package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import b.d.b.a.a;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult extends GuildRoleSubscriptionTierBenefitViewModel$Event {
    private final Benefit benefit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult(Benefit benefit) {
        super(null);
        m.checkNotNullParameter(benefit, "benefit");
        this.benefit = benefit;
    }

    public static /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult copy$default(GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult guildRoleSubscriptionTierBenefitViewModel$Event$SendResult, Benefit benefit, int i, Object obj) {
        if ((i & 1) != 0) {
            benefit = guildRoleSubscriptionTierBenefitViewModel$Event$SendResult.benefit;
        }
        return guildRoleSubscriptionTierBenefitViewModel$Event$SendResult.copy(benefit);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Benefit getBenefit() {
        return this.benefit;
    }

    public final GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult copy(Benefit benefit) {
        m.checkNotNullParameter(benefit, "benefit");
        return new GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult(benefit);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult) && m.areEqual(this.benefit, ((GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult) other).benefit);
        }
        return true;
    }

    public final Benefit getBenefit() {
        return this.benefit;
    }

    public int hashCode() {
        Benefit benefit = this.benefit;
        if (benefit != null) {
            return benefit.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("SendResult(benefit=");
        sbU.append(this.benefit);
        sbU.append(")");
        return sbU.toString();
    }
}
