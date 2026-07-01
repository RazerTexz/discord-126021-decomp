package com.discord.widgets.guild_role_subscriptions.setup;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanDetails$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanDetails this$0;

    public WidgetGuildRoleSubscriptionPlanDetails$onViewBound$2(WidgetGuildRoleSubscriptionPlanDetails widgetGuildRoleSubscriptionPlanDetails) {
        this.this$0 = widgetGuildRoleSubscriptionPlanDetails;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.openMediaChooser();
    }
}
