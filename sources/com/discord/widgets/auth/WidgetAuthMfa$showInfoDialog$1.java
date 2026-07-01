package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthMfa$showInfoDialog$1 implements View$OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;

    public WidgetAuthMfa$showInfoDialog$1(AlertDialog alertDialog) {
        this.$dialog = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$dialog.dismiss();
    }
}
