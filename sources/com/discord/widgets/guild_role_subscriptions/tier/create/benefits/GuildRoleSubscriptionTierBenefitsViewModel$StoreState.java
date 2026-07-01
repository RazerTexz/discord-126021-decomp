package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierBenefitsViewModel$StoreState {
    private final List<Integer> activeTrialUserLimitOptions;
    private final boolean isGuildEligibleForTrials;
    private final List<SubscriptionTrialInterval> trialIntervalOptions;

    public GuildRoleSubscriptionTierBenefitsViewModel$StoreState(boolean z2, List<Integer> list, List<SubscriptionTrialInterval> list2) {
        m.checkNotNullParameter(list, "activeTrialUserLimitOptions");
        m.checkNotNullParameter(list2, "trialIntervalOptions");
        this.isGuildEligibleForTrials = z2;
        this.activeTrialUserLimitOptions = list;
        this.trialIntervalOptions = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel$StoreState copy$default(GuildRoleSubscriptionTierBenefitsViewModel$StoreState guildRoleSubscriptionTierBenefitsViewModel$StoreState, boolean z2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = guildRoleSubscriptionTierBenefitsViewModel$StoreState.isGuildEligibleForTrials;
        }
        if ((i & 2) != 0) {
            list = guildRoleSubscriptionTierBenefitsViewModel$StoreState.activeTrialUserLimitOptions;
        }
        if ((i & 4) != 0) {
            list2 = guildRoleSubscriptionTierBenefitsViewModel$StoreState.trialIntervalOptions;
        }
        return guildRoleSubscriptionTierBenefitsViewModel$StoreState.copy(z2, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsGuildEligibleForTrials() {
        return this.isGuildEligibleForTrials;
    }

    public final List<Integer> component2() {
        return this.activeTrialUserLimitOptions;
    }

    public final List<SubscriptionTrialInterval> component3() {
        return this.trialIntervalOptions;
    }

    public final GuildRoleSubscriptionTierBenefitsViewModel$StoreState copy(boolean isGuildEligibleForTrials, List<Integer> activeTrialUserLimitOptions, List<SubscriptionTrialInterval> trialIntervalOptions) {
        m.checkNotNullParameter(activeTrialUserLimitOptions, "activeTrialUserLimitOptions");
        m.checkNotNullParameter(trialIntervalOptions, "trialIntervalOptions");
        return new GuildRoleSubscriptionTierBenefitsViewModel$StoreState(isGuildEligibleForTrials, activeTrialUserLimitOptions, trialIntervalOptions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierBenefitsViewModel$StoreState)) {
            return false;
        }
        GuildRoleSubscriptionTierBenefitsViewModel$StoreState guildRoleSubscriptionTierBenefitsViewModel$StoreState = (GuildRoleSubscriptionTierBenefitsViewModel$StoreState) other;
        return this.isGuildEligibleForTrials == guildRoleSubscriptionTierBenefitsViewModel$StoreState.isGuildEligibleForTrials && m.areEqual(this.activeTrialUserLimitOptions, guildRoleSubscriptionTierBenefitsViewModel$StoreState.activeTrialUserLimitOptions) && m.areEqual(this.trialIntervalOptions, guildRoleSubscriptionTierBenefitsViewModel$StoreState.trialIntervalOptions);
    }

    public final List<Integer> getActiveTrialUserLimitOptions() {
        return this.activeTrialUserLimitOptions;
    }

    public final List<SubscriptionTrialInterval> getTrialIntervalOptions() {
        return this.trialIntervalOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z2 = this.isGuildEligibleForTrials;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<Integer> list = this.activeTrialUserLimitOptions;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<SubscriptionTrialInterval> list2 = this.trialIntervalOptions;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final boolean isGuildEligibleForTrials() {
        return this.isGuildEligibleForTrials;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(isGuildEligibleForTrials=");
        sbU.append(this.isGuildEligibleForTrials);
        sbU.append(", activeTrialUserLimitOptions=");
        sbU.append(this.activeTrialUserLimitOptions);
        sbU.append(", trialIntervalOptions=");
        return a.L(sbU, this.trialIntervalOptions, ")");
    }
}
