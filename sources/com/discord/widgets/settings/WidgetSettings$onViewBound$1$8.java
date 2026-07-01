package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import com.discord.widgets.settings.premium.WidgetSettingsGifting$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$8 implements View$OnClickListener {
    public static final WidgetSettings$onViewBound$1$8 INSTANCE = new WidgetSettings$onViewBound$1$8();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsGifting$Companion widgetSettingsGifting$Companion = WidgetSettingsGifting.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsGifting$Companion.launch$default(widgetSettingsGifting$Companion, context, null, 2, null);
    }
}
