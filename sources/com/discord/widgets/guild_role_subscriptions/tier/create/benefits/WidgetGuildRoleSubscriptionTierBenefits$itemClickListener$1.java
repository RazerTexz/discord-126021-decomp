package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.hubs.RadioSelectorItems;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet;
import java.util.List;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.requireContext().getString(C5419R.string.guild_role_subscription_setup_tier_active_trial_user_limit_title);
        C12238m.checkNotNullExpressionValue(string, "requireContext().getStri…e_trial_user_limit_title)");
        companion.show(parentFragmentManager, new RadioSelectorItems(string, (List) this.this$0.getBenefitsViewModel().withViewState(new C8543xb42820e4(this))), new C8545xb42820e5(this));
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onAddBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem benefitAdapterItem) {
        C12238m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        WidgetGuildRoleSubscriptionTierBenefit.INSTANCE.launch(this.this$0.requireContext(), this.this$0.benefitLauncher, this.this$0.getGuildId(), benefitAdapterItem.getType(), (32 & 16) != 0 ? null : benefitAdapterItem.getTierName(), (32 & 32) != 0 ? null : null);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
        C12238m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        if (benefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) {
            GuildRoleSubscriptionBenefitAdapterItem.BenefitItem benefitItem = (GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) benefitAdapterItem;
            WidgetGuildRoleSubscriptionTierBenefit.INSTANCE.launch(this.this$0.requireContext(), this.this$0.benefitLauncher, this.this$0.getGuildId(), benefitItem.getType(), benefitItem.getTierName(), benefitItem.getBenefit());
        }
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onFreeTrialToggle(boolean isEnabled) {
        if (isEnabled) {
            this.this$0.getBenefitsViewModel().withViewState(new C8546xa5534d9a(this));
        } else {
            this.this$0.getViewModel().updateFreeTrialInterval(null);
        }
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onTrialIntervalClick() {
        WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.requireContext().getString(C5419R.string.guild_role_subscription_setup_free_trial_time_limit_title);
        C12238m.checkNotNullExpressionValue(string, "requireContext().getStri…e_trial_time_limit_title)");
        companion.show(parentFragmentManager, new RadioSelectorItems(string, (List) this.this$0.getBenefitsViewModel().withViewState(new C8547x81da72ab(this))), new C8549x81da72ac(this));
    }
}
