package com.discord.widgets.contact_sync;

import android.view.Menu;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$configureToolbar$2<T> implements Action1<Menu> {
    public final /* synthetic */ WidgetContactSyncViewModel$ToolbarConfig $toolbarConfig;

    public WidgetContactSync$configureToolbar$2(WidgetContactSyncViewModel$ToolbarConfig widgetContactSyncViewModel$ToolbarConfig) {
        this.$toolbarConfig = widgetContactSyncViewModel$ToolbarConfig;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Menu menu) {
        call2(menu);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R$id.menu_contact_sync_skip);
        m.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_contact_sync_skip)");
        menuItemFindItem.setVisible(this.$toolbarConfig.getShowSkip());
    }
}
