package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierBenefitsViewModel$1 extends o implements Function1<GuildRoleSubscriptionTierBenefitsViewModel$StoreState, Unit> {
    public final /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierBenefitsViewModel$1(GuildRoleSubscriptionTierBenefitsViewModel guildRoleSubscriptionTierBenefitsViewModel) {
        super(1);
        this.this$0 = guildRoleSubscriptionTierBenefitsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitsViewModel$StoreState guildRoleSubscriptionTierBenefitsViewModel$StoreState) {
        invoke2(guildRoleSubscriptionTierBenefitsViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionTierBenefitsViewModel$StoreState guildRoleSubscriptionTierBenefitsViewModel$StoreState) {
        GuildRoleSubscriptionTierBenefitsViewModel guildRoleSubscriptionTierBenefitsViewModel = this.this$0;
        m.checkNotNullExpressionValue(guildRoleSubscriptionTierBenefitsViewModel$StoreState, "storeState");
        GuildRoleSubscriptionTierBenefitsViewModel.access$handleStoreState(guildRoleSubscriptionTierBenefitsViewModel, guildRoleSubscriptionTierBenefitsViewModel$StoreState);
    }
}
