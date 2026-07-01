package com.discord.widgets.servers.auditlog;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog$onViewBound$1<T> implements Action1<Menu> {
    public final /* synthetic */ WidgetServerSettingsAuditLog this$0;

    public WidgetServerSettingsAuditLog$onViewBound$1(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog) {
        this.this$0 = widgetServerSettingsAuditLog;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Menu menu) {
        call2(menu);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Menu menu) {
        View actionView;
        MenuItem menuItemFindItem = menu.findItem(R$id.menu_filter);
        if (menuItemFindItem == null || (actionView = menuItemFindItem.getActionView()) == null) {
            return;
        }
        actionView.setOnClickListener(new WidgetServerSettingsAuditLog$onViewBound$1$1(this));
    }
}
