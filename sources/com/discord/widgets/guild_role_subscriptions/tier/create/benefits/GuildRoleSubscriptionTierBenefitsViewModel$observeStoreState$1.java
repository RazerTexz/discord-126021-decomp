package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierBenefitsViewModel$observeStoreState$1 extends o implements Function0<GuildRoleSubscriptionTierBenefitsViewModel$StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierBenefitsViewModel$observeStoreState$1(GuildRoleSubscriptionTierBenefitsViewModel guildRoleSubscriptionTierBenefitsViewModel, long j) {
        super(0);
        this.this$0 = guildRoleSubscriptionTierBenefitsViewModel;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionTierBenefitsViewModel$StoreState invoke() {
        return new GuildRoleSubscriptionTierBenefitsViewModel$StoreState(GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(this.$guildId), GuildRoleSubscriptionTierBenefitsViewModel.access$getGuildRoleSubscriptionsStore$p(this.this$0).getGuildRoleSubscriptionFreeTrialActiveUserLimitOptions(), GuildRoleSubscriptionTierBenefitsViewModel.access$getGuildRoleSubscriptionsStore$p(this.this$0).getGuildRoleSubscriptionFreeTrialIntervalOptions());
    }
}
