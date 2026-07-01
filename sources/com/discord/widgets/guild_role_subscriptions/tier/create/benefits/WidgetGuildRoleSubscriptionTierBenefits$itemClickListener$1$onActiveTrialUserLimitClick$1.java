package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.hubs.RadioSelectorItem;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1 extends o implements Function1<GuildRoleSubscriptionTierBenefitsViewModel$ViewState, List<? extends RadioSelectorItem>> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1(WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends RadioSelectorItem> invoke(GuildRoleSubscriptionTierBenefitsViewModel$ViewState guildRoleSubscriptionTierBenefitsViewModel$ViewState) {
        return invoke2(guildRoleSubscriptionTierBenefitsViewModel$ViewState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<RadioSelectorItem> invoke2(GuildRoleSubscriptionTierBenefitsViewModel$ViewState guildRoleSubscriptionTierBenefitsViewModel$ViewState) {
        m.checkNotNullParameter(guildRoleSubscriptionTierBenefitsViewModel$ViewState, "it");
        List<Integer> activeTrialUserLimitOptions = guildRoleSubscriptionTierBenefitsViewModel$ViewState.getActiveTrialUserLimitOptions();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(activeTrialUserLimitOptions, 10));
        int i = 0;
        for (Object obj : activeTrialUserLimitOptions) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            arrayList.add((RadioSelectorItem) WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0.this$0).withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1$$special$$inlined$mapIndexed$lambda$1(i, (Integer) obj, this)));
            i = i2;
        }
        return arrayList;
    }
}
