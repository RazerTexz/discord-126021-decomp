package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.app.AppFragment;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$2(WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3 widgetGuildRoleSubscriptionTierBenefit$onViewBound$3) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit$onViewBound$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AppFragment.hideKeyboard$default(this.this$0.this$0, null, 1, null);
    }
}
