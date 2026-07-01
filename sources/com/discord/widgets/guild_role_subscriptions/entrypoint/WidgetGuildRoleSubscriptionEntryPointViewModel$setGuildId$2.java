package com.discord.widgets.guild_role_subscriptions.entrypoint;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPointViewModel$setGuildId$2 extends o implements Function1<WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionEntryPointViewModel$setGuildId$2(WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionEntryPointViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState widgetGuildRoleSubscriptionEntryPointViewModel$StoreState) {
        invoke2(widgetGuildRoleSubscriptionEntryPointViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState widgetGuildRoleSubscriptionEntryPointViewModel$StoreState) {
        WidgetGuildRoleSubscriptionEntryPointViewModel widgetGuildRoleSubscriptionEntryPointViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetGuildRoleSubscriptionEntryPointViewModel$StoreState, "storeState");
        WidgetGuildRoleSubscriptionEntryPointViewModel.access$handleStoreState(widgetGuildRoleSubscriptionEntryPointViewModel, widgetGuildRoleSubscriptionEntryPointViewModel$StoreState);
    }
}
