package com.discord.widgets.servers;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetServerSettingsEmojisEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojisEdit$configureMenu$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetServerSettingsEmojisEdit this$0;

    public WidgetServerSettingsEmojisEdit$configureMenu$1(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        this.this$0 = widgetServerSettingsEmojisEdit;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364406) {
            return;
        }
        WidgetServerSettingsEmojisEdit.access$deleteEmoji(this.this$0);
    }
}
