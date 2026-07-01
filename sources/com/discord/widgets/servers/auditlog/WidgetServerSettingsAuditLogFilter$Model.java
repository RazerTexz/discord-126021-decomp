package com.discord.widgets.servers.auditlog;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model {
    public static final WidgetServerSettingsAuditLogFilter$Model$Companion Companion = new WidgetServerSettingsAuditLogFilter$Model$Companion(null);
    private final List<MGRecyclerDataPayload> listItems;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetServerSettingsAuditLogFilter$Model(List<? extends MGRecyclerDataPayload> list) {
        m.checkNotNullParameter(list, "listItems");
        this.listItems = list;
    }

    public final List<MGRecyclerDataPayload> getListItems() {
        return this.listItems;
    }
}
