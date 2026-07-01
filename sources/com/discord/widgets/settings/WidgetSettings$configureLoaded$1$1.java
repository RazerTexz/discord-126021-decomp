package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$configureLoaded$1$1 implements View$OnClickListener {
    public static final WidgetSettings$configureLoaded$1$1 INSTANCE = new WidgetSettings$configureLoaded$1$1();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsDeveloper$Companion widgetSettingsDeveloper$Companion = WidgetSettingsDeveloper.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        widgetSettingsDeveloper$Companion.launch(context);
    }
}
