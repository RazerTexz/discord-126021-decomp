package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier this$0;

    public WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$1(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        this.this$0 = widgetServerSettingsGuildRoleSubscriptionEditTier;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getViewModel$p(this.this$0).submitChanges();
    }
}
