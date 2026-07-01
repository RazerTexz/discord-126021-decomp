package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.hubs.RadioSelectorItems;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet$Companion;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 implements GuildRoleSubscriptionBenefitAdapter$Listener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter$Listener
    public void onActiveTrialUserLimitClick() {
        WidgetRadioSelectorBottomSheet$Companion widgetRadioSelectorBottomSheet$Companion = WidgetRadioSelectorBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.requireContext().getString(2131890622);
        m.checkNotNullExpressionValue(string, "requireContext().getStri…e_trial_user_limit_title)");
        widgetRadioSelectorBottomSheet$Companion.show(parentFragmentManager, new RadioSelectorItems(string, (List) WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(this.this$0).withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1(this))), new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2(this));
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter$Listener
    public void onAddBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem benefitAdapterItem) {
        m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        WidgetGuildRoleSubscriptionTierBenefit$Companion.launch$default(WidgetGuildRoleSubscriptionTierBenefit.Companion, this.this$0.requireContext(), WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitLauncher$p(this.this$0), WidgetGuildRoleSubscriptionTierBenefits.access$getGuildId$p(this.this$0), benefitAdapterItem.getType(), benefitAdapterItem.getTierName(), null, 32, null);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter$Listener
    public void onBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
        m.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        if (benefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem$BenefitItem) {
            GuildRoleSubscriptionBenefitAdapterItem$BenefitItem guildRoleSubscriptionBenefitAdapterItem$BenefitItem = (GuildRoleSubscriptionBenefitAdapterItem$BenefitItem) benefitAdapterItem;
            WidgetGuildRoleSubscriptionTierBenefit.Companion.launch(this.this$0.requireContext(), WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitLauncher$p(this.this$0), WidgetGuildRoleSubscriptionTierBenefits.access$getGuildId$p(this.this$0), guildRoleSubscriptionBenefitAdapterItem$BenefitItem.getType(), guildRoleSubscriptionBenefitAdapterItem$BenefitItem.getTierName(), guildRoleSubscriptionBenefitAdapterItem$BenefitItem.getBenefit());
        }
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter$Listener
    public void onFreeTrialToggle(boolean isEnabled) {
        if (isEnabled) {
            WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(this.this$0).withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onFreeTrialToggle$1(this));
        } else {
            WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0).updateFreeTrialInterval(null);
        }
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter$Listener
    public void onTrialIntervalClick() {
        WidgetRadioSelectorBottomSheet$Companion widgetRadioSelectorBottomSheet$Companion = WidgetRadioSelectorBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.requireContext().getString(2131890606);
        m.checkNotNullExpressionValue(string, "requireContext().getStri…e_trial_time_limit_title)");
        widgetRadioSelectorBottomSheet$Companion.show(parentFragmentManager, new RadioSelectorItems(string, (List) WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(this.this$0).withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1(this))), new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$2(this));
    }
}
