package com.discord.widgets.servers.auditlog;

import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter$AuditLogLoadingViewHolder extends MGRecyclerViewHolder<WidgetServerSettingsAuditLogAdapter, MGRecyclerDataPayload> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogAdapter$AuditLogLoadingViewHolder(WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter) {
        super(R$layout.widget_server_settings_audit_log_loading_listitem, widgetServerSettingsAuditLogAdapter);
        m.checkNotNullParameter(widgetServerSettingsAuditLogAdapter, "adapter");
    }
}
