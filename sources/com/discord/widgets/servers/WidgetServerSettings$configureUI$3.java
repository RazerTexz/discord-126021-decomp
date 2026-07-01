package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog;

/* JADX INFO: compiled from: WidgetServerSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettings$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettings$Model $model;

    public WidgetServerSettings$configureUI$3(WidgetServerSettings$Model widgetServerSettings$Model) {
        this.$model = widgetServerSettings$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsAuditLog.Companion.create(a.x(view, "v", "v.context"), this.$model.getGuild().getId(), this.$model.getGuild().getName());
    }
}
