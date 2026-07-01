package com.discord.widgets.guild_role_subscriptions.setup;

import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ List $steps$inlined;
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanSetup this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup, List list) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionPlanSetup;
        this.$steps$inlined = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(this.this$0.requireContext(), this.this$0.getGuildId());
        this.this$0.requireActivity().finish();
    }
}
