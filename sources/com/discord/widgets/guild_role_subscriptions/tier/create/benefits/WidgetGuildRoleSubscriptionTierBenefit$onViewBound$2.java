package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    public WidgetGuildRoleSubscriptionTierBenefit$onViewBound$2(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildRoleSubscriptionTierBenefit.access$cancel(this.this$0);
    }
}
