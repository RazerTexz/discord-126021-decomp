package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps;
import com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureUI$6 implements View$OnClickListener {
    public static final WidgetSettingsAccount$configureUI$6 INSTANCE = new WidgetSettingsAccount$configureUI$6();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEnableMFASteps$Companion widgetEnableMFASteps$Companion = WidgetEnableMFASteps.Companion;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        widgetEnableMFASteps$Companion.launch(context);
    }
}
