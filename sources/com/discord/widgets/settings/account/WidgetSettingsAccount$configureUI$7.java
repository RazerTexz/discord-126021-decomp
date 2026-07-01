package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureUI$7 implements View$OnClickListener {
    public static final WidgetSettingsAccount$configureUI$7 INSTANCE = new WidgetSettingsAccount$configureUI$7();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccountBackupCodes$Companion widgetSettingsAccountBackupCodes$Companion = WidgetSettingsAccountBackupCodes.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        widgetSettingsAccountBackupCodes$Companion.launch(context);
    }
}
