package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$configureUI$8 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAccount this$0;

    public WidgetSettingsAccount$configureUI$8(WidgetSettingsAccount widgetSettingsAccount) {
        this.this$0 = widgetSettingsAccount;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccount.access$showRemove2FAModal(this.this$0);
    }
}
