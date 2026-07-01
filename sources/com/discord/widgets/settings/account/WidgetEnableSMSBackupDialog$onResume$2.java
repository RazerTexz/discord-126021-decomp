package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableSMSBackupDialog$onResume$2 implements View$OnClickListener {
    public final /* synthetic */ Boolean $enable;
    public final /* synthetic */ WidgetEnableSMSBackupDialog this$0;

    public WidgetEnableSMSBackupDialog$onResume$2(WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog, Boolean bool) {
        this.this$0 = widgetEnableSMSBackupDialog;
        this.$enable = bool;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEnableSMSBackupDialog.access$enableSMSBackup(this.this$0, this.$enable.booleanValue());
    }
}
