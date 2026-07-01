package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountContactsNameEdit$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAccountContactsNameEdit this$0;

    public WidgetSettingsAccountContactsNameEdit$configureUI$1(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit) {
        this.this$0 = widgetSettingsAccountContactsNameEdit;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccountContactsNameEdit.access$submitName(this.this$0, "");
    }
}
