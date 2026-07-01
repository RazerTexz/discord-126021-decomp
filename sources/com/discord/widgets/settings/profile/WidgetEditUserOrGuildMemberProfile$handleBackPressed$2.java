package com.discord.widgets.settings.profile;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$handleBackPressed$2 implements View$OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    public WidgetEditUserOrGuildMemberProfile$handleBackPressed$2(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, AlertDialog alertDialog) {
        this.this$0 = widgetEditUserOrGuildMemberProfile;
        this.$dialog = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEditUserOrGuildMemberProfile.access$getDiscardConfirmed$p(this.this$0).set(true);
        this.$dialog.dismiss();
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
