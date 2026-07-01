package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureUI$9 implements View$OnClickListener {
    public static final WidgetSettingsAccount$configureUI$9 INSTANCE = new WidgetSettingsAccount$configureUI$9();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsBlockedUsers$Companion widgetSettingsBlockedUsers$Companion = WidgetSettingsBlockedUsers.Companion;
        m.checkNotNullExpressionValue(view, "view");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        widgetSettingsBlockedUsers$Companion.launch(context);
    }
}
