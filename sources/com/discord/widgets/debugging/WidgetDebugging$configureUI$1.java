package com.discord.widgets.debugging;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$configureUI$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetDebugging this$0;

    public WidgetDebugging$configureUI$1(WidgetDebugging widgetDebugging) {
        this.this$0 = widgetDebugging;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364385) {
            return;
        }
        boolean z2 = !menuItem.isChecked();
        menuItem.setChecked(z2);
        WidgetDebugging.access$getFilterSubject$p(this.this$0).onNext(Boolean.valueOf(z2));
    }
}
