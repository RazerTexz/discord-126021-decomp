package com.discord.widgets.channels.settings;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings$configureUi$1<T1, T2> implements Action2<MenuItem, Context> {
    public final /* synthetic */ String $displayName;
    public final /* synthetic */ WidgetChannelGroupDMSettings this$0;

    public WidgetChannelGroupDMSettings$configureUi$1(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings, String str) {
        this.this$0 = widgetChannelGroupDMSettings;
        this.$displayName = str;
    }

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() == 2131364393) {
            WidgetChannelGroupDMSettings widgetChannelGroupDMSettings = this.this$0;
            WidgetChannelGroupDMSettings.access$confirmLeave(widgetChannelGroupDMSettings, widgetChannelGroupDMSettings.requireContext(), new WidgetChannelGroupDMSettings$configureUi$1$1(this), this.$displayName);
        }
    }
}
