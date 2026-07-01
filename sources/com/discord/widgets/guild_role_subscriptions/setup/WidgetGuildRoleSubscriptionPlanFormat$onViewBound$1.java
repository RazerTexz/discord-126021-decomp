package com.discord.widgets.guild_role_subscriptions.setup;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanFormat$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanFormat this$0;

    public WidgetGuildRoleSubscriptionPlanFormat$onViewBound$1(WidgetGuildRoleSubscriptionPlanFormat widgetGuildRoleSubscriptionPlanFormat) {
        this.this$0 = widgetGuildRoleSubscriptionPlanFormat;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildRoleSubscriptionPlanFormat.access$getViewModel$p(this.this$0).updateFullServerGate(true);
    }
}
