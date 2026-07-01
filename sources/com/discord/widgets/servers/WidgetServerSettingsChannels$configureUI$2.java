package com.discord.widgets.servers;

import android.view.Menu;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$configureUI$2<T> implements Action1<Menu> {
    public final /* synthetic */ WidgetServerSettingsChannels$Model $model;

    public WidgetServerSettingsChannels$configureUI$2(WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model) {
        this.$model = widgetServerSettingsChannels$Model;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Menu menu) {
        call2(menu);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R$id.menu_sort_channel);
        m.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_sort_channel)");
        menuItemFindItem.setVisible(!this.$model.isSorting());
        MenuItem menuItemFindItem2 = menu.findItem(R$id.menu_sort_done);
        m.checkNotNullExpressionValue(menuItemFindItem2, "menu.findItem(R.id.menu_sort_done)");
        menuItemFindItem2.setVisible(this.$model.isSorting());
    }
}
