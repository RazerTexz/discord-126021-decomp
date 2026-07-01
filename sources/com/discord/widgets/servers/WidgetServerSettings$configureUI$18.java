package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.servers.guild_role_subscription.payments.WidgetServerSettingsGuildRoleSubscriptionEarnings;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettings$configureUI$18 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettings this$0;

    public WidgetServerSettings$configureUI$18(WidgetServerSettings widgetServerSettings) {
        this.this$0 = widgetServerSettings;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsGuildRoleSubscriptionEarnings.Companion.launch(this.this$0.requireContext());
    }
}
