package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.account.WidgetSettingsAccount$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onViewBound$3 implements View$OnClickListener {
    public static final WidgetSettingsPrivacy$onViewBound$3 INSTANCE = new WidgetSettingsPrivacy$onViewBound$3();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccount$Companion widgetSettingsAccount$Companion = WidgetSettingsAccount.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsAccount$Companion.launch$default(widgetSettingsAccount$Companion, context, true, null, 4, null);
    }
}
