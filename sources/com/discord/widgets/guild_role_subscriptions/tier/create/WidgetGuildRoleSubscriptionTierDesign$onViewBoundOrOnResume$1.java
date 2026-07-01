package com.discord.widgets.guild_role_subscriptions.tier.create;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign$onViewBoundOrOnResume$1 extends o implements Function1<GuildRoleSubscriptionTierViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDesign this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierDesign$onViewBoundOrOnResume$1(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierDesign;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        invoke2(guildRoleSubscriptionTierViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        m.checkNotNullParameter(guildRoleSubscriptionTierViewModel$ViewState, "it");
        WidgetGuildRoleSubscriptionTierDesign.access$configureUI(this.this$0, guildRoleSubscriptionTierViewModel$ViewState);
    }
}
