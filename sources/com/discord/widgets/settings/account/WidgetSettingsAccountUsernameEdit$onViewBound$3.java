package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAccountUsernameEdit this$0;

    public WidgetSettingsAccountUsernameEdit$onViewBound$3(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        this.this$0 = widgetSettingsAccountUsernameEdit;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccountUsernameEdit.access$showPasswordVerification(this.this$0);
    }
}
