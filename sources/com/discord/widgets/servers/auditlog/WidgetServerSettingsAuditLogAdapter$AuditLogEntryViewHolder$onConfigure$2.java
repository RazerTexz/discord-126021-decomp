package com.discord.widgets.servers.auditlog;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$2 implements Runnable {
    public final /* synthetic */ WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder this$0;

    public WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder$onConfigure$2(WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder widgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder) {
        this.this$0 = widgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView$LayoutManager layoutManager = WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getRecycler().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int iMin = Math.min(linearLayoutManager.findLastCompletelyVisibleItemPosition(), WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getPageSize() - 1);
            int adapterPosition = this.this$0.getAdapterPosition();
            if (iFindFirstCompletelyVisibleItemPosition >= 0 && iMin >= iFindFirstCompletelyVisibleItemPosition && adapterPosition >= 0) {
                if (iFindFirstCompletelyVisibleItemPosition > adapterPosition || iMin < adapterPosition) {
                    WidgetServerSettingsAuditLogAdapter$AuditLogEntryViewHolder.access$getAdapter$p(this.this$0).getRecycler().smoothScrollToPosition(this.this$0.getAdapterPosition());
                }
            }
        }
    }
}
