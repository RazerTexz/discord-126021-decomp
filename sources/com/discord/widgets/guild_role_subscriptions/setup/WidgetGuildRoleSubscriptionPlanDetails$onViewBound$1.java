package com.discord.widgets.guild_role_subscriptions.setup;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanDetails$onViewBound$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanDetails this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionPlanDetails$onViewBound$1(WidgetGuildRoleSubscriptionPlanDetails widgetGuildRoleSubscriptionPlanDetails) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionPlanDetails;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "it");
        WidgetGuildRoleSubscriptionPlanDetails.access$getViewModel$p(this.this$0).updateDescription(str);
    }
}
