package com.discord.widgets.channels.settings;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$configureUI$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ WidgetThreadSettingsViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetThreadSettings this$0;

    public WidgetThreadSettings$configureUI$1(WidgetThreadSettings widgetThreadSettings, WidgetThreadSettingsViewModel$ViewState widgetThreadSettingsViewModel$ViewState) {
        this.this$0 = widgetThreadSettings;
        this.$viewState = widgetThreadSettingsViewModel$ViewState;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364369) {
            return;
        }
        WidgetThreadSettings.access$confirmDelete(this.this$0, ((WidgetThreadSettingsViewModel$ViewState$Valid) this.$viewState).getChannel());
    }
}
