package com.discord.widgets.debugging;

import android.view.Menu;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$configureUI$2<T> implements Action1<Menu> {
    public final /* synthetic */ WidgetDebugging$Model $model;

    public WidgetDebugging$configureUI$2(WidgetDebugging$Model widgetDebugging$Model) {
        this.$model = widgetDebugging$Model;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Menu menu) {
        call2(menu);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R$id.menu_debugging_filter);
        m.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_debugging_filter)");
        menuItemFindItem.setChecked(this.$model.isFiltered());
    }
}
