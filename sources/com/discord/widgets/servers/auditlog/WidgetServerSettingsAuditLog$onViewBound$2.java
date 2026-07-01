package com.discord.widgets.servers.auditlog;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.discord.stores.StoreStream;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog$onViewBound$2 extends RecyclerView$OnScrollListener {
    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (recyclerView.canScrollVertically(1)) {
            return;
        }
        StoreStream.Companion.getAuditLog().fetchMoreAuditLogEntries();
    }
}
