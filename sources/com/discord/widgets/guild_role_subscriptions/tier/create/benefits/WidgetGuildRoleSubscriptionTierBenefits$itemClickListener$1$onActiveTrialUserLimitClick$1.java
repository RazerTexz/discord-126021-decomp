package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitsViewModel.ViewState, List<? extends WidgetRadioSelectorBottomSheet2>> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1(WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final List<WidgetRadioSelectorBottomSheet2> invoke(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "it");
        List<Integer> activeTrialUserLimitOptions = viewState.getActiveTrialUserLimitOptions();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(activeTrialUserLimitOptions, 10));
        int i = 0;
        for (Object obj : activeTrialUserLimitOptions) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            arrayList.add((WidgetRadioSelectorBottomSheet2) this.this$0.this$0.getViewModel().withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1$$special$$inlined$mapIndexed$lambda$1(i, (Integer) obj, this)));
            i = i2;
        }
        return arrayList;
    }
}
