package com.discord.widgets.settings;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import com.discord.widgets.debugging.WidgetDebugging;
import com.discord.widgets.debugging.WidgetDebugging$Companion;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$configureToolbar$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetSettings this$0;

    public WidgetSettings$configureToolbar$1(WidgetSettings widgetSettings) {
        this.this$0 = widgetSettings;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        switch (menuItem.getItemId()) {
            case R$id.menu_settings_debugging /* 2131364408 */:
                WidgetDebugging$Companion widgetDebugging$Companion = WidgetDebugging.Companion;
                m.checkNotNullExpressionValue(context, "context");
                widgetDebugging$Companion.launch(context);
                break;
            case R$id.menu_settings_log_out /* 2131364409 */:
                WidgetSettings widgetSettings = this.this$0;
                m.checkNotNullExpressionValue(context, "context");
                WidgetSettings.access$showLogoutDialog(widgetSettings, context);
                break;
        }
    }
}
