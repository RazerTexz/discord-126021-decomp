package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrationsListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$1 implements View$OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;

    public WidgetServerSettingsIntegrationsListItem$showDisableSyncDialog$1(AlertDialog alertDialog) {
        this.$dialog = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$dialog.dismiss();
    }
}
