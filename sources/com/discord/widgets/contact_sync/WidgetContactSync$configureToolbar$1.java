package com.discord.widgets.contact_sync;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$configureToolbar$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetContactSync this$0;

    public WidgetContactSync$configureToolbar$1(WidgetContactSync widgetContactSync) {
        this.this$0 = widgetContactSync;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364380) {
            return;
        }
        WidgetContactSync.access$getViewModel$p(this.this$0).skip();
    }
}
