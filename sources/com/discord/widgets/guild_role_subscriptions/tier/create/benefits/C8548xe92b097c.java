package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtilsKt;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.hubs.RadioSelectorItem;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1$$special$$inlined$mapIndexed$lambda$1 */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8548xe92b097c extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, RadioSelectorItem> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ SubscriptionTrialInterval $subscriptionTrialInterval;
    public final /* synthetic */ C8547x81da72ab this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8548xe92b097c(int i, SubscriptionTrialInterval subscriptionTrialInterval, C8547x81da72ab c8547x81da72ab) {
        super(1);
        this.$index = i;
        this.$subscriptionTrialInterval = subscriptionTrialInterval;
        this.this$0 = c8547x81da72ab;
    }

    @Override // kotlin.jvm.functions.Function1
    public final RadioSelectorItem invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "guildRoleSubscriptionTierViewModelState");
        return new RadioSelectorItem(this.$index, String.valueOf(GuildRoleSubscriptionUtilsKt.getFormattedLabel(this.$subscriptionTrialInterval, this.this$0.this$0.this$0.requireContext())), C12238m.areEqual(viewState.getGuildRoleSubscriptionTier().getTrialInterval(), this.$subscriptionTrialInterval));
    }
}
