package com.discord.widgets.settings.connections;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$onViewBound$2<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetSettingsUserConnections this$0;

    public WidgetSettingsUserConnections$onViewBound$2(WidgetSettingsUserConnections widgetSettingsUserConnections) {
        this.this$0 = widgetSettingsUserConnections;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() == 2131364360 && this.this$0.getContext() != null) {
            WidgetSettingsUserConnectionsAdd.Companion.show(this.this$0);
        }
    }
}
