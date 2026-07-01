package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils2;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1$$special$$inlined$mapIndexed$lambda$1 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, WidgetRadioSelectorBottomSheet2> {
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
    public final WidgetRadioSelectorBottomSheet2 invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "guildRoleSubscriptionTierViewModelState");
        return new WidgetRadioSelectorBottomSheet2(this.$index, String.valueOf(GuildRoleSubscriptionUtils2.getFormattedLabel(this.$subscriptionTrialInterval, this.this$0.this$0.this$0.requireContext())), Intrinsics3.areEqual(viewState.getGuildRoleSubscriptionTier().getTrialInterval(), this.$subscriptionTrialInterval));
    }
}
