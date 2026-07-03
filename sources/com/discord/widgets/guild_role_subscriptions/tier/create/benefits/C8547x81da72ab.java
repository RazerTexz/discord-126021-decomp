package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel;
import com.discord.widgets.hubs.RadioSelectorItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1 */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8547x81da72ab extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierBenefitsViewModel.ViewState, List<? extends RadioSelectorItem>> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8547x81da72ab(WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final List<RadioSelectorItem> invoke(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "it");
        List<SubscriptionTrialInterval> trialIntervalOptions = viewState.getTrialIntervalOptions();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(trialIntervalOptions, 10));
        int i = 0;
        for (Object obj : trialIntervalOptions) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            arrayList.add((RadioSelectorItem) this.this$0.this$0.getViewModel().withViewState(new C8548xe92b097c(i, (SubscriptionTrialInterval) obj, this)));
            i = i2;
        }
        return arrayList;
    }
}
