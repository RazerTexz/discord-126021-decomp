package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem extends GuildRoleSubscriptionBenefitAdapterItem {
    private final Integer activeTrialUserLimit;
    private final boolean isFreeTrialEnabled;
    private final String key;
    private final SubscriptionTrialInterval trialInterval;

    public GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem(boolean z2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num) {
        super(null);
        this.isFreeTrialEnabled = z2;
        this.trialInterval = subscriptionTrialInterval;
        this.activeTrialUserLimit = num;
        this.key = "FreeTrialItem";
    }

    public static /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem copy$default(GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem, boolean z2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled;
        }
        if ((i & 2) != 0) {
            subscriptionTrialInterval = guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.trialInterval;
        }
        if ((i & 4) != 0) {
            num = guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.activeTrialUserLimit;
        }
        return guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.copy(z2, subscriptionTrialInterval, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsFreeTrialEnabled() {
        return this.isFreeTrialEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SubscriptionTrialInterval getTrialInterval() {
        return this.trialInterval;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getActiveTrialUserLimit() {
        return this.activeTrialUserLimit;
    }

    public final GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem copy(boolean isFreeTrialEnabled, SubscriptionTrialInterval trialInterval, Integer activeTrialUserLimit) {
        return new GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem(isFreeTrialEnabled, trialInterval, activeTrialUserLimit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem)) {
            return false;
        }
        GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem = (GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem) other;
        return this.isFreeTrialEnabled == guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.isFreeTrialEnabled && m.areEqual(this.trialInterval, guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.trialInterval) && m.areEqual(this.activeTrialUserLimit, guildRoleSubscriptionBenefitAdapterItem$FreeTrialItem.activeTrialUserLimit);
    }

    public final Integer getActiveTrialUserLimit() {
        return this.activeTrialUserLimit;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final SubscriptionTrialInterval getTrialInterval() {
        return this.trialInterval;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z2 = this.isFreeTrialEnabled;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        SubscriptionTrialInterval subscriptionTrialInterval = this.trialInterval;
        int iHashCode = (i + (subscriptionTrialInterval != null ? subscriptionTrialInterval.hashCode() : 0)) * 31;
        Integer num = this.activeTrialUserLimit;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final boolean isFreeTrialEnabled() {
        return this.isFreeTrialEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("FreeTrialItem(isFreeTrialEnabled=");
        sbU.append(this.isFreeTrialEnabled);
        sbU.append(", trialInterval=");
        sbU.append(this.trialInterval);
        sbU.append(", activeTrialUserLimit=");
        return a.F(sbU, this.activeTrialUserLimit, ")");
    }
}
