package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsAccountEmailEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEdit$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAccountEmailEdit this$0;

    public WidgetSettingsAccountEmailEdit$onViewBound$4(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        this.this$0 = widgetSettingsAccountEmailEdit;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccountEmailEdit.access$showPasswordVerification(this.this$0);
    }
}
