package com.discord.widgets.guild_role_subscriptions.tier.create;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionReview$reviewViewModel$2 extends AbstractC12240o implements Function0<GuildRoleSubscriptionReviewViewModel> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionReview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionReview$reviewViewModel$2(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionReview;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionReviewViewModel invoke() {
        return new GuildRoleSubscriptionReviewViewModel(this.this$0.getGuildId(), null, null, null, 14, null);
    }
}
