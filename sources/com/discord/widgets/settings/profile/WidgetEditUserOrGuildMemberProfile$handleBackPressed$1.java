package com.discord.widgets.settings.profile;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$handleBackPressed$1 implements View$OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;

    public WidgetEditUserOrGuildMemberProfile$handleBackPressed$1(AlertDialog alertDialog) {
        this.$dialog = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$dialog.dismiss();
    }
}
