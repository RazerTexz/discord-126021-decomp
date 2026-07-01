package com.discord.widgets.channels.settings;

import android.app.AlertDialog;
import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$confirmDelete$1 implements View$OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;

    public WidgetThreadSettings$confirmDelete$1(AlertDialog alertDialog) {
        this.$dialog = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$dialog.dismiss();
    }
}
