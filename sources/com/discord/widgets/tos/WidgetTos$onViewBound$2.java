package com.discord.widgets.tos;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetTos.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTos$onViewBound$2<T1, T2> implements Action2<MenuItem, Context> {
    public static final WidgetTos$onViewBound$2 INSTANCE = new WidgetTos$onViewBound$2();

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364409) {
            return;
        }
        StoreStream.Companion.getAuthentication().logout();
    }
}
