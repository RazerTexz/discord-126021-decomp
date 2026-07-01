package com.discord.widgets.servers.auditlog;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog$Model$Loaded extends WidgetServerSettingsAuditLog$Model {
    private final CharSequence actionFilterText;
    private final List<MGRecyclerDataPayload> auditLogEntryItems;
    private final CharSequence usernameFilterText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetServerSettingsAuditLog$Model$Loaded(List<? extends MGRecyclerDataPayload> list, CharSequence charSequence, CharSequence charSequence2) {
        super(null);
        m.checkNotNullParameter(list, "auditLogEntryItems");
        m.checkNotNullParameter(charSequence, "usernameFilterText");
        m.checkNotNullParameter(charSequence2, "actionFilterText");
        this.auditLogEntryItems = list;
        this.usernameFilterText = charSequence;
        this.actionFilterText = charSequence2;
    }

    public final CharSequence getActionFilterText() {
        return this.actionFilterText;
    }

    public final List<MGRecyclerDataPayload> getAuditLogEntryItems() {
        return this.auditLogEntryItems;
    }

    public final CharSequence getUsernameFilterText() {
        return this.usernameFilterText;
    }
}
