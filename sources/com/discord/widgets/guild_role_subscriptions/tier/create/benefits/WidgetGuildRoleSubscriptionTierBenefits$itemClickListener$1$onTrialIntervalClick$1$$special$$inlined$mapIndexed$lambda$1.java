package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel$ViewState;
import com.discord.widgets.hubs.RadioSelectorItem;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1$$special$$inlined$mapIndexed$lambda$1 extends o implements Function1<GuildRoleSubscriptionTierViewModel$ViewState, RadioSelectorItem> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ SubscriptionTrialInterval $subscriptionTrialInterval;
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1$$special$$inlined$mapIndexed$lambda$1(int i, SubscriptionTrialInterval subscriptionTrialInterval, WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1) {
        super(1);
        this.$index = i;
        this.$subscriptionTrialInterval = subscriptionTrialInterval;
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ RadioSelectorItem invoke(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        return invoke2(guildRoleSubscriptionTierViewModel$ViewState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final RadioSelectorItem invoke2(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        m.checkNotNullParameter(guildRoleSubscriptionTierViewModel$ViewState, "guildRoleSubscriptionTierViewModelState");
        return new RadioSelectorItem(this.$index, String.valueOf(GuildRoleSubscriptionUtilsKt.getFormattedLabel(this.$subscriptionTrialInterval, this.this$0.this$0.this$0.requireContext())), m.areEqual(guildRoleSubscriptionTierViewModel$ViewState.getGuildRoleSubscriptionTier().getTrialInterval(), this.$subscriptionTrialInterval));
    }
}
