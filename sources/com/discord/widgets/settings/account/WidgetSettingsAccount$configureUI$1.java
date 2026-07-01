package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.TextView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAccount this$0;

    public WidgetSettingsAccount$configureUI$1(WidgetSettingsAccount widgetSettingsAccount) {
        this.this$0 = widgetSettingsAccount;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccountChangePassword$Companion widgetSettingsAccountChangePassword$Companion = WidgetSettingsAccountChangePassword.Companion;
        TextView textView = WidgetSettingsAccount.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textView, "binding.settingsAccountChangePassword");
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "binding.settingsAccountChangePassword.context");
        widgetSettingsAccountChangePassword$Companion.launch(context);
    }
}
