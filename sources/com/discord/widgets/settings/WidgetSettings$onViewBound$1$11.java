package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$11 implements View$OnClickListener {
    public static final WidgetSettings$onViewBound$1$11 INSTANCE = new WidgetSettings$onViewBound$1$11();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAuthorizedApps$Companion widgetSettingsAuthorizedApps$Companion = WidgetSettingsAuthorizedApps.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        widgetSettingsAuthorizedApps$Companion.launch(context);
    }
}
