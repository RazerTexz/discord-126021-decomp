package com.discord.widgets.servers.auditlog;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.PopupMenu$OnMenuItemClickListener;
import b.d.b.a.a;
import com.discord.R$id;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog$onViewBound$1$1$1 implements PopupMenu$OnMenuItemClickListener {
    public final /* synthetic */ View $view;
    public final /* synthetic */ WidgetServerSettingsAuditLog$onViewBound$1$1 this$0;

    public WidgetServerSettingsAuditLog$onViewBound$1$1$1(WidgetServerSettingsAuditLog$onViewBound$1$1 widgetServerSettingsAuditLog$onViewBound$1$1, View view) {
        this.this$0 = widgetServerSettingsAuditLog$onViewBound$1$1;
        this.$view = view;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.appcompat.widget.PopupMenu$OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        m.checkNotNullExpressionValue(menuItem, "it");
        switch (menuItem.getItemId()) {
            case R$id.menu_audit_log_sort_actions /* 2131364361 */:
                WidgetServerSettingsAuditLogFilter.Companion.show(a.x(this.$view, "view", "view.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(this.this$0.this$0.this$0), 1);
                return true;
            case R$id.menu_audit_log_sort_users /* 2131364362 */:
                WidgetServerSettingsAuditLogFilter.Companion.show(a.x(this.$view, "view", "view.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(this.this$0.this$0.this$0), 0);
                return true;
            default:
                return true;
        }
    }
}
