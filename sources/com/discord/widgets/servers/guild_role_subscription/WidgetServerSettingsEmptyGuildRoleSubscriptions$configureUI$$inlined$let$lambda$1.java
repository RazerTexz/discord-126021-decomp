package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup;

/* JADX INFO: compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$$inlined$let$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEmptyGuildRoleSubscriptions this$0;

    public WidgetServerSettingsEmptyGuildRoleSubscriptions$configureUI$$inlined$let$lambda$1(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        this.this$0 = widgetServerSettingsEmptyGuildRoleSubscriptions;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildRoleSubscriptionPlanSetup.Companion.launch(this.this$0.requireContext(), WidgetServerSettingsEmptyGuildRoleSubscriptions.access$getGuildId$p(this.this$0));
        this.this$0.requireActivity().finish();
    }
}
