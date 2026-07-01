package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureUI$3 implements View$OnClickListener {
    public static final WidgetSettingsAccount$configureUI$3 INSTANCE = new WidgetSettingsAccount$configureUI$3();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccountContactsNameEdit$Companion widgetSettingsAccountContactsNameEdit$Companion = WidgetSettingsAccountContactsNameEdit.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        widgetSettingsAccountContactsNameEdit$Companion.launch(context);
    }
}
