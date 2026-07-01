package com.discord.widgets.voice.settings;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: compiled from: WidgetVoiceChannelSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceChannelSettings$confirmDelete$1 implements View$OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;

    public WidgetVoiceChannelSettings$confirmDelete$1(AlertDialog alertDialog) {
        this.$dialog = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$dialog.dismiss();
    }
}
