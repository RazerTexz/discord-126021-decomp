package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettings$configureUI$16 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettings$Model $model;
    public final /* synthetic */ WidgetServerSettings this$0;

    public WidgetServerSettings$configureUI$16(WidgetServerSettings widgetServerSettings, WidgetServerSettings$Model widgetServerSettings$Model) {
        this.this$0 = widgetServerSettings;
        this.$model = widgetServerSettings$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsGuildRoleSubscriptions.Companion.launch(this.this$0.requireContext(), this.$model.getGuild().getId());
    }
}
