package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.R;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1$$special$$inlined$mapIndexed$lambda$1 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, WidgetRadioSelectorBottomSheet2> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ Integer $limitOption;
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1$$special$$inlined$mapIndexed$lambda$1(int i, Integer num, WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1) {
        super(1);
        this.$index = i;
        this.$limitOption = num;
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetRadioSelectorBottomSheet2 invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        String string;
        Intrinsics3.checkNotNullParameter(viewState, "guildRoleSubscriptionTierViewModelState");
        int i = this.$index;
        Integer num = this.$limitOption;
        if (num == null || (string = String.valueOf(num.intValue())) == null) {
            string = this.this$0.this$0.this$0.getString(R.string.guild_role_subscription_setup_tier_active_trial_user_limit_none_option);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(\n             …                        )");
        }
        return new WidgetRadioSelectorBottomSheet2(i, string, Intrinsics3.areEqual(this.$limitOption, viewState.getGuildRoleSubscriptionTier().getActiveTrialUserLimit()));
    }
}
