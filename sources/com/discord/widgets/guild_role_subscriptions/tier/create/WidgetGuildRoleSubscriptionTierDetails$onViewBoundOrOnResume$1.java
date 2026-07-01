package com.discord.widgets.guild_role_subscriptions.tier.create;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails$onViewBoundOrOnResume$1 extends o implements Function1<GuildRoleSubscriptionTierViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDetails this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierDetails$onViewBoundOrOnResume$1(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionTierDetails;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        invoke2(guildRoleSubscriptionTierViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails = this.this$0;
        m.checkNotNullExpressionValue(guildRoleSubscriptionTierViewModel$ViewState, "viewState");
        WidgetGuildRoleSubscriptionTierDetails.access$configureUI(widgetGuildRoleSubscriptionTierDetails, guildRoleSubscriptionTierViewModel$ViewState);
    }
}
