package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.C5419R;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.hubs.RadioSelectorItem;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1$$special$$inlined$mapIndexed$lambda$1 */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8544x62fd44f5 extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, RadioSelectorItem> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ Integer $limitOption;
    public final /* synthetic */ C8543xb42820e4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8544x62fd44f5(int i, Integer num, C8543xb42820e4 c8543xb42820e4) {
        super(1);
        this.$index = i;
        this.$limitOption = num;
        this.this$0 = c8543xb42820e4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final RadioSelectorItem invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        String string;
        C12238m.checkNotNullParameter(viewState, "guildRoleSubscriptionTierViewModelState");
        int i = this.$index;
        Integer num = this.$limitOption;
        if (num == null || (string = String.valueOf(num.intValue())) == null) {
            string = this.this$0.this$0.this$0.getString(C5419R.string.f14707x846378d0);
            C12238m.checkNotNullExpressionValue(string, "getString(\n             …                        )");
        }
        return new RadioSelectorItem(i, string, C12238m.areEqual(this.$limitOption, viewState.getGuildRoleSubscriptionTier().getActiveTrialUserLimit()));
    }
}
