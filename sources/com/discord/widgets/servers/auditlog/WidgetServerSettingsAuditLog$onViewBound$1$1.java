package com.discord.widgets.servers.auditlog;

import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.widget.PopupMenu;
import com.discord.R$menu;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog$onViewBound$1$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsAuditLog$onViewBound$1 this$0;

    public WidgetServerSettingsAuditLog$onViewBound$1$1(WidgetServerSettingsAuditLog$onViewBound$1 widgetServerSettingsAuditLog$onViewBound$1) {
        this.this$0 = widgetServerSettingsAuditLog$onViewBound$1;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(this.this$0.this$0.getContext(), 2131951663), view);
        popupMenu.getMenuInflater().inflate(R$menu.menu_audit_log_sort, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new WidgetServerSettingsAuditLog$onViewBound$1$1$1(this, view));
        popupMenu.show();
    }
}
