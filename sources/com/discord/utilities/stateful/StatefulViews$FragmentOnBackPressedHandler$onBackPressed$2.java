package com.discord.utilities.stateful;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StatefulViews$FragmentOnBackPressedHandler$onBackPressed$2 implements View$OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;
    public final /* synthetic */ StatefulViews$FragmentOnBackPressedHandler this$0;

    public StatefulViews$FragmentOnBackPressedHandler$onBackPressed$2(StatefulViews$FragmentOnBackPressedHandler statefulViews$FragmentOnBackPressedHandler, AlertDialog alertDialog) {
        this.this$0 = statefulViews$FragmentOnBackPressedHandler;
        this.$dialog = alertDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StatefulViews$FragmentOnBackPressedHandler.access$getDiscardConfirmed$p(this.this$0).set(true);
        this.$dialog.dismiss();
        this.this$0.getActivity().onBackPressed();
    }
}
