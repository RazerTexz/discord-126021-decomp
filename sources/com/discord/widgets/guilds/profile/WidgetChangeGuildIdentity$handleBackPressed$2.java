package com.discord.widgets.guilds.profile;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$handleBackPressed$2 implements View$OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    public WidgetChangeGuildIdentity$handleBackPressed$2(WidgetChangeGuildIdentity widgetChangeGuildIdentity, AlertDialog alertDialog) {
        this.this$0 = widgetChangeGuildIdentity;
        this.$dialog = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChangeGuildIdentity.access$getDiscardConfirmed$p(this.this$0).set(true);
        this.$dialog.dismiss();
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
