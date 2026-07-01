package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel$ViewState;
import com.discord.widgets.hubs.RadioSelectorItem;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1$$special$$inlined$mapIndexed$lambda$1 extends o implements Function1<GuildRoleSubscriptionTierViewModel$ViewState, RadioSelectorItem> {
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
    public /* bridge */ /* synthetic */ RadioSelectorItem invoke(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        return invoke2(guildRoleSubscriptionTierViewModel$ViewState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final RadioSelectorItem invoke2(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        String string;
        m.checkNotNullParameter(guildRoleSubscriptionTierViewModel$ViewState, "guildRoleSubscriptionTierViewModelState");
        int i = this.$index;
        Integer num = this.$limitOption;
        if (num == null || (string = String.valueOf(num.intValue())) == null) {
            string = this.this$0.this$0.this$0.getString(2131890621);
            m.checkNotNullExpressionValue(string, "getString(\n             …                        )");
        }
        return new RadioSelectorItem(i, string, m.areEqual(this.$limitOption, guildRoleSubscriptionTierViewModel$ViewState.getGuildRoleSubscriptionTier().getActiveTrialUserLimit()));
    }
}
