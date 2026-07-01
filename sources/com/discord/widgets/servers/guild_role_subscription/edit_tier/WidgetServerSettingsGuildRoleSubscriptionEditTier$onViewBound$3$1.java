package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3$1(WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3 widgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3) {
        super(0);
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getViewModel$p(this.this$0.this$0).deleteTier();
    }
}
