package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptions$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptions this$0;

    public WidgetServerSettingsGuildRoleSubscriptions$onViewBound$1(WidgetServerSettingsGuildRoleSubscriptions widgetServerSettingsGuildRoleSubscriptions) {
        this.this$0 = widgetServerSettingsGuildRoleSubscriptions;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsGuildRoleSubscriptions.access$getViewModel$p(this.this$0).submitChanges();
    }
}
