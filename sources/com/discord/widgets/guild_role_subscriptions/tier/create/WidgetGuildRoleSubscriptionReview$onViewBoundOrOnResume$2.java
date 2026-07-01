package com.discord.widgets.guild_role_subscriptions.tier.create;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$2 extends o implements Function1<GuildRoleSubscriptionReviewViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionReview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$2(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview) {
        super(1);
        this.this$0 = widgetGuildRoleSubscriptionReview;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionReviewViewModel$ViewState guildRoleSubscriptionReviewViewModel$ViewState) {
        invoke2(guildRoleSubscriptionReviewViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildRoleSubscriptionReviewViewModel$ViewState guildRoleSubscriptionReviewViewModel$ViewState) {
        m.checkNotNullParameter(guildRoleSubscriptionReviewViewModel$ViewState, "it");
        WidgetGuildRoleSubscriptionReview.access$configureUI(this.this$0, guildRoleSubscriptionReviewViewModel$ViewState);
    }
}
