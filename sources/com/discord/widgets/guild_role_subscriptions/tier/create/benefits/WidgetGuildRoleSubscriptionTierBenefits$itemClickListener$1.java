package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import androidx.fragment.app.FragmentManager;
import com.discord.R;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet3;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 implements GuildRoleSubscriptionBenefitAdapter.Listener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onActiveTrialUserLimitClick() {
        WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.requireContext().getString(R.string.guild_role_subscription_setup_tier_active_trial_user_limit_title);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getStri…e_trial_user_limit_title)");
        companion.show(parentFragmentManager, new WidgetRadioSelectorBottomSheet3(string, (List) this.this$0.getBenefitsViewModel().withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1(this))), new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2(this));
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onAddBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem benefitAdapterItem) {
        Intrinsics3.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        WidgetGuildRoleSubscriptionTierBenefit.INSTANCE.launch(this.this$0.requireContext(), this.this$0.benefitLauncher, this.this$0.getGuildId(), benefitAdapterItem.getType(), (32 & 16) != 0 ? null : benefitAdapterItem.getTierName(), (32 & 32) != 0 ? null : null);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
        Intrinsics3.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        if (benefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) {
            GuildRoleSubscriptionBenefitAdapterItem.BenefitItem benefitItem = (GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) benefitAdapterItem;
            WidgetGuildRoleSubscriptionTierBenefit.INSTANCE.launch(this.this$0.requireContext(), this.this$0.benefitLauncher, this.this$0.getGuildId(), benefitItem.getType(), benefitItem.getTierName(), benefitItem.getBenefit());
        }
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onFreeTrialToggle(boolean isEnabled) {
        if (isEnabled) {
            this.this$0.getBenefitsViewModel().withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onFreeTrialToggle$1(this));
        } else {
            this.this$0.getViewModel().updateFreeTrialInterval(null);
        }
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onTrialIntervalClick() {
        WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.requireContext().getString(R.string.guild_role_subscription_setup_free_trial_time_limit_title);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getStri…e_trial_time_limit_title)");
        companion.show(parentFragmentManager, new WidgetRadioSelectorBottomSheet3(string, (List) this.this$0.getBenefitsViewModel().withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1(this))), new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$2(this));
    }
}
