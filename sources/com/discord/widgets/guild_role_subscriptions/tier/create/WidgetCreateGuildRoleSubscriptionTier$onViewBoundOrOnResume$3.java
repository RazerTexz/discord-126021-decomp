package com.discord.widgets.guild_role_subscriptions.tier.create;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$3 extends o implements Function1<CreateGuildRoleSubscriptionTierViewModel$Event, Unit> {
    public final /* synthetic */ WidgetCreateGuildRoleSubscriptionTier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$3(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        super(1);
        this.this$0 = widgetCreateGuildRoleSubscriptionTier;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CreateGuildRoleSubscriptionTierViewModel$Event createGuildRoleSubscriptionTierViewModel$Event) {
        invoke2(createGuildRoleSubscriptionTierViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CreateGuildRoleSubscriptionTierViewModel$Event createGuildRoleSubscriptionTierViewModel$Event) {
        WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = this.this$0;
        m.checkNotNullExpressionValue(createGuildRoleSubscriptionTierViewModel$Event, "it");
        WidgetCreateGuildRoleSubscriptionTier.access$handleEvent(widgetCreateGuildRoleSubscriptionTier, createGuildRoleSubscriptionTierViewModel$Event);
    }
}
