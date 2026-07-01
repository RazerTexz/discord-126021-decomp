package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$3 implements View$OnClickListener {
    public final /* synthetic */ MGRecyclerDataPayload $data;
    public final /* synthetic */ WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder this$0;

    public WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$3(WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder widgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder, MGRecyclerDataPayload mGRecyclerDataPayload) {
        this.this$0 = widgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder;
        this.$data = mGRecyclerDataPayload;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsAuditLogAdapter.access$setEnsureExpandedIsVisible$p(WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder.access$getAdapter$p(this.this$0), true);
        StoreStream.Companion.getAuditLog().toggleSelectedState(((WidgetServerSettingsAuditLogAdapter$AuditLogEntryItem) this.$data).getAuditLogEntry().getId());
    }
}
