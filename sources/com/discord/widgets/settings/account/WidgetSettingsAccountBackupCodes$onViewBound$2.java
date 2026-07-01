package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAccountBackupCodes this$0;

    public WidgetSettingsAccountBackupCodes$onViewBound$2(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        this.this$0 = widgetSettingsAccountBackupCodes;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccountBackupCodes.access$getBackupCodes(this.this$0, true);
    }
}
