package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$21 implements View$OnClickListener {
    public static final WidgetSettings$onViewBound$1$21 INSTANCE = new WidgetSettings$onViewBound$1$21();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsVoice$Companion widgetSettingsVoice$Companion = WidgetSettingsVoice.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsVoice$Companion.launch$default(widgetSettingsVoice$Companion, context, null, false, 6, null);
    }
}
