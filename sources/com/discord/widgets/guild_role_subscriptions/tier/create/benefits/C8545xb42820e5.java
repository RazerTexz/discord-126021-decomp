package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2 */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8545xb42820e5 extends AbstractC12240o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 this$0;

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierBenefitsViewModel.ViewState, Unit> {
        public final /* synthetic */ int $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i) {
            super(1);
            this.$index = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            C8545xb42820e5.this.this$0.this$0.getViewModel().updateFreeTrialLimit(viewState.getActiveTrialUserLimitOptions().get(this.$index));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8545xb42820e5(WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.f27425a;
    }

    public final void invoke(int i) {
        this.this$0.this$0.getBenefitsViewModel().withViewState(new AnonymousClass1(i));
    }
}
