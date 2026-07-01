package com.discord.widgets.channels.settings;

import android.view.Menu;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.R$id;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$configureUI$2<T> implements Action1<Menu> {
    public final /* synthetic */ WidgetThreadSettingsViewModel$ViewState $viewState;

    public WidgetThreadSettings$configureUI$2(WidgetThreadSettingsViewModel$ViewState widgetThreadSettingsViewModel$ViewState) {
        this.$viewState = widgetThreadSettingsViewModel$ViewState;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Menu menu) {
        call2(menu);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R$id.menu_channel_settings_delete);
        m.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
        menuItemFindItem.setVisible(((WidgetThreadSettingsViewModel$ViewState$Valid) this.$viewState).getCanManageThread());
        menu.findItem(R$id.menu_channel_settings_delete).setTitle(2131888404);
        MenuItem menuItemFindItem2 = menu.findItem(R$id.menu_channel_settings_reset);
        m.checkNotNullExpressionValue(menuItemFindItem2, "it.findItem(R.id.menu_channel_settings_reset)");
        menuItemFindItem2.setVisible(false);
    }
}
