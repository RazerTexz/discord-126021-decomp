package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsAuditLog this$0;

    public WidgetServerSettingsAuditLog$onViewBound$4(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog) {
        this.this$0 = widgetServerSettingsAuditLog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsAuditLogFilter.Companion.show(a.x(view, "it", "it.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(this.this$0), 0);
    }
}
