package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$ToggleMfaDialog$configure$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsSecurity$ToggleMfaDialog this$0;

    public WidgetServerSettingsSecurity$ToggleMfaDialog$configure$2(WidgetServerSettingsSecurity$ToggleMfaDialog widgetServerSettingsSecurity$ToggleMfaDialog) {
        this.this$0 = widgetServerSettingsSecurity$ToggleMfaDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
