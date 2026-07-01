package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$6 implements View$OnClickListener {
    public static final WidgetSettings$onViewBound$1$6 INSTANCE = new WidgetSettings$onViewBound$1$6();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsGuildBoost$Companion widgetSettingsGuildBoost$Companion = WidgetSettingsGuildBoost.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        widgetSettingsGuildBoost$Companion.launch(context);
    }
}
