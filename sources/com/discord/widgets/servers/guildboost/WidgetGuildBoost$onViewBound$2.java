package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.view.MenuItem;
import androidx.core.app.NotificationCompat;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$Companion;
import d0.z.d.m;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$onViewBound$2<T1, T2> implements Action2<MenuItem, Context> {
    public static final WidgetGuildBoost$onViewBound$2 INSTANCE = new WidgetGuildBoost$onViewBound$2();

    @Override // rx.functions.Action2
    public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
        call2(menuItem, context);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(MenuItem menuItem, Context context) {
        m.checkNotNullExpressionValue(menuItem, "menuItem");
        if (menuItem.getItemId() != 2131364398) {
            return;
        }
        WidgetSettingsGuildBoost$Companion widgetSettingsGuildBoost$Companion = WidgetSettingsGuildBoost.Companion;
        m.checkNotNullExpressionValue(context, "context");
        widgetSettingsGuildBoost$Companion.launch(context);
    }
}
